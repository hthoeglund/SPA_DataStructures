import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;


public class RandomSentence {
	
    public static void main(String[] args) throws FileNotFoundException{
        String filename = args[0];
        ArrayList<String> text = uploadFile(filename);
        System.out.println(generateSentence(text));
    }

    //Uploads the text file into an ArrayList<String>
    public static ArrayList<String> uploadFile(String file) throws FileNotFoundException{
        String token1 = "";

	    Scanner inFile1 = new Scanner(new File(file));
	    ArrayList<String> list = new ArrayList<String>();

	    while (inFile1.hasNext()) {
	      token1 = inFile1.next();
	      list.add(token1);
	    }
	    
	    inFile1.close();
	    return list;
    }

    //Creates the HashMap
    private static HashMap<String, ArrayList<String>> trainData(ArrayList<String> text){
        HashMap<String, ArrayList<String>> dict = new HashMap<String, ArrayList<String>>();
        
        for(int i = 0; i < text.size()-1; i++){
            String currentWord = text.get(i);
            String nextWord = text.get(i+1);
            dict.putIfAbsent(currentWord, new ArrayList<String>());
            dict.get(currentWord).add(nextWord);
        }

        return dict;
    }

    //Generates the sentence
    public static String generateSentence(ArrayList<String> text){
        ArrayList<String> newText = removeErrors(text);
        HashMap<String, ArrayList<String>> list = trainData(newText);
        String result = "";

        //Adds a sentence starter
        Random rand = new Random();
        ArrayList<String> starters = getStart(newText);
        String currentWord = starters.get(rand.nextInt(starters.size()));
        result = result + currentWord;

        //Continues the chain until a setence ender is added
        while(currentWord.charAt(currentWord.length()-1) != '.' && currentWord.charAt(currentWord.length()-1) != '!' && currentWord.charAt(currentWord.length()-1) != '?'){
            currentWord = list.get(currentWord).get(rand.nextInt(list.get(currentWord).size()));
            result = result + " " + currentWord;
        }
        return result;
    }

    //Returns an ArrayList<String> with all of the possible sentence starters
    private static ArrayList<String> getStart(ArrayList<String> text){
        ArrayList<String> starts = new ArrayList<String>();
        for(int i = 0; i < text.size(); i++){
            if(Character.isUpperCase(text.get(i).charAt(0))){
                starts.add(text.get(i));
            }
        }

        return starts;
    }

    //Removes errors
    private static ArrayList<String> removeErrors(ArrayList<String> text){
        ArrayList<String> noErrors = new ArrayList<String>();
        for(int i = 0; i < text.size(); i++){
            String currentWord = text.get(i);
            if(!currentWord.contains("â") && !currentWord.contains("€") && !currentWord.contains("�")){
                noErrors.add(currentWord);
            }
        }

        return noErrors;
    }
}
