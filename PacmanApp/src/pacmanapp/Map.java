/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanapp;

/**
 *
 * @author csc190
 */
public class Map {
    char[][] txtmap;
    Sprite[][] map;
    GameEngine ge;
    
    public Map(char[][] txtmap, GameEngine ge)
    {
        this.txtmap=txtmap;
        this.ge=ge;
        map =load();
        
    }
    
    public Sprite[][] load()
    {
        int y=0, x=0;
        Sprite[][] temp = new Sprite[txtmap.length][txtmap[0].length];
        while(y<txtmap.length)
        {
            while(x<txtmap[0].length)
            {
                char c = txtmap[y][x];
                switch(c){
                    case 'x': 
                        temp[y][x]=new Wall(x*50,y*50);
                        ge.register(temp[y][x]);
                        break;
                    case '.':
                        temp[y][x]=new Pacdot(x*50,y*50);
                        ge.register(temp[y][x]);
                        break;
                    case 'o':
                        temp[y][x]=new Pacman(x*50,y*50,0,1);
                        ge.register(temp[y][x]);
                        ge.playerPacman=(Pacman)temp[y][x];
                        break;
                    case 'b':
                        temp[y][x]=new Blinky(x*50,y*50,0,1);
                        ge.register(temp[y][x]);
                        //ge.playerPacman=(Pacman)temp[y][x];
                        break;
                    case 'p':
                        temp[y][x]=new Pinky(x*50,y*50,0,1);
                        ge.register(temp[y][x]);
                        break;
                    case 'i':
                        temp[y][x]=new Inky(x*50,y*50,0,1);
                        ge.register(temp[y][x]);
                        break;
                    case 'c':
                        temp[y][x]=new Clyde(x*50,y*50,0,1);
                        ge.register(temp[y][x]);
                        break;
                    default:
                        temp[y][x]=new EmptyPath();
                        break;
                }
                        
                
                
                x++;
            }
            y++;
            x=0;
        }
        return temp;
    }
    public void drawAll()
    {
        int x=0; int y=0;
        while(y<map.length)
        {
            while(x<map.length)
            {
                map[y][x].draw(ge.api);
                x++;
            }
            x=0; y++;
        }
    }
    
    public int getDirTo(int sx, int sy, int dx, int dy){
        // A* implemented here
        return 0;
    }
}
