package token;

import opennlp.tools.tokenize.SimpleTokenizer;  

public class SimpleTokenizerEN { 
   public static void main(String args[]){ 
     
      String sentence = "Believe and don't give up. Never give up on your goals!"; 
    
      //Instantiating SimpleTokenizer class 
      SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE;  
       
      //Tokenizing the given sentence 
      String tokens[] = simpleTokenizer.tokenize(sentence);  
       
      //Printing the tokens 
      for(String token : tokens) {         
         System.out.println(token);  
      }       
   }  
}