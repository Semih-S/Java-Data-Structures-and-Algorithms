import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Question4{
    // Insertion sort algorithm that counts number of swaps
    public static int insertionSortCountSwaps(ArrayList<String> input) {
        int swapCount = 0;
        for (int i = 0; i < input.size(); i++) {
            String item = input.get(i);
            int j = i - 1;
            while (j >= 0 && input.get(j).compareTo(item) > 0) {
                input.set(j + 1, input.get(j));
                j = j - 1;
                swapCount++; 
            }
            input.set(j + 1, item);
        }
        return swapCount;
    }
    // Merge sort Algorithm That counts number of swaps
    public static int mergeSortCountSwaps(ArrayList<String> input) {
        if (input.size() > 1) {
            int mid = input.size() / 2;
            ArrayList<String> left = new ArrayList<>(input.subList(0, mid));
            ArrayList<String> right = new ArrayList<>(input.subList(mid, input.size()));
    
            mergeSortCountSwaps(left);
            mergeSortCountSwaps(right);
    
            int i = 0;
            int j = 0;
            int k = 0;
            int swaps = 0; 
            while (i < left.size() && j < right.size()) {
                if (left.get(i).compareTo(right.get(j)) < 0) {
                    input.set(k, left.get(i));
                    i ++;
                } else {
                    input.set(k, right.get(j));
                    j ++;
                    swaps += (mid - i); 
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
            return swaps;
        } else {
            return 0;
        }
        
    }
    
    // File loaded for the two algorithms above
    public static ArrayList<String> first_x_value(String input, int value) {
        // Reading the file
        File file = new File(input);
        try {
            Scanner input_file = new Scanner(file);
            ArrayList<String> words_in_input_2 = new ArrayList<String>();
            input_file.useDelimiter("\\W+");

            while (input_file.hasNext()){
                words_in_input_2.add(input_file.next());
            }
            ArrayList<String> first_x = new ArrayList<String>(words_in_input_2.subList(0, value));
            input_file.close();
            return first_x;
        // Exception handled
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;

        

    }
    public static void main(String[] args) {
        // Testing part
        long insertion_start_100 = System.nanoTime();
        Question2.insertionSort(first_x_value("./input.txt", 100));
        long insertion_stop_100 = System.nanoTime();
        System.out.print("Runtime(in nanaoseconds) for 100 values in insertion sort: ");
        System.out.println(insertion_stop_100 - insertion_start_100);
        System.out.print("Number of Sorts for 100 values in insertion sort: ");
        System.out.println(insertionSortCountSwaps(first_x_value("./input.txt", 100)));

        long merge_start_100 = System.nanoTime();
        Question3.mergeSort(first_x_value("./input.txt", 100));
        long merge_stop_100 = System.nanoTime();
        System.out.print("Runtime(in nanoseconds) for 100 values in merge sort: ");
        System.out.println(merge_stop_100 - merge_start_100);
        System.out.print("Number of Sorts for 100 values in merge sort: ");
        System.out.println(mergeSortCountSwaps(first_x_value("./input.txt", 100)));

        long insertion_start_200 = System.nanoTime();
        Question2.insertionSort(first_x_value("./input.txt", 200));
        long insertion_stop_200 = System.nanoTime();
        System.out.print("Runtime(in nanaoseconds) for 200 values in insertion sort: ");
        System.out.println(insertion_stop_200 - insertion_start_200);
        System.out.print("Number of Sorts for 200 values in insertion sort: ");
        System.out.println(insertionSortCountSwaps(first_x_value("./input.txt", 200)));

        long merge_start_200 = System.nanoTime();
        Question3.mergeSort(first_x_value("./input.txt", 200));
        long merge_stop_200 = System.nanoTime();
        System.out.print("Runtime(in nanoseconds) for 200 values in merge sort: ");
        System.out.println(merge_stop_200 - merge_start_200);
        System.out.print("Number of Sorts for 200 values in merge sort: ");
        System.out.println(mergeSortCountSwaps(first_x_value("./input.txt", 200)));

        long insertion_start_500 = System.nanoTime();
        Question2.insertionSort(first_x_value("./input.txt", 500));
        long insertion_stop_500 = System.nanoTime();
        System.out.print("Runtime(in nanaoseconds) for 500 values in insertion sort: ");
        System.out.println(insertion_stop_500 - insertion_start_500);
        System.out.print("Number of Sorts for 500 values in insertion sort: ");
        System.out.println(insertionSortCountSwaps(first_x_value("./input.txt", 500)));

        long merge_start_500 = System.nanoTime();
        Question3.mergeSort(first_x_value("./input.txt", 500));
        long merge_stop_500 = System.nanoTime();
        System.out.print("Runtime(in nanoseconds) for 500 values in merge sort: ");
        System.out.println(merge_stop_500 - merge_start_500);
        System.out.print("Number of Sorts for 500 values in merge sort: ");
        System.out.println(mergeSortCountSwaps(first_x_value("./input.txt", 500)));
    }
}