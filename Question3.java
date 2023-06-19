import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Question3{
    public static ArrayList<String> mergeSort(ArrayList<String> input) {
        // Merge Sort
        if (input.size() > 1) {
            int mid = input.size() / 2;
            ArrayList<String> left = new ArrayList<>(input.subList(0, mid));
            ArrayList<String> right = new ArrayList<>(input.subList(mid, input.size()));

            mergeSort(left);
            mergeSort(right);

            int i = 0;
            int j = 0;
            int k = 0;
            while (i < left.size() && j < right.size()) {
                if (left.get(i).compareTo(right.get(j)) < 0) {
                    input.set(k, left.get(i));
                    i ++;
                } else {
                    input.set(k, right.get(j));
                    j ++;
                }
                k++;
            }

            while (i < left.size()) {
                input.set(k, left.get(i));
                i ++;
                k ++;
            }

            while (j < right.size()) {
                input.set(k, right.get(j));
                j ++;
                k ++;
            }

            
        }
        return input;
    }


    public static void main(String[] args) {
        // Testing
        System.out.println(mergeSort(Question1.deleteStopwords("./input.txt", "./stopwords.txt")));
    }
}