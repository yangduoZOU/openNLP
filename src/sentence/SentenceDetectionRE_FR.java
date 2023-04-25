package sentence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class SentenceDetectionRE_FR {
	
	private static String readFile(String filePath) { 
        StringBuilder contentBuilder = new StringBuilder();
 
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)) 
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
 
        return contentBuilder.toString();
    }
	public static void main(String args[]) throws Exception { 

		  String filePath = "texte_FR.txt";
	   
	      String sentence = readFile( filePath );
	      
	      String simple = "[.?!]";      
	      String[] splitString = (sentence.split(simple));
	      int i = 1;
	      for (String sent : splitString) {
	    	  System.out.println(i+": "+sent+"\n---------------------");
		      i++;
	      } 
	} 
}