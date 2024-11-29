public class Q16 {
    public static String RemovePunctuation(String s) {
        StringBuilder x = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                x.append(c);
            }
        }
        return x.toString();
    }
    public static void main(String[] args) {
        System.out.println("The sentence after removing : " + RemovePunctuation("It's Raining , right ?"));
    }
}
