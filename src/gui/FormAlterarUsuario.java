package gui;

import beans.Professor;
import beans.TAL;
import business.AdaptadorBDElectroSearch;
import business.Facade;
import business.ManterProfessor;
import business.ManterTAL;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FormAlterarUsuario extends javax.swing.JFrame {

    private String matricula;
    private String tipo;

    public FormAlterarUsuario() {
        initComponents();
    }

    public FormAlterarUsuario(String matricula, String tipo) {
        initComponents();
        this.matricula = matricula;
        this.tipo = tipo;

        setarValores();

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                if (e.getID() == WindowEvent.WINDOW_CLOSING) {
                    int selectedOption = JOptionPane.showConfirmDialog(null, "Deseja Sair Realmente? Você pode perder dados não salvos!", "Sistema informa:", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_OPTION) {

                        System.exit(0);
                    }
                }
            }
        });
    }

    private void setarValores() {
        ResultSet rs = null;
        String query;
        
        String nome = "";
        String cpf = "";
        String disciplina = "";
        String login = "";
        String senha = "";
        
        if ("TAL".equals(this.tipo)) {
            TAL tal = Facade.getInstance().searchTAL(this.matricula);
            nome = tal.getNome();
            cpf = tal.getCpf();
            disciplina = tal.getDisciplina();
            login = tal.getLogin();
            senha = tal.getSenha();
            
        } else if ("Professor".equals(this.tipo)) {
            Professor professor = Facade.getInstance().searchProfessor(this.matricula);
            nome = professor.getNome();
            cpf = professor.getCpf();
            disciplina = professor.getDisciplina();
            login = professor.getLogin();
            senha = professor.getSenha();
        }

        cmpNome.setText(nome);
        cmpCpf.setText(cpf);
        cmpMatricula.setText(this.matricula);

        cmpMatricula.setEnabled(false);

        cmpDisciplina.setText(disciplina);
        cmpLogin.setText(login);
        cmpNovaSenha.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        cmpDisciplina = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmpLogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmpSenha = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmpNome = new javax.swing.JTextField();
        cmpCpf = new javax.swing.JTextField();
        cmpMatricula = new javax.swing.JTextField();
        btVoltar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btConfigurar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cmpNovaSenha = new javax.swing.JPasswordField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("Edição de Usuários");

        jLabel2.setText("Nome:");

        jLabel3.setText("CPF:");

        jLabel4.setText("Matrícula:");

        jLabel5.setText("Disciplina:");

        jLabel6.setText("Login:");

        jLabel7.setText("Senha:");

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btConfigurar.setText("Reconfigurar");
        btConfigurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfigurarActionPerformed(evt);
            }
        });

        jLabel8.setText("Nova Senha:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmpLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmpDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cmpNome))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cmpMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmpCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btSalvar)
                            .addGap(18, 18, 18)
                            .addComponent(btConfigurar)
                            .addGap(18, 18, 18)
                            .addComponent(btVoltar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmpNovaSenha))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(cmpSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmpNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmpCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmpMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmpDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmpLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmpSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmpNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVoltar)
                    .addComponent(btSalvar)
                    .addComponent(btConfigurar))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConfigurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfigurarActionPerformed
        setarValores();
    }//GEN-LAST:event_btConfigurarActionPerformed
    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        int selectedOption = JOptionPane.showConfirmDialog(null, "Deseja Sair Realmente?", "ElectroSearch informa:", JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION) {
            FormManterUsuarios manterUsuarios = new FormManterUsuarios();
            setVisible(false);
            manterUsuarios.setVisible(true);
        }
    }//GEN-LAST:event_btVoltarActionPerformed
    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        String nome = cmpNome.getText();
        String cpf = cmpCpf.getText();
        String matriculaA = cmpMatricula.getText();
        String disciplina = cmpDisciplina.getText();
        String login = cmpLogin.getText();
        String senha = cmpSenha.getText();
        String novasenha = cmpNovaSenha.getText();

        if (!nome.isEmpty() && !cpf.isEmpty() && !matricula.isEmpty() && !login.isEmpty() && !senha.isEmpty()) {
            ResultSet rs;
            String query;
            String confirmarSenha = null;
            if ("TAL".equals(this.tipo)) {
                List<TAL> listaDeTal = null;
                try {
                    listaDeTal = Facade.getInstance().pesquisarTAL(this.matricula, 1);
                } catch (SQLException ex) {
                    Logger.getLogger(FormAlterarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
                Iterator<TAL> itTAL = listaDeTal.iterator();;
                while (itTAL.hasNext()) {
                    TAL tal = itTAL.next();
                    confirmarSenha = tal.getSenha();
                }

                boolean confirmaAtualizacao = false;

                if (confirmarSenha.equals(senha)) {
                    if (!novasenha.isEmpty()) {
                        try {
                            confirmaAtualizacao = Facade.getInstance().atualizarTAL(true, nome, disciplina, senha, cpf, login, this.matricula, novasenha);
                        } catch (SQLException ex) {
                            Logger.getLogger(FormAlterarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            confirmaAtualizacao = Facade.getInstance().atualizarTAL(false, nome, disciplina, senha, cpf, login, this.matricula, novasenha);
                        } catch (SQLException ex) {
                            Logger.getLogger(FormAlterarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    if (confirmaAtualizacao) {
                        JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
                        FormManterUsuarios manterUsuarios = new FormManterUsuarios();
                        setVisible(false);
                        manterUsuarios.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro, tente novamente!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta!!");
                }

            } else {
                List<Professor> listaDeProfessor = null;
                try {
                    listaDeProfessor = Facade.getInstance().pesquisarProfessor(this.matricula, 1);
                } catch (SQLException ex) {
                    Logger.getLogger(FormAlterarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
                Iterator<Professor> itProfessor = listaDeProfessor.iterator();;
                while (itProfessor.hasNext()) {
                    Professor professor = itProfessor.next();
                    confirmarSenha = professor.getSenha();
                }

                boolean confirmaAtualizacao = false;

                if (confirmarSenha.equals(senha)) {
                    if (!novasenha.isEmpty()) {
                        try {
                            confirmaAtualizacao = Facade.getInstance().atualizarProfessor(true, nome, disciplina, senha, cpf, login, this.matricula, novasenha);
                        } catch (SQLException ex) {
                            Logger.getLogger(FormAlterarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            confirmaAtualizacao = Facade.getInstance().atualizarProfessor(false, nome, disciplina, senha, cpf, login, this.matricula, novasenha);
                        } catch (SQLException ex) {
                            Logger.getLogger(FormAlterarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    if (confirmaAtualizacao) {
                        JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
                        FormManterUsuarios manterUsuarios = new FormManterUsuarios();
                        setVisible(false);
                        manterUsuarios.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro, tente novamente!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta!!");
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }
    }//GEN-LAST:event_btSalvarActionPerformed
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
            java.util.logging.Logger.getLogger(FormAlterarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAlterarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAlterarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAlterarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAlterarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfigurar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JTextField cmpCpf;
    private javax.swing.JTextField cmpDisciplina;
    private javax.swing.JTextField cmpLogin;
    private javax.swing.JTextField cmpMatricula;
    private javax.swing.JTextField cmpNome;
    private javax.swing.JPasswordField cmpNovaSenha;
    private javax.swing.JPasswordField cmpSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
