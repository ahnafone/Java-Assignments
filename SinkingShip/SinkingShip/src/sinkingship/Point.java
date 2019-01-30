/**
 * Point.java
 * Simple conversion between regular x,y coordinates and what the
 * the computer requires for array indexing.
 * 
 * by Ahnaf Ahmed, 1560767
 * Feb 7th, 2018
 */
package sinkingship;

/**
 *
 * @author ahnaf3
 */
public class Point {
    //Instance variables
    private int x;
    private int y;
    private int row;
    private int column;
    
    //Constructor
    Point(int x, int y){
        this.x = x;
        this.y = y;
        row = y - 1;
        column = x - 1;                
    }//constructor
    
    //Methods
    public int getRow(){
        return row;
    }//getRow
    
    public int getColumn(){
        return column;
    }//getColumn    
}//class