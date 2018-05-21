/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanapp;

import javafx.scene.paint.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 *
 * @author csc190
 */
public class PacmanApp extends Application implements API {

    protected GraphicsContext gc;
    protected GameEngine ge;
    protected Canvas canvas = new Canvas(700, 600);
    protected Group root = new Group();
    protected HashMap<String, Image> map;
   

   //NOTES will delete later    
        /*public void initMainMenu(Stage stage){
        Rectangle bg = new Rectangle(900, 600);
        
        Font font = Font.font(72);
        
        Button btnLoad = new Button("LOAD MAP");
        btnLoad.setFont(font);
        btnLoad.setOnAction((event) -> {
            start(stage);
        });
        
        Button btnExit = new Button("EXIT");
        btnExit.setFont(font);
        btnExit.setOnAction((event) ->  {
        //    exit(stage);
        });
        
        VBox vbox = new VBox(50, btnLoad, btnExit);
        vbox.setTranslateX(400);
        vbox.setTranslateY(200);
        
        //Stage.getChildren().addAll(bg, vbox);
        
    }*/
    
    @Override
    public void start(Stage primaryStage) {

        Group g1 = new Group();
        Group g2 = new Group();
        Scene sc1menu = new Scene(g1, 500, 500, Color.SLATEGREY);
        //Scene sc2game = new Scene(g2, 500, 500);
        
        Font font = Font.font(70);
        Font font2 = Font.font(STYLESHEET_MODENA,50);
        Font fontb2 = Font.font(71);
        
        //Start Game on g1
        Label t1 = new Label("GAME MENU");
        t1.setFont(font2);
        t1.setTextFill(Color.WHITE);
        Button b1 = new Button("Start");
        b1.setFont(font);
        
        //Other menu buttons can be added to g1 here...
        //Load Game on g2
        Label t2 = new Label(" ");
        Button b2 = new Button("Load");
        b2.setFont(fontb2);
        
        VBox vbox = new VBox(50, b1, b2);
        vbox.setTranslateX(400);
        vbox.setTranslateY(200);
          
        t1.setTranslateY(20);
        t1.setTranslateX(100);
        t2.setTranslateY(65);
        b1.setTranslateY(120);
        b1.setTranslateX(122);
        b2.setTranslateY(300);
        b2.setTranslateX(122);
        g1.getChildren().addAll(vbox, t1, b1, t2, b2);
        //g2.getChildren().addAll(t2, b2);

        //b2 set on action to loadmap, and then set for that button click
        //go to the scene which represents the new loadmap, 
        //so add the scene switch after the loadmap part and then show that
        
        primaryStage.setScene(sc1menu);
        primaryStage.show();
    
    //}    
        ge = new GameEngine(this);
        ge.loadMap("maps/map0.txt");
        map = new HashMap<String, Image>();
        gc = canvas.getGraphicsContext2D();
             
        myThread thread = new myThread();
        thread.start();
        
       root.getChildren().add(canvas);
       //root.getChildren().add(gc.getCanvas());
       
       HBox score = new HBox();
       score.setAlignment(Pos.TOP_CENTER);
       
       Label scoreLabel = new Label("Score:");
       scoreLabel.setTextFill(Color.WHITE);
       scoreLabel.setFont(Font.font("Arial", 30));
       scoreLabel.setAlignment(Pos.TOP_LEFT);
       
       score.getChildren().add(scoreLabel);
       root.getChildren().add(score);

        Scene sc2game = new Scene(root, 640,640, Color.BLACK);
 
        sc2game.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.UP){
                ge.handleKey(GameEngine.KEY.UP);
            }
            
            if (e.getCode() == KeyCode.DOWN){
                ge.handleKey(GameEngine.KEY.DOWN);
            }
            
            if (e.getCode() == KeyCode.RIGHT){
                ge.handleKey(GameEngine.KEY.RIGHT);
            }
            
            if (e.getCode() == KeyCode.LEFT){
                ge.handleKey(GameEngine.KEY.LEFT);
            }
        });
                
        //scene event switch to Pacman game
        b1.setOnMouseClicked(e -> { primaryStage.setScene(sc2game); });
        //option to return to menu if implemented
        //implement for quit or for loadmap file
                                                //setScene for loadMap
        b2.setOnMouseClicked(e -> { primaryStage.setScene(sc1menu); });

        //Set color of background
        //primaryStage.setScene(sc1menu);
        primaryStage.setTitle("Pacman");
        //primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void drawImg(String path, int x, int y, int w, int h) {
        FileInputStream fis = null;
        Image im = map.get(path);
        
        if (im == null) {
            try {
                fis = new FileInputStream(path);
                im = new Image(fis);
                map.put(path, im);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PacmanApp.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (fis != null) {
                        fis.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(PacmanApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        this.gc.drawImage(im, x, y, w, h);

    }

    @Override
    public void clear() {
        gc.clearRect(0, 0, 1000, 1000);
    }

    class myThread extends Thread {

        public void run() {
            while (true) {
                try {
                    Thread.sleep(50);
                    ge.oneRound();
                } catch (InterruptedException ex) {
                    Logger.getLogger(PacmanApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
