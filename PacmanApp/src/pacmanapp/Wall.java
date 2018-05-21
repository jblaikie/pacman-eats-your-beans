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
public class Wall implements Sprite {
    int x; int y;

    public Wall(int x, int y)
    {
        this.x=x; this.y=y;
    }
    @Override
    public void draw(API api) {
         api.drawImg("objectImgs/fullblock.png",x,y,30,30);
    }

    @Override
    public void update() {
        
    }

    @Override
    public int getX() {
    return x;    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getW() {
       return 30;
    }

    @Override
    public int getH() {
        return 30;
    }
    
}
