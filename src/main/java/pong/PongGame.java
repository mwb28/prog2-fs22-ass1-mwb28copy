package pong;

import gui.Window;

public class PongGame {

    private int width;
    private int height;

    public PongGame(int width, int height) {
        this.width = width;
        this.height = height;
        // TODO Ball und Spieler erzeugen
    }

    public void handleEvents(Window window) {
        if (window.isKeyPressed("up")) {
            // Spieler rechts nach oben bewegen
        }
        // TODO die drei weiteren Tasten behandeln
	}

    public void step() {
        // TODO Einen Zeitschritt prozessieren, also den Ball bewegen und Kollisionen behandeln.
    }

	public void drawGame(Window window) {
        // TODO Zeichnet die drei Game Objekte.
        // TODO Zeichnet den Punktestand.
	}
}
