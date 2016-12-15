public abstract class CreditCard {
    protected double interestRate;
    protected double balance = 0;

    public double calculateInterest()
    {
        return balance * interestRate;
    }

    public double getInterestRate() 
    {
        return interestRate;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public double getBalance()
    {
        return balance;
    }
}
