package pos;

import java.io.FileInputStream;
import java.io.InputStream;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.SimpleTokenizer;

public class POS_FR {
	public static void main(String args[]) throws Exception {
		// Loading Parts of speech model
		InputStream inputStream = new FileInputStream("fr-pos.bin");
		POSModel model = new POSModel(inputStream);

		// Instantiating POSTaggerME class
		POSTaggerME tagger = new POSTaggerME(model);

		String sentence = "Le traitement automatique des langues (TAL), "
				+ "est une discipline qui porte essentiellement sur la compréhension, "
				+ "la manipulation et la génération du langage naturel par les machines.";
		
		// Instantiating SimpleTokenizer class
		SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE;

		// Tokenizing the given sentence
		String tokens[] = simpleTokenizer.tokenize(sentence);

		// Generating tags
		String[] tags = tagger.tag(tokens);
		int i=0;
	    for(String str:tokens){
	    	System.out.println(str+" --> "+tags[i]);
	    	i++;	 
	    }
	}
}