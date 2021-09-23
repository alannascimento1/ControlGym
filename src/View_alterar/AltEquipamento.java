/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_alterar;

import Control.TelaPrincipal;
import DAO.Conexao;
import DAO.EquipamentoDAO;
import DAO.FornecedorDAO;
import DAO.FuncionarioDAO;
import Model.Equipamento;
import Model.Fornecedor;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class AltEquipamento extends javax.swing.JDialog {

    /**
     * Creates new form AltModelo
     */
    private TelaPrincipal telaPrincipal;
    public AltEquipamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        preencherEquipamento();
        preencherForn();
        telaPrincipal = (TelaPrincipal) parent;
    }
    
    public void preencherEquipamento() {

        Connection conexao = Conexao.conectar();
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
        List<Equipamento> listaEquipamento = new ArrayList<>();
        listaEquipamento = equipamentoDAO.listarEquipamentos();
        for (Equipamento eq : listaEquipamento) {
            jCEquipamento.addItem(eq.getNome());
        }
        Conexao.desconectar(conexao);

    } 
    public void preencherForn() {

        Connection conexao = Conexao.conectar();
        FornecedorDAO fornecedorDAO = new FornecedorDAO(conexao);
        List<Fornecedor> listaFornecedor = new ArrayList<>();
        listaFornecedor = fornecedorDAO.listarFornecedor();
        for (Fornecedor f : listaFornecedor) {
            jCFornecedor.addItem(f.getNome());
        }
        Conexao.desconectar(conexao);

    }     
    
    public void preencheCamposField(String nome) {
        Connection conexao = Conexao.conectar();
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
        Equipamento eq = equipamentoDAO.selecionaEquipamento(jCEquipamento.getSelectedItem().toString());
        jCFornecedor.getModel().setSelectedItem(new FornecedorDAO(conexao).selecionaFornecedor( eq.getFornecedor()).getNome() );
        jTDescricao1.setText(eq.getDescricao());
        jTexercicio1.setText(eq.getExercicio());
        Conexao.desconectar(conexao);
    } 


    public void limparModelos() {
        jCEquipamento.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTexercicio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jCFornecedor = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jCEquipamento = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTDescricao1 = new javax.swing.JTextArea();
        jTexercicio1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Exercício");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ControlGym");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Editar Equipamento");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sign-out-option.png"))); // NOI18N
        jButton1.setText("   Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Descrição");

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/checked.png"))); // NOI18N
        jButton3.setText("   Confirmar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Fornecedor");

        jCEquipamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um modelo" }));
        jCEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCEquipamentoActionPerformed(evt);
            }
        });

        jTDescricao1.setColumns(20);
        jTDescricao1.setRows(5);
        jTDescricao1.setText("Nenhuma Descrição");
        jScrollPane2.setViewportView(jTDescricao1);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Exercício");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTexercicio1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jCEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTexercicio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton3});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (jCEquipamento.getSelectedIndex() > 0) {
            Connection conexao = Conexao.conectar();
            EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
            Equipamento eq = equipamentoDAO.selecionaEquipamento((String) jCEquipamento.getSelectedItem());
            eq.setDescricao(jTDescricao1.getText());
            eq.setExercicio(jTexercicio1.getText());
            eq.setFornecedor(new FornecedorDAO(conexao).selecionaFornecedor(jCFornecedor.getSelectedItem().toString()).getId());

            if (equipamentoDAO.altEquipamento(eq)) {
                telaPrincipal.preencherEquipamentos();
                limparModelos();                
                JOptionPane.showMessageDialog(rootPane, "Equipamento Atualizado!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Erro inesperado", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
            Conexao.desconectar(conexao);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um Equipamento", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jCEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCEquipamentoActionPerformed
        Connection conexao = Conexao.conectar();
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
        preencheCamposField(jCEquipamento.getSelectedItem().toString());        
        Conexao.desconectar(conexao);  
    }//GEN-LAST:event_jCEquipamentoActionPerformed

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
            java.util.logging.Logger.getLogger(AltEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AltEquipamento dialog = new AltEquipamento(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jCEquipamento;
    private javax.swing.JComboBox<String> jCFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTDescricao1;
    private javax.swing.JTextField jTexercicio;
    private javax.swing.JTextField jTexercicio1;
    // End of variables declaration//GEN-END:variables
}
