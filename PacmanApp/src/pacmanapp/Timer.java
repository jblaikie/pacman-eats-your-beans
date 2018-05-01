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

public class Timer {
    protected long starttime;
    public void start()
    {
        starttime = System.currentTimeMillis();
    }
    public double stop()
    {
        return System.currentTimeMillis() - starttime;
    }
}
