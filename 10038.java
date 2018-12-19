import java.util.*;
import java.io.BufferedInputStream;
import java.lang.*;

public class Main {
    //method to check whether an array has a specific difference between it's any two elements.
        public static boolean hasDifference(int[] array) {
            if (array.length == 1) {
                //debug error
                //System.out.println("hasDifference: array length is 1.");
                return true;
            } else {
                boolean[] differenceFlag = new boolean[array.length - 1];
                int i, j;
                for (i = 0; i < array.length - 1; i++) {
                    
                        int difference = (array[i] - array[i + 1]) > 0 ? (array[i] - array[i + 1]):(array[i + 1] - array[i]);
                            if (0 < difference && difference < array.length) {
                                differenceFlag[difference - 1] = true;
                                //debug
                                //System.out.printf("hasDifference: difference \"%d\" exists, subtracting %d from %d.\n", difference, array[i], array[i + 1]);
                            }

                    
                }
                
                
                for (int k = 0; k < differenceFlag.length ; k++) {
                    if (differenceFlag[k] == false) {
                        //debug
                        //System.out.printf("hasDifference: difference \"%d\" does not exist.\n", k + 1);
                        return false;
                    }
                }
                return true;
            }
        }
    
    public static void main(String[] args) throws Exception {
        // Your code here!
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n;//the number of elements in each line
        
        int i;//iterator
       
       //main loop
        while(sc.hasNext()) {
           
           //input
            n = sc.nextInt();
            int[] numbers   = new int[n];
            for (i = 0; i < n; i++) {
                numbers[i] = sc.nextInt();
                //debug
                //System.out.printf("numbers[%d] = %d\n", i, numbers[i]);
            }
            //debug 
            //System.out.printf("numbers.length: %d, n: %d\n", numbers.length, n); 
            
            //output
            if (hasDifference(numbers)) {
                System.out.println("Jolly");
            } else {
                System.out.println("Not jolly");
            }
        }
    }
}
