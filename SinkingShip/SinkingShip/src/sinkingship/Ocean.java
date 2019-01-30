/**
 * by Ahnaf Ahmed, 1560767
 * Feb 7th, 2018
 */
package sinkingship;

/**
 *
 * @author ahnaf3
 */
public class Ocean {
    private static final int SIZE = 10;
    private boolean[][] shipCoordinates = new boolean[SIZE][SIZE]; //stores the
                                                      //coordinates of the ship
    
    private int successfulShots = 0;
    private boolean shipSunk = false;
    
    //Instance Variables
    char[][] anOcean; //'~' = water; 'X' = water that's hit
                     // 'S' = ship (not hit); '$' = ship hit
    
    //Constructor
    Ocean(){
        anOcean = new char[SIZE][SIZE];
        
        //Initialize entire ocean to water
        for (int row = 0; row < SIZE; row++)
            for (int column = 0; column < SIZE; column++)
                anOcean[row][column] = '~';
        
        //Fills in the boolean array with false as a default
        for (int num = 0; num < SIZE; num++)
            for (int num2 = 0; num2 < SIZE; num2++)
                shipCoordinates[num][num2] = false;
        
        placeShip();
    }//constructor
    
    
    //Methods
    public void print(){
       for (int row = 0; row < SIZE; row++) {
            //Contains extra print lines for creating the interface
            if (row != 9)
                System.out.print("   " + (row + 1) + "  ");
            else
                System.out.print("   10 ");
            
            for (int column = 0; column < SIZE; column++) {
                
                if (shipSunk && shipCoordinates[row][column])
                    System.out.print("& ");
                else
                    System.out.print(anOcean[row][column] + " ");
                
            }//inner for
            System.out.println();
       }//outer for
    }//print
    
    //This method allows main to determine the status of the ship
    public boolean getShipStatus() {
        return shipSunk;
    }//getShipStatus
    
    public void placeShip(){
        RandomPositionOrientation aCombo = new RandomPositionOrientation();
        int row = aCombo.getRow();
        int column = aCombo.getColumn();
        int orientation = aCombo.getOrientation();
        
        //Place middle of ship
        shipCoordinates[row][column] = true;
        
        //Place other 2 parts of the ship
        switch (orientation){
            case 0: //horizontal
                shipCoordinates[row][column - 1] = true;
                shipCoordinates[row][column + 1] = true;
                break;
            case 1: //vertical
                shipCoordinates[row - 1][column] = true;
                shipCoordinates[row + 1][column] = true;
                break;
            case 2: //diagonal \
                shipCoordinates[row + 1][column + 1] = true;
                shipCoordinates[row - 1][column - 1] = true;
                break;
            case 3: //diagonal /
                shipCoordinates[row + 1][column - 1] = true;
                shipCoordinates[row - 1][column + 1] = true;
                break;
        }//switch
    }//placeShip
    
    public void fireShot (Point ballLocation) {
        if (ballLocation.getRow() > (SIZE - 1) ||
                ballLocation.getColumn() > (SIZE - 1) ) { //if coordinates out
                                                          //of bounds
            System.out.println("Error! Shot location out of bounds!");
        }//if
        else if (anOcean[ballLocation.getRow()][ballLocation.getColumn()]
                == 'S' || 
                anOcean[ballLocation.getRow()][ballLocation.getColumn()] 
                == 'X') { //if a shot is fired somewhere twice
            System.out.println("Error! A shot was fired there already!");
        }//else if 1
        else if (anOcean[ballLocation.getRow()][ballLocation.getColumn()]
                 == '~') { //if ball struck the ocean
            if (shipCoordinates[ballLocation.getRow()][ballLocation.getColumn()]
                    ) { //if ball hit the ship
                anOcean[ballLocation.getRow()][ballLocation.getColumn()] = 'S';
                
                System.out.println("Yikes, HIT the ship");
                successfulShots++;
                if (successfulShots == 3) { //if the ball has sunk the ship
                    shipSunk = true;
                    print();
                    System.out.println("Congratulations! "
                            + "You have sunk the ship!");
                }//inner if
                
            }//outer if
            else { //if the ball missed the ship
                anOcean[ballLocation.getRow()][ballLocation.getColumn()] = 'X';
                System.out.println("Nice try;  missed the ship");
                //numberOfShots++;
            }//else
            
        }//else if 2
    }//fireShot
    
}//class