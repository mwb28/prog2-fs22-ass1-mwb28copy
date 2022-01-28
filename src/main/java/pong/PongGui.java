package pong;

import gui.Window;

public class PongGui {

    private static int WIDTH = 800;
    private static  int HEIGHT = 600;

    public static void main(String[] args) {
        
        PongGame game = new PongGame(WIDTH, HEIGHT);

        Window window = new Window("Pong", WIDTH, HEIGHT);
        window.open();
        
        // Game loop
        while (window.isOpen()) {
            // Prozessiert Benutzereingaben
            game.handleEvents(window);

            // Prozessiert einen einzelnen Zeitschritt 
            game.step();

            // Zeichnet den Spielzustand
            game.drawGame(window);

            window.refreshAndClear(20);
        }
    }
}
