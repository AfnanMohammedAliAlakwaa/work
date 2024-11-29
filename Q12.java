public class Q12 {
    public int TheSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
    public static void main(String[] args) {
        Q12 obj1 = new Q12();
        System.out.println("The Summation of n = " + obj1.TheSum(13));

    }
}
