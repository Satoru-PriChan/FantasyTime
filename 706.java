import java.util.*;
import java.io.BufferedInputStream;

public class Main {
    
    //method for getting string in the top, third, and fifth line of printed numbers.
    public static ArrayList<String> strForHorizontal(DrawnArea area, ArrayList<Integer> digits, int side) {
        ArrayList<String> line = new ArrayList<String>();
        for (int digit : digits) {
             line.add(letters.blank);
             for (int i = 1; i <= side; i++) {
                line.add(area.toBePrintedChar(digit));
             }
             line.add(letters.blank);
             line.add(letters.blank);
        }
        line.remove(line.size() - 1);
        return line;
    }
    
    //method for getting string in the second, fourth line of printed numbers.
    public static ArrayList<String> strForVertical(DrawnArea leftArea, DrawnArea rightArea, ArrayList<Integer> digits, int side) {
        ArrayList<String> line = new ArrayList<String>();
        for (int digit : digits) {
            line.add(leftArea.toBePrintedChar(digit));
            for (int i = 1; i <= side; i++) {
                line.add(letters.blank);
            }
            line.add(rightArea.toBePrintedChar(digit));
            line.add(letters.blank);
        }
        line.remove(line.size() - 1);
        return line;
    }
    
    public static void main(String[] args) throws Exception {
        // Your code here!
        
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int side, number = 0;
        while (sc.hasNext()) {
          side = sc.nextInt();
          number = sc.nextInt();
          
          //check input end flag
          if (side == 0 && number == 0) {
              break;
          }
          
          //get each digit
          ArrayList<Integer> digits = new ArrayList<Integer>();
          do {
              digits.add(number % 10);
              number *= 0.1;
          } while(number > 0);
          Collections.reverse(digits);
          
          //print TOP
          DrawnArea area = DrawnArea.TOP;
          for (String str : strForHorizontal(area, digits, side)) {
              System.out.print(str);
          }
          System.out.print("\n");
          
          //print SECOND
          DrawnArea leftArea = DrawnArea.SECOND_LEFT;
          DrawnArea rightArea = DrawnArea.SECOND_RIGHT;
          ArrayList<String> strs = strForVertical(leftArea, rightArea, digits, side);
          for (int i = 1; i <= side; i++) {
            for (String str : strs) {
              System.out.print(str);
            }
            System.out.print("\n");
          }
          
          //print THIRD
          area = DrawnArea.THIRD;
          for (String str : strForHorizontal(area, digits, side)) {
              System.out.print(str);
          }
          System.out.print("\n");
          
          //print FOURTH
          leftArea = DrawnArea.FOURTH_LEFT;
          rightArea = DrawnArea.FOURTH_RIGHT;
          strs = strForVertical(leftArea, rightArea, digits, side);
          for (int i = 1; i <= side; i++) {
            for (String str : strs) {
              System.out.print(str);
            }
            System.out.print("\n");
          }
          
          //print FIFTH
          area = DrawnArea.FIFTH;
          for (String str : strForHorizontal(area, digits, side)) {
              System.out.print(str);
          }
          System.out.print("\n");
        }
    }
}

//letters to be printed.
class letters {
    static String horizontalBar = "-";
    static String verticalBar = "|";
    static String blank = " ";
}

//seven areas to draw bars when you print numbers.
enum DrawnArea {
    TOP, SECOND_LEFT, SECOND_RIGHT, THIRD, FOURTH_LEFT, FOURTH_RIGHT, FIFTH;
    
    public String toBePrintedChar(int singleDigitNumber) {
        switch (singleDigitNumber) {
            case 0:
                switch (this) {
                    case TOP:
                        return letters.horizontalBar;
                    case SECOND_LEFT:
                        return letters.verticalBar;
                    case SECOND_RIGHT:
                        return letters.verticalBar;
                    case THIRD:
                        return letters.blank;
                    case FOURTH_LEFT:
                        return letters.verticalBar;
                    case FOURTH_RIGHT:
                        return letters.verticalBar;
                    case FIFTH:
                        return letters.horizontalBar;
                }
            case 1:
                switch (this) {
                    case TOP:
                        return letters.blank;
                    case SECOND_LEFT:
                        return letters.blank;
                    case SECOND_RIGHT:
                        return letters.verticalBar;
                    case THIRD:
                        return letters.blank;
                    case FOURTH_LEFT:
                        return letters.blank;
                    case FOURTH_RIGHT:
                        return letters.verticalBar;
                    case FIFTH:
                        return letters.blank;
                }
            case 2:
                switch (this) {
                    case TOP:
                        return letters.horizontalBar;
                    case SECOND_LEFT:
                        return letters.blank;
                    case SECOND_RIGHT:
                        return letters.verticalBar;
                    case THIRD:
                        return letters.horizontalBar;
                    case FOURTH_LEFT:
                        return letters.verticalBar;
                    case FOURTH_RIGHT:
                        return letters.blank;
                    case FIFTH:
                        return letters.horizontalBar;
                }
            case 3:
                switch (this) {
                    case TOP:
                        return letters.horizontalBar;
                    case SECOND_LEFT:
                        return letters.blank;
                    case SECOND_RIGHT:
                        return letters.verticalBar;
                    case THIRD:
                        return letters.horizontalBar;
                    case FOURTH_LEFT:
                        return letters.blank;
                    case FOURTH_RIGHT:
                        return letters.verticalBar;
                    case FIFTH:
                        return letters.horizontalBar;
                }
            case 4:
                switch (this) {
                    case TOP:
                        return letters.blank;
                    case SECOND_LEFT:
                        return letters.verticalBar;
                    case SECOND_RIGHT:
                        return letters.verticalBar;
                    case THIRD:
                        return letters.horizontalBar;
                    case FOURTH_LEFT:
                        return letters.blank;
                    case FOURTH_RIGHT:
                        return letters.verticalBar;
                    case FIFTH:
                        return letters.blank;
                }
            case 5:
                switch (this) {
                    case TOP:
                        return letters.horizontalBar;
                    case SECOND_LEFT:
                        return letters.verticalBar;
                    case SECOND_RIGHT:
                        return letters.blank;
                    case THIRD:
                        return letters.horizontalBar;
                    case FOURTH_LEFT:
                        return letters.blank;
                    case FOURTH_RIGHT:
                        return letters.verticalBar;
                    case FIFTH:
                        return letters.horizontalBar;
                }
            case 6:
                switch (this) {
                    case TOP:
                        return letters.horizontalBar;
                    case SECOND_LEFT:
                        return letters.verticalBar;
                    case SECOND_RIGHT:
                        return letters.blank;
                    case THIRD:
                        return letters.horizontalBar;
                    case FOURTH_LEFT:
                        return letters.verticalBar;
                    case FOURTH_RIGHT:
                        return letters.verticalBar;
                    case FIFTH:
                        return letters.horizontalBar;
                }
            case 7:
                switch (this) {
                    case TOP:
                        return letters.horizontalBar;
                    case SECOND_LEFT:
                        return letters.blank;
                    case SECOND_RIGHT:
                        return letters.verticalBar;
                    case THIRD:
                        return letters.blank;
                    case FOURTH_LEFT:
                        return letters.blank;
                    case FOURTH_RIGHT:
                        return letters.verticalBar;
                    case FIFTH:
                        return letters.blank;
                }
            case 8:
                switch (this) {
                    case TOP:
                        return letters.horizontalBar;
                    case SECOND_LEFT:
                        return letters.verticalBar;
                    case SECOND_RIGHT:
                        return letters.verticalBar;
                    case THIRD:
                        return letters.horizontalBar;
                    case FOURTH_LEFT:
                        return letters.verticalBar;
                    case FOURTH_RIGHT:
                        return letters.verticalBar;
                    case FIFTH:
                        return letters.horizontalBar;
                }
            case 9:
                switch (this) {
                    case TOP:
                        return letters.horizontalBar;
                    case SECOND_LEFT:
                        return letters.verticalBar;
                    case SECOND_RIGHT:
                        return letters.verticalBar;
                    case THIRD:
                        return letters.horizontalBar;
                    case FOURTH_LEFT:
                        return letters.blank;
                    case FOURTH_RIGHT:
                        return letters.verticalBar;
                    case FIFTH:
                        return letters.horizontalBar;
                }
        }
        return "!";
    }
}