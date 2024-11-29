class CreditCard2{
    private double balance;
    public void processPayment(double amount){
        if (amount >0){
            balance -= amount;
            System.out.println("The process is : " + amount);

        }
        else {
            System.out.println("Can not do a process in a  negative number");
        }
    }
    public void makePayment(double amount){
        if (amount <=0){
            throw new IllegalArgumentException("Payemnt should be positive"+amount);
        }
    }

}
public class Q19 {
    public static void main (String [] args){
        CreditCard2 card = new CreditCard2();

        card.processPayment(-3500);
        card.makePayment(600);

    }


    }
