public class cellData
{
    /*
    *   Instance Variables
    */
    public boolean rowError     = false;    //Value to check if there is a 
    public boolean columnError  = false;    //"error" (== two or more of the same number value) 
    public boolean boxError     = false;    //inside every container of row, column and box
    public boolean starter      = false;    //starter to see if this cell was an original value that the user can't change
    
    public int number = 0;
    public int row;
    public int column;
    public int box;
    
    /*
    *   Counstructors
    */
    public cellData(int r,int c,int b)
    {
        this.row = r;
        this.column = c;
        this.box =b;
    }
    
    /*
    *   Getters
    */
    public int getNumber(){
        return number;
    }
    public int getRow(){
        return row;
    }
    public int getColumn(){
        return column;
    }
    public int getBox(){
        return box;
    }
    public boolean getRowError(){
        return rowError;
    }
    public boolean getColError(){
        return columnError;
    }
    public boolean getBoxError(){
        return boxError;
    }
    public boolean isStarter(){
        return starter;
    }
    
    /*
    *   Setters
    */
    public void setNumber(int n){
        number      = n;
    }
    public void setRowError(boolean r){
        rowError    = r;
    }
    public void setColError(boolean c){
        columnError = c;
    }
    public void setBoxError(boolean b){
        boxError    = b;
    }
    public void trueStarter(){
        starter = true;
    }
    
    
}