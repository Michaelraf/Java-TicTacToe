import java.util.Scanner;

import controller.Game;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Game game = new Game();
        game.intro(s);
        game.play(s);
        s.close();
    }
}
