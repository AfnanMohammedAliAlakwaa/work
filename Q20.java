 class CreditCard3{
    private double balance;
    private double creditLimit;

    public CreditCard3( double limit, double initialBalance) {

        this.creditLimit = limit;
        this.balance = initialBalance;
    }


    public double getBalance() { return balance; }
    public double getCreditLimit() { return creditLimit; }

    public void updateCreditLimit(double newLimit) {
        this.creditLimit = newLimit;
    }

    public boolean charge(double price) {
        if (price + balance > creditLimit) {
            System.out.println("Charge denied: " + price);
            return false;
        }
        balance += price;
        return true;
    }

    public void makePayment(double amount) {
        if (amount < 0) {
            System.out.println("Negative payments are not allowed.");
            return;
        }
        balance -= amount;
    }

    public static void printSummary(CreditCard3 card) {

        System.out.println("Balance = " + card.balance);
        System.out.println("Credit Limit = " + card.creditLimit);
    }
}

public class Q20 {


    public static void main( String [] args){
        CreditCard3[] cards = new CreditCard3[3];
        cards[0] = new CreditCard3( 5000, 1000);
        cards[1] = new CreditCard3( 3000, 500);
        cards[2] = new CreditCard3( 2000, 0);
        for (int val : new int[] {5000, 3000, 1000}) {
            cards[2].charge(val);
        }
        for (CreditCard3 card : cards) {
            CreditCard3.printSummary(card);
            System.out.println();
        }
    }
}




