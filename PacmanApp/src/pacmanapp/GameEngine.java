package pacmanapp;

import java.util.ArrayList;
import javafx.event.EventHandler;

public class GameEngine {

    protected Pacman playerPacman;
    protected ArrayList<Sprite> arrSprites = new ArrayList<Sprite>();

    public void loadMap() { //pass map path
        Pacman man1 = new Pacman(200, 100, 1, 0);
        Pacman man2 = new Pacman(100, 250, 1, 0);
        this.register(man1);
        this.register(man2);
        this.playerPacman = man1;
    }

    public void register(Sprite s) {
        this.arrSprites.add(s);

    }

    protected API api;

    public GameEngine(API api) {
        this.api = api;
    }

    public void oneRound() {
        Timer timer = new Timer();
        timer.start();
        api.clear();
        for (Sprite s : this.arrSprites) {
            for (Sprite s2 : arrSprites) {
                if (s != s2) {
                    if (s.getX() <= s2.getX() && s2.getX() <= s.getX() + s.getW()) {
                        if (s.getY() <= s2.getY() && s2.getY() <= s.getY() + s.getH()) {
                            //if (s instanceof Pacman && s2 instanceof Pacdot) {
                            if (s instanceof Pacman && s2 instanceof Pacman) {
                                delete(s2);
                            }
                            //else if(s2 instanceof Pacman && s instanceof Pacdot)
                            //  delete(s);
                        }
                    }
                }
            }
            s.update();
            s.draw(this.api);
        }
        timer.stop();

    }

    public enum KEY {
        UP, DOWN, LEFT, RIGHT
    };
    

    public void handleKey(KEY key) {
        switch (key) {
            case UP:
                this.playerPacman.setDirection(0, -1); //why is it 0, -1 and not 0, 1??
                break;
            case DOWN:
                this.playerPacman.setDirection(0, 1); //why not 0, -1??
                break;
            case LEFT:
                this.playerPacman.setDirection(-1, 0);
                break;
            case RIGHT:
                this.playerPacman.setDirection(1, 0);
                break;

        }
    }

    
    public void delete (Sprite s){
        this.arrSprites.remove(s);
    }
    
    
    



}
