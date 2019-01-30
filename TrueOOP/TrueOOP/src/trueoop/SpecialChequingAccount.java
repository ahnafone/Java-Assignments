/*
 * SpecialChequingAccount.java
 * by Ahnaf Ahmed, 1560767
 * Feb 25th 2018
 * 
 * Public Methods
 *    Constructors to make a Special Chequing Account
 *    endOfMonth()
 *        Performs month end stuff (interest calc, reset variables,
 *        print report and cheque numbers of all cheques cashed for the month)
 *        and checks the minimum monthly balance for the month
 *    withdrawal(double) --> boolean
 *        Subtracts from balance if amount positive (takes out withdrawal
 *        fee if fee is applicable)
 *    billPayment(double amount, GeneralAccount g) --> false
 *        Substracts ammount from balance and transfer the amount into the
 *        account g, if the fee is still applicable
 *    chequeCashed(int num, double amount) --> false
 *        Adds the amount to the balance as long as the deposit amount
 *        and the balance together are not lower than the chequeCash fee,
 *        which is substracted from the total if service fee is applicable
 */
package trueoop;

/**
 *
 * @author ahnaf3
 */
public class SpecialChequingAccount extends ChequingAccount {
    
    double MIN_MONTH_BALANCE = 1000;
    
    /** * * * * *
     * Constructors
     *    Creates account
     * 
     * @param accountNum = the account number, given as a String.
     * @param fName = the first name of account holder, given as a String.
     * @param lName = the last name of account holder, given as a String.
     * @param initBalance = the initial deposit amount (must be +ve or set to 0)
     */
    public SpecialChequingAccount(String accountNum, String fName, String lName,
                            double initBalance) {
        super(accountNum, fName, lName, initBalance);
        if (minMonthBalance >= MIN_MONTH_BALANCE)
            applyServiceFee = false;
    }//contructor
    
    public SpecialChequingAccount(){
        this("0", "Unknown", "Unknown", 0);
    }//default constructor
    
    /** * * * * *
     * endOfMonth
     *    Prints report and checks if account should be fee exempt
     */
    @Override
    public void endOfMonth(){
        super.endOfMonth();
        if (balance >= MIN_MONTH_BALANCE)
            applyServiceFee = false;
    }//endOfMonth
    
    /** * * * * *
     * checkMinMonthlyBalance
     *    Used to check if the account is fee exempt before each transaction
     */
    public void checkMinMonthlyBalance() {
        if (balance < MIN_MONTH_BALANCE)
            applyServiceFee = true;
    }//checkMinMonthlyBalance
    
    /**
     * withdrawal
     *    Subtract amount (and service fee) from balance, assuming amount 
     *    is positive and service fee (withdrawFee) is available in account
     *    after checking if the account is fee exempt
     * @param amount
     * @return: true if transaction successful; false otherwise
     */
    @Override
    public boolean withdrawal(double amount) {
        checkMinMonthlyBalance();
        return super.withdrawal(amount);
    }//withdrawal
    
    /** * * * * *
     * chequeCashed
     *    Subtract amount (and service fee) from balance, assuming amount 
     *    is positive and service fee (chequeCashFee) is available in account
     *    after checking if the account is fee exempt
     * 
     * @param num = the cheque number (an int)
     * @param amount = amount of the cheque (positive double)
     * @return false since action is not successful
     */
    @Override
    public boolean chequeCashed(int num, double amount) {
        checkMinMonthlyBalance();
        return super.chequeCashed(num, amount);
    }//chequeCashed
    
    /** * * * * *
     * billPayment
     *    Subtract amount (and service fee) from balance and deposits that
     *    amount to another account, assuming amount is positive and
     *    service fee (billPayFee) is available in account after checking if
     *    the account is fee exempt
     * 
     * @param amount = amount of the bill (positive double)
     * @param g = account to pay
     * @return: true of transaction successful, false if otherwise
     */
    @Override
    public boolean billPayment(double amount, GeneralAccount g) {
        checkMinMonthlyBalance();
        return super.billPayment(amount, g);
    }
}//class
