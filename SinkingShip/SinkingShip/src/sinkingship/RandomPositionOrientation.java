/**
 * This creates a valid position and orientation for placing
 * a ship into a grid of SIZE X SIZE.
 * 
 * by Ahnaf Ahmed, 1560767
 * (Not really, it was mostly Rosanna :)
 * Feb 7th, 2018
 * 
 * Public Methods:
 * Constructor
 * getRow
 * getColumn
 * getOrientation
 * makeValidPositionOrientation 
 */
package sinkingship;

import java.util.Random;

/**
 *
 * @author ahnaf3
 */
public class RandomPositionOrientation {
    private static final Random RAND_NUM_GEN = new Random();
    private static final int SIZE = 10;
    
    //Instance variables
    private int row;
    private int column;
    private int orientation; //0 = horizontal; 1 = vertical
                             // 2 = diagonal \; 3 = diagonal /
    
    //Constructor
    RandomPositionOrientation(){
        makeValidPositionOrientation();
    }//Constructor
    
    //Methods
    public int getRow(){
        return row;
    }//getRow
    
    public int getColumn(){
        return column;
    }//getColumn
    
    public int getOrientation(){
        return orientation;
    }//getOrientation
    
    /**
     * This only makes the random position and
     * orientation but does not check whether
     * a ship could actually be placed like that.
     * I.e. it might not be valid for placing.
     */
    private void makeRandomPositionOrientation(){
        row = RAND_NUM_GEN.nextInt(SIZE);
        column = RAND_NUM_GEN.nextInt(SIZE);
        orientation = RAND_NUM_GEN.nextInt(4);
    }//makeRandomPositionOrientation
    
    /**
     * 
     * @return true if the combination of row, column, and
     *         orientation can actually be used to place a 
     *         ship;  false otherwise.
     */
    private boolean testCombo(){
        //top and bottom edges are only valid when orientation is horizontal
        if ((row == 0 || row == SIZE - 1) && orientation != 0)
            return false;       
        //left and right edges are only valid when orientation is vertical
        if ((column == 0 || column == SIZE - 1) && orientation != 1)    
            return false;              
        return true;
    }//testCombo
    
    /**
     * This makes a random VALID position and orientation.
     */
    public void makeValidPositionOrientation(){
        boolean isValid = false;
        while (! isValid){
            makeRandomPositionOrientation();
            isValid = testCombo();
        }//while        
    }//makeValidPositionOrientation
    
}//class