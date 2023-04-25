package token;

import java.io.FileInputStream; 
import java.io.InputStream; 
import opennlp.tools.tokenize.TokenizerME; 
import opennlp.tools.tokenize.TokenizerModel;  

public class TokenizerME_FR { 
  
   public static void main(String args[]) throws Exception{     
     
      String sentence = "Le traitement automatique des langues (TAL), est un domaine multidisciplinaire impliquant la linguistique, l'informatique et l'intelligence artificielle, qui vise à créer des outils de traitement de la langue naturelle pour diverses applications."; 
       
      //Loading the Tokenizer model 
      InputStream inputStream = new FileInputStream("fr-token.bin"); 
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