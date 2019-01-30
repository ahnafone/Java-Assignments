/*
 * SavingsAccount.java
 * by Ahnaf Ahmed, 1560767
 * Feb 25th 2018
 * 
 * Public Methods
 *      Constructors to make a Chequing Account
 *      withdrawal(double) --> boolean
 *        Subtracts from balance if amount positive (takes out withdrawal
 *        fee if service fee is applicable)
 *    endOfMonth()
 *        Performs month end stuff (interest calc, reset variables,
 *        print report and adds interest to balance)
 */
package trueoop;

/**
 *
 * @author AhnaV
 */
public class SavingsAccount extends GeneralAccount {
    
    /** * * * * *
     * Constructors
     *    Creates account.
     * 
     * @param accountNum = the account number, given as a String.
     * @param fName = the first name of account holder, given as a String.
     * @param lName = the last name of account holder, given as a String.
     * @param initBalance = the initial deposit amount (must be +ve or set to 0)
     */
    public SavingsAccount (String accountNum, String fName, String lName,
                            double initBalance){
        super(accountNum, fName, lName, initBalance);
        
        interestRate = 0.002;
        withdrawFee = 5;
        applyServiceFee = false;
    }
    
    public SavingsAccount (){
        this("0", "Unknown", "Unknown", 0);               
    }//default constructor, no arguments given
    
    /** * * * * *
     * withdrawal
     *    Subtract amount (and service fee) from balance, assuming amount 
     *    is positive and service fee (withdrawFee) is available in account
     * 
     * @param amount = positive double number
     * @return: true if transaction successful; false otherwise
     */
    @Override
    public boolean withdrawal(double amount){
        if(!applyServiceFee) {
            boolean outcome = super.withdrawal(amount);
            if (outcome) {
                applyServiceFee = true;
                return true;
            }//if inner
        }//if
        return super.withdrawal(amount);
    }//withdrawal
    
    /** * * * * *
     * endOfMonth
     *    Prints report and adds interest depending the amount on minimum
     *    monthly balance.
     */
    @Override
    public void endOfMonth () {
        applyServiceFee = false;
        super.endOfMonth();
    }//endOfMonth
    
}//class
