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
public class Ghost implements Sprite {

    protected int x, y, sx, sy;
    
    public Ghost(int x, int y, int sx, int sy) {
        this.x = x;
        this.y = y;
        this.sx = sx;
        this.sy = sy;
    }

    @Override
    public void draw(API api) {
        return;
    }

    @Override
    public void update() {
        return;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
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
