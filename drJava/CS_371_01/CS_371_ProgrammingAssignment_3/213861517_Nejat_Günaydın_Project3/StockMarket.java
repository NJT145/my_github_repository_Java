// developped with JDK 8.0_102
// developper: Nejat Günaydýn
import java.util.*;
import edu.princeton.cs.algs4.*;
public class StockMarket{
    In inputFile = new In("StockDealsInput.txt");
    Out outputFile = new Out("TransitionOutput.txt");
    public static void main(String[] args){
        StockMarket instance = new StockMarket();
        instance.nonStaticMain();
    }
    
    public boolean containing (String[] array, String item) {
        for (String i:array) {
            if ((i == item) || (item != null && item.equals(i))) {
                return true;
            }
        }
        return false;
    }
    
    public void nonStaticMain(){
        
        System.out.println("Loading file \"StockDealsInput.txt\"...");
        System.out.println("----------------------- Text in file \"StockDealsInput.txt\" is : ----------------------");
        String inputText = inputFile.readAll();
        inputFile.close();
        
        String[] inputList= inputText.split("\n");
        int inputSize = inputList.length;
      
        MinPQ<String> s_queue = new MinPQ<String>();
        MaxPQ<String> b_queue = new MaxPQ<String>();
        
        for (int i=0; i<inputSize; i++) {
            String input = inputList[i];
            String type = inputList[i].split(" ")[0].trim();
            String id = inputList[i].split(" ")[1].trim();
            String shared = inputList[i].split(" ")[2].trim();
            String cost = inputList[i].split(" ")[3].trim();
            String key = cost+";"+input;
            if (type.startsWith("S")) {s_queue.insert(key);}
            if (type.startsWith("B")) {b_queue.insert(key);}
            System.out.println(input);
        }
        
        System.out.println("----------------------------------------------------------------------------------------");
        
        System.out.println("\nBuying and Selling transitions are simulating...\n");
        
        int sellNumber = s_queue.size();
        int buyNumber = b_queue.size();
        
        String output = "";
        int maxSize_listTransitions = sellNumber*buyNumber;
        String[] listTransitions = new String[maxSize_listTransitions];
        Arrays.fill(listTransitions, "null");
        String[] listTransitionsText = new String[maxSize_listTransitions];
        Arrays.fill(listTransitionsText, "null");
        int indexTransition = 0;
        
        int sharedBuy_rest = 0;
        
        for (int i=0; i<sellNumber; i++) {
            
            String orderSell = (s_queue.min().split(";")[1]);
            int id_sell = (Integer.parseInt(orderSell.split(" ")[1].trim()));
            int sharedSell = (Integer.parseInt(orderSell.split(" ")[2].trim()));
            int minSellPrice = (Integer.parseInt(orderSell.split(" ")[3].trim()));
            
            for (int j=0; j<buyNumber; j++) {
                
                String orderBuy = (b_queue.max().split(";")[1]);
                int id_buy = (Integer.parseInt(orderBuy.split(" ")[1].trim()));
                int sharedBuy = (Integer.parseInt(orderBuy.split(" ")[2].trim()));
                int maxBuyPrice = (Integer.parseInt(orderBuy.split(" ")[3].trim()));
                
                String lastTransition = (orderSell+" --> "+orderBuy);
                int old_sharedSell = sharedSell;
                
                int transfered = 0;
                
                if (minSellPrice<=maxBuyPrice && sharedSell>0) {
                    
                    if (sharedBuy_rest>0) {
                        if (sharedSell>=sharedBuy_rest) {
                            sharedSell-=sharedBuy_rest;
                            transfered = (sharedBuy_rest);
                        } 
                        else {
                            transfered = sharedSell;
                            sharedBuy_rest -= sharedSell;
                            sharedSell = 0;
                        }
                    }
                    else {
                        if (sharedSell>=sharedBuy) {
                            sharedSell-=sharedBuy;
                            transfered = (old_sharedSell-sharedSell);
                            b_queue.delMax();
                        } 
                        else {
                            transfered = sharedSell;
                            sharedBuy_rest -= sharedSell;
                            sharedSell = 0;
                        }
                    }
                }
                
                if (containing(listTransitions, lastTransition)==false) {
                    String transitionTextOutput = "S"+String.valueOf(id_sell)+" sells to B"+String.valueOf(id_buy)+" in size of "+String.valueOf(transfered);
                    listTransitions[indexTransition] = lastTransition;
                    listTransitionsText[indexTransition] = transitionTextOutput;
                    indexTransition += 1;
                }
            }
            s_queue.delMin();
        }
        
        for (int i=0; i<listTransitionsText.length; i++){
            if (listTransitionsText[i].equals("null") == false){
                output += (listTransitionsText[i]+"\n");
            }
        }
        
        System.out.println("Creating file \"TransitionOutput.txt\"...");
        System.out.println("----------------------- Text in file \"TransitionOutput.txt\" is : ---------------------");
        outputFile.print(output);
        System.out.println(output.trim());
        System.out.println("----------------------------------------------------------------------------------------");
    }
}
