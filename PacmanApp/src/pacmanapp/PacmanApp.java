/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
   

    @Override
    public void start(Stage primaryStage) {
        ge = new GameEngine(this);
        ge.loadMap();
        map = new HashMap<String, Image>();
        gc = canvas.getGraphicsContext2D();
             
        myThread thread = new myThread();
        thread.start();
        
        root.getChildren().add(canvas);

        Scene scene = new Scene(root, 700, 600);
        
        scene.setOnKeyPressed((KeyEvent e) -> {
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
        

        primaryStage.setTitle("Pacman");
        primaryStage.setScene(scene);
        primaryStage.show();
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
