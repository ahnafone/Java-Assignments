/**
 * by Ahnaf Ahmed, 1560767
 * Feb 7th, 2018
 */
package sinkingship;

import java.util.Scanner;

/**
 *
 * This is the main class
 */
public class SinkingShip {

    /**
     * This is the main method.
     * It takes input from the user and creates output on the screen.
     * 
     * @param args
     */
    public static void main(String[] args) {
        
        //System.out.print("Row is: " + test.getRow());
        //System.out.println(" Column is: " + test.getColumn());
        
        int numberOfShots = 0;
        
        //prints the header (start)
        System.out.println();
        System.out.println("!===============================================!");
        System.out.println("     Welcome to 'I would like to sink a ship'    ");
        System.out.println("!===============================================!");
        //(end)
        
        Ocean pacific = new Ocean();
        while(!(pacific.getShipStatus())) {
            //prints the ocean (start)
            System.out.println("   x →");
            System.out.println("y");
            System.out.println("↓");
            System.out.println("      1 2 3 4 5 6 7 8 9 10");
            pacific.print();
            System.out.println();
            //(end)
            
            
            try {
                //asks and recieves input from the user (start)
                Scanner scanner = new Scanner(System.in);
                System.out.print("Please enter x and y coordinates of shot: ");
                int row = scanner.nextInt();
                System.out.print(" ");
                int column = scanner.nextInt();
                //(end)
                
                //uses user input to determine outcome of game (start)
                Point shotLocation = new Point(row, column);
                pacific.fireShot(shotLocation);
                System.out.println();
                numberOfShots++;
                //(end)
            }
            catch (Exception e) {
                System.out.println("Error! Please enter integers only!");
            }
        }//while
        System.out.println("You took " + numberOfShots + " shots.");
        
    }//main
    
}//class