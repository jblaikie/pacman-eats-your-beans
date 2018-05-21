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
                        temp[y][x]=new Wall(x,y);
                        ge.register(temp[y][x]);
                        break;
                    case '.':
                        temp[y][x]=new Pacdot(x,y);
                        ge.register(temp[y][x]);
                        break;
                    case 'o':
                        temp[y][x]=new Pacman(x,y,0,1);
                        ge.register(temp[y][x]);
                        ge.playerPacman=(Pacman)temp[y][x];
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
}
