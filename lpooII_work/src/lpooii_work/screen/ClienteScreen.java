/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lpooii_work.screen;

import lpooii_work.classes.Cliente;
import lpooii_work.screen.table.ClienteTable;

/**
 *
 * @author leonardozanotti
 */
public class ClienteScreen extends javax.swing.JFrame {
    private final ClienteTable clienteTableModel = new ClienteTable();
    private int clickedLine = -1;
    private Cliente clienteToUpdate;
    
    /**
     * Creates new form Cliente
     */
    public ClienteScreen() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Cliente");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VoltarButton = new javax.swing.JButton();
        CadastrarButton = new javax.swing.JButton();
        AtualizarButton = new javax.swing.JButton();
        ExcluirButton = new javax.swing.JButton();
        NomeLabel = new javax.swing.JLabel();
        SobrenomeLabel = new javax.swing.JLabel();
        RGLabel = new javax.swing.JLabel();
        CPFLabel = new javax.swing.JLabel();
        EnderecoLabel = new javax.swing.JLabel();
        NomeField = new javax.swing.JTextField();
        SobrenomeField = new javax.swing.JTextField();
        RGField = new javax.swing.JTextField();
        CPFField = new javax.swing.JTextField();
        EnderecoField = new javax.swing.JTextField();
        ScrollPane = new javax.swing.JScrollPane();
        clientesTable = new javax.swing.JTable();
        PesquisarLabel = new javax.swing.JLabel();
        SearchField = new javax.swing.JTextField();
        PesquisarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        VoltarButton.setText("Voltar");
        VoltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarButtonActionPerformed(evt);
            }
        });

        CadastrarButton.setText("Cadastrar");
        CadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarButtonActionPerformed(evt);
            }
        });

        AtualizarButton.setText("Atualizar");
        AtualizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarButtonActionPerformed(evt);
            }
        });

        ExcluirButton.setText("Excluir");
        ExcluirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirButtonActionPerformed(evt);
            }
        });

        NomeLabel.setText("Nome");

        SobrenomeLabel.setText("Sobrenome");

        RGLabel.setText("RG");

        CPFLabel.setText("CPF");

        EnderecoLabel.setText("Endereço");

        RGField.setToolTipText("");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RGLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RGField, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EnderecoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EnderecoField, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NomeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SobrenomeLabel)
                            .addComponent(VoltarButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SobrenomeField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(CadastrarButton)
                                .addGap(18, 18, 18)
                                .addComponent(AtualizarButton)
                                .addGap(18, 18, 18)
                                .addComponent(ExcluirButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CPFLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CPFField, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(PesquisarLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PesquisarButton)
                                .addGap(1, 1, 1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VoltarButton)
                    .addComponent(AtualizarButton)
                    .addComponent(CadastrarButton)
                    .addComponent(ExcluirButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomeLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SobrenomeLabel)
                    .addComponent(SobrenomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RGLabel)
                    .addComponent(RGField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CPFLabel)
                    .addComponent(CPFField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EnderecoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EnderecoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PesquisarLabel)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PesquisarButton))
                .addGap(18, 18, 18)
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarButtonActionPerformed
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_VoltarButtonActionPerformed

    private void CadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarButtonActionPerformed
        String nome = this.NomeField.getText();
        String sobrenome = this.SobrenomeField.getText();
        String rg = this.RGField.getText();
        String cpf = this.CPFField.getText();
        String endereco = this.EnderecoField.getText();
        if (nome.length() > 0 && sobrenome.length() > 0 && rg.length() > 0 && cpf.length() > 0 && endereco.length() > 0) {
            Cliente c = new Cliente(nome, sobrenome, rg, cpf, endereco);
            this.clienteTableModel.addCliente(c);
            cleanFields();
        }
    }//GEN-LAST:event_CadastrarButtonActionPerformed

    private void AtualizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarButtonActionPerformed
        String nome = this.NomeField.getText();
        String sobrenome = this.SobrenomeField.getText();
        String rg = this.RGField.getText();
        String cpf = this.CPFField.getText();
        String endereco = this.EnderecoField.getText();
        if (nome.length() > 0 && sobrenome.length() > 0 && rg.length() > 0 && cpf.length() > 0 && endereco.length() > 0) {
            this.clienteTableModel.updateCliente(clienteToUpdate, nome, sobrenome, rg, cpf, endereco);
            cleanFields();
        }
    }//GEN-LAST:event_AtualizarButtonActionPerformed

    private void ExcluirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirButtonActionPerformed
        if (clickedLine != -1) {
            Cliente c = clienteTableModel.getCliente(clickedLine);
            clienteTableModel.removeCliente(c);
        }
        clickedLine = -1;
        cleanFields();
    }//GEN-LAST:event_ExcluirButtonActionPerformed

    private void clientesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientesTableMouseClicked
        clickedLine = clientesTable.rowAtPoint(evt.getPoint());
        clienteToUpdate = clienteTableModel.getCliente(clickedLine);
        this.NomeField.setText(clienteToUpdate.getNome());
        this.SobrenomeField.setText(clienteToUpdate.getSobrenome());
        this.RGField.setText(clienteToUpdate.getRg());
        this.CPFField.setText(clienteToUpdate.getCpf());
        this.EnderecoField.setText(clienteToUpdate.getEndereco());
    }//GEN-LAST:event_clientesTableMouseClicked

    private void PesquisarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarButtonActionPerformed
        String search = this.SearchField.getText();
        clienteTableModel.searchCliente(search);
    }//GEN-LAST:event_PesquisarButtonActionPerformed

    private void cleanFields(){
        this.NomeField.setText("");
        this.SobrenomeField.setText("");
        this.RGField.setText("");
        this.CPFField.setText("");
        this.EnderecoField.setText("");       
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
            java.util.logging.Logger.getLogger(ClienteScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtualizarButton;
    private javax.swing.JTextField CPFField;
    private javax.swing.JLabel CPFLabel;
    private javax.swing.JButton CadastrarButton;
    private javax.swing.JTextField EnderecoField;
    private javax.swing.JLabel EnderecoLabel;
    private javax.swing.JButton ExcluirButton;
    private javax.swing.JTextField NomeField;
    private javax.swing.JLabel NomeLabel;
    private javax.swing.JButton PesquisarButton;
    private javax.swing.JLabel PesquisarLabel;
    private javax.swing.JTextField RGField;
    private javax.swing.JLabel RGLabel;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTextField SearchField;
    private javax.swing.JTextField SobrenomeField;
    private javax.swing.JLabel SobrenomeLabel;
    private javax.swing.JButton VoltarButton;
    private javax.swing.JTable clientesTable;
    // End of variables declaration//GEN-END:variables
}
