import java.util.*;
import java.io.BufferedInputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        // Your code here!
        
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int i, j, x, max, min, maxCycleLength = 0;
        int cycleLength;
        
        while(sc.hasNext()) {
            //get i and j from input
            i = sc.nextInt();
            j = sc.nextInt();
        	//don't forget reset maxCycleLength each time
            maxCycleLength = 0;
            
            //i and j's are unclear in whether either one is greater, so check it.
            if (i > j) {
                max = i;
                min = j;
            } else {
                max = j;
                min = i;
            }
            
            //short cut:  you only need to calculate value from max to the half value of max. Because this problem tells us 
            //to submit just the MAX cycle length.
            //for example max: 200 min: 0 -> max: 200 min: 100
            //max: 100 min: 25 -> max: 100 min: 50
            if (min < (max / 2)) {
                min = (max / 2);
            }
            
            
            //outer loop i ~ j (or j ~ i)
            for (cycleLength = 1;min <= max; min++, cycleLength = 1) {
                x = min;
                //inner loop perform operation written on the problem
                while (x != 1) {
                    if(x % 2 == 1){
                        x = 3 * x + 1;
                    	//shift operator is faster than division operator
                        x >>= 1;
                        cycleLength += 2;
                    } else {
                        x >>= 1;
                        cycleLength += 1;
                    }
                }
                
            	//debug
                //System.out.println("cycleLength: " + cycleLength + " min: " + min + " x: " + x);
                if (cycleLength > maxCycleLength) {
                    maxCycleLength = cycleLength;
                    //debug
                    //System.out.println("maxCycleLength: " + maxCycleLength + " value: " + min + " x: " + x);
                } 
                
            }
            System.out.println(i + " " + j + " " + maxCycleLength);
        }
    }
}
