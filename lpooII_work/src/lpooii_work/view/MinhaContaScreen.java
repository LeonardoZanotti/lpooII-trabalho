/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lpooii_work.view;

import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import lpooii_work.controller.ContaController;
import lpooii_work.database.DAOException;
import lpooii_work.models.Conta;

/**
 *
 * @author leonardozanotti
 */
public class MinhaContaScreen extends javax.swing.JFrame {
    private Conta clienteConta;

    /**
     * Creates new form MinhaConta
     */
    public MinhaContaScreen() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Minha conta");
        this.setResizable(false);
        SaqueButton.setEnabled(false);
        DepositoButton.setEnabled(false);
        SaldoButton.setEnabled(false);
        RemunerarButton.setEnabled(false);
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
        SaqueButton = new javax.swing.JButton();
        DepositoButton = new javax.swing.JButton();
        SaldoButton = new javax.swing.JButton();
        RemunerarButton = new javax.swing.JButton();
        PesquisarLabel = new javax.swing.JLabel();
        SearchField = new javax.swing.JTextField();
        PesquisarButton = new javax.swing.JButton();
        selecionadoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        VoltarButton.setText("Voltar");
        VoltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarButtonActionPerformed(evt);
            }
        });

        SaqueButton.setText("Saque");
        SaqueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaqueButtonActionPerformed(evt);
            }
        });

        DepositoButton.setText("Depósito");
        DepositoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepositoButtonActionPerformed(evt);
            }
        });

        SaldoButton.setText("Saldo");
        SaldoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaldoButtonActionPerformed(evt);
            }
        });

        RemunerarButton.setText("Remunerar");
        RemunerarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemunerarButtonActionPerformed(evt);
            }
        });

        PesquisarLabel.setText("CPF do cliente:");

        PesquisarButton.setText("Pesquisar");
        PesquisarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarButtonActionPerformed(evt);
            }
        });

        selecionadoLabel.setText("Nenhum cliente selecionado!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VoltarButton)
                    .addComponent(PesquisarLabel)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PesquisarButton)
                    .addComponent(selecionadoLabel)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SaldoButton)
                        .addGap(18, 18, 18)
                        .addComponent(SaqueButton)
                        .addGap(18, 18, 18)
                        .addComponent(DepositoButton)
                        .addGap(18, 18, 18)
                        .addComponent(RemunerarButton)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(VoltarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PesquisarLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PesquisarButton)
                .addGap(31, 31, 31)
                .addComponent(selecionadoLabel)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaldoButton)
                    .addComponent(SaqueButton)
                    .addComponent(DepositoButton)
                    .addComponent(RemunerarButton))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarButtonActionPerformed
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_VoltarButtonActionPerformed

    private void PesquisarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarButtonActionPerformed
        try {
            String search = this.SearchField.getText();
            clienteConta = ContaController.getContaByCPF(search);
            if (clienteConta != null) {
                this.selecionadoLabel.setText("Cliente selecionado: " + clienteConta.getDono().getFullName());
                SaqueButton.setEnabled(true);
                DepositoButton.setEnabled(true);
                SaldoButton.setEnabled(true);
                RemunerarButton.setEnabled(true);
            } else {
                this.selecionadoLabel.setText("Nenhum cliente selecionado!");
                SaqueButton.setEnabled(false);
                DepositoButton.setEnabled(false);
                SaldoButton.setEnabled(false);
                RemunerarButton.setEnabled(false);
            }
        } catch (DAOException | IOException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro buscando conta por CPF!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_PesquisarButtonActionPerformed

    private void SaqueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaqueButtonActionPerformed
        String saqueString = JOptionPane.showInputDialog("Quanto quer sacar?");
        try {
            if (saqueString != null) {
                double saqueDouble = Double.parseDouble(saqueString);
                if (clienteConta.saca(saqueDouble)) {
                    JOptionPane.showMessageDialog(null, "Saque de R$" + saqueString + " efetuado com sucesso!", "Saque", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Saque inválido!", "Saque", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Saque inválido!", "Saque", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SaqueButtonActionPerformed

    private void DepositoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepositoButtonActionPerformed
        String depositoString = JOptionPane.showInputDialog("Quanto quer depositar?");
        try {
            if (depositoString != null) {
                double depositoDouble = Double.parseDouble(depositoString);
                if (clienteConta.deposita(depositoDouble)) {
                    JOptionPane.showMessageDialog(null, "Depósito de R$" + depositoString + " efetuado com sucesso!", "Depósito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Depósito inválido!", "Depósito", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Depósito inválido!", "Depósito", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_DepositoButtonActionPerformed

    private void RemunerarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemunerarButtonActionPerformed
        clienteConta.remunera();
        JOptionPane.showMessageDialog(null, "Conta remunerada com sucesso!", "Remunerar", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_RemunerarButtonActionPerformed

    private void SaldoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaldoButtonActionPerformed
        JOptionPane.showMessageDialog(null, "Seu saldo é de R$" + String.format("%.2f", clienteConta.getSaldo()), "Saldo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_SaldoButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MinhaContaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MinhaContaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MinhaContaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MinhaContaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MinhaContaScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DepositoButton;
    private javax.swing.JButton PesquisarButton;
    private javax.swing.JLabel PesquisarLabel;
    private javax.swing.JButton RemunerarButton;
    private javax.swing.JButton SaldoButton;
    private javax.swing.JButton SaqueButton;
    private javax.swing.JTextField SearchField;
    private javax.swing.JButton VoltarButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel selecionadoLabel;
    // End of variables declaration//GEN-END:variables
}
