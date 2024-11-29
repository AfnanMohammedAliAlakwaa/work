import java.util.Scanner;

public class Q8 {
    public void myfun(){
        Scanner obj1 = new Scanner(System.in);
        System.out.println("Enter An Integer : ");
        int integerValue = obj1.nextInt();
        System.out.println("Enter A Double : ");
        double doubleValue = obj1.nextDouble();
        System.out.println("Enter A String : ");
        String StringValue = obj1.next();
        System.out.println("Enter A Boolean : ");
        boolean booleanValue = obj1.nextBoolean();

        System.out.println("Your input : ");
        System.out.println("Integer : " + integerValue);
        System.out.println("Double : " + doubleValue);
        System.out.println("String : " + StringValue);
        System.out.println("Bolean : " + booleanValue);

    }

    public static void main(String[] args) {
        Q8 obj1 = new Q8();
        obj1.myfun();

    }
}
