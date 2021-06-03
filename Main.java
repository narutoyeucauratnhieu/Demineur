import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the size of a square: please type N:");
        int N = sc.nextInt();
        System.out.println("Choose how many bombs:");
        int numofMines = sc.nextInt();
        Game ob = new Game(N,numofMines);
        ob.gamePlay();
        sc.close();
    }
}
