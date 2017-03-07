import java.lang.* ;
//* http://stackoverflow.com/questions/7552660/java-convert-float-to-string-and-string-to-float
public class Calculator {

  public static void main(String [] args){
    
    System.out.println("Loading file \"InputCalculator.txt\"...");
    
    In in = new In("InputCalculator.txt");
    System.out.println("------------------------ Text in file \"InputCalculator.txt\" is : ------------------------");
    String readStringFromInputFile = in.readAll();
    System.out.println(readStringFromInputFile);
    in.close() ;
    
    System.out.println("-------------------------------------------------------------------------------------------");
    
    String[] operators = "=+-".split("");
    
    String[] inputLinesList = readStringFromInputFile.split("\n") ;
    
    String outputString = "" ;
    
    System.out.println("Checking file contents : ...");
    
    boolean isNumber = true ;
    float oldCurrentTotal = 0 ;
    float newNum = 0 ;
    String operator = null ;
    
    for (int i=0; i<(inputLinesList.length); i++){
      
      if (isNumber==true){
        if (operator == null){
          oldCurrentTotal = Float.parseFloat(inputLinesList[i]);
          newNum = 0 ;
          outputString += "\n" + (String.valueOf(oldCurrentTotal));
        }else{
          newNum = Float.parseFloat(inputLinesList[i]);
          
          outputString += "\n" + (String.valueOf(oldCurrentTotal)+operator+String.valueOf(newNum));
          
          if ((operator.contentEquals(operators[1]))){
            oldCurrentTotal += newNum ; 
          }else{
            if ((operator.contentEquals(operators[2]))){
              oldCurrentTotal -= newNum ;}}}
        isNumber = false;
      }else{
        operator = (inputLinesList[i]).trim();
        
        if (operator.contentEquals(operators[0])) {
          operator = null ;
          outputString += "\n" + (String.valueOf(oldCurrentTotal));}
        
        isNumber = true; }}
    
    System.out.println("Checking completed, output recorded, writing on file ...");
    
    Out outputFile = new Out("OutputCalculator.txt");
    
    System.out.println("Creating file \"OutputCalculator.txt\" ...");
    
    System.out.println("------------------------ Text in file \"OutputCalculator.txt\" is : -----------------------");
    String[] outputListed = outputString.split("\n");
    for (int i=1; i<(outputListed.length); i++){
      System.out.println(outputListed[i]);
      outputFile.println(outputListed[i]);}
    
    System.out.println("-------------------------------------------------------------------------------------------");
    
    outputFile.close() ;
  }  
}
