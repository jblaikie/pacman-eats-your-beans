package pacmanapp;
public class Pacman implements Sprite
{
    protected int x, y, sx, sy;
    protected String[] arrPics ={ //up
        "pacmanImgs/pacmanUp1.png", "pacmanImgs/pacmanUp2.png",
        "pacmanImgs/pacmanUp3.png", "pacmanImgs/pacmanUp4.png",
        "pacmanImgs/pacmanUp5.png"
    };
    protected String[] arrPics2 ={ //down
        "pacmanImgs/pacmanDown1.png", "pacmanImgs/pacmanDown2.png",
        "pacmanImgs/pacmanDown3.png", "pacmanImgs/pacmanDown4.png",
        "pacmanImgs/pacmanDown5.png"
    };
    
    protected String[] arrPics3 ={ //left
        "pacmanImgs/pacmanL1.png", "pacmanImgs/pacmanL2.png",
        "pacmanImgs/pacmanL3.png", "pacmanImgs/pacmanL4.png",
        "pacmanImgs/pacmanL5.png"   
    };
    
    protected String[] arrPics4 ={ //right
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
        
        //String pic = this.arrPics[this.picIndex];
        //api.drawImg(pic, x, y, 30, 30);
        
        if (this.sx == 0 && this.sy == -1){ //up
            String pic = this.arrPics[this.picIndex];
            api.drawImg(pic, x, y, 30, 30);     
        }
        
        if (this.sx == 0 && this.sy == 1){ //down
            String pic2 = this.arrPics2[this.picIndex];
            api.drawImg(pic2, x, y, 30, 30);
        }
        
        if (this.sx == -1 && this.sy == 0){ //left
            String pic3 = this.arrPics3[this.picIndex];
            api.drawImg(pic3, x, y, 30, 30);
        }
        
        if (this.sx == 1 && this.sy == 0){ //down
            String pic4 = this.arrPics4[this.picIndex];
            api.drawImg(pic4, x, y, 30, 30);
        }
        
    }
    
    @Override
    public void update()
    {
        counter++;
        this.x = this.sx + x;
        this.y = this.sy + y;
        
        if(counter % 25 == 0){
            this.picIndex = (picIndex + 1) % 5;//% this.arrPics.length;
        }
    }
    public void setDirection(int sx, int sy)
    {
        this.sx = sx;
        this.sy = sy;
    }

    public int getDirectionX(){
        return this.sx;
    }
    
    public int getDirectionY(){
        return this.sy;
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
