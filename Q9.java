class GameEntry{
    int score;

    public GameEntry(int score) {
        this.score = score;
    }

}
public class Q9 {
    public static void main(String[] args) {
        GameEntry arr[] = new GameEntry[5];
        for (int i = 0 ; i<arr.length ; i++){
            arr[i] = new GameEntry(i*10);

        }
        GameEntry arr2[] = arr.clone();
        arr[4].score=550;
        System.out.println("arr2[4].score = " + arr2[4].score);

    }
}
