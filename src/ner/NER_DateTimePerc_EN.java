package ner;

import java.io.FileInputStream; 
import java.io.InputStream;  
import opennlp.tools.namefind.NameFinderME; 
import opennlp.tools.namefind.TokenNameFinderModel; 
import opennlp.tools.tokenize.TokenizerME; 
import opennlp.tools.tokenize.TokenizerModel; 
import opennlp.tools.util.Span;  

public class NER_DateTimePerc_EN {  
   public static void main(String args[]) throws Exception{        
      
      //On charge le modèle qui tokenize...
      InputStream inputStreamTokenizer = new FileInputStream("en-token.bin");
      TokenizerModel tokenModel = new TokenizerModel(inputStreamTokenizer);  
      TokenizerME tokenizer = new TokenizerME(tokenModel); //...et on instancie
       
      //On tokenize
      String example = "Today is Tuesday, April 25, 2023. "
      		+ "It's 08:48 now and close to 9 o'clock. "
      		+ "There is a 100% probability for you to go to school.";
      //System.out.println(example);
      String tokens[] = tokenizer.tokenize(example); 
       
      //On charge le NER-person model...
      InputStream inputStreamNameFinder1 = new FileInputStream("en-ner-date.bin");       
      TokenNameFinderModel model1 = new TokenNameFinderModel(inputStreamNameFinder1); 
      NameFinderME nameFinder1 = new NameFinderME(model1); //...et on instancie
      //On charge le NER-location model...
      InputStream inputStreamNameFinder2 = new FileInputStream("en-ner-time.bin");       
      TokenNameFinderModel model2 = new TokenNameFinderModel(inputStreamNameFinder2); 
      NameFinderME nameFinder2 = new NameFinderME(model2); //...et on instancie
      //On charge le NER-organization model...
      InputStream inputStreamNameFinder3 = new FileInputStream("en-ner-percentage.bin");       
      TokenNameFinderModel model3 = new TokenNameFinderModel(inputStreamNameFinder3); 
      NameFinderME nameFinder3 = new NameFinderME(model3); //...et on instancie
      
      //On récupère les matchs...
      Span nameSpans1[] = nameFinder1.find(tokens);
      Span nameSpans2[] = nameFinder2.find(tokens);
      Span nameSpans3[] = nameFinder3.find(tokens);
      
      //...et on les affiche
      for(Span s1: nameSpans1)        
         System.out.println(s1.toString()+"  "+tokens[s1.getStart()]);
      for(Span s2: nameSpans2)        
          System.out.println(s2.toString()+"  "+tokens[s2.getStart()]);
      for(Span s3: nameSpans3)        
          System.out.println(s3.toString()+"  "+tokens[s3.getStart()]);
   }    
} 