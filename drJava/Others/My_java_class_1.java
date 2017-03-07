import java.io.*;
import java.util.*;

public class My_java_class_1 {
    
    public My_java_class_1() { 
        /* YOUR CONSTRUCTOR CODE HERE*/
        
    }
    
    public static void main(String[] args) {
        
        String input="1,23,,456";
        String[] inputList=input.split(",");
        String[] inputList2=input.split("");
        for (int i=0;i<inputList.length;i++){System.out.print(inputList[i]+"/");}
        System.out.println();
        for (int i=0;i<inputList2.length;i++){System.out.print(inputList2[i]+"/");}
        System.out.println();
        for (String i : inputList){System.out.print(i+"/");}
        System.out.println();
        for (int i=inputList.length-1;i>=0;i--){System.out.print(inputList[i]+"/");}
        System.out.println();
        
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        
        System.out.println((inputList));
        System.out.println((inputList.getClass().getName()));
        System.out.println((inputList.getClass().getSimpleName()));
        
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        
        File f = new File("C:\\Users\\asus\\Desktop\\java_files\\my_java_workspace_(drJava)\\CS_371_01");
        //File f = new File("C:/Users/nejatgunaydin/Desktop/java_files/my_java_workspace_(drJava)/CS_371_01/CS 371 Project #1");
        for (File file : f.listFiles()){System.out.println(file);}
        System.out.println();
        File[] matchingFiles = f.listFiles(new FilenameFilter() {public boolean accept(File dir, String name) {return name.startsWith("CsvToReverse") && name.endsWith(".txt");}});
        for (File file : matchingFiles){System.out.println(file);}
        
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        
        java.net.URL main = My_java_class_1.class.getResource("My_java_class_1.class");
        if (!"file".equalsIgnoreCase(main.getProtocol()))
            throw new IllegalStateException("My_java_class_1 class is not stored in a file.");
        File path1 = new File(main.getPath());
        System.out.println(path1);
        ////or
        String path2 = new File("My_java_class_1.class").getAbsolutePath();
        System.out.println(path2);
        
        String path3 = new File("").getAbsolutePath();
        System.out.println(path3);
        
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        
        float a=Float.parseFloat("1");
        System.out.println(a);
        
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        
        String s1 = "hello world";
        String s2 = s1.toUpperCase();
        String s3 = s1.substring(6,11);
        StdOut.println(s1);
        StdOut.println(s2);
        StdOut.println(s3);
        
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        
        System.out.println(Math.log(10));
        System.out.println(Math.log(10)/Math.log(10));
        //"static int log(int x, int base){return (int) (Math.log(x) / Math.log(base));}"
        
        System.out.println("-----------------------------------------------------------------------");
        
        int sum=0;
        for (int i=0; i<3; i++){sum++;}
        System.out.println(sum);
        
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        if (!true){System.out.println("!true");}
        if (!false){System.out.println("!false");}
        System.out.println("-----------------------------------------------------------------------");

    }
    
    
    
}
