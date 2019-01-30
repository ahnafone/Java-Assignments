/*
 * Hotpotato.java
 * 
 * by Ahnaf Ahmed, 1560767
 * March 15th, 2018
 */
package hotpotato;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author AhnaV
 */
public class Hotpotato {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Input for number of players (start)
        Scanner scannerOutside = new Scanner(System.in);
        System.out.println("Please enter the number of player: ");
        int numOfPlayers = scannerOutside.nextInt();
        //(end)
        
        CircularlyLinkedList gameList = new CircularlyLinkedList();
        inputNames(numOfPlayers, gameList);
        System.out.println("Players:  " + gameList);
        
        //exchange (start) (it works :)
        System.out.println();
        System.out.println("Switch who: ");
        String swap1 = scannerOutside.next();
        
        System.out.println("With: ");
        String swap2 = scannerOutside.next();
        
        gameList.exchange(swap1, swap2);
        //(end)
        
        
        //game starts (start)
        System.out.println("=====================");
        runGame(gameList);
        System.out.println("Game over!");
        if (gameList.isEmpty())
            System.out.println("Error! No players were found.");
        else
            System.out.println("The winner is: " + gameList.removeFirst());
        //game ends (end)
        
    }//main
    
    /**
     * inputNames
     *    Takes the number of players and the linked list as the argument
     *    and asks the user to input the names of the players which are stored
     *    in the list.
     * @param numOfPlayers = number of players
     * @param gameList = circular linked list which stores the names
     */
    public static void inputNames(int numOfPlayers,
            CircularlyLinkedList gameList) {
        int count = 1;
        Scanner scannerInside = new Scanner(System.in);
        while (count <= numOfPlayers) {
            System.out.println("Enter name of player " + count + ": ");
            String aName = scannerInside.nextLine();
            gameList.addLast(aName);
            count++;
        }
    }//inputNames
    
    /**
     * runGame
     *    Loops the game  and eliminates players one by one until only
     *    one player is left, and then returns the list containing one node.
     * @param gameList = circularly linked list containing all the 
     * @return: the circular list after it has been modified
     */
    public static CircularlyLinkedList runGame(CircularlyLinkedList gameList) {
        Random rand = new Random();
        
        if (gameList.size() != 0 && gameList.size() != 1) {
            
            while(gameList.size() != 1){
                int randomNumber = rand.nextInt(20) + 1;
                System.out.println("Random Time: " + randomNumber);
                int count = 0;
                
                System.out.println("Has potato: " + gameList.first());
                gameList.rotate();
                
                //Loop of elimination (start)
                while(count < randomNumber) {
                    
                    System.out.println("Has potato: " + gameList.first());
                    count++;
                    if (count == randomNumber){
                        System.out.println("STOP!");
                        gameList.removeFirst();
                    }//if
                    else
                        gameList.rotate();
                }//while inner
                // (end)
                
                System.out.println("Players left: " + gameList);
                System.out.println("=====================");
            }//while outer
        }//if
        
        return gameList;
    }//runGame
    
}
