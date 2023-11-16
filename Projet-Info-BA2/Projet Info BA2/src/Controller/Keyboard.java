package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Model.Game;

public class Keyboard implements KeyListener {
    private Game game;

    private static final int player1 = 0;

    public Keyboard(Game game) {
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();

        switch (key) {
        case KeyEvent.VK_RIGHT:                    //Gère le mouvement du joueur
            game.movePlayer(1, 0, player1);
            break;
        case KeyEvent.VK_LEFT:
        	game.movePlayer(-1, 0, player1);
            break;
        case KeyEvent.VK_DOWN:
            game.movePlayer(0, 1, player1);
            break;
        case KeyEvent.VK_UP:
            game.movePlayer(0, -1, player1);
             break;
        case KeyEvent.VK_SPACE:                 //Gère l'attaque du joueur
            game.action(player1);
             break;
        case KeyEvent.VK_Q:						//Gère les différentes commandes des objets
        	game.catchPotion(player1);
             break;
        case KeyEvent.VK_S:
        	game.catchDiamond(player1);
        case KeyEvent.VK_A:
        	game.usePotion(player1);
        	break;
        case KeyEvent.VK_T:
        	game.teleport(player1);
        	break;
        case KeyEvent.VK_W:
        	game.dropPotion(player1);
        	break;
        case KeyEvent.VK_X:
        	game.dropDiamond(player1);
        	break;
        case KeyEvent.VK_Z:
        	game.useDiamond(player1);
        	break;
        }
        
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
