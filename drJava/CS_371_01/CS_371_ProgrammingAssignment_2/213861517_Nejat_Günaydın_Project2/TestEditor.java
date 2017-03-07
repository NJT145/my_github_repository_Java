// developped with "JDK 8.0 update 102"

import java.io.*;
import java.util.*;
import java.lang.* ;
import edu.princeton.cs.algs4.*;

public class TestEditor {
        
    private static boolean putInsert = false;
    
    private static boolean putExit = false;
    
    public static class Node {
        String item;
        Node next;
    }

    public static Node goToLine (Node first, int index1) {
        Node node_1 = new Node();
        int lineNum = 0;
        node_1 = first;
        for(int i=0;i<(index1-1);i++){node_1 = node_1.next;}
        return node_1;
    }
    
    public static String insert (Node first, int index1, String str) {
        Node oldFirstMain = goToLine(first,index1-1);
        Node oldNextMain = oldFirstMain.next;
        oldFirstMain.next =new Node();
        oldFirstMain.next.item = str;
        oldFirstMain.next.next = oldNextMain;
        return (str);
    }
    
    public static String delete (Node first, int index1, int index2) {
        Node oldFirstMain = new Node();
        oldFirstMain = goToLine(first,index1-1);
        Node linkRemain = new Node();
        linkRemain = goToLine(first,index2-1);
        if (linkRemain.next==null) {
            oldFirstMain.next = null;
        } else {
            System.out.println("--A");
            System.out.println(oldFirstMain.next.item);
            System.out.println("--B");
            System.out.println(linkRemain.item);
            System.out.println(linkRemain.next);
            oldFirstMain.next = linkRemain;
        }
        return (oldFirstMain.item+" ; "+linkRemain.item);

    }
    
    public static String list (Node first, int index1, int index2) {
        Node linkdListSelected = new Node();
        int lineNum = index1-1;
        String output = "";
        linkdListSelected = goToLine(first,index1);
        String outputLine;
        for(int i=(index1-1);i<index2;i++){
            lineNum += 1;
            outputLine = Integer.toString(lineNum)+">"+linkdListSelected.item;
            output += "\n" + outputLine ;
            linkdListSelected = linkdListSelected.next;
        }
        if (output=="") {output=Integer.toString(0)+">";}
        return (output);
    }
    
    public static Node append (Node first, int lineNumber, String str) {
        Node nodeSelected = goToLine(first,lineNumber);
        nodeSelected.item=str;
        Node new_nodeSelected = new Node();
        nodeSelected.next = new_nodeSelected;
        nodeSelected =nodeSelected.next;
        return nodeSelected;
    }
    
    public static String save (Node first, int index1, int index2) {
        Node savedLink = new Node();
        String savedText = "";
        savedLink = goToLine(first,index1);
        savedText += (savedLink.item);
        savedLink = savedLink.next;
        for(int i=(index1);i<index2;i++){
            savedText += "\n"+(savedLink.item);
            savedLink = savedLink.next;
        }
        return (savedText);
    }
    
    
    public static void main(String[] args) { 
        
        System.out.println("Loading file \"InputFile.txt\"...");
        
        In in = new In("InputFile.txt");
        String readStringFromInputFile = in.readAll();
        in.close() ;
        
        System.out.println("------------------------ Text in file \"InputFile.txt\" is : ------------------------");
        System.out.println(readStringFromInputFile);
        System.out.println("----------------------------------------------------------------------------------------");
        
        System.out.println("Creating file \"OutputFile.txt\"...");
        
        String[] inputLinesList = readStringFromInputFile.split("\n") ;
        
        String outputString="";
        int selectedLine = 0;
        int selectedLineInsert = 0;
        
        String error_message = "!!!!Error: Can not continue after Exit.!!!!";
        
        String line0 = "InputFile.txt";
        
        Node root = new Node();
        root.item = line0;
        Node linkedList = new Node() ;
        root.next = linkedList;
        
        outputString += line0+"\r";
        
        for (int i=0;i<(inputLinesList.length);i++){
            String inputLine = inputLinesList[i] ;
            String[] inputLineSplitted = ((inputLine).split(" "));
            String firstWord = (inputLineSplitted[0]).trim() ;
            System.out.print(inputLineSplitted.length);System.out.println("--"+inputLine);
            
            if (firstWord.equals("I")) {      
                putInsert=true;
                String outputLine = error_message;
                if (putExit==false){
                    outputLine = Integer.toString(selectedLine)+">"+inputLine;
                    selectedLineInsert = (Integer.valueOf((inputLineSplitted[1]).trim())-1);
                }
                outputString += ("\n"+outputLine);
            } else if (firstWord.equals("D")) {
                putInsert=false;
                String outputLine = error_message;
                if (putExit==false){
                    outputLine = Integer.toString(selectedLine)+">"+inputLine;
                    int start;
                    int end;
                
                    
                }
                outputString += ("\n"+outputLine);
            } else if (firstWord.equals("L")) {
                putInsert=false;
                String outputLine = error_message;
                String output_of_list = outputLine;
                int start = 1;
                int end = selectedLine;
                if (putExit==false){
                    outputLine = Integer.toString(selectedLine)+">"+inputLine;
                    if (inputLineSplitted.length>1){start = (Integer.valueOf((inputLineSplitted[1]).trim()));}
                    if (inputLineSplitted.length>2){end = (Integer.valueOf((inputLineSplitted[2]).trim()));}
                    output_of_list = list(linkedList,start,end);
                    outputLine = outputLine+output_of_list;
                }
                outputString += ("\n"+outputLine);
            } else if (firstWord.equals("A")) {
                putInsert=false;
                String outputLine = error_message;
                if (putExit==false){
                    outputLine = Integer.toString(selectedLine)+">"+inputLine;
                }
                outputString += ("\n"+outputLine);
            } else if (firstWord.equals("S")) {
                putInsert=false;
                String outputLine = error_message;
                if (putExit==false){
                    outputLine = Integer.toString(selectedLine)+">"+inputLine;
                    String savedText = save(linkedList,1,selectedLine);
                    String savedFileName = ((inputLineSplitted[1]).trim());
                    Out savedFile = new Out(savedFileName);
                    savedFile.println(savedText);
                    savedFile.close() ;
                }
                outputString += ("\n"+outputLine);
            } else if (firstWord.equals("E")) {
                putInsert=false;
                String outputLine = Integer.toString(selectedLine)+">"+inputLine;
                if (putExit==true){outputLine = error_message;}
                putExit = true;
                outputString += ("\n"+outputLine);
            } else {
                selectedLine += 1;
                String outputLine = error_message;
                if (putExit==false){
                    int lineNumber = selectedLine;
                    if (putInsert==true) {
                        selectedLineInsert += 1;
                        lineNumber = selectedLineInsert;
                        int oldSelectedLine = selectedLine;
                        insert(linkedList,lineNumber,inputLine); 
                    } else {
                        append(linkedList,selectedLine,inputLine);
                    }
                    outputLine = Integer.toString(lineNumber)+">"+inputLine;
                }
                outputString += ("\n"+outputLine);
            }
        }
        
        
        Out outputFile = new Out("OutputFile.txt");
        System.out.println("------------------------  Text in file \"OutputFile.txt\" is :  ------------------------");
        outputFile.println(outputString);
        System.out.println(outputString);
        System.out.println("----------------------------------------------------------------------------------------");
        
        outputFile.close() ;
        int selectedLine1=selectedLine;
        
        selectedLine = 0;
        
        Node root1 = new Node();
        root1.item = "root1"; 
        selectedLine+=1;
        Node first = new Node();
        root1.next = first;
        first.item = "abc";
        selectedLine+=1;
        Node second = new Node();
        first.next = second;
        second.item = "defgsadlljxjcaösachkhckshdkc";
        selectedLine+=1;
        Node third = new Node();
        second.next = third;
        third.item = " third abnxcskk ";
        selectedLine+=1;
        

        System.out.println(list(root1,1,selectedLine));
        System.out.println("-------------------------");
        System.out.println((goToLine(root1,2)).item);
        System.out.println("-------------------------");
        System.out.println(goToLine(root1,2).item);
        System.out.println(goToLine(root1,selectedLine).next);
        System.out.println(delete(root1,2,3));
        System.out.println("-------------------------");
        System.out.println(list(root1,1,3));
        
    }    
}
