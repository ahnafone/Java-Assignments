/*
 * ChequingAccount.java
 * by Ahnaf Ahmed, 1560767
 * Feb 25th 2018
 * 
 * Public Methods
 *      Constructors to make a Chequing Account
 *    endOfMonth()
 *        Performs month end stuff (interest calc, reset variables,
 *        print report and cheque numbers of all cheques cashed for the month)
 *    billPayment(double amount, GeneralAccount g) --> false
 *        Substracts ammount from balance and transfer the amount into the
 *        account g
 *    chequeCashed(int num, double amount) --> false
 *        Adds the amount to the balance as long as the deposit amount
 *        and the balance together are not lower than the chequeCash fee,
 *        which is substracted from the total
 *    toString() --> String
 *        String report
 */
package trueoop;

/**
 *
 * @author ahnaf3
 */
public class ChequingAccount extends GeneralAccount {
    
    //Data (start)
    String chequesCashed;
    private double billPayFee;
    private double chequeCashFee;
    //Data (end)
    
    //Methods (start)
    
    /** * * * * *
     * Constructors
     *    Creates account.
     * 
     * @param accountNum = the account number, given as a String.
     * @param fName = the first name of account holder, given as a String.
     * @param lName = the last name of account holder, given as a String.
     * @param initBalance = the initial deposit amount (must be +ve or set to 0)
     */
    public ChequingAccount(String accountNum, String fName, String lName,
                            double initBalance) {
        super(accountNum, fName, lName, initBalance);
        billPayFee = 5.5;
        chequeCashFee = 3.5;
        chequesCashed = "none";
        applyServiceFee = true;
        withdrawFee = 3.5;
    }//contructor, all arguements
    
    public ChequingAccount(){
        this("0", "Unknown", "Unknown", 0);
    }//default constructor, no arguments given
    //Constructors (end)
    
    /** * * * * *
     * endOfMonth
     *    Prints report
     */
    @Override
    public void endOfMonth(){
        System.out.println("===========================");
        System.out.println(this);
        chequesCashed = "none";
    }//endOfMonth
    
    /** * * * * *
     * billPayment
     *    Subtract amount (and service fee) from balance and deposits that
     *    amount to another account, assuming amount is positive and
     *    service fee (billPayFee) is available in account
     * 
     * @param amount = amount of the bill (positive double)
     * @param g = account to pay
     * @return: true of transaction successful, false if otherwise
     */
    @Override
    public boolean billPayment(double amount, GeneralAccount g){
        if (amount > 0){
            if (applyServiceFee && balance >= (billPayFee + amount)) {
                balance = balance - billPayFee - amount;
                g.deposit(amount);
                return true;
            }//if inner
            else if(balance >= amount) {
                balance = balance - amount;
                g.deposit(amount);
                return true;
            }//else if
            System.out.println("bill payment error: amount and service fee (" + 
            (amount + billPayFee) + ") is greater than balance");
            return false;
        }//if outer
        else {
            System.out.println("bill payment error: amount (" + amount +
                    ") should be postive");
            return false;
        }//else
    }//billPayment
    
    /** * * * * *
     * chequeCashed
     *    Subtract amount (and service fee) from balance, assuming amount 
     *    is positive and service fee (chequeCashFee) is available in account
     * 
     * @param num = the cheque number (an int)
     * @param amount = amount of the cheque (positive double)
     * @return false since action is not successful
     */
    @Override
    public boolean chequeCashed(int num, double amount){
        if ((amount + chequeCashFee) <= balance && amount >= 0) {
            balance = balance - amount - chequeCashFee;
            if (!chequesCashed.equals("none"))
                chequesCashed = chequesCashed + num + " ";
            else
                chequesCashed = num + " ";
            return true;
        }//if
        else if(amount < 0) {
            System.out.println("cheque cashed error: amount (" + amount +
                    ") should be postive");
            return false;
        }//else if
        System.out.println("cheque cashed error: amount and service fee (" +
                (amount + chequeCashFee) + ") is greater than balance");
        return false;
    }//chequeCashed
    
    /** * * * * *
     * toString
     *    Gives String representation of an account
     * 
     * @return the String representation
     */
    @Override
    public String toString(){
        return "\n" +accountNum + "\n" + lastName.toUpperCase() + ", " + 
                firstName + "\n" +  
                "Balance: " + String.format("%.2f", balance) + "\n" +
                "Cheque cashed: " + chequesCashed + "\n";
    }//toString
    
    //Methods (end)
    
}//class
