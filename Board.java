
/*Board.java
 initializing the board
 */
public class Board  
{
    /*
     *  Used in the beginning to see if the values is a starter and cannot be changed 
     */
   public static void initlize(cellData [][] gameBoard){
       for(int x = 0; x < 9; x++){
           for(int y =0; y < 9; y++ ){
               if (gameBoard[x][y].getNumber()!= 0){
                   gameBoard[x][y].trueStarter();
                }
           }
       }
    } 
    
    /*
     *  Sets all number values in every cell to zero
     */
   public static void reset(cellData [][] gameBoard){
       for(int x = 0; x < 9; x++){
           for(int y =0; y < 9; y++ ){
               gameBoard[x][y].setNumber(0);
           }
       }
    }
    
    /*
     *  Predefined valeus for this build
     */
    public static void setBoard(cellData[][] gameBoard)
    {
        reset(gameBoard);
        // put your code here
        gameBoard[0][0].setNumber(7); //Change the value for one of the cells - does it work?
        gameBoard[0][2].setNumber(5);
        gameBoard[0][4].setNumber(4);
        gameBoard[0][6].setNumber(3);
        gameBoard[0][8].setNumber(6);
        
        gameBoard[1][1].setNumber(4);
        
        gameBoard[2][0].setNumber(3);
        gameBoard[2][4].setNumber(5);
        gameBoard[2][5].setNumber(7);
        gameBoard[2][8].setNumber(2);
        
        gameBoard[3][1].setNumber(9);
        gameBoard[3][4].setNumber(1);
        gameBoard[3][7].setNumber(7);
        
        gameBoard[4][2].setNumber(6);
        gameBoard[4][3].setNumber(9);
        gameBoard[4][5].setNumber(5);
        gameBoard[4][6].setNumber(2);
        
        gameBoard[5][1].setNumber(1);
        gameBoard[5][4].setNumber(2);
        gameBoard[5][7].setNumber(4);
        
        gameBoard[6][0].setNumber(1);
        gameBoard[6][3].setNumber(2);
        gameBoard[6][4].setNumber(3);
        gameBoard[6][8].setNumber(4);
        
        gameBoard[7][7].setNumber(8);
        
        gameBoard[8][0].setNumber(6);
        gameBoard[8][2].setNumber(4);
        gameBoard[8][4].setNumber(7);
        gameBoard[8][6].setNumber(9);
        gameBoard[8][8].setNumber(3);
        
    }
    
    /*
     *  Answers for this build
     */
    public static void setAnswers(cellData[][] answerBoard){
        answerBoard[0][0].setNumber(7); 
        answerBoard[0][1].setNumber(2); 
        answerBoard[0][2].setNumber(5); 
        answerBoard[0][3].setNumber(8); 
        answerBoard[0][4].setNumber(4); 
        answerBoard[0][5].setNumber(9); 
        answerBoard[0][6].setNumber(3); 
        answerBoard[0][7].setNumber(1); 
        answerBoard[0][8].setNumber(6); 
        
        answerBoard[1][0].setNumber(9); 
        answerBoard[1][1].setNumber(4); 
        answerBoard[1][2].setNumber(1); 
        answerBoard[1][3].setNumber(3); 
        answerBoard[1][4].setNumber(6); 
        answerBoard[1][5].setNumber(2); 
        answerBoard[1][6].setNumber(8); 
        answerBoard[1][7].setNumber(5); 
        answerBoard[1][8].setNumber(7); 
        
        answerBoard[2][0].setNumber(3); 
        answerBoard[2][1].setNumber(6); 
        answerBoard[2][2].setNumber(8); 
        answerBoard[2][3].setNumber(1); 
        answerBoard[2][4].setNumber(5); 
        answerBoard[2][5].setNumber(7); 
        answerBoard[2][6].setNumber(4); 
        answerBoard[2][7].setNumber(9); 
        answerBoard[2][8].setNumber(2); 
        
        answerBoard[3][0].setNumber(5); 
        answerBoard[3][1].setNumber(9); 
        answerBoard[3][2].setNumber(2); 
        answerBoard[3][3].setNumber(4); 
        answerBoard[3][4].setNumber(1); 
        answerBoard[3][5].setNumber(3); 
        answerBoard[3][6].setNumber(6); 
        answerBoard[3][7].setNumber(7); 
        answerBoard[3][8].setNumber(8); 
        
        answerBoard[4][0].setNumber(4); 
        answerBoard[4][1].setNumber(7); 
        answerBoard[4][2].setNumber(6); 
        answerBoard[4][3].setNumber(9); 
        answerBoard[4][4].setNumber(8); 
        answerBoard[4][5].setNumber(5); 
        answerBoard[4][6].setNumber(2); 
        answerBoard[4][7].setNumber(3); 
        answerBoard[4][8].setNumber(1); 
        
        answerBoard[5][0].setNumber(8); 
        answerBoard[5][1].setNumber(1); 
        answerBoard[5][2].setNumber(3); 
        answerBoard[5][3].setNumber(7); 
        answerBoard[5][4].setNumber(2); 
        answerBoard[5][5].setNumber(6); 
        answerBoard[5][6].setNumber(5); 
        answerBoard[5][7].setNumber(4); 
        answerBoard[5][8].setNumber(9); 
        
        answerBoard[6][0].setNumber(1); 
        answerBoard[6][1].setNumber(5); 
        answerBoard[6][2].setNumber(9); 
        answerBoard[6][3].setNumber(2); 
        answerBoard[6][4].setNumber(3); 
        answerBoard[6][5].setNumber(8); 
        answerBoard[6][6].setNumber(7); 
        answerBoard[6][7].setNumber(6); 
        answerBoard[6][8].setNumber(4); 
        
        answerBoard[7][0].setNumber(2); 
        answerBoard[7][1].setNumber(3); 
        answerBoard[7][2].setNumber(7); 
        answerBoard[7][3].setNumber(6); 
        answerBoard[7][4].setNumber(9); 
        answerBoard[7][5].setNumber(4); 
        answerBoard[7][6].setNumber(1); 
        answerBoard[7][7].setNumber(8); 
        answerBoard[7][8].setNumber(5); 
        
        answerBoard[8][0].setNumber(6); 
        answerBoard[8][1].setNumber(8); 
        answerBoard[8][2].setNumber(4); 
        answerBoard[8][3].setNumber(5); 
        answerBoard[8][4].setNumber(7); 
        answerBoard[8][5].setNumber(1); 
        answerBoard[8][6].setNumber(9); 
        answerBoard[8][7].setNumber(2); 
        answerBoard[8][8].setNumber(3);
    }
}
