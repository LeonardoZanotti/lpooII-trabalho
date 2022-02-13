/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lpooii_work;

import lpooii_work.screen.UserScreen;

/**
 *
 * @author leonardozanotti
 */
public class LpooII_work implements Runnable {
    UserScreen userScreen = new UserScreen();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Thread(new LpooII_work()).start();
    }
    
    @Override
    public void run() {
        while (true) {
            userScreen.repaint();
        }
    }
    
}
