/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lpooii_work.screen;

import javax.swing.JButton;
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
        this.setLayout(null);
        
        JButton clientesButton = new JButton("Clientes");
        JButton vincularButton = new JButton("Nova conta");
        JButton contasButton = new JButton("Contas");
        
        
        clientesButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clientesButton.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
    
        clientesButton.setBounds(115,90,300,100);
        vincularButton.setBounds(115,245,300,100);
        contasButton.setBounds(115,400,300,100);
    
        getContentPane().add(clientesButton);
        getContentPane().add(vincularButton);
        getContentPane().add(contasButton);
    }
    
}
