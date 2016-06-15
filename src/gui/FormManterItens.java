package gui;

import beans.Itens;
import business.Facade;
import business.SaberLogin;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormManterItens extends javax.swing.JFrame {

    public FormManterItens() {
        initComponents();
        Vector<Vector> dados = new Vector<Vector>();
        ButtonGroup group = new ButtonGroup();
        group.add(btPID);
        group.add(btPN);
        group.add(btTIP);
        group.add(btAleatorio);

        listarTudo();

        int id = SaberLogin.getTipodeusuario();

        switch (id) {
            case 0:
                jPanel1.setVisible(false);
                break;
        }

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                if (e.getID() == WindowEvent.WINDOW_CLOSING) {
                    int selectedOption = JOptionPane.showConfirmDialog(null, "Deseja Sair Realmente?", "Sistema informa:", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                }
            }
        });

        jTable1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int k = jTable1.getSelectedRow();
                    String nome = (String) jTable1.getValueAt(k, 1);

                    FormExibirItem alterar = new FormExibirItem(nome);
                    alterar.setVisible(true);

                }
            }
        });

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btApagar = new javax.swing.JButton();
        cmpPesquisa = new javax.swing.JTextField();
        btProcurar = new javax.swing.JButton();
        btPID = new javax.swing.JRadioButton();
        btPN = new javax.swing.JRadioButton();
        btTIP = new javax.swing.JRadioButton();
        btAleatorio = new javax.swing.JRadioButton();
        btExibirTudo = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Tipo", "Disponível"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("Lista de componentes");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btNovo)
                .addGap(30, 30, 30)
                .addComponent(btAlterar)
                .addGap(30, 30, 30)
                .addComponent(btApagar)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btAlterar)
                    .addComponent(btApagar)))
        );

        cmpPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmpPesquisaKeyPressed(evt);
            }
        });

        btProcurar.setText("Pesquisar");
        btProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProcurarActionPerformed(evt);
            }
        });

        btPID.setText("ID");

        btPN.setText("Nome");

        btTIP.setText("Tipo");

        btAleatorio.setText("Aleatório");

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
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmpPesquisa)
                        .addGap(18, 18, 18)
                        .addComponent(btProcurar))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btExibirTudo)
                        .addGap(18, 18, 18)
                        .addComponent(btVoltar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btPID)
                        .addGap(30, 30, 30)
                        .addComponent(btPN)
                        .addGap(30, 30, 30)
                        .addComponent(btTIP)
                        .addGap(18, 18, 18)
                        .addComponent(btAleatorio)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btProcurar)
                    .addComponent(cmpPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPID)
                    .addComponent(btPN)
                    .addComponent(btTIP)
                    .addComponent(btAleatorio))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btVoltar)
                        .addComponent(btExibirTudo))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        setVisible(false);

        if (SaberLogin.getTipodeusuario() == 0) {
            FormLogin login = new FormLogin();
            login.setVisible(true);
        } else if (SaberLogin.getTipodeusuario() == 1) {
            PainelTAL pan = new PainelTAL();
            pan.setVisible(true);
        } else if (SaberLogin.getTipodeusuario() == 2) {
            PainelProfessor pan = new PainelProfessor();
            pan.setVisible(true);
        }
    }//GEN-LAST:event_btVoltarActionPerformed
    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        FormNovoItem formNovoItem = new FormNovoItem();
        formNovoItem.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btNovoActionPerformed
    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        int k, i;
        i = jTable1.getSelectedRowCount();
        if (i == 0) {
            JOptionPane.showMessageDialog(null, "Selecione pelo menos um item!");
        } else if (i > 1) {
            JOptionPane.showMessageDialog(null, "Selecione apenas um item!");
        } else if (i == 1) {
            k = jTable1.getSelectedRow();

            String nome = (String) jTable1.getValueAt(k, 1);

            FormAlterarItem alterar = new FormAlterarItem(nome);
            setVisible(false);
            alterar.setVisible(true);
        }
    }//GEN-LAST:event_btAlterarActionPerformed
    private void btApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btApagarActionPerformed
        int i = jTable1.getSelectedRowCount();
        if (i == 1) {
            int k = jTable1.getSelectedRow();
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            String nome = (String) jTable1.getValueAt(k, 1);
            Facade.getInstance().apagarItem(nome);
            ((DefaultTableModel) jTable1.getModel()).removeRow(jTable1.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Item apagado com sucesso!");
        } else if (i == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um item para excluir!");
        } else if (i > 1) {
            System.out.println(i);
            JOptionPane.showMessageDialog(null, "Selecione somente um item para excluir!");
        }
    }//GEN-LAST:event_btApagarActionPerformed
    private void btProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProcurarActionPerformed
        String search = cmpPesquisa.getText();
        Vector<Vector> info = new Vector<Vector>();
        int esc = 0;

        if (btPID.isSelected()) {
            esc = 1;
        } else if (btPN.isSelected()) {
            esc = 2;
        } else if (btTIP.isSelected()) {
            esc = 3;
        } else if (btAleatorio.isSelected()) {
            esc = 4;
        }

        List<Itens> listaDeItens = null;

        try {
            listaDeItens = Facade.getInstance().procurarItem(search, esc);
            if (listaDeItens != null) {
                Iterator<Itens> itItens = listaDeItens.iterator();
                while (itItens.hasNext()) {
                    Itens item = itItens.next();
                    Vector table = new Vector();
                    table.add(item.getId());
                    table.add(item.getNome());
                    table.add(item.getTipo());
                    if (item.isDisponivel()) {
                        table.add("Sim");
                    } else {
                        table.add("Não");
                    }
                    info.add(table);
                }

                apagarlinhas();

                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

                for (int i = 0; i < info.size(); i++) {
                    System.out.println(info.get(i));
                }

                for (int i = 0; i < info.size(); i++) {
                    dtm.addRow(info.get(i));
                }

            } else {
                JOptionPane.showMessageDialog(null, "Item não encontrado!");
            }
        } catch (java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O valor do ID deve ser um número!");
            cmpPesquisa.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(FormManterItens.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btProcurarActionPerformed
    private void cmpPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmpPesquisaKeyPressed
    }//GEN-LAST:event_cmpPesquisaKeyPressed

    private void btExibirTudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExibirTudoActionPerformed
        listarTudo();
    }//GEN-LAST:event_btExibirTudoActionPerformed
    private void listarTudo() {
        List<Itens> listaDeItens = null;
        Vector<Vector> dados = new Vector<Vector>();
        try {
            listaDeItens = Facade.getInstance().procurarItem("", 5);
        } catch (SQLException ex) {
            Logger.getLogger(FormManterItens.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (listaDeItens != null) {
            Iterator<Itens> itItens = listaDeItens.iterator();
            while (itItens.hasNext()) {
                Itens item = itItens.next();
                Vector table = new Vector();
                table.add(item.getId());
                table.add(item.getNome());
                table.add(item.getTipo());
                if (item.isDisponivel()) {
                    table.add("Sim");
                } else {
                    table.add("Não");
                }
                dados.add(table);
            }

            apagarlinhas();

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

            for (int i = 0; i < dados.size(); i++) {
                dtm.addRow(dados.get(i));
            }
        }
    }

    public void apagarlinhas() {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        int linhas = dtm.getRowCount();

        if (linhas > 0) {
            for (int i = 1; i <= linhas; i++) {
                dtm.removeRow(0);
            }
        }
    }

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(FormManterItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormManterItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormManterItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormManterItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormManterItens().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btAleatorio;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btApagar;
    private javax.swing.JButton btExibirTudo;
    private javax.swing.JButton btNovo;
    private javax.swing.JRadioButton btPID;
    private javax.swing.JRadioButton btPN;
    private javax.swing.JButton btProcurar;
    private javax.swing.JRadioButton btTIP;
    private javax.swing.JButton btVoltar;
    private javax.swing.JTextField cmpPesquisa;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
