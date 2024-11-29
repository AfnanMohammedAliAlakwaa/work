import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        System.out.println("Please Enter students Id , Name and Major");
        Scanner in= new Scanner(System.in);

        Student myarr[]= new Student[3];

        for (int i = 0; i <myarr.length ; i++) {
            myarr[i]=new Student(in.nextInt(),in.next(),in.next());

        }
        for (int i = 0; i < myarr.length; i++) {
            System.out.println(myarr[i]);
        }


    }
}
