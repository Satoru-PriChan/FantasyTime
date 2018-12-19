import java.util.*;
import java.io.BufferedInputStream;

//not yet completed

public class Main {
    public static void main(String[] args) throws Exception {
        // Your code here!
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
       
       int[] blackKingLocation = {100, 100};
       int[] whiteKingLocation = {100, 100};
       
       //initial value(X) for the board.
       char[][] board = new char[10][10];
       for (int x = 0; x < 10; x++) {
            Arrays.fill(board[x], 'X');    
       }
       
       //iterators
       int m, n; 
       
       //Nth game
       int nThGame = 0;
       
       //main loop
       while(sc.hasNext()) {
           
           nThGame++;

           //location reset
           whiteKingLocation[0] = 100;
           whiteKingLocation[1] = 100;
           blackKingLocation[0] = 100;
           blackKingLocation[1] = 100;
           
           //input
           for (n = 1; n < 9; n++) {
                String temp = sc.next();
               for (m = 1; m < 9; m++) {
                    
                    board[m][n] = temp.charAt(m - 1);
                    if (board[m][n] == 'K') {
                        whiteKingLocation[0] = m;
                        whiteKingLocation[1] = n;
                    }  else if (board[m][n] == 'k') {
                        blackKingLocation[0] = m;
                        blackKingLocation[1] = n;
                    }
               } 
           }
           
           //empty check
           if (whiteKingLocation[0] == 100) {
               break;
           }
           
           //each king check
           boolean whiteIsInCheck, blackIsInCheck;
           whiteIsInCheck = board[whiteKingLocation[0] + 1][whiteKingLocation[1] + 1] == 'p' ||
                            board[whiteKingLocation[0] - 1][whiteKingLocation[1] + 1] == 'p' ||
                            kingIsInCheck(whiteKingLocation[0], whiteKingLocation[1], board, 'p', 'r', 'b', 'q', 'k', 'n');
           
           blackIsInCheck = board[whiteKingLocation[0] + 1][whiteKingLocation[1] - 1] == 'P' ||
                            board[whiteKingLocation[0] - 1][whiteKingLocation[1] - 1] == 'P' ||
                            kingIsInCheck(blackKingLocation[0], blackKingLocation[1], board, 'P', 'R', 'B', 'Q', 'K', 'N') ;          
            
            //output
            System.out.print("Game #");
            System.out.print(nThGame);
            System.out.print(": ");
            if (whiteIsInCheck) {
                System.out.print("white");
            } else if (blackIsInCheck) {
                System.out.print("black");
            } else {
                System.out.print("no");
            }
            System.out.println(" king is in check.");
        }
    }
  
  //method to calculate to judge whether kings are in check.(other than one by pawn)
            public static boolean kingIsInCheck(int locationM, int locationN, char[][] board, char pawn, char rook, char bishop, char queen, char king, char knight) {
                int m, n;
                //upper diaconally: probably in check by Bishop, Queen, King, and Pawn.
                for (m = locationM + 1, n = locationN + 1; ; m++, n++) {
                    //sqare adjacent to the king. Pawn, King.
                    if ((m == locationM + 1) && (n == locationN + 1) && (board[m][n] == king)) {
                        return true;
                    }
                    
                    //Bishop, Queen
                    if ((board[m][n] == bishop) || (board[m][n] == queen)) {
                        return true;
                    }
                    
                    //other 
                    if (board[m][n] == knight || board[m][n] == rook || board[m][n] == king || board[m][n] == pawn || board[m][n] == 'X') {
                        break;                        
                    }

                }
                
                for (m = locationM - 1, n = locationN + 1; ; m--, n++) {
                    //sqare adjacent to the king. Pawn, King.
                    if ((m == locationM - 1) && (n == locationN + 1) && (board[m][n] == king)) {
                        return true;
                    }
                    
                    //Bishop, Queen
                    if (board[m][n] == bishop || board[m][n] == queen) {
                        return true;
                    }
                    
                    //other 
                    if (board[m][n] == knight || board[m][n] == rook || board[m][n] == king || board[m][n] == pawn || board[m][n] == 'X') {
                        break;                        
                    }

                }
                
                //lower diagonally
                for (m = locationM + 1, n = locationN - 1; ; m++, n++) {
                    //sqare adjacent to the king. Pawn, King.
                    if ((m == locationM + 1) && (n == locationN - 1) && (board[m][n] == king)) {
                        return true;
                    }
                    
                    //Bishop, Queen
                    if (board[m][n] == bishop || board[m][n] == queen) {
                        return true;
                    }
                    
                    //other 
                    if (board[m][n] == knight || board[m][n] == rook || board[m][n] == king || board[m][n] == pawn || board[m][n] == 'X') {
                        break;                        
                    }

                }
                
                for (m = locationM - 1, n = locationN - 1; ; m--, n++) {
                    //sqare adjacent to the king. Pawn, King.
                    if ((m == locationM - 1) && (n == locationN - 1) && (board[m][n] == king)) {
                        return true;
                    }
                    
                    //Bishop, Queen
                    if (board[m][n] == bishop || board[m][n] == queen) {
                        return true;
                    }
                    
                    //other 
                    if (board[m][n] == knight || board[m][n] == rook || board[m][n] == king || board[m][n] == pawn || board[m][n] == 'X') {
                        break;                        
                    }

                }
                    
                 //vertically
                for (m = locationM + 1, n = locationN;; m++) {
                    //adjacent square: king
                    if ((m == locationM + 1) && board[m][n] == king) {
                        return true;
                    }
                    
                    //Rook, Queen
                    if (board[m][n] == rook || board[m][n] == queen) {
                        return true;
                    }
                    
                    //other
                    if (board[m][n] == pawn || board[m][n] == bishop || board[m][n] == king || board[m][n] == knight || board[m][n] == 'X') {
                        break;
                    }
                }
                
                for (m = locationM - 1, n = locationN;; m++) {
                    //adjacent square: king
                    if ((m == locationM - 1) && board[m][n] == king) {
                        return true;
                    }
                    
                    //Rook, Queen
                    if (board[m][n] == rook || board[m][n] == queen) {
                        return true;
                    }
                    
                    //other
                    if (board[m][n] == pawn || board[m][n] == bishop || board[m][n] == king || board[m][n] == knight || board[m][n] == 'X') {
                        break;
                    }
                }
                
                //horizontally
                for (m = locationM, n = locationN + 1;; n++) {
                    //adjacent square: king
                    if ((n == locationN + 1) && board[m][n] == king) {
                        return true;
                    }
                    
                    //Rook, Queen
                    if (board[m][n] == rook || board[m][n] == queen) {
                        return true;
                    }
                    
                    //other
                    if (board[m][n] == pawn || board[m][n] == bishop || board[m][n] == king || board[m][n] == knight || board[m][n] == 'X') {
                        break;
                    }
                }
                
                for (m = locationM, n = locationN - 1;; n--) {
                    //adjacent square: king
                    if ((n == locationN - 1) && board[m][n] == king) {
                        return true;
                    }
                    
                    //Rook, Queen
                    if (board[m][n] == rook || board[m][n] == queen) {
                        return true;
                    }
                    
                    //other
                    if (board[m][n] == pawn || board[m][n] == bishop || board[m][n] == king || board[m][n] == knight || board[m][n] == 'X') {
                        break;
                    }
                }
                
                //knight
                m = locationM;
                n = locationN;
                if (board[m - 1][n - 1] == knight || 
                    board[m - 1][n] == knight     || 
                    board[m - 1][n + 1] == knight || 
                    board[m][n - 1] == knight     || 
                    board[m][n + 1] == knight     || 
                    board[m + 1][n - 1] == knight || 
                    board[m + 1][n] == knight     || 
                    board[m + 1][n + 1] == knight   ) {
                        return true;
                }
                
            return false;
            }    
}
