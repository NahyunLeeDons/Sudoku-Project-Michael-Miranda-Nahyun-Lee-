import java.util.Scanner;
import java.util.InputMismatchException;
public class reader
{
    private static Scanner input = new Scanner(System.in); /* 
                                                            Input is ouside of any one method
                                                            If it needs to be reused again.           
                                                            */
    
    /*
    * only 0 - 9
    */
    public static int readIntOneNine()
        {
            boolean reset = false;
            int number = 0;
            
            System.out.println("Enter a number between 1 - 9!\n");
            do
            {
                try
                {
                    number = input.nextInt();
                    
                    if (number < 1 ||number > 9)
                    {
                        throw new Exception("Enter a number between 1 - 9!\n");
                    }
                    reset = false; // Breaks out of loop
                }
                catch(InputMismatchException e) //User inputs a string or float.
                {
                    System.out.println("Enter a number between 1 - 9!\n");
                    input.nextLine(); // Clear Buffer
                    reset = true; // Resets the Loop
                }
                catch(Exception e)              //Catches Exception if number is less than 0 or greater than 9.
                {
                    System.out.println("Enter a number between 1 - 9!\n");
                    input.nextLine(); // Clear Buffer
                    reset = true; // Resets the Loop
                }
            }
            while(reset);
            return number;
    }
    
    /*
    *   only 1-12 [0 is the cheat button]
    */
    public static int readIntOptions() // 
        {
            boolean reset   = false;
            int number      = 0;
            String prompt   = "Enter a number Between 1 - 11!\n" + 
                              "1 - 9 To set number\n" + 
                              "10 to Display all Options for the Cell\n" +
                              "11 to Display a key to reading this\n" +
                              "12 to Reset the board\n\n";
            System.out.println(prompt);
            do
            {
                try
                {
                    number = input.nextInt();
                    
                    if (number < -1 ||number > 12)
                    {
                        throw new Exception(prompt);
                    }
                    reset = false; // Breaks out of loop
                }
                catch(InputMismatchException e) //User inputs a string or float.
                {
                    System.out.println(prompt);
                    input.nextLine(); // Clear Buffer
                    reset = true; // Resets the Loop
                }
                catch(Exception e)              //Catches Exception if number is less than 0 or greater than 11.
                {
                    System.out.println(prompt);
                    input.nextLine(); // Clear Buffer
                    reset = true; // Resets the Loop
                }
            }
            while(reset);
            return number;
    }
    
    /*
     *  Checks if input will cause error - but since the user 
     *  can only put one number at a time, you only need to check 
     *  the same row/col/boxes as the user input placed,
     *  because they're the only ones that will be affected.
     */
    public static void error(cellData [][][] data, cellData thisOne)
    {   
        boolean moreThanOne = false;
        int rowCounter = 0;
        int colCounter = 0;
        int boxCounter = 0;
        
        int row = thisOne.getRow();
        int col = thisOne.getColumn();
        int box = thisOne.getBox();
        
        //This resets the error values for all of cells in same row/col/boxes
        for(int index = 0; index < 9 ; index++){
            data[0][row][index].setRowError(false);
            data[1][col][index].setColError(false);
            data[2][box][index].setBoxError(false);
        }
        for(int value = 1; value < 10; value ++)
        {
            for(int index = 0; index < 9; index++)
            {
                if (data[0][row][index].getNumber() == value){
                    rowCounter ++;
                }
                 if (data[1][col][index].getNumber() == value){
                    colCounter ++;
                }
                 if (data[2][box][index].getNumber() == value){
                    boxCounter ++;
                }
            }
             /*
             *  If there is two or more of that number value
             *  inside the same row grouping,
             *  all cells in the same box grouping matching that number value 
             *  will have their row error set to true
             */
            if(rowCounter > 1){
                for(int index = 0; index < 9; index++){
                    if (data[0][row][index].getNumber() == value){
                        data[0][row][index].setRowError(true);
                    } 
                }
            }
             /*
             *  If there is two or more of that number value
             *  inside the same column grouping,
             *  all cells in the same box grouping matching that number value 
             *  will have their column error set to true
             */
            if(colCounter > 1){
                for(int index = 0; index < 9; index++){
                    if (data[1][col][index].getNumber() == value){
                        data[1][col][index].setColError(true);
                    } 
                }
            }
            /*
             *  If there is two or more of that number value
             *  inside the same box grouping,
             *  all cells in the same box grouping matching that number value 
             *  will have their box error set to true
             */
            if(boxCounter > 1){
                for(int index = 0; index < 9; index++){
                    if (data[2][box][index].getNumber() == value){
                        data[2][box][index].setBoxError(true);
                    } 
                }
            }   
            //resets the counters
            rowCounter = 0;
            colCounter = 0;
            boxCounter = 0;
        }
    }
    
    /*
     * Reads what numbers that aren't already in 
     * the same row/col/box of each cell
     */
    public static void readOption(cellData [][][] data, cellData thisOne)
    {
        
        String outputRow = "Possible row    values:";
        String outputCol = "Possible column values:";
        String outputBox = "Possible box    values:";
        
        int row = thisOne.getRow();
        int col = thisOne.getColumn();
        int box = thisOne.getBox();
        
        boolean rowTaken = false; 
        boolean colTaken = false;
        boolean boxTaken = false;
        
        for(int values = 1; values < 10; values ++)
        {
            for(int index = 0; index < 9; index ++)
            {
                if (data [0][row][index].getNumber() == values){
                    rowTaken = true;
                }
                if (data [1][col][index].getNumber() == values){
                    colTaken = true;
                }
                if (data [2][box][index].getNumber() == values){
                    boxTaken = true;
                }
            }
            /*
             * If the number value has not been used ONCE in the cell 
             * add it to the list of possible for user to consider
             */
            if (rowTaken == false){
                outputRow += String.format("%5d", values);
            } 
            if (colTaken == false){
                outputCol += String.format("%5d", values);
            }
            if (boxTaken == false){
                outputBox += String.format("%5d", values);
            }
            
            //Resets the flags
            rowTaken = false;
            colTaken = false;
            boxTaken = false;
        }
        System.out.print(outputRow + "\n" + outputCol + "\n" + outputBox + "\n");
    }
    
    /*
     *  You're a dirty cheater, aren't ya?
     *  Lookin at my source code,
     *  what are ya?
     */
    public static void dirtyCheater(cellData [][]gameBoard, cellData[][] answerBoard){
        for(int x = 0; x < 9; x++){
            for(int y = 0; y < 9; y++){
                gameBoard[x][y].setNumber(answerBoard[x][y].getNumber());
            }
        }
    }
    
    /*
     *  Checks if all the cells have a non-zero
     */
    public static boolean isFull(cellData [][] gameBoard){
        boolean full = true;
        for(int x = 0; x < 9; x++){
            for(int y = 0; y < 9; y++){
                if(gameBoard[x][y].getNumber() == 0 ){
                    full =false;
                    y = 9;
                    x = 9;
                }
            }
        }
        return full;
    }
    
    /*
     * Checks if the gameBoard matches the answer key
     */
    public static boolean noErrors(cellData [][] gameBoard, cellData[][] answerBoard){
        boolean correct = true;
        for(int x = 0; x < 9; x++){
            for(int y = 0; y < 9; y++){
                if(gameBoard[x][y].getNumber() !=  answerBoard[x][y].getNumber()){
                    correct =false;
                    y = 9;
                    x = 9;
                }
            }
        }
        return correct;
    }
    
    /*
     * Checks if the gameBoard matches the answer key
     */
    
    /*ALTERNATE VERSION IF YOU WANNA BE "ORGANIC"
     * public static boolean noErrors(cellData [][] gameBoard){
        boolean correct = true;
        for(int x = 0; x < 9; x++){
            for(int y = 0; y < 9; y++){
                if( gameBoard[x][y].getRowError()||
                    gameBoard[x][y].getColError()||
                    gameBoard[x][y].getBoxError()||){
                    correct =false;
                    y = 9;
                    x = 9;
                }
            }
        }
        return correct;
    }*/
}