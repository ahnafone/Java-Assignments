/**
 * Node.java
 * 
 * by Ahnaf Ahmed, 1560767
 * April 5th, 2018
 */
package tree;

/**
 *
 * @author AhnaV
 */
public class Node {
    
    private int idNum;
    private String employeeName;
    private Node leftChild;
    private Node rightChild;
    
    /**
     * Constructor
     *      Creates a node for an employee
     * @param employeeName = first name of employee
     * @param idNum = a unique number that identifies the employee
     */
    public Node (String employeeName, int idNum) {
        this.idNum = idNum;
        this.employeeName = employeeName;
        leftChild = null;
        rightChild = null;
    }//constructor
    
    public Node() {
        this("Unknown", 00);
    }//default constructor
    
    //Access methods
    public int getID() {
        return idNum;
    }//getID
    public String getName() {
        return employeeName;
    }//getName
    public Node getLeftChild() {
        return leftChild;
    }//getLeftChild
    public Node getRightChild() {
        return rightChild;
    }//getRightChild
    
    //Update methods
    public void setID(int idNum) {
        this.idNum = idNum;
    }//setID
    public void setName(String employeeName) {
        this.employeeName = employeeName;
    }//setName
    public void setLeftChild (Node leftChild) {
        this.leftChild = leftChild;
    }//setLeftChild
    public void setRightChild (Node rightChild) {
        this.rightChild = rightChild;
    }//setRightChild
    
    public String toString() {
        return ("Employee Name: " + employeeName + "\n" +
                "ID number: " + idNum + "\n");
    }
}
