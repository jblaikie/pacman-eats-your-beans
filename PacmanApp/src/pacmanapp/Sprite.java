package pacmanapp;

public interface Sprite{
    
    public void draw(API api);
    public void update();
    public int getX();
    public int getY();
    public int getW();
    public int getH();
}
