public class Q15 {
    public static int CountVowels(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            switch (Character.toLowerCase(c)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println("Number of vowels is : " +CountVowels("Hello Everyone"));
    }

}
