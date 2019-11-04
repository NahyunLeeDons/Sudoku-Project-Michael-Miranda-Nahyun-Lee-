public class display{
    private static int WhyNot = 0; //Why not?
    
    /*
     * This prints out the entire board
     */
    public static void board(cellData [][] gameBoard){
    for (int row2 = 0; row2 < 9; row2 ++)
        {
            boardRow(gameBoard, row2);
        }
    }
    
    /*
     *This just prints out a row of the gameBoard 
     */
    public static void boardRow(cellData [][] gameBoard, int row)
    
    {   
        String thisRow = "";
        //Top row
        thisRow += String.format("X---XX---XX---XX---XX---XX---XX---XX---XX---X\n");
        
        //Depending on the error values will change how each cell will print
        
        //2nd Row
        for (int index = 0; index < 9; index++){
            if (gameBoard[row][index].getColError() && gameBoard[row][index].getBoxError()){
                thisRow += "|*C*|";
            }
            else if(gameBoard[row][index].getColError()){
                thisRow += "| C |";
            }
            else if(gameBoard[row][index].getBoxError()){
                thisRow += "|* *|";
            }
            else{
                thisRow += "|   |";
            }
            if (index == 8){
                thisRow += "\n";
            }
        }
        
        //Middle Row
        for (int index = 0; index < 9; index++){
            if (gameBoard[row][index].getRowError()){
                thisRow += String.format("|R%dR|",gameBoard[row][index].getNumber());
            }
            else{
                thisRow += String.format("| %d |",gameBoard[row][index].getNumber());
            }
            if (index == 8){
                thisRow += "\n";
            }
        }
        
        //4th row [copy of second]
        for (int index = 0; index < 9; index++){
            if (gameBoard[row][index].getColError() && gameBoard[row][index].getBoxError()){
                thisRow += "|*C*|";
            }
            else if(gameBoard[row][index].getColError()){
                thisRow += "| C |";
            }
            else if(gameBoard[row][index].getBoxError()){
                thisRow += "|* *|";
            }
            else{
                thisRow += "|   |";
            }
            if (index == 8){
                thisRow += "\n";
            }
        }
        
        //Last row [copy of first]
        thisRow += String.format("X---XX---XX---XX---XX---XX---XX---XX---XX---X\n");
        
        System.out.print(thisRow);
    }
    
   
    
    
}