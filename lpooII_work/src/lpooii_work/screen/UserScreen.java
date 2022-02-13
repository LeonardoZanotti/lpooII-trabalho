/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lpooii_work.screen;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 *
 * @author leonardozanotti
 */
public class UserScreen extends JFrame {
    
    public UserScreen() {
        this.initialize();
    }
    
    private void initialize() {
        this.setSize(530, 620);
        this.setLocationRelativeTo(null);

        this.setTitle("Banco LPOOII");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
    
}
