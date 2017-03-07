// developped with JDK 8.0_102
// developper: Nejat Günaydýn
import java.util.*;
public class SortingWithNewOrdering {
    In orderingFile = new In("NewOrdering.txt");
    In inputFile = new In("InputNewOrdering.txt");
    
    Out outputFile = new Out("OutputNewOrdering.txt");    
    public static void main(String[] args){
        SortingWithNewOrdering instance = new SortingWithNewOrdering();
        instance.nonStaticMain();
    }
    private static boolean less(int num, int[] array1, int[] array2){
        int size1=array1.length;
        int size2=array2.length;
        if (size1!=size2) return false;
        else return (array1[num]<array2[num]);
    }
    private static void exch(String[] array1, int[][] array2, int i, int j){
        String swap1=array1[i]; array1[i]=array1[j]; array1[j]= swap1;
        int[] swap2=array2[i]; array2[i]=array2[j]; array2[j]= swap2;
    }
    public void sort(String[] array1, int[][] array2, int N, int M){
        for (int i = 0; i < N; i++){
            for (int j = i; j > 0; j--){
                int k=0;
                while (k<M-1) {
                if (less(0,array2[j], array2[j-1])){
                    exch(array1, array2, j, j-1);
                } 
                else if (array2[j][k]==array2[j-1][k]) {
                    if (less((k+1),array2[j], array2[j-1])){
                        exch(array1, array2, j, j-1);
                    }
                }
                else break;
                k+=1;
                }
            }
        }
    }
    public void nonStaticMain(){
        
        String orderingText = orderingFile.readAll();
        String[] orderingList=orderingText.split(" ");
        int orderingSize = orderingList.length;
        String ordering =orderingList[0].trim();
        for (int i=1; i<orderingSize; i++) {
            ordering += orderingList[i].trim();
        }
        
        String inputText = inputFile.readAll();
        String[] inputList=inputText.split("\n");
        int inputSize = inputList.length;
        for (int i=0; i<inputSize; i++) {
            inputList[i] = inputList[i].trim();
        }
        
        int maxLength = 0;
        for (int i=0; i<inputSize; i++) {
            int input_str_length = (inputList[i]).length();
            if (maxLength<input_str_length) {maxLength=input_str_length;}
        }
        
        int[][] output_orderArrays = new int[inputSize][maxLength];
        String[] outputList = inputList;
        
        for (int i=0; i<inputSize; i++) {
            int size = inputList[i].length();
            String[] inputSplitted = inputList[i].split("");
            for (int j=0; j<maxLength; j++) {
                int index;
                if (j<size) {
                    index=((ordering.indexOf(inputSplitted[j].trim()))+1);
                    if (index<0) {index=orderingSize+2;}
                } else {index=0;}
                output_orderArrays[i][j]=index;
            }   
        }
        sort(inputList, output_orderArrays, inputSize, maxLength);
        String output = "";
        for (int i=0; i<inputSize; i++){
            System.out.println(inputList[i]);
            output+=inputList[i]+"\n";
        }
        outputFile.println(output);
        inputFile.close();
        outputFile.close();
    }  
}
