
package hw01_file_bplustree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Tuğba Güler
 * 
 */
public class HW01_File_BPlusTree {

    public static void main(String[] args) throws IOException {
        long start = System.nanoTime();
        //The writing process is handled in this section.
        FileWriter writting_to_input_file = new FileWriter("C:/input.txt");
        
        BufferedWriter out = new BufferedWriter(writting_to_input_file);
        
        // Writes each of its command-line arguments on a line by itself
        for (String tgb : input_file_for_bpluss_tree()) {
            out.write(tgb + "\n");
        }
        out.close();
        
        // Calculated how long the program was running
        long finish = System.nanoTime(); 
        System.out.println("Working time of the entire program : " + (double)(finish-start)/1000000);
    }
    
    public static List<Double> generate_numbers() {
        ArrayList<Double> list = new ArrayList<Double>();
        //key-value pairs must be randomly generated only once for 500000
        int number_of_generate_numbers = 500000;
        for (int i = 0; i < number_of_generate_numbers; i++) {
            // The values must be floating point numbers in the range -1000.0 to +1000.0
            // Java has two primitive types for floating-point numbers:float and double 
            // Codes organized using double
            double x = (double) (Math.round(((Math.random() * ((2000) + 1)) - 1000) * 10000.0) / 10000.0);
            // added to the list
            list.add(x);
        }
        // list sorted in ascending mode
        Collections.sort(list);
        return list;
    }

    private static Iterable<String> input_file_for_bpluss_tree() {
        /*----- m value is created -----*/
        long start_created_m_value = System.nanoTime();
        // A list of commands has been created
        List<String> command_list = new ArrayList<String>();
        // m values created between 5 and 50
        int m = (int) (((50 - 5) * Math.random()) + 5);
        // Command to start printing
        command_list.add("Start --> " + m );
        System.out.println("m : " + m);
        long finish_created_m_value = System.nanoTime();
        System.out.println("Calculating creating different m value time : " + (double)(finish_created_m_value-start_created_m_value)/1000000);

        /*-----  Insert queries created -----*/
        // A hash map of the key value has been created
        // Maps can take any Object, for both key and value.
        long start_inset_numbers = System.nanoTime();
        
        Map<Integer, Double> map = new HashMap<Integer, Double>();
        // Keys will be generated and these keys will be associated with the generated values.
        int t = 1;
        for (Double g : generate_numbers()) {
            map.put(t, g);
            t++;
        }
        // Insert commands have been printed
        for (Integer c : map.keySet()) {
            command_list.add("Insert(" + c + "," + map.get(c) + ")");
        }
        long finish_inset_numbers = System.nanoTime();
         System.out.println("Calculating inset numbers : " + (double)(finish_inset_numbers-start_inset_numbers)/1000000);

        /*----- Search queries created -----*/
        // To calculate how long the search process takes
        long start_searching_time = System.nanoTime();  
        // 100 unique numbers generated for keys
        ArrayList<Integer> keys = new ArrayList<Integer>();
        int number_of_generate_keys = 100;
        for (int j = 1; j <= number_of_generate_keys; j++) {
            int n = (int) ((Math.random() * ((100) + 1)) - 1);
            // added to the list
            keys.add(n);
        }
        // Search queries added for each key
        for (int k : keys) {
            command_list.add("Search(" + k + ")");
        }
         long finish_searching_time = System.nanoTime();
         System.out.println("Calculating searching time : " + (double)(finish_searching_time-start_searching_time)/1000000);
        // return list of commands
        return command_list;
    }
}
