package token;

import java.io.FileInputStream; 
import java.io.InputStream; 
import opennlp.tools.tokenize.TokenizerME; 
import opennlp.tools.tokenize.TokenizerModel;  

public class TokenizerME_EN { 
  
   public static void main(String args[]) throws Exception{     
     
      String sentence = "Believe and don't give up (TAL). Never give up on your goals!"; 
       
      //Loading the Tokenizer model 
      InputStream inputStream = new FileInputStream("en-token.bin"); 
      TokenizerModel tokenModel = new TokenizerModel(inputStream); 
       
      //Instantiating the TokenizerME class 
      TokenizerME tokenizer = new TokenizerME(tokenModel); 
       
      //Tokenizing the given raw text 
      String tokens[] = tokenizer.tokenize(sentence);       
          
      //Printing the tokens  
      for (String a : tokens) 
         System.out.println(a); 
   } 
} 