/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import beans.Professor;
import beans.TAL;
import business.Facade;
import business.ManterProfessor;
import business.ManterTAL;
import business.SaberLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public class FormLogin extends javax.swing.JFrame {

    public FormLogin() {
        initComponents();
        ButtonGroup group = new ButtonGroup();
        group.add(brTAL);
        group.add(brProfessor);

        brProfessor.setSelected(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmpLogin = new javax.swing.JTextField();
        cmpSenha = new javax.swing.JPasswordField();
        btEntrar = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        brProfessor = new javax.swing.JRadioButton();
        brTAL = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Login:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Senha: ");

        cmpLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmpLoginActionPerformed(evt);
            }
        });

        btEntrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btEntrar.setText("Entrar");
        btEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntrarActionPerformed(evt);
            }
        });

        btPesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        brProfessor.setText("Professor");

        brTAL.setText("TAL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(brProfessor)
                        .addGap(18, 18, 18)
                        .addComponent(brTAL))
                    .addComponent(cmpSenha)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btPesquisar)
                        .addGap(58, 58, 58)
                        .addComponent(btEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmpLogin))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmpLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmpSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brProfessor)
                    .addComponent(brTAL))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEntrar)
                    .addComponent(btPesquisar))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        int priv = 0;
        FormManterItens chamar = new FormManterItens();
        chamar.setVisible(true);
        setVisible(false);
        SaberLogin.getInstance().setTipodeusuario(0);
    }//GEN-LAST:event_btPesquisarActionPerformed
    private void btEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntrarActionPerformed
        if ((!(cmpLogin.getText()).isEmpty()) && (!(cmpSenha.getText()).isEmpty())) {
            String login = cmpLogin.getText();
            String senha = cmpSenha.getText();

            int escolha = 0;

            if (brProfessor.isSelected()) {
                escolha = 1;
            } else if (brTAL.isSelected()) {
                escolha = 2;
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma forma de login!");
            }

            if (escolha == 2) {
                TAL tal = null;
                try {
                    tal = Facade.getInstance().procurarUsuario(login, senha);
                } catch (SQLException ex) {
                    Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (tal != null) {
                    if (tal.getLogin().equals(login) && tal.getSenha().equals(senha)) {
                        JOptionPane.showMessageDialog(null, "Login feito!");
                        SaberLogin.getInstance().setMatricula(tal.getMatricula());
                        SaberLogin.getInstance().setTipodeusuario(1);
                        FormManterItens painel = new FormManterItens();
                        painel.setVisible(true);
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Login ou senha incorretos");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Login ou senha incorretos");

                }
            } else if (escolha == 1) {
                Professor professor = null;
                try {
                    professor = Facade.getInstance().procurarProfessor(login, senha);
                } catch (SQLException ex) {
                    Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (professor != null) {
                    if (professor.getLogin().equals(login) && professor.getSenha().equals(senha)) {
                        JOptionPane.showMessageDialog(null, "Login feito!");
                        PainelProfessor painel = new PainelProfessor();
                        SaberLogin.getInstance().setMatricula(professor.getMatricula());
                        SaberLogin.getInstance().setTipodeusuario(2);
                        painel.setVisible(true);
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Login ou senha incorretos");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Login ou senha incorretos");

                }
            }

//            try{
//            if (escolha == 1) {
//                        ResultSet rs1 = ManterProfessor.procurarProfessor(nome, senha);
//                    if (rs1.next()) {
//                        JOptionPane.showMessageDialog(null, "Login feito!");
//                        ManterProfessor professor = new ManterProfessor(rs1.getString("login"), rs1.getString("cpf"), rs1.getString("nome"), rs1.getString("disciplina"), rs1.getString("senha"), rs1.getString("matricula"));
//                        PainelProfessor painel = new PainelProfessor();
//                        SaberLogin.setTipodeusuario(2);
//                        painel.setVisible(true);
//                        setVisible(false);
//                    }else {
//                        JOptionPane.showMessageDialog(null, "Login ou senha incorretos");
//                    }
//            }
//            } catch (SQLException ex) {
//                Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
//            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
        }


    }//GEN-LAST:event_btEntrarActionPerformed
    private void cmpLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmpLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpLoginActionPerformed

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
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton brProfessor;
    private javax.swing.JRadioButton brTAL;
    private javax.swing.JButton btEntrar;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JTextField cmpLogin;
    private javax.swing.JPasswordField cmpSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
