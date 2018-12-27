import java.util.*;
import java.io.BufferedInputStream;

public class Main {
    
    
         //method to make calendar where you can see whether each day is in strike.
        //you can pass to numberOfDays from N or pseudoLCM, the smaller of the two.
        //hartal should be start from [0]...
        public static int[] makeCalendar(int numberOfDays, int numberOfParties, int[] hartal) {
            int j, k;
            int[] cal = new int[numberOfDays + 1];
            
            //debug
            System.out.printf("makeCallendar: numberOfDays: %d, numberOfParties: %d, hartal.length: %d.\n", numberOfDays, numberOfParties, hartal.length);
            
            outer: for (j = 0; j < numberOfDays; j++) {
                //Saturday or Friday
                if (((j + 1) % 7) == 0 || ((j + 1) % 7) == 6) {
                    cal[j + 1] = 0;
                    //debug
                    System.out.printf("makeCallendar: %dth day is Friday, or Saturday.\n", (j + 1));
                    continue;
                } else {
                    inner: for (k = 0; k < hartal.length; k++) {
                        if ((j + 1) % hartal[k] == 0) {
                            cal[j + 1] = 1;
                            //debug
                            System.out.printf("makeCallendar: %dth day is on strike.\n", (j + 1));
                            continue outer;
                        }
                    }
                    cal[j + 1] = 0;
                    //debug
                    System.out.printf("makeCallendar: %dth day is not on strike.\n", (j + 1));
                }
            }
            
            return cal;
        }
   
    public static void main(String[] args) throws Exception {
        // Your code here!
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        
        //the number of days
        int N;
        
        //the number of political parties
        int P;
 
        //hartal parameter for each political party.
        //hartal[101] :the first party hartal[102]: the second party...
        int[] hartal = new int[300];
        
        //variable to memorise if each day has strike or not.
        //value 0: no strikes 1: a strike exists
        int[] callender = new int[5650];
        
        //iterator
        int i;
        
        //temporal
        int temp;
        int removedParty = 0;
        int answer;
        //ideally Least Common Multiple is called for, but it is hassle to calculate,
        //so just multiply each hartal and assign the product to this variable.
        int pseudoLCM;
        
        //the number of test cases
        int T = sc.nextInt();
        
        if (T < 1) {
            return;
        }
        
       //main loop
        for (; T > 0; T--) {
            removedParty = 0;
            temp = 0;
            answer = 0;
            pseudoLCM = 1;
            
            N = sc.nextInt();
            P = sc.nextInt();
            
            //get hartal parameters
            for (i = 0; i < P; i++) {
                temp = sc.nextInt();
                if (temp < N) {
                    hartal[i + 1] = temp;
                    //debug
                    System.out.printf("//get hartal parameters: hartal[i:%d + 1]: %d\n", i,  hartal[i + 1]);    
                } else {
                    //hartal is larger than N, so do not need to consider the hartal.
                    removedParty++;
                    //debug
                    System.out.printf("//get hartal parameters: %dth party is removed, cause it\'s hartal is %d, larger than the number of days %d. removed party is %d\n",
                    (i + 1), temp, N, removedParty);  
                    continue;
                }
                
            }
            
            //reduce party number
            P -= removedParty;
            //debug
            System.out.printf("//reduce party number: removed party is %d, then P is in the end %d\n", removedParty, P);
            
            //get pseudoLCM
            for (i = 0; i < P; i++) {
                pseudoLCM *= hartal[i + 1];
            }
            //debug
            System.out.printf("//get pseudoLCM: %d\n", pseudoLCM);
            
            //count 
            if (pseudoLCM < N) {
                callender = makeCalendar(pseudoLCM, P, Arrays.copyOfRange(hartal, 101, 100 + P));
                int a = 0, b = 0;
                for (i = 1; i <= N - pseudoLCM; i++) {
                    //debug
                    System.out.printf("//count: pseudoLCM < N: i: %d, a: %d, b: %d\n", i, a, b);
                    if (callender[i] == 1) {
                        a++;
                        b++;
                        //debug
                        System.out.printf("//count: pseudoLCM < N: a and b added: i: %d, a: %d, b: %d\n", i, a, b);
                    }
                }
                for (; i <= N; i++) {
                    b++;
                    //debug
                    System.out.printf("//count: pseudoLCM < N: b added: i: %d, a: %d, b: %d\n", i, a, b);
                }
                
                //answer
                System.out.printf("%d\n", (a + (b - a)*(N / pseudoLCM)));
            } else {
                int a = 0;
                callender = makeCalendar(N, P, Arrays.copyOfRange(hartal, 1, P + 1));
                for (int date : callender) {
                    if (date == 1) {
                        a++;
                    }  
                }
                //answer
                System.out.printf("%d\n", a);
            }
            
        }
        
    }
}
