import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Question1{
    public static ArrayList<String> deleteStopwords(String input, String stopwords) {
        // Reading files with exception handling using scanner.
        File file = new File(input);
        File file_2 = new File(stopwords);
        try {
        
        Scanner input_file = new Scanner(file);
        Scanner input_file_2 = new Scanner(file_2);
        // Store input file as an arraylist after seperating each line
        ArrayList<String> words_in_input = new ArrayList<String>();
        
        input_file.useDelimiter("\\W+");

        while (input_file.hasNext()){
            words_in_input.add(input_file.next());
        }
        // Store stopwords file as an arraylist after seperating each line
        ArrayList<String> skip_words = new ArrayList<String>();
        while (input_file_2.hasNextLine()){
            skip_words.add(input_file_2.nextLine());
        }

        ArrayList<String> filtered_words = new ArrayList<String>();

        // Filter words in input by checking if they are in skip words and output filtered words
            for (int n = 0; n < words_in_input.size(); n++) {
                String word_in_input = words_in_input.get(n);
                if (skip_words.contains(word_in_input)) {
                    ;
                } else {
                    filtered_words.add(word_in_input);
                }

            
        }
        
        // Closing the file and performin exception handling
        input_file.close();
        input_file_2.close();
        return (filtered_words);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
       
    }


    
        



     public static void main(String[] args) {
        // Testing part
        System.out.println(deleteStopwords("./input.txt", "./stopwords.txt"));
    }

}