/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lpooii_work.screen;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import lpooii_work.classes.Cliente;

/**
 *
 * @author leonardozanotti
 */
public class UserScreen extends JFrame implements ActionListener {
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    
    // replace with db data
    Cliente c1 = new Cliente("Leonardo", "Zanotti", "123123456", "123456789", "endereço 1", 0);
    Cliente c2 = new Cliente("Leonardo 2", "Zanotti 2", "46", "89", "endereço 2", 0);
    
    public UserScreen() {
        // replace with db data
        clientes.add(c1);
        clientes.add(c2);
        
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
        JPanel newPanel = new JPanel(new GridLayout(20, 20));
        newPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(this);
        voltarButton.setActionCommand("voltar");
        newPanel.add(voltarButton);

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

                List<String> clienteNomes = clientes.stream().map(cliente -> cliente.getFullName()).collect(Collectors.toList());
                DefaultListModel model = new DefaultListModel();
                model.addAll(clienteNomes);
                JList clientesList = new JList(model);
                
                DefaultListModel model = new DefaultListModel();


                // limpar model
                // model.clear();
                // jList1.setModel(model);

                // remover item
                // model.remove(jList1.getSelectedIndex()); //retorna a posição do item selecionado.
                // jList1.setModel(model);

                newPanel.add(incluirButton);
                newPanel.add(atualizarButton);
                newPanel.add(excluirButton);
                newPanel.add(clientesList);
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