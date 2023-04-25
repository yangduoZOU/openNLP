package pos;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class POS_EN_MaxentPerceptronClassique {
	private static String readFile(String filePath) {
		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contentBuilder.toString();
	}

	public static void main(String args[]) throws Exception {
		String filePath = "testPOS.txt";
		String contenu = readFile(filePath);

		// Tokenizer
		InputStream is = new FileInputStream("en-token.bin");
		TokenizerModel model = new TokenizerModel(is);
		Tokenizer tokenizer = new TokenizerME(model);
		String tokens[] = tokenizer.tokenize(contenu);

		// importer le POS maxent model
		InputStream inputStream1 = new FileInputStream("en-pos-maxent.bin");
		POSModel model1 = new POSModel(inputStream1);
		// importer le POS perceptron model
		InputStream inputStream2 = new FileInputStream("en-pos-perceptron.bin");
		POSModel model2 = new POSModel(inputStream2);
		// importer le POS classique model
		InputStream inputStream3 = new FileInputStream("en-pos.bin");
		POSModel model3 = new POSModel(inputStream3);

		// instancier le POSTaggerME class
		POSTaggerME tagger1 = new POSTaggerME(model1);
		POSTaggerME tagger2 = new POSTaggerME(model2);
		POSTaggerME tagger3 = new POSTaggerME(model3);

		// on recherche les étiquettes :
		String[] tags1 = tagger1.tag(tokens);
		String[] tags2 = tagger2.tag(tokens);
		String[] tags3 = tagger3.tag(tokens);

		// Instantiating the POSSample class
		POSSample sample1 = new POSSample(tokens, tags1);
		System.out.println("POSmaxent:\n"+sample1.toString());
		POSSample sample2 = new POSSample(tokens, tags2);
		System.out.println("POSperceptron:\n"+sample2.toString());
		POSSample sample3 = new POSSample(tokens, tags3);
		System.out.println("POSclassique:\n"+sample3.toString());

	}
}