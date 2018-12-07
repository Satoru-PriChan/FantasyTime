import java.util.*;
import java.io.BufferedInputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        // Your code here!
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int num;
        double[] payment = new double[1005];
        while (sc.hasNext()) {
            //get student's number
            num = sc.nextInt();
            
            //check end flag
            if (num == 0) {
                break;
            }
            double average = 0.0;
            //get the costs each student paid
            for (int i = 1; i <= num; i++) {
                payment[i] = sc.nextDouble();
                average += payment[i];
            }
            average /= num;
            
            //calculate positive difference and negative difference
            double positiveDifference = 0.0;
            double negativeDifference = 0.0;
            for (int j = 1; j <= num; j++) {
                if (payment[j] >= average) {
                    //round off to the 2nd place of decimal point.
                    positiveDifference += (long)((payment[j] - average) * 100) * 0.01;
                } else {
                    negativeDifference += (long)((average - payment[j]) * 100) * 0.01;
                }
            }
            
            //output Don't forget format 
            double answer = ((positiveDifference < negativeDifference) ? negativeDifference:positiveDifference);
            System.out.printf("$%.2f\n", answer);
        }
    }
}