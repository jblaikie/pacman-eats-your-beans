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
public class Pinky extends Ghost implements Sprite {
    
    protected int x, y, sx, sy;
    protected String[] arrPics ={
        "ghostImgs/pinky1.png", "ghostImgs/pinky2.png"
    };
    
    protected int picIndex = 0;
    private int counter = 0;
    
    public Pinky(int x, int y, int sx, int sy) {
        super(x, y, sx, sy);
    }
    
    public int findDest(int x, int y){
        
        return 0;
    }

    @Override
    public void draw(API api) {
        String pic = this.arrPics[this.picIndex];
        api.drawImg(pic, x, y, 30, 30);
    }

    @Override
    public void update() {
        counter++;
        this.x = this.sx + x;
        this.y = this.sy + y;
        
        if(counter % 25 == 0){
            this.picIndex = (picIndex + 1) % this.arrPics.length;
        }
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public int getW() {
        return super.getW();
    }

    @Override
    public int getH() {
        return super.getH();
    }
    
}
