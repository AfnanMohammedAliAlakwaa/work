public class Q13 {
    public int OddSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i += 2) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Q13 obj1 = new Q13();
        System.out.println("The summation of odd numbers less than n = " + obj1.OddSum(44));

    }
}
