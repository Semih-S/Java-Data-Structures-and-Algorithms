import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Question2{
    public static ArrayList<String> insertionSort(ArrayList<String> input) {
        // Insertion Sort
        for (int i = 0; i < (input.size()); i++) {
            String item = input.get(i);
            int j = i - 1;
            while (j >= 0 && input.get(j).compareTo(item) > 0) {
                input.set(j + 1, input.get(j));
                j = j - 1;
            }
            input.set(j + 1, item); 
        }
        return input;
    }


    public static void main(String[] args) {
        // Testing part
        System.out.println(insertionSort(Question1.deleteStopwords("./input.txt", "./stopwords.txt")));
    }
}