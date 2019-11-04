    public class SudokuNoGui
    {
        public static void main(String [] args)
        {
        /*
         *  Initialize Everything
         */
        cellData [][]   gameBoard   = new cellData[9][9];       //Creates a 9 * 9 array of cellData objects
        cellData [][][] data        = new cellData[3][9][9];    //Creates a 3 * 9 * 9 array of REFERENCES via shallow copy to gameBoard
        
        cellData [][] answerBoard   = new cellData[9][9];       //You're just a dirty cheater?
        
        int row = 0;
        int column = 0;
        int box = 0;
        int boxX= 0;    
        int boxY = 0;
        for(int x = 0; x < 9; x++)
        {
            for(int y = 0; y < 9; y++)
            {
            row = x;
            column = y;
            
            //used for the 3 x 3 subarray inside thr 9 x 9
            boxX = x/3;
            boxY = y/3;
            switch(boxX)
            {
                case 0:switch(boxY)
                    {
                         case 0: 
                            box = 0;
                            break;
                         case 1: 
                            box = 1;
                            break;   
                         case 2:
                            box = 2;
                            break;
                    }break;
                case 1:switch(boxY)
                    {
                        case 0: 
                            box = 3;
                            break;
                         case 1: 
                            box = 4;
                            break;   
                         case 2:
                            box = 5;
                            break;
                    }break;
                case 2:switch(boxY)
                    {
                         case 0: 
                            box = 6;
                            break;
                         case 1: 
                            box = 7;
                            break;   
                         case 2:
                            box = 8;
                            break;
            
                    }break;
            }
            //Initlizes both the gameBoard and answerBoard object value via constructor
            gameBoard[x][y] = new cellData(row,column,box);
            answerBoard[x][y] = new cellData(row,column,box);
            
                /*Sets the cell's row column and box, 
                will not change for the rest of the program.
                */
            data[0][x][y] = gameBoard [x][y];                   // Shallow Copies refrences of X
            data[1][y][x] = gameBoard [x][y];                   // Shallow Copies refrences of Y
            data[2][box][y%3 + ((x%3)*3)] = gameBoard [x][y];   // Shallow Copies refrences of Boxes 
            
            }
            System.out.print("\n");
        }
        
        //sets both respective boards .number values
        Board.setBoard(gameBoard);      //sets the board to the predefined build
        Board.initlize(gameBoard);      //sets the isStarter for who aren't currently 0 to true
        Board.setAnswers(answerBoard);  //sets the answer board to the predefined answer key
    
        
        boolean playing = true;
        boolean repeat = false;
        boolean ableToMod;
        int xInput;
        int yInput;
        int numInput;
        
        
        /*
         *  Menu
         */
        while(playing)
        {   
            display.board(gameBoard);                  //Prints out the board
            ableToMod = true;
            
            System.out.println("Enter X Value");        //Reversing the values actually works
            yInput = reader.readIntOneNine() -1;
            
            System.out.println("Enter Y Value");
            xInput = reader.readIntOneNine() -1;
            if(gameBoard[xInput][yInput].isStarter()){  //If the values cannot be changed, they won't be.
                System.out.println("That is a starter Value!\nCannot be changed\nTry Again!");
                ableToMod = false;
            }   
            
            if(ableToMod)
            {
                do{ 
                    System.out.printf("[%d][%d] 's cell value is %d\n\n", 
                                        yInput +1,xInput +1,                    //Prints currently seclected cell
                                        gameBoard[xInput][yInput].getNumber()); //And it's value.
                    
                    numInput = reader.readIntOptions();
                    
                    if (numInput ==12){             //Resets board
                        Board.reset(gameBoard);
                        repeat = false;
                    }
                    else if(numInput == 11){        //Key for what's in the cell
                        System.out.println("\nFor Every Cell\n"+
                                            "R = there is a matching value in the same Row\n" + 
                                            "C = there is a matching value in the same Column\n" + 
                                            "B = there is a matching value in the same Box\n ");
                    }   
                    else if(numInput == 10){        //Reads possible answers for the box/column/row that hasn't been taken
                        reader.readOption(data,gameBoard[xInput][yInput]);
                        repeat = true;
                    }
                    else if(numInput == 0){         //Cheater
                        gameBoard[xInput][yInput].setNumber(
                            answerBoard[xInput][yInput].getNumber());
                        repeat = false;
                    }
                    else if(numInput == -1){        //Dirty Cheater
                        reader.dirtyCheater(gameBoard,answerBoard);
                    }
                    else{                           //Set this cells value to the number
                        gameBoard[xInput][yInput].setNumber(numInput);
                        reader.error(data,gameBoard[xInput][yInput]);   
                        repeat = false;
                    }
                }while(repeat);
            }
            //Checks if all cells are full and if there isn't any errors.
            if(reader.isFull(gameBoard) && reader.noErrors(gameBoard,answerBoard)){
                display.board(gameBoard);
                System.out.printf("Congrats, you won!");
                playing = false;
            }
            
        }
}
}