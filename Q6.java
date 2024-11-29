import java.util.Scanner;

public class Q6 {
    public void myfun(){
        Scanner obj1 = new Scanner(System.in);

        String [] myarr = new String[4];
        System.out.println("Enter Four Fruits Name : ");
        for (int i=0; i<myarr.length ; i++){
            String j = obj1.nextLine();
            myarr[i]=j;

        }
        for (int i =0 ; i<myarr.length ; i++){
            System.out.println(myarr[i]);
        }
    }
    public static void main(String[] args) {
        Q6 obj1 = new Q6();
        obj1.myfun();
    }
}
