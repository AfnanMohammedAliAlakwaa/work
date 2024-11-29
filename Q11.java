public class Q11 {
    public boolean isEven(int i) {
        return i == 0 || ((i & 1) == 0);
    }

    public static void main(String[] args) {
        Q11 obj1 = new Q11();
        System.out.println("It is Even : " + obj1.isEven(14));
    }
}
