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
public class Inky extends Ghost implements Sprite {
    
        
    protected int x, y, sx, sy;
    protected String[] arrPics ={
        "ghostImgs/inky1.png", "ghostImgs/inky2.png"
    };
    
    protected Pacman playerPacman;
    protected GameEngine ge;
    
    protected int picIndex = 0;
    private int counter = 0;
    
    public Inky(int x, int y, int sx, int sy) {
        super(x, y, sx, sy);
    }
    
    public int findDest(int x, int y){
       /* switch(playerPacman.getDirectionX() && playerPacman.getDirectionY()){
            case UP:
                //Pinky.setX(playerPacman.getX());
                x = playerPacman.getX();
                y = playerPacman.getY()-2;
                return (x, y);
            case DOWN:
                x = playerPacman.getX();
                y = playerPacman.getY()+2;
                return (x, y);
            case LEFT:
                x = playerPacman.getX()-2;
                y = playerPacman.getY();
                return (x, y);
            case RIGHT:
                x = playerPacman.getX()+2;
                y = playerPacman.getY();
                return (x, y);
            default:
                return 0;
        } */
        return 0;
    }

    public int findDestX(){
        return this.playerPacman.getX();
    }
    
    public int findDestY(){
        return this.playerPacman.getY();
    }
    
    public void setDirection(){
       if(findDestX() == 1)
            this.sx = findDestX() + 2;
       else if(findDestX() == -1)
            this.sx = findDestX() - 2;
       if(findDestY() == 1)
            this.sy = findDestY() + 2;
       else if(findDestY() == -1)
            this.sy = findDestY() - 2;
       
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
