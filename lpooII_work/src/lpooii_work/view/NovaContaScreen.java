/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lpooii_work.view;

import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import lpooii_work.controller.ClienteController;
import lpooii_work.controller.ContaController;
import lpooii_work.database.DAOException;
import lpooii_work.models.Cliente;
import lpooii_work.models.Conta;
import lpooii_work.models.ContaCorrente;
import lpooii_work.models.ContaInvestimento;
import lpooii_work.view.table.ClienteTable;

/**
 *
 * @author leonardozanotti
 */
public class NovaContaScreen extends javax.swing.JFrame {
    private final ClienteTable clienteTableModel = new ClienteTable();
    private int clickedLine = -1;
    private Cliente clienteToAction;

    /**
     * Creates new form NovaConta
     */
    public NovaContaScreen() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Nova conta");
        this.setResizable(false);
        this.setAllClients();
        this.Label3.setVisible(false);
        this.Input3.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        VoltarButton = new javax.swing.JButton();
        ContaBox = new javax.swing.JComboBox<>();
        ScrollPane = new javax.swing.JScrollPane();
        clientesTable = new javax.swing.JTable();
        PesquisarLabel = new javax.swing.JLabel();
        SearchField = new javax.swing.JTextField();
        PesquisarButton = new javax.swing.JButton();
        Label1 = new javax.swing.JLabel();
        Label2 = new javax.swing.JLabel();
        Label3 = new javax.swing.JLabel();
        Input1 = new javax.swing.JTextField();
        Input2 = new javax.swing.JTextField();
        Input3 = new javax.swing.JTextField();
        CriarContaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        VoltarButton.setText("Voltar");
        VoltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarButtonActionPerformed(evt);
            }
        });

        ContaBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Conta corrente", "Conta investimento" }));
        ContaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContaBoxActionPerformed(evt);
            }
        });

        clientesTable.setModel(clienteTableModel);
        clientesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientesTableMouseClicked(evt);
            }
        });
        ScrollPane.setViewportView(clientesTable);

        PesquisarLabel.setText("Pesquisar");

        PesquisarButton.setText("Pesquisar");
        PesquisarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarButtonActionPerformed(evt);
            }
        });

        Label1.setText("Dep??sito inicial (R$)");

        Label2.setText("Limite (R$)");

        Label3.setText("Dep??sito inicial (R$)");

        Input1.setToolTipText("");

        CriarContaButton.setText("Criar conta");
        CriarContaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CriarContaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PesquisarLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PesquisarButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label2)
                            .addComponent(Label1)
                            .addComponent(Label3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Input1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Input2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Input3, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VoltarButton)
                            .addComponent(ContaBox, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CriarContaButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(VoltarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PesquisarLabel)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PesquisarButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ContaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label1)
                    .addComponent(Input1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label2)
                    .addComponent(Input2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label3)
                    .addComponent(Input3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(CriarContaButton)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarButtonActionPerformed
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_VoltarButtonActionPerformed

    private void clientesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientesTableMouseClicked
        clickedLine = clientesTable.rowAtPoint(evt.getPoint());
        clienteToAction = clienteTableModel.getCliente(clickedLine);
    }//GEN-LAST:event_clientesTableMouseClicked

    private void PesquisarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarButtonActionPerformed
        try {
            String search = this.SearchField.getText();
            clienteTableModel.setClientes(ClienteController.searchClients(search));
        } catch (DAOException | IOException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar a opera????o: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_PesquisarButtonActionPerformed

    private void ContaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContaBoxActionPerformed
        String selectedConta = (String) this.ContaBox.getSelectedItem();
        if (selectedConta.equals("Conta corrente")) {
            this.Label1.setText("Dep??sito inicial (R$)");
            this.Label2.setText("Limite (R$)");
            this.Label3.setVisible(false);
            this.Input3.setVisible(false);
        } else {
            this.Label1.setText("Montante m??nimo (R$)");
            this.Label2.setText("Dep??sito m??nimo (R$)");
            this.Label3.setVisible(true);
            this.Input3.setVisible(true);
        }
    }//GEN-LAST:event_ContaBoxActionPerformed

    private void CriarContaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CriarContaButtonActionPerformed
        String selectedConta = (String) this.ContaBox.getSelectedItem();
        String input1 = this.Input1.getText();
        String input2 = this.Input2.getText();
        String input3 = this.Input3.getText();
        if ("".equals(input1) || "".equals(input2) || ("".equals(input3) && selectedConta.equals("Conta investimento")) || clienteToAction == null) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos e selecione um cliente!", "Erro criando conta", JOptionPane.ERROR_MESSAGE);
            return;
        } else try {
            if (clienteToAction.getConta() != null) {
                JOptionPane.showMessageDialog(null, "Cliente j?? possui conta!", "Erro criando conta", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (DAOException | IOException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro buscando conta do cliente!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        Conta conta = null;
        try {
            if (selectedConta.equals("Conta corrente")) {
                double depositoInicial = Double.parseDouble(input1);
                double limite = Double.parseDouble(input2);
                conta = (ContaCorrente) new ContaCorrente(0.0, depositoInicial, limite, 1, clienteToAction.getId());
            } else {
                double montanteMinimo = Double.parseDouble(input1);
                double depositoMinimo = Double.parseDouble(input2);
                double depositoInicial = Double.parseDouble(input3);
                conta = (ContaInvestimento) new ContaInvestimento(0.0, montanteMinimo, depositoMinimo, depositoInicial, 2, clienteToAction.getId());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite apenas numeros nos campos de deposito", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        try {
            ContaController.inserir(conta);
            JOptionPane.showMessageDialog(null, "Conta criada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.cleanAllFields();
        } catch (DAOException | IOException | SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar a opera????o: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_CriarContaButtonActionPerformed

    private void setAllClients() {
        try {
            clienteTableModel.setClientes(ClienteController.buscarTodos());
        } catch (DAOException | IOException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar a opera????o: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cleanAllFields() {
        clienteTableModel.cleanTable();
        this.setAllClients();
        this.ContaBox.setSelectedIndex(0);
        this.Input1.setText("");
        this.Input2.setText("");
        this.Input3.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NovaContaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovaContaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovaContaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovaContaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovaContaScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ContaBox;
    private javax.swing.JButton CriarContaButton;
    private javax.swing.JTextField Input1;
    private javax.swing.JTextField Input2;
    private javax.swing.JTextField Input3;
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Label2;
    private javax.swing.JLabel Label3;
    private javax.swing.JButton PesquisarButton;
    private javax.swing.JLabel PesquisarLabel;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTextField SearchField;
    private javax.swing.JButton VoltarButton;
    private javax.swing.JTable clientesTable;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
