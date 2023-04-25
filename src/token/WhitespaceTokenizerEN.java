package token;

import opennlp.tools.tokenize.WhitespaceTokenizer;  

public class WhitespaceTokenizerEN {  
   
   public static void main(String args[]){ 
     
      String sentence = "Believe and don't give up. Never give up on your goals!"; 
    
      //Instantiating whitespaceTokenizer class 
       WhitespaceTokenizer whitespaceTokenizer = WhitespaceTokenizer.INSTANCE;  
       
      //Tokenizing the given paragraph 
      String tokens[] = whitespaceTokenizer.tokenize(sentence);  
       
      //Printing the tokens 
      for(String token : tokens)     
         System.out.println(token);        
   } 
}