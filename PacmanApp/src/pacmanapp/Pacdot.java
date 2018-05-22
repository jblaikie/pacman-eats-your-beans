package pacmanapp;
public class Pacdot implements Sprite
{
    int x; int y;
    public Pacdot(int x, int y)
    {
        this.x=x; this.y=y;
    }
    public void draw(API api){
        api.drawImg("objectImgs/pacdot.png",x,y,30,30);
    }
    public void update(){}

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getW() {
        return 50;
    }

    @Override
    public int getH() {
        return 50;
    }
    
}
