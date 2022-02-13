/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lpooii_work.screen;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author leonardozanotti
 */
public class UserScreen extends JFrame implements ActionListener {
    
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
        
        JPanel homePanel = new JPanel(new GridLayout(3, 1, 20, 20));
        homePanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        JButton clientesButton = new JButton("Clientes");
        JButton vincularButton = new JButton("Nova conta");
        JButton contasButton = new JButton("Contas");
        
        clientesButton.setBounds(115,90,300,100);
        vincularButton.setBounds(115,245,300,100);
        contasButton.setBounds(115,400,300,100);
    
        clientesButton.addActionListener(this);
        vincularButton.addActionListener(this);
        contasButton.addActionListener(this);
        
        clientesButton.setActionCommand("clientes");
        vincularButton.setActionCommand("vincular");
        contasButton.setActionCommand("contas");
        
        homePanel.add(clientesButton);
        homePanel.add(vincularButton);
        homePanel.add(contasButton);

        this.setContentPane(homePanel);
        this.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case "clientes":
                changePanel("clientes");
                break;
            case "vincular":
                changePanel("clientes");
                break;
            case "contas":
                changePanel("clientes");
                break;
            default:
                break;
        }
    }
    
    public void changePanel(String panel) {
        JPanel newPanel = new JPanel();
        newPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        switch (panel) {
            case "clientes":
                JButton incluirButton = new JButton("Novo cliente");
                JButton atualizarButton = new JButton("Atualizar cliente");
                JButton excluirButton = new JButton("Remover cliente");

                incluirButton.addActionListener(this);
                atualizarButton.addActionListener(this);
                excluirButton.addActionListener(this);

                incluirButton.setActionCommand("incluirCliente");
                atualizarButton.setActionCommand("atualizarCliente");
                excluirButton.setActionCommand("removerCliente");

                newPanel.add(incluirButton);
                newPanel.add(atualizarButton);
                newPanel.add(excluirButton);
                break;
            case "vincular":
                break;
            case "contas":
                break;
            default:
                break;
        }
        
        this.setContentPane(newPanel);
        this.revalidate();
    }
}
