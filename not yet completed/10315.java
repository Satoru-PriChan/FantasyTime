import java.util.*;
import java.io.BufferedInputStream;

//class for Hand
class Hand {
    
    boolean madeUpOfSameSuit;
    boolean consecutiveValues;
    //9: Straight flush 8: Four of a kind 7: Full House 6: Flush 5: Straight 
    //4: Three of a kind 3: Two pairs 2: Pair 1: High card
    int rank;
    int[] nums;
    
    
    //constructor
    public Hand(boolean _madeUpOfSameSuit, int[] _nums) {
        this.madeUpOfSameSuit = _madeUpOfSameSuit;
        
        //debug
        System.out.print("Hand constructor: ");
        for (int u: _nums) {
            System.out.printf("%d ", u);
        }
        System.out.println();
        
        //[2]: the number of Pair(0, 1, 2) [3]: if Three of a kind exists(1) or not(0)
        //[4]: if Four of a kind exists(1) or not(0)
        int[] sameNum = new int[6];
        
        //iterators
        int i, j;
        int temp;
        
        int sameNumCount = 0;
        
        //sort
        for (i = 0; i < _nums.length - 1; i++) {
            for (j = i + 1; j < _nums.length; j++) {
                //debug
                //System.out.printf("//sort: i: %d, j: %d\n", i, j);
                if (_nums[i] < _nums[j]) {
                    //debug
                    //System.out.printf("//sort: gonna exchange values: _nums[i]: %d, _nums[j]: %d\n", _nums[i], _nums[j]);
                    temp = _nums[i];
                    _nums[i] = _nums[j];
                    _nums[j] = temp;
                }
            }
        }
        
        this.nums = _nums;
        //debug
        /*
        System.out.printf("after //sort: this.nums: \n");
        for (int n: this.nums) {
            System.out.printf("%d ", n);
        } 
        System.out.println();
        */
        
        //check if same numbers
        for (i = 0; i < _nums.length - 1; i++) {
            if (_nums[i] == _nums[i + 1]) {
                sameNumCount++;
                //debug
                //System.out.printf("check if same numbers: _nums[i]: %d == _nums[i + 1]: %d, then sameNumCount: %d\n", _nums[i], _nums[i + 1], sameNumCount);
            } else {
                
                sameNum[sameNumCount + 1]++;
                sameNumCount = 0;
                //debug
                //System.out.printf("check if same numbers: _nums[i]: %d != _nums[i + 1]: %d, then sameNumCount: %d, sameNum[sameNumCount + 1]: %d\n", _nums[i], _nums[i + 1], sameNumCount, sameNum[sameNumCount + 1]);
            }
        }
        if (sameNumCount > 0) {
            sameNum[sameNumCount + 1]++;
            sameNumCount = 0;
        }
        //debug
        /*
        System.out.printf("after same numbers check: sameNum: ");
        for (int m : sameNum) {
            System.out.printf("%d ", m);
        }
        System.out.println();
        */
        
        //check if consecutive values
        boolean _consecutiveValues = false;
        for (int k = 0; k < nums.length - 1; k++) {
            if (nums[k] != nums[k + 1] + 1) {
                _consecutiveValues = false;
                //debug
                //System.out.printf("check if consecutive values: nums[k]: %d, nums[k + 1] : %d, then gonna break\n", nums[k], nums[k + 1]);
                break;
            } else {
                //debug
                //System.out.printf("check if consecutive values: nums[k]: %d, nums[k + 1] : %d, consecutive.\n", nums[k], nums[k + 1]);
                _consecutiveValues = true;
            }
        }
        //debug
        //System.out.printf("after consecutive check: this.consecutiveValues: %s\n", _consecutiveValues ? "true" : "false");
        this.consecutiveValues = _consecutiveValues;
        
        //chechk what rank
        if (_madeUpOfSameSuit && _consecutiveValues) {
            this.rank = 9;
        } else if (sameNum[4] == 1) {
            this.rank = 8;
        } else if (sameNum[3] == 1 & sameNum[2] == 1) {
            this.rank = 7;
        } else if (_madeUpOfSameSuit) {
            this.rank = 6;
        } else if (_consecutiveValues) {
            this.rank = 5;
        } else if (sameNum[3] == 1) {
            this.rank = 4;
        } else if (sameNum[2] == 2) {
            this.rank = 3;
        } else if (sameNum[2] == 1) {
            this.rank = 2;
        } else {
            this.rank = 1;
        }
        //debug
        System.out.printf("after constructor: this.rank: %d\n\n", this.rank);
    }
}

public class Main {
   
    public static void main(String[] args) throws Exception {
        // Your code here!
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n;//the number of elements in each line
        
        int i;//iterator
        
        //numbers for each hand
        int[] numHand = new int[10];
        char[] suitHand = new char[10];
        char tmp;
        //debug: Driver
        /*
        Hand hand1 = new Hand(false, new int[] {2, 3, 5, 9, 13});
        Hand hand2 = new Hand(false, new int[] {2, 3, 4, 8, 14});
        hand1 = new Hand(false, new int[] {2, 4, 4, 2, 4});
        hand2 = new Hand(false, new int[] {2, 8, 14, 12, 3});
        hand1 = new Hand(false, new int[] {14, 14, 14, 13, 14});
        hand2 = new Hand(false, new int[] {1, 3, 4, 5, 2});
        hand1 = new Hand(true, new int[] {6, 8, 7, 9, 10});
        hand2 = new Hand(false, new int[] {2, 3, 5, 9, 13});
        */
       
       //main loop
       
       
        while(sc.hasNext()) {
           //input
           for (i = 1; i <= 20; i++) {
               switch (i % 2) {
                   //odd number
                   case 1:
                        tmp = sc.next().charAt(0);
                        swich tmp {
                            case 'A':
                                numHand[i >> 1] = 14;
                                break;
                            case 'K':
                                numHand[i >> 1] = 13;
                                break;
                            case 'Q':
                                numHand[i >> 1] = 12;
                                break;
                            case 'J':
                                numHand[i >> 1] = 11;
                                break;
                            case 'T':
                                numHand[i >> 1] = 10;
                                break;
                            default:
                                numHand[i >> 1] = tmp - '0';
                        }
                        break;
                    //even number
                    default:
                        suitHand[(i >> 1) - 1] = sc.next().charAt(0);
                    
               }
           }
           
           //judge & output
           Hand white, black;
           if (suitHand[0] == suitHand[1] && suitHand[1] == suitHand[2] && suitHand[2] == suitHand[3] && suitHand[3] == suitHand[4]) {
               black = new Hand(true, Arrays.copyOfRange(numHand, 0, 4));
           } else {
               black = new Hand(false, Arrays.copyOfRange(numHand, 0, 4));
           }
           if (suitHand[5] == suitHand[6] && suitHand[6] == suitHand[7] && suitHand[7] == suitHand[8] && suitHand[8] == suitHand[9]) {
               white = new Hand(true, Arrays.copyOfRange(numHand, 5, 9));
           } else {
               white = new Hand(false, Arrays.copyOfRange(numHand, 5, 9));
           }
           
           if (black.rank > white.rank) {
               System.out.println("Black wins.");
           } else if (black.rank < white.rank) {
               System.out.println("White wins.");
           } else {
               //same rank
               switch (black.rank) {
                   case 
               }
           }
           
           
        
        }
    }
}
