package gui;

import beans.Professor;
import beans.TAL;
import business.AdaptadorBDElectroSearch;
import business.Facade;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormManterUsuarios extends javax.swing.JFrame {

    public FormManterUsuarios() {
        initComponents();

        ButtonGroup group = new ButtonGroup();
        group.add(btRMatricula);
        group.add(btRNome);
        group.add(btRCpf);

        preencherTabela();

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                if (e.getID() == WindowEvent.WINDOW_CLOSING) {
                    int selectedOption = JOptionPane.showConfirmDialog(null, "Deseja Sair Realmente?", "ElectroSearch informa:", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btPesquisar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblaUsuarios = new javax.swing.JTable();
        pnBotoes = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btApagar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        cmpPesquisar = new javax.swing.JTextField();
        btRMatricula = new javax.swing.JRadioButton();
        btRNome = new javax.swing.JRadioButton();
        btRCpf = new javax.swing.JRadioButton();
        btExibirTudo = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("Configuração dos Usuários");

        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        tblaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matrícula", "Nome", "CPF", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblaUsuarios);

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btApagar.setText("Apagar");
        btApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btApagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBotoesLayout = new javax.swing.GroupLayout(pnBotoes);
        pnBotoes.setLayout(pnBotoesLayout);
        pnBotoesLayout.setHorizontalGroup(
            pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotoesLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btNovo)
                .addGap(30, 30, 30)
                .addComponent(btAlterar)
                .addGap(30, 30, 30)
                .addComponent(btApagar))
        );
        pnBotoesLayout.setVerticalGroup(
            pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btNovo)
                .addComponent(btAlterar)
                .addComponent(btApagar))
        );

        btSair.setText("Voltar");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        btRMatricula.setText("Matricula");

        btRNome.setText("Nome");

        btRCpf.setText("CPF");

        btExibirTudo.setText("Exibir Tudo");
        btExibirTudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExibirTudoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btRMatricula)
                        .addGap(18, 18, 18)
                        .addComponent(btRNome)
                        .addGap(18, 18, 18)
                        .addComponent(btRCpf))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmpPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(188, 188, 188)
                        .addComponent(btExibirTudo)
                        .addGap(30, 30, 30)
                        .addComponent(btSair)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPesquisar)
                    .addComponent(cmpPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRMatricula)
                    .addComponent(btRNome)
                    .addComponent(btRCpf))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btSair)
                        .addComponent(btExibirTudo))
                    .addComponent(pnBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        setVisible(false);
        FormNovoUsuario novoUsuario = new FormNovoUsuario();
        novoUsuario.setVisible(true);
    }//GEN-LAST:event_btNovoActionPerformed
    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        int i = tblaUsuarios.getSelectedRowCount();
        if (i == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um usuário para editar!");
        } else if (i == 1) {
            int k = tblaUsuarios.getSelectedRow();
            DefaultTableModel dtm = (DefaultTableModel) tblaUsuarios.getModel();
            String tipo = (String) tblaUsuarios.getValueAt(k, 3);
            if ("TAL".equals(tipo)) {
                String matricula = (String) tblaUsuarios.getValueAt(k, 0);
                setVisible(false);
                FormAlterarUsuario alterarUsuario = new FormAlterarUsuario(matricula, "TAL");
                alterarUsuario.setVisible(true);
            } else if ("Professor".equals(tipo)) {
                String matricula = (String) tblaUsuarios.getValueAt(k, 0);
                setVisible(false);
                FormAlterarUsuario alterarUsuario = new FormAlterarUsuario(matricula, "Professor");
                alterarUsuario.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione somente um usuário para editar!");
        }
    }//GEN-LAST:event_btAlterarActionPerformed
    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        PainelProfessor painelProfessor = new PainelProfessor();
        setVisible(false);
        painelProfessor.setVisible(true);
    }//GEN-LAST:event_btSairActionPerformed
    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        String nome = cmpPesquisar.getText();
        Vector<Vector> info = new Vector<Vector>();
        int esc = 0;
        DefaultTableModel dtm;

        if (btRMatricula.isSelected()) {
            esc = 1;
        } else if (btRNome.isSelected()) {
            esc = 2;
        } else if (btRCpf.isSelected()) {
            esc = 3;
        } else {
            esc = 0;
        }

        if (esc == 1 || esc == 2 || esc == 3) {
            try {
                List<TAL> listaDeTal = Facade.getInstance().pesquisarTAL(nome, esc);
                if (listaDeTal != null) {
                    Iterator<TAL> itTAL = listaDeTal.iterator();
                    while (itTAL.hasNext()) {
                        TAL tal = itTAL.next();
                        Vector table = new Vector();
                        String matricula = tal.getMatricula();
                        table.add(matricula);
                        String nomy = tal.getNome();
                        table.add(nomy);
                        String cpf = tal.getCpf();
                        table.add(cpf);
                        table.add("TAL");
                        info.add(table);
                    }
                }

                apagarlinhas();

                dtm = (DefaultTableModel) tblaUsuarios.getModel();

                for (int i = 0; i < info.size(); i++) {
                    dtm.addRow(info.get(i));
                }

            } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro! Tente novamente!");
            } catch (SQLException ex) {
                Logger.getLogger(FormManterItens.class.getName()).log(Level.SEVERE, null, ex);
            }

            info = new Vector<Vector>();

            try {
                List<Professor> listaDeProfessor = Facade.getInstance().pesquisarProfessor(nome, esc);
                if (listaDeProfessor != null) {
                    Iterator<Professor> itProfessor = listaDeProfessor.iterator();
                    while (itProfessor.hasNext()) {
                        Professor professor = itProfessor.next();
                        Vector table = new Vector();
                        String matricula = professor.getMatricula();
                        table.add(matricula);
                        String nomy = professor.getNome();
                        table.add(nomy);
                        String cpf = professor.getCpf();
                        table.add(cpf);
                        table.add("Professor");
                        info.add(table);
                    }
                }

                dtm = (DefaultTableModel) tblaUsuarios.getModel();

                for (int i = 0; i < info.size(); i++) {
                    dtm.addRow(info.get(i));
                }

            } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro! Tente novamente!");
            } catch (SQLException ex) {
                Logger.getLogger(FormManterItens.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma opção de pesquisa!");
        }
    }//GEN-LAST:event_btPesquisarActionPerformed
    private void btApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btApagarActionPerformed
        int i = tblaUsuarios.getSelectedRowCount();
        if (i == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um item para excluir!");
        } else if (i == 1) {
            int k = tblaUsuarios.getSelectedRow();
            DefaultTableModel dtm = (DefaultTableModel) tblaUsuarios.getModel();
            String tipo = (String) tblaUsuarios.getValueAt(k, 3);
            if (tipo == "TAL") {
                String matricula = (String) tblaUsuarios.getValueAt(k, 0);
                try {
                    if (Facade.getInstance().excluirTAL(matricula)) {
                        ((DefaultTableModel) tblaUsuarios.getModel()).removeRow(tblaUsuarios.getSelectedRow());
                        JOptionPane.showMessageDialog(null, "Item apagado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro! Tente novamente!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FormManterUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (tipo == "Professor") {
                String matricula = (String) tblaUsuarios.getValueAt(k, 0);
                try {
                    if (Facade.getInstance().excluirProfessor(matricula)) {
                        ((DefaultTableModel) tblaUsuarios.getModel()).removeRow(tblaUsuarios.getSelectedRow());
                        JOptionPane.showMessageDialog(null, "Item apagado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro! Tente novamente!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FormManterUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione somente um item para excluir!");
        }
    }//GEN-LAST:event_btApagarActionPerformed

    private void btExibirTudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExibirTudoActionPerformed
        preencherTabela();
    }//GEN-LAST:event_btExibirTudoActionPerformed

    @SuppressWarnings("empty-statement")

    private void preencherTabela() {
        apagarlinhas();
        Vector<Vector> dados = new Vector<Vector>();
        DefaultTableModel dtm = (DefaultTableModel) tblaUsuarios.getModel();

        List<TAL> listaDeTal = Facade.getInstance().selecionarTudoTAL();
        if (listaDeTal != null) {
            Iterator<TAL> itTAL = listaDeTal.iterator();
            while (itTAL.hasNext()) {
                TAL tal = itTAL.next();
                Vector table = new Vector();
                String matricula = tal.getMatricula();
                table.add(matricula);
                String nomy = tal.getNome();
                table.add(nomy);
                String cpf = tal.getCpf();
                table.add(cpf);
                table.add("TAL");
                dados.add(table);
            }

            for (int i = 0; i < dados.size(); i++) {
                dtm.addRow(dados.get(i));
            }
        }

        dados = new Vector<Vector>();

        List<Professor> listaDeProfessor = Facade.getInstance().selecionarTudoProfessor();

        if (listaDeProfessor != null) {

            Iterator<Professor> itProfessor = listaDeProfessor.iterator();
            while (itProfessor.hasNext()) {
                Professor professor = itProfessor.next();
                Vector table = new Vector();
                String matricula = professor.getMatricula();
                table.add(matricula);
                String nomy = professor.getNome();
                table.add(nomy);
                String cpf = professor.getCpf();
                table.add(cpf);
                table.add("Professor");
                dados.add(table);
            }
        }

        for (int i = 0; i < dados.size(); i++) {
            dtm.addRow(dados.get(i));
        }

    }

    public void apagarlinhas() {
        DefaultTableModel dtm = (DefaultTableModel) tblaUsuarios.getModel();
        int linhas = dtm.getRowCount();

        if (linhas > 0) {
            for (int i = 1; i <= linhas; i++) {
                dtm.removeRow(0);
            }
        }
    }

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
            java.util.logging.Logger.getLogger(FormManterUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormManterUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormManterUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormManterUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormManterUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btApagar;
    private javax.swing.JButton btExibirTudo;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JRadioButton btRCpf;
    private javax.swing.JRadioButton btRMatricula;
    private javax.swing.JRadioButton btRNome;
    private javax.swing.JButton btSair;
    private javax.swing.JTextField cmpPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel pnBotoes;
    private javax.swing.JTable tblaUsuarios;
    // End of variables declaration//GEN-END:variables
}
