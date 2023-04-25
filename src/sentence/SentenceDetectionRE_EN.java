package sentence;

public class SentenceDetectionRE_EN {  
	   public static void main(String args[]){ 
	     
	      String sentence = " Hi. How are you? Welcome to Tutorialspoint! We provide free tutorials on various technologies."; 
	     
	      String simple = "[.?!]";      
	      String[] splitString = (sentence.split(simple));
	      int i = 1;
	      for (String sent : splitString) {
	    	  System.out.println(i+": "+sent+"\n---------------------");
		      i++;
	      }
	         
	   } 
	}