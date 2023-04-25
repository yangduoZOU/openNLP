package chunking;

import java.io.File; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStream;  

import opennlp.tools.chunker.ChunkerME; 
import opennlp.tools.chunker.ChunkerModel; 
import opennlp.tools.cmdline.postag.POSModelLoader; 
import opennlp.tools.postag.POSModel; 
import opennlp.tools.postag.POSTaggerME; 
import opennlp.tools.tokenize.WhitespaceTokenizer;  

public class ChunkerME_EN { 
   
   public static void main(String args[]) throws IOException { 
      //Tokenizing the sentence 
      String sentence = "Tom was graduated from Cambridge University.";       
      WhitespaceTokenizer whitespaceTokenizer= WhitespaceTokenizer.INSTANCE; 
      String[] tokens = whitespaceTokenizer.tokenize(sentence); 
     
      //Generating the POS tags 
      //Load the parts of speech model 
      File file = new File("en-pos.bin"); 
      POSModel model = new POSModelLoader().load(file);     
      
      //Constructing the tagger 
      POSTaggerME tagger = new POSTaggerME(model);        
      
      //Generating tags from the tokens 
      String[] tags = tagger.tag(tokens);    
    
      //Loading the chunker model 
      InputStream inputStream = new 
         FileInputStream("en-chunker.bin"); 
      ChunkerModel chunkerModel = new ChunkerModel(inputStream);  
      
      //Instantiate the ChunkerME class 
      ChunkerME chunkerME = new ChunkerME(chunkerModel);
       
      //Generating the chunks 
      String result[] = chunkerME.chunk(tokens, tags); 
  
      for (String s : result) 
         System.out.println(s);         
   }    
} 