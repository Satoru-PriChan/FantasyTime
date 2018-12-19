import java.util.*;
import java.io.BufferedInputStream;

public class Main {

  public static void main(String[] args) throws Exception {
    int s;
  String digitString;
  Scanner sc = new Scanner(new BufferedInputStream(System.in));
  
  /*
  LED representation for each number, according to 
  the following convention.
  
    -0-
    |  |
    2  1
    |  |
    -3-
    |  |
    5  4
    |  |
    -6-
    
  */
  
  final String[][] conversionTable = new String[][]{
              /* 0   1   2   3   4   5   6  */
      /* 0 */  {"-","|","|"," ","|","|","-"},
      /* 1 */  {" ","|"," "," ","|"," "," "},
      /* 2 */  {"-","|"," ","-"," ","|","-"},
      /* 3 */  {"-","|"," ","-","|"," ","-"},
      /* 4 */  {" ","|","|","-","|"," "," "},
      /* 5 */  {"-"," ","|","-","|"," ","-"},
      /* 6 */  {"-"," ","|","-","|","|","-"},
      /* 7 */  {"-","|"," "," ","|"," "," "},
      /* 8 */  {"-","|","|","-","|","|","-"},
      /* 9 */  {"-","|","|","-","|"," ","-"}
  };
  
  //iterators
  int i, j, k;
  
  while (sc.hasNext()) {
      s = sc.nextInt();
      digitString = sc.next();
      
      //check if the number is equal to 0.
      if (s == 0) {
          break;
      } 
      
      int n = digitString.length();
      int digit;
      
      for (i = 0; i< 2*s + 3; i++) {
          for (j = 0; j < n; j++) {
              //ASCII code number: you can get corresponding integer.
              char zero = '0';
              digit = digitString.charAt(j) - zero;
              
              //upper, middle, and lower parts
              if (i % (s + 1) == 0) {
                  System.out.print(" ");
                  for (k = 0; k < s; k++) {
                      System.out.print(conversionTable[digit][i / (s + 1) * 3]);
                  }
                  System.out.print(" ");
              }
              
              //between upper and middle parts
              if (i > 0 && i < (s + 1)) {
                  System.out.print(conversionTable[digit][2]);
                  for (k = 0; k < s; k++) {
                      System.out.print(" ");
                  }
                  System.out.print(conversionTable[digit][1]);
              }
              
              //between middle and lower parts
              if (i > (s + 1) && i < (2*s + 2)) {
                  System.out.print(conversionTable[digit][5]);
                  for (k = 0; k < s; k++) {
                      System.out.print(" ");
                  }
                  System.out.print(conversionTable[digit][4]);
              }
              
              if (j != n - 1) {
                  System.out.print(" ");
              }
          }
          System.out.print("\n");
      }
      System.out.print("\n");
      
  }
  
  }
}