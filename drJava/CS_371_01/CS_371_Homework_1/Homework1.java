import java.util.*;
import edu.princeton.cs.algs4.*;
public class Homework1 {
    
    public Homework1() { 
        /* YOUR CONSTRUCTOR CODE HERE*/
    }
    
    public static double[] twoDiffMax (double[] a) {
        int size = a.length;
        double[] twoDiffMaxPair = { 0.0 , 0.0 };
        if (size!=0){
            double min = a[0];
            double max = a[0];
            for (int i = 0; i < size; i++){
                if (min > a[i]){ min = a[i] ;}
                if (max < a[i]){ max = a[i] ;}
            }
            twoDiffMaxPair[0] = max ;
            twoDiffMaxPair[1] = min ;
            System.out.print("twoDiffMaxPair : ");
            System.out.print(max);System.out.print(" ");System.out.print(min);
            System.out.println();
        }else{
            System.out.println("!!!! Please enter an array which has a size not equal to zero.");
        }
        return twoDiffMaxPair;
    }
    
    public static void doubleSeriesOfOnesAndNines (double[] a) {
        int size = a.length;
        int onesEnd = -1;
        int ninesStart = -1;
        for (int i = 0; i < size; i++){
            String inputText = Double.toString(a[i]);
            if (inputText.indexOf("1")!=-1){onesEnd=i;}
            if (ninesStart==-1){if(inputText.indexOf("9")!=-1){ninesStart=i;}}
        }
        String outputText1 = "There are no series of ones,";
        String outputText2 = " and there are no series of nines.";
        if (onesEnd!=-1){outputText1="Series of ones ends at index ".concat(Integer.toString(onesEnd));}
        if (ninesStart!=-1){outputText2=(" and series of nines starts at index ".concat(Integer.toString(ninesStart))).concat(" .");}
        String outputText = (outputText1.concat(outputText2));
        System.out.println(outputText);
    }
    
    public static void stringSeriesOfOnesAndNines (String[] a) {
        int size = a.length;
        int onesEnd = -1;
        int ninesStart = -1;
        for (int i = 0; i < size; i++){
            String inputText = a[i];
            if (inputText.indexOf("1")!=-1){onesEnd=i;}
            if (ninesStart==-1){if(inputText.indexOf("9")!=-1){ninesStart=i;}}
        }
        String outputText1 = "There are no series of ones,";
        String outputText2 = " and there are no series of nines.";
        if (onesEnd!=-1){outputText1="Series of ones ends at index ".concat(Integer.toString(onesEnd));}
        if (ninesStart!=-1){outputText2=(" and series of nines starts at index ".concat(Integer.toString(ninesStart))).concat(" .");}
        String outputText = (outputText1.concat(outputText2));
        System.out.println(outputText);
    }
    public static int obsolete (int N){ 
        int result = 0 ;
        for ( int i =0; i < (N-1); i++){
            for ( int j=i +1; j < N ; j++){
                for ( int k=1; k < j ; k++){
                    result+=1; } } }
        return result ; }
    
    public static void main(String[] args) {
        double[] a1 = {1.0,2.9,4.0,3.0};
        twoDiffMax(a1);
        double[] a21 = {11,1111.1,1,1111,11111,9,9999,99,99999};
        String[] a22 = {"11","1111.1","1","1111","11111","9","9999","99","99999"};
        doubleSeriesOfOnesAndNines(a21);
        stringSeriesOfOnesAndNines(a22);
        System.out.println(obsolete(3));
    }
    
}
