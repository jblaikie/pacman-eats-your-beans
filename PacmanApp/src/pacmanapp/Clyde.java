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
public class Clyde extends Ghost implements Sprite {
    
    protected GameEngine ge;
    protected int x, y, sx, sy;
    protected String[] arrPics ={
        "ghostImgs/cylde1.png", "ghostImgs/clyde2.png" //clyde1.png does not exist due to typo in file name
    };
    
    protected int picIndex = 0;
    private int counter = 0;
    public Clyde(int x, int y, int sx, int sy) {
        super(x, y, sx, sy);
    }
    
    public int findDestX(){
        return this.ge.playerPacman.getX();
    }
    
    public int findDestY(){
        return this.ge.playerPacman.getY();
    }
    
    public void setDirection(){
        int dx = Math.abs(ge.playerPacman.getX() - this.getX());
        int dy = Math.abs(ge.playerPacman.getY() - this.getY());
        if( dx > 8 && dy > 8){
            // directly target Pacman
            this.sx = findDestX();
            this.sy = findDestY();
        }
        else{
            // retreat to bottom left corner
            this.sx++;
            this.sy++;
        }

       System.out.println(this.sx);
       System.out.println(this.sy);
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
