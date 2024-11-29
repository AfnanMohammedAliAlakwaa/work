public class Q10 {
    public static boolean  isMultiple(long n , long m){
        return n%m ==0;
    }

    public static void main(String[] args) {
        long n = 670;
        long m = 300;

        if(isMultiple(n,m)){
            System.out.println(n + " Is A Multiple of : " + m);

        }
        else {
            System.out.println(n + " Is Not Multiple of : " +m);
        }

    }
}
