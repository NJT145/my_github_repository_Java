public class Reverser {
    
    public static void main(String [] args){
        
        System.out.println("Loading file \"CsvToReverse.txt\"...");
        
        In in = new In("CsvToReverse.txt");
        System.out.println("------------------------ Text in file \"CsvToReverse.txt\" is : ------------------------");
        String readStringFromInputFile = in.readAll();
        System.out.println(readStringFromInputFile);
        in.close() ;
        
        System.out.println("----------------------------------------------------------------------------------------");
        
        Out output = new Out("ReverseCsv.txt");
        
        System.out.println("Creating file \"ReverseCsv.txt\"...");
        System.out.println("------------------------  Text in file \"ReverseCsv.txt\" is :  ------------------------");
        
        String[] inputLinesList = readStringFromInputFile.split("\n") ;
        
        for (int i=(inputLinesList.length-1);i>=0;i--){
            String[] inputLineSplitted = (inputLinesList[i]).split(",") ;
            String outputByLine = (inputLineSplitted[inputLineSplitted.length-1]);
            for (int num=inputLineSplitted.length-2;num>=0;num--){
                outputByLine = outputByLine + "," + inputLineSplitted[num] ; }
            System.out.println(outputByLine);
            output.println(outputByLine); }
        
        System.out.println("----------------------------------------------------------------------------------------");
        
        output.close() ;
    }
}
