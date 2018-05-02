package pacmanapp;
public class Pacman implements Sprite
{
    protected int x, y, sx, sy;
    protected String[] arrPics ={
        "pacmanImgs/pacman1.png", "pacmanImgs/pacman2.png",
        "pacmanImgs/pacman3.png", "pacmanImgs/pacman4.png",
        "pacmanImgs/pacman5.png"
    };
    
    protected int picIndex = 0;
    private int counter = 0;
    
    public Pacman(int x, int y, int sx, int sy){
        this.x = x;
        this.y = y;
        this.sx = sx;
        this.sy = sy;
    }
    public void draw(API api)
    {
        String pic = this.arrPics[this.picIndex];
        api.drawImg(pic, x, y, 50, 50);
    }
    
    @Override
    public void update()
    {
        counter++;
        this.x = this.sx + x;
        this.y = this.sy + y;
        
        if(counter % 25 == 0){
            this.picIndex = (picIndex + 1) % this.arrPics.length;
        }
    }
    public void setDirection(int sx, int sy)
    {
        this.sx = sx;
        this.sy = sy;
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
        return 50;
    }

    @Override
    public int getH() {
        return 50;
    }
}
