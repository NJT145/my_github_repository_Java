/**
 * Auto Generated Java Class.
 */
public class OctoberThree {
  
  
  public static void main(String[] args) { 
    
    In myFile = new In("inputFile.txt");
    String insideOfFile = myFile.readAll();
    System.out.print(insideOfFile);
    String addedString = insideOfFile + "\n789";
    Out outputFile = new Out("outputFile.txt");
    outputFile.print(addedString);
    
  }
  
  /* ADD YOUR CODE HERE */
  
}
