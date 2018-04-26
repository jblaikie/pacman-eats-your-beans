package pacmanapp;

import java.util.ArrayList;

public class GameEngine
{
    protected Pacman playerPacman;
    protected ArrayList arrSprites = new ArrayList();

    public void loadMap() { //pass map path
        Pacman man1 = new Pacman(100, 100, 1, 0);
        Pacman man2 = new Pacman(300, 300, 0, 1);
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
            s.update();
            s.draw(this.api);
        }
        timer.stop();

    }

    



}
