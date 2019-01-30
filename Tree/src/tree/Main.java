/**
 * Main.java
 * 
 * by Ahnaf Ahmed, 1560767
 * April 5th, 2018
 */
package tree;

/**
 *
 * @author AhnaV
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tree x = new Tree();
        x.insert("bugs bunny", 50);
        x.insert("mickey", 30);
        x.insert("minnie", 80);
        x.insert("donald", 25);
        x.insert("pluto", 65);
        x.insert("santa", 40);
        x.insert("elsa", 100);
        x.insert("anna", 70);
        x.insert("olav", 58);
        x.insert("bugs bunny", 1);
        x.insert("mickey", 2);
        x.insert("minnie", 3);
        x.insert("anna", 8);
        x.insert("olav", 9);
        System.out.println(x.preOrderString());
        System.out.println(x.postOrderString());
        System.out.println(x.inOrderString());
        
        System.out.println("Max id goes to " + x.maxName());
        System.out.println("parent of santa is " + x.parent(40));
        System.out.println("parent of olav is " + x.parent(58));
        System.out.println("parent of anna is " + x.parent(70));
        System.out.println("parent of minnie is " + x.parent(80));
        System.out.println("parent of elsa is " + x.parent(100));
        System.out.println("parent of bugs bunny is " + x.parent(51));
        
        System.out.println("total of id numbers; " + x.averageTree());
        System.out.println(x.numOfNodes());
    }
    
}
