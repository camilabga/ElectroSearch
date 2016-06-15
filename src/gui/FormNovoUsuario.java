package gui;

import beans.Professor;
import beans.TAL;
import business.Facade;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public class FormNovoUsuario extends javax.swing.JFrame {

    public FormNovoUsuario() {
        initComponents();

        ButtonGroup group = new ButtonGroup();
        group.add(btRTal);
        group.add(btRProfessor);

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

    public boolean verificarMatricula(String matr) {
        if (btRTal.isSelected()) {
            List matriculas = new ArrayList();
            List<TAL> listaDeTal = Facade.getInstance().selecionarTudoTAL();
            if (listaDeTal != null) {
                Iterator<TAL> itTAL = listaDeTal.iterator();
                while (itTAL.hasNext()) {
                    TAL tal = itTAL.next();
                    String matricula = tal.getMatricula();
                    matriculas.add(matricula);
                }
            } else {
                return true;
            }

            boolean estaLivre = true;
            if (!matriculas.isEmpty()) {
                for (int i = 0; i < matriculas.size(); i++) {
                    if (matr.equals(matriculas.get(i))) {
                        estaLivre = false;
                        break;
                    }
                }
            }
            return estaLivre;

        } else {
            List<Professor> listaDeProfessor = Facade.getInstance().selecionarTudoProfessor();
            Iterator<Professor> itProfessor = listaDeProfessor.iterator();

            List matriculas = new ArrayList();

            while (itProfessor.hasNext()) {
                Professor professor = itProfessor.next();
                String matricula = professor.getMatricula();
                matriculas.add(matricula);
            }

            boolean estaLivre = true;
            if (!matriculas.isEmpty()) {
                for (int i = 0; i < matriculas.size(); i++) {
                    if (matr.equals(matriculas.get(i))) {
                        estaLivre = false;
                        break;
                    }
                }
            }
            return estaLivre;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmpNome = new javax.swing.JTextField();
        cmpCpf = new javax.swing.JTextField();
        cmpMatricula = new javax.swing.JTextField();
        cmpDisciplina = new javax.swing.JTextField();
        cmpLogin = new javax.swing.JTextField();
        cmpSenha = new javax.swing.JPasswordField();
        btAdicionar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btRTal = new javax.swing.JRadioButton();
        btRProfessor = new javax.swing.JRadioButton();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("Cadastro de Usuários");

        jLabel2.setText("Nome:");

        jLabel3.setText("CPF:");

        jLabel4.setText("Matrícula:");

        jLabel5.setText("Disciplina:");

        jLabel6.setText("Login:");

        jLabel7.setText("Senha:");

        btAdicionar.setText("Adicionar");
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        jLabel8.setText("Tipo:");

        btRTal.setText("TAL");

        btRProfessor.setText("Professor");

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cmpMatricula))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(btRTal)
                                        .addGap(18, 18, 18)
                                        .addComponent(btRProfessor))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(cmpSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGap(35, 35, 35)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmpCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmpNome)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btAdicionar)
                                    .addGap(30, 30, 30)
                                    .addComponent(btLimpar)
                                    .addGap(30, 30, 30)
                                    .addComponent(btVoltar)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmpLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                    .addComponent(cmpDisciplina))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(80, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
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
                    .addComponent(btRTal)
                    .addComponent(btRProfessor))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdicionar)
                    .addComponent(btLimpar)
                    .addComponent(btVoltar))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        String nome = cmpNome.getText();
        String cpf = cmpCpf.getText();
        String matricula = cmpMatricula.getText();
        String disciplina = cmpDisciplina.getText();
        String login = cmpLogin.getText();
        String senha = cmpSenha.getText();

        if (!nome.isEmpty() && !cpf.isEmpty() && !matricula.isEmpty() && !login.isEmpty() && !senha.isEmpty()) {
            if (verificarMatricula(matricula)) {
                if (btRTal.isSelected()) {
                    boolean adicionarTal = false;
                    try {
                        adicionarTal = Facade.getInstance().AdicionarTal(nome, cpf, matricula, disciplina, login, senha);
                    } catch (SQLException ex) {
                        Logger.getLogger(FormNovoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (adicionarTal) {
                        JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso!");
                        setVisible(false);
                        FormManterUsuarios abrir = new FormManterUsuarios();
                        abrir.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro! Tente novamente!");
                    }
                } else if (btRProfessor.isSelected()) {
                    try {
                        if (Facade.getInstance().AdicionarProfessor(nome, cpf, matricula, disciplina, login, senha)) {
                            JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso!");
                            setVisible(false);
                            FormManterUsuarios abrir = new FormManterUsuarios();
                            abrir.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro! Tente novamente!");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(FormNovoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um tipo de usuário!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Matrícula previamente cadastrada! Insira uma matrícula válida!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }
    }//GEN-LAST:event_btAdicionarActionPerformed
    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        cmpNome.setText("");
        cmpCpf.setText("");
        cmpDisciplina.setText("");
        cmpMatricula.setText("");
        cmpLogin.setText("");
        cmpSenha.setText("");
    }//GEN-LAST:event_btLimparActionPerformed
    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        setVisible(false);
        FormManterUsuarios formManterUsuarios = new FormManterUsuarios();
        formManterUsuarios.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(FormNovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormNovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormNovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormNovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormNovoUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JRadioButton btRProfessor;
    private javax.swing.JRadioButton btRTal;
    private javax.swing.JButton btVoltar;
    private javax.swing.JTextField cmpCpf;
    private javax.swing.JTextField cmpDisciplina;
    private javax.swing.JTextField cmpLogin;
    private javax.swing.JTextField cmpMatricula;
    private javax.swing.JTextField cmpNome;
    private javax.swing.JPasswordField cmpSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
