package gui;

import business.SaberLogin;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class PainelProfessor extends javax.swing.JFrame {
    private String nome;
    private String login;
    private String cpf;
    private String disciplina;
    private String senha;
    private String op;
    private String matricula;
    
    
    public PainelProfessor() {
        initComponents();
        
        SaberLogin.setTipodeusuario(2);

        
         this.addWindowListener(new java.awt.event.WindowAdapter() {  
                public void windowClosing(java.awt.event.WindowEvent e) {  
                    if (e.getID() == WindowEvent.WINDOW_CLOSING){  
                        int selectedOption = JOptionPane.showConfirmDialog(null,"Deseja Sair Realmente?", "Sistema informa:", JOptionPane.YES_NO_OPTION);  
        if(selectedOption == JOptionPane.YES_OPTION){  
              
            System.exit(0);                           
        }     
                    }     
                }  
            }); 
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btManterItem = new javax.swing.JButton();
        btConfigUsuarios = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel3.setText("Bem vindo, Professor!");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel2.setText("ElectroSearch");

        btManterItem.setText("<html>Lista de <br/>Componentes</html>");
        btManterItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btManterItemActionPerformed(evt);
            }
        });

        btConfigUsuarios.setText("<html>Configurações <br/>dos Usuários</html>");
        btConfigUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfigUsuariosActionPerformed(evt);
            }
        });

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btSair)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btManterItem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btConfigUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 60, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btManterItem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btConfigUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(btSair)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        btManterItem.getAccessibleContext().setAccessibleName("<html>Lista de <br/>Componentes<html>");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btManterItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btManterItemActionPerformed
        FormManterItens chamar = new FormManterItens();

        chamar.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btManterItemActionPerformed

    private void btConfigUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfigUsuariosActionPerformed
        FormManterUsuarios manterUsuarios = new FormManterUsuarios();
        setVisible(false);
        manterUsuarios.setVisible(true);
    }//GEN-LAST:event_btConfigUsuariosActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        int selectedOption = JOptionPane.showConfirmDialog(null,"Deseja Sair Realmente?", "ElectroSearch informa:", JOptionPane.YES_NO_OPTION);  
        if(selectedOption == JOptionPane.YES_OPTION){
            setVisible(false);
            SaberLogin.setTipodeusuario(0);
            FormLogin login = new FormLogin();
            login.setVisible(true);
        }
    }//GEN-LAST:event_btSairActionPerformed

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
            java.util.logging.Logger.getLogger(PainelProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PainelProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PainelProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PainelProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PainelProfessor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfigUsuarios;
    private javax.swing.JButton btManterItem;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
