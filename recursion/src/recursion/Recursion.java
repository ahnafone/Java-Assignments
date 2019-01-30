/**
 * Recursion.java
 * 
 * by Ahnaf Ahmed, 1560767
 * March 29th 2018
 */
package recursion;

/**
 *
 * @author AhnaV
 */
public class Recursion implements PrintSquare{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Recursion square = new Recursion();
        square.printSquare(5);
    }//main
    
    /**
     * Prints a line of asterisks to standard output
     * @param size = size of the square
     */
    public void printLine (int size) {
        if (size < 1) {
            System.out.println();
        }//base case
        else {
            System.out.print("* ");
            printLine(size - 1);
        }//recursive case
            
    }//printLine
    
    /**
     * Acts as a wrapper for the original printSquare
     * @param size 
     */
    public void printSquare(int size) {
        printSquare(size, size);
    }
    
    /**
     * Prints the remaining portion of square where
     * length indicates how many rows remain and 
     * size is the size of the square
     * @param size
     * @param length 
     */
    private void printSquare (int size, int length) {
        if (size < 1) {
            System.out.println();
        }//base case
        else {
            printLine(length);
            printSquare(size - 1, length);
        }//recursive case
    }//printSquare
    
    
}//class
