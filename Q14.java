public class Q14 {
    public int SquareSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i * i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Q14 obj1 = new Q14();
        System.out.println("The sum of square positive numbers =  " +obj1.SquareSum(39));

    }
}
