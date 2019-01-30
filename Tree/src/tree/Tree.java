/**
 * Tree.java
 * 
 * by Ahnaf Ahmed, 1560767
 * April 5th, 2018
 */
package tree;

/**
 *
 * @author AhnaV
 */
public class Tree {
    
    private Node root;
    
    /**
     * Simply starts a tree with empty
     */
    public Tree() {
        root = null;    //tree starts off empty;
    }
    
    /**
     * insert
     *      Evaluates the appropriate position and then saves the employee
     *      name and id number as a node in that position
     * @param employeeName = name of employee to be added
     * @param idNum = id number of employee to be added
     */
    public void insert(String employeeName, int idNum) {
        if (root == null)
            root = new Node (employeeName, idNum);
        else
            insert(employeeName, idNum, root);
    }//insert: wrapper
    
    /**
     * insert
     *      This is the main function.
     *      Evaluates the appropriate position and then saves the employee
     *      name and id number as a node in that position.
     * @param employeeName = name of employee
     * @param idNum = id number
     * @param locationInTree = stores the location of the node in recursion
     */
    private void insert(String employeeName, int idNum, Node locationInTree) {
        if (idNum < locationInTree.getID()) {
            if (locationInTree.getLeftChild() == null)
                locationInTree.setLeftChild(new Node(employeeName, idNum));
            else
                insert(employeeName, idNum, locationInTree.getLeftChild());
        }
        else
            if (locationInTree.getRightChild() == null)
                locationInTree.setRightChild(new Node(employeeName, idNum));
            else
                insert(employeeName, idNum, locationInTree.getRightChild());
    }//insert: main function
    
    //Access Methods
    public Node getRoot() {
        return root;
    }//getRoot
    
    public String toString() {
        return root.toString();
    }//toString
    
    /**
     * preOrderString
     *      This acts as a wrapper to the main function.
     * @return string representation of preordered list
     */
    public String preOrderString() {
        if (root == null)
            return "";
        else
            return preOrderString(root);
    }//preOrderString: wrapper
    
    /**
     * preOrder
     *      Prints all the names and id numbers from the top to bottom,
     *      starting from left
     * @param locationInTree = stores the location of the node in recursion
     * @return: string representation of preordered list
     */
    private String preOrderString(Node locationInTree) {
        if (locationInTree == null)
            return "";
        else
            return locationInTree.toString() +
                    preOrderString(locationInTree.getLeftChild()) +
                    preOrderString(locationInTree.getRightChild());
    }//preOrderString: main function
    
    /**
     * postOrderString
     *      This acts a wrapper to the main function.
     * @return string representation of postordered list
     */
    public String postOrderString() {
        if (root == null)
            return "";
        else
            return postOrderString(root);
    }//postOrderString: wrapper
    
    /**
     * postOrderedString
     *      Prints all the names and id numbers from the bottom to top,
     *      starting left first.
     * @param locationInTree = stores the location of the node in recursion
     * @return string representation of postordered list
     */
    private String postOrderString(Node locationInTree) {
        if (locationInTree == null)
            return "";
        else
            return postOrderString(locationInTree.getLeftChild()) +
                    postOrderString(locationInTree.getRightChild()) +
                    locationInTree.toString();
    }
    
    /**
     * inOrderString
     *      This acts a wrapper to the main function.
     * @return string representation of the list middle first
     */
    public String inOrderString() {
        if (root == null)
            return "";
        else
            return inOrderString(root);
    }//postOrderString: wrapper
    
    /**
     * inOrderString
     *      This prints the names and id numbers starting from the middle,
     *      left first
     * @param locationInTree = stores the location of the node in recursion
     * @return string representation of the list middle first
     */
    private String inOrderString(Node locationInTree) {
        if (locationInTree == null)
            return "";
        else
            return inOrderString(locationInTree.getLeftChild()) +
                    locationInTree.toString() +
                    inOrderString(locationInTree.getRightChild());
    }
    
    /**
     * findNum
     *      This acts as a wrapper to the main function.
     * @param idNum = id number of the employee
     * @return: name of employee
     */
    public String findNum(int idNum) {
        if (root == null)
            return "Error! No employees found.";
        else
            return findNum(idNum, root);
    }
    
    /**
     * findNum
     *      Finds the name of the employee using the id number
     * @param idNum = id number of employee
     * @param locationInTree = stores the location of the node in recursion
     * @return: name of employee
     */
    private String findNum(int idNum, Node locationInTree) {
        if (locationInTree == null)
            return "Error! Id number not found.";
        else if (idNum == locationInTree.getID())
            return locationInTree.getName();
        else if(idNum < locationInTree.getID())
            return findNum(idNum, locationInTree.getLeftChild());
        else
            return findNum(idNum, locationInTree.getRightChild());
    }//findNum
    
    /**
     * findName
     *      This acts as a wrapper to the main function
     * @param employeeName = name of the employee
     * @return: the id number of the employee
     */
    public int findName(String employeeName) {
        if (root == null)
            return 1;
        else
            return findName(employeeName, root);
    }
    
    /**
     * findName
     *      Finds the id number using the name of the employee
     * @param employeeName = name of the employee
     * @param locationInTree = stores the location of the node in recursion
     * @return: the id number of the employee
     */
    private int findName(String employeeName, Node locationInTree) {
        if (locationInTree == null)
            return 1;
        else if (locationInTree.getName().equals(employeeName))
            return locationInTree.getID();
        else
            return findName(employeeName, locationInTree.getLeftChild())*
                    findName(employeeName, locationInTree.getRightChild());
            //Either going left or going right will return 1 (for not found)
            //hence why the multiplicatopn works
            //But even when the name is found, this 
            
    }//findNum
    
    /**
     * maxName
     *      Returns the employee name with the highest id number.
     *      Returns "not available" if tree is empty.
     * @return: name of employee with highest id number or nothing
     */
    public String maxName() {
        if (root == null)
            return "Not available";
        else
            return maxName(root);
    }//maxName: wrapper function
    
    /**
     * maxName
     *      Returns the employee name with the highest id number.
     *      Returns "not available" if tree is empty.
     * @param locationInTree = node that keeps track of location in tree
     * @return: name of employee with highest id number or nothing
     */
    public String maxName(Node locationInTree) {
        if (locationInTree.getRightChild() == null) //base case
            return locationInTree.getName();
        else                                        //recursive case
            return maxName(locationInTree.getRightChild());
    }//maxName: main function
    
    /**
     * parent
     *      Returns the name of the parent of the node with the id number
     *      given by the user.
     * @param idNumber = the id number of the child of the parent we 
     *                   are looking for
     * @return: name of parent
     */
    public String parent(int idNumber) {
        if (root == null)
            return "Error: Tree is empty";
        else  if (root.getID() == idNumber)
            return "Error: parent of root not possible";
        
        Node locationInTree = root;
        while (locationInTree!= null) {
            
            if (locationInTree.getLeftChild() == null)
                if (locationInTree.getRightChild() == null)
                    break;
                else if (locationInTree.getRightChild().getID() == idNumber)
                    return locationInTree.getName();
                else {
                    locationInTree = locationInTree.getRightChild();
                    continue;
                }//else (inside if)
            
            else if (locationInTree.getRightChild() == null) {
                if (locationInTree.getLeftChild().getID() == idNumber)
                    return locationInTree.getName();
                
                locationInTree = locationInTree.getLeftChild();
                continue;
            }//else if
                
            else if (locationInTree.getLeftChild().getID() == idNumber || 
                    locationInTree.getRightChild().getID() == idNumber)
                return locationInTree.getName(); //parent is found
            else if (idNumber < locationInTree.getID())
                locationInTree = locationInTree.getLeftChild();
            else
                locationInTree = locationInTree.getRightChild();
        }//while
        
        return "Error: employee with ID " + idNumber + " was not found";
                                                //parent not found
    }//parent
    
    public int numOfNodes() {
        if (root == null)
            return 0;
        
        return numOfNodes(0, root);
    }//numOfNodes: wrapper
    
    private int numOfNodes(int total, Node locationInTree) {
        if (locationInTree == null)
            return 0;
        else {
            total += 1;
            if (locationInTree.getLeftChild() != null) {
                total = numOfNodes(total, locationInTree.getLeftChild());
            }
            if (locationInTree.getRightChild() != null) {
                total = numOfNodes(total, locationInTree.getRightChild());
            }
            return total;
        }
    }//numOfNodes: main function
    
    /**
     * averageTree
     *      Acts as a wrapper function to the main function. It takes
     *      the total of all IDs and divides them by the total number of nodes
     *      in the tree.
     * @return; average ID number
     */
    public float averageTree() {
        if (root == null)
            return 0;
        
        return (averageTree(root)/numOfNodes());
    }//averageTree
    
    /**
     * averageTree
     *      Finds the total of all ID numbers. The average is found and returned
     *      by the wrapper.
     * @param locationInTree = stores location in tree
     * @return: total of all ID numbers
     */
    private float averageTree(Node locationInTree) {
        if (locationInTree == null)
            return 0;
        else {
            float totalID = ( locationInTree.getID() + 
                    averageTree(locationInTree.getLeftChild()) +
                    averageTree(locationInTree.getRightChild()));
            return totalID;
        }
    }//averageTree
    
    
}//class
