 class CreditCard{
    private double creditLimit2;
    public void updateCreditLimit(double newLimit) {
        creditLimit2 = newLimit;
        System.out.println("The new credit limit is :" + newLimit);

    }}
public class Q18 {
    public static void main (String [] args){
        CreditCard card = new CreditCard();
        card.updateCreditLimit(12500);

    }

}
