package pacmanapp;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javafx.event.EventHandler;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameEngine {

    protected Pacman playerPacman;
    protected ArrayList<Sprite> arrSprites = new ArrayList<Sprite>();
    protected ArrayList<Sprite> dead = new ArrayList<Sprite>();
    protected Map map;
    protected int score = 0;

    protected API api;

    public GameEngine(API api) {
        this.api = api;
    }
    public void loadMap(String path) {
        try {
            //pass map path
            //Pacman man1 = new Pacman(200, 100, 1, 0);
            //Pacman man2 = new Pacman(100, 250, 1, 0);
            //this.register(man1);
            //this.register(man2);
            //this.playerPacman = man1;
            Path p = Paths.get(path);
            Scanner scanner = new Scanner(p);
            char[][] map=new char[8][8];
            int x=0,y=0;
            while(scanner.hasNextLine()&&y<map.length)
            {
                String line = scanner.nextLine();
               // Scanner s2 = new Scanner(line);
                while(x<line.length())
                {
                    //String next = s2.next();
                    map[y][x]=line.charAt(x);
                    //switch(next) { //contruct map obj
                    //  case "x":
                    
                    //}
                    x++;
                }
                y++; x=0;
            }
            this.map=new Map(map, this);
            
            
        } catch (IOException ex) {
            Logger.getLogger(GameEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }

    public void register(Sprite s) {
        this.arrSprites.add(s);

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
                            if (s instanceof Pacdot && s2 instanceof Pacman) {
                                dead.add(s);
                                score = score + 10;
                            }
                            else if(s instanceof Wall && s2 instanceof Pacman){
                                ((Pacman)s2).setDirection(0,0);
                                ((Pacman)s2).x = Math.round(((Pacman)s2).x / 50)* 50 + 5;
                                ((Pacman)s2).y = Math.round(((Pacman)s2).y / 50)* 50 - 5;
                            } 
                            if (s instanceof Pacman && s2 instanceof Ghost) {
                                dead.add(s);
                                System.out.println("Game Over");
                            }
                        }
                    }
                }
            }
            s.update();
            s.draw(this.api);
        }
        api.updateScore();
        for(Sprite sprite: this.dead){
                delete(sprite);
            }
        timer.stop();

    }

    public enum KEY {
        UP, DOWN, LEFT, RIGHT
    };
    

    public void handleKey(KEY key) {
        switch (key) {
            case UP:
                this.playerPacman.setDirection(0, -1); 
                break;
            case DOWN:
                this.playerPacman.setDirection(0, 1); 
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
    
    public int getScore(){
        return this.score;
    }
    
    public void drawScore(int x, int y){
        
    }
    
}
