package gui;

import beans.Itens;
import business.AdaptadorBDElectroSearch;
import business.Facade;
import business.ManterItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public class FormNovoItem extends javax.swing.JFrame {
    public FormNovoItem() {
        initComponents();
        ButtonGroup group = new ButtonGroup();
        group.add(btRSim);
        group.add(btRNao);

        Vector<String> ntipos = listarComboBox();
        for (int i = 0; i < ntipos.size(); i++) {
            jcTipo.addItem(ntipos.get(i));
        }

        ActionListener listener;
        listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ("Outro".equals((String) jcTipo.getSelectedItem())) {
                    cmpOutroTipo.setEnabled(true);
                } else {
                    cmpOutroTipo.setEnabled(false);
                }
            }
        };

        jcTipo.addActionListener(listener);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmpNome = new javax.swing.JTextField();
        btRSim = new javax.swing.JRadioButton();
        btRNao = new javax.swing.JRadioButton();
        cmpDatasheet = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        cmpDescricao = new javax.swing.JTextArea();
        btLimpar = new javax.swing.JButton();
        btAdicionar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        jcTipo = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cmpOutroTipo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("Cadastro de Itens");

        jLabel2.setText("Nome:");

        jLabel3.setText("Tipo:");

        jLabel4.setText("Disponível:");

        jLabel5.setText("Datasheet:");

        jLabel6.setText("Descrição:");

        btRSim.setText("Sim");

        btRNao.setText("Não");
        btRNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRNaoActionPerformed(evt);
            }
        });

        cmpDescricao.setColumns(20);
        cmpDescricao.setRows(5);
        jScrollPane1.setViewportView(cmpDescricao);

        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btAdicionar.setText("Adicionar");
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        jcTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-----" }));
        jcTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcTipoActionPerformed(evt);
            }
        });

        jLabel7.setText("Outro:");

        cmpOutroTipo.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btRSim)
                                .addGap(18, 18, 18)
                                .addComponent(btRNao))
                            .addComponent(cmpDatasheet)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btAdicionar)
                            .addGap(115, 115, 115)
                            .addComponent(btLimpar)
                            .addGap(115, 115, 115)
                            .addComponent(btVoltar))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jcTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmpOutroTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmpNome, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmpNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cmpOutroTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btRSim)
                    .addComponent(btRNao))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmpDatasheet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLimpar)
                    .addComponent(btAdicionar)
                    .addComponent(btVoltar))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        String nome = cmpNome.getText();
        FormManterItens back = new FormManterItens();
        boolean estaLivre = verificarNome(nome);

        if (estaLivre) {

            String tipo;

//        if (!(!"-----".equals((String)jcTipo.getSelectedItem())) && !tipo.isEmpty()){
//            if (!"-----".equals((String)jcTipo.getSelectedItem())) {
//                tipo = (String)jcTipo.getSelectedItem();
//            } else {
//                tipo = cmpOutroTipo.getText();
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Informe apenas um campo para Tipo!");
//        }
            if ("-----".equals((String) jcTipo.getSelectedItem())) {
                JOptionPane.showMessageDialog(null, "Insira um tipo válido!");
            }

            if ("Outro".equals((String) jcTipo.getSelectedItem())) {
                tipo = (String) cmpOutroTipo.getText();
            } else {
                tipo = (String) jcTipo.getSelectedItem();
            }

            boolean disponivel = true;

            if (btRSim.isSelected()) {
                disponivel = true;
            } else if (btRNao.isSelected()) {
                disponivel = false;
            }

            String datasheet = cmpDatasheet.getText();
            String descricao = cmpDescricao.getText();

            if (!nome.isEmpty() & !tipo.isEmpty() && !datasheet.isEmpty() && !descricao.isEmpty()) {
                boolean confirmar = Facade.getInstance().adicionarItem(nome, tipo, disponivel, datasheet, descricao);

                if (confirmar) {
                    JOptionPane.showMessageDialog(null, "Item adicionado com sucesso!");
                    System.out.println("Item adicionado");
                }

                limparCadastro();

                FormManterItens novo = new FormManterItens();
                novo.setVisible(true);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Insira um item não cadastrado!");
            limparCadastro();
        }
    }//GEN-LAST:event_btAdicionarActionPerformed
    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        limparCadastro();
    }//GEN-LAST:event_btLimparActionPerformed
    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        FormManterItens back = new FormManterItens();
        back.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btVoltarActionPerformed
    private void jcTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcTipoActionPerformed
//        jcTipo.addActionListener (new ActionListener () {
//        public void actionPerformed(ActionEvent e) {
//            if ("Outro".equals((String)jcTipo.getSelectedItem())) {
//                cmpOutroTipo.setEnabled(true);
//            }
//        }
//    });
    }//GEN-LAST:event_jcTipoActionPerformed
    private void btRNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRNaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRNaoActionPerformed
    
    public void limparCadastro() {
        cmpNome.setText("");
        cmpOutroTipo.setText("");
        cmpDatasheet.setText("");
        cmpDescricao.setText("");
//        if (btRSim.isSelected()) {
//            btRSim.doClick();
//        } else if (btRNao.isSelected()) {
//            btRNao.doClick();
//        }

        jcTipo.setSelectedIndex(0);

    }
    public Vector<String> listarComboBox() {
        //Captura do Banco de Dados
        List<Itens> listaDeItens = null;
        List tipos = new ArrayList();

        try {
            listaDeItens = Facade.getInstance().procurarItem("", 5);
        } catch (SQLException ex) {
            Logger.getLogger(FormManterItens.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (listaDeItens != null) {
            Iterator<Itens> itItens = listaDeItens.iterator();
            while (itItens.hasNext()) {
                Itens item = itItens.next();
                tipos.add(item.getTipo());
            }
        }
        
        Vector<String> diferentes = new Vector<String>();

        String tipon;
        if (!tipos.isEmpty()) {
            tipon = (String) tipos.get(0);
            diferentes.add(tipon);
            boolean adicionar = false;
            for (int i = 0; i < tipos.size(); i++) {
                for (int j = 0; j < diferentes.size(); j++) {
                    if (tipos.get(i) == null ? diferentes.get(j) != null : !tipos.get(i).equals(diferentes.get(j))) {
                        adicionar = true;
                    } else {
                        adicionar = false;
                        break;
                    }
                }

                if (adicionar) {
                    tipon = (String) tipos.get(i);
                    diferentes.add(tipon);
                    adicionar = false;

                }
            }
        }

        diferentes.add("Outro");

        for (int i = 0; i < diferentes.size(); i++) {
            //System.out.println(diferentes.get(i));
        }

        return diferentes;
    }
    public boolean verificarNome(String nome) {
        List<Itens> listaDeItens = null;
        List nomes = new ArrayList();

        try {
            listaDeItens = Facade.getInstance().procurarItem("", 5);
        } catch (SQLException ex) {
            Logger.getLogger(FormManterItens.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (listaDeItens != null) {
            Iterator<Itens> itItens = listaDeItens.iterator();
            while (itItens.hasNext()) {
                Itens item = itItens.next();
                nomes.add(item.getNome());
            }
        }

        boolean estaLivre = true;
        if (!nomes.isEmpty()) {
            for (int i = 0; i < nomes.size(); i++) {
                if (nome.equals(nomes.get(i))) {
                    estaLivre = false;
                    break;
                }
            }
        }
        return estaLivre;
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
            java.util.logging.Logger.getLogger(FormNovoItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormNovoItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormNovoItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormNovoItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormNovoItem().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JRadioButton btRNao;
    private javax.swing.JRadioButton btRSim;
    private javax.swing.JButton btVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cmpDatasheet;
    private javax.swing.JTextArea cmpDescricao;
    private javax.swing.JTextField cmpNome;
    private javax.swing.JTextField cmpOutroTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcTipo;
    // End of variables declaration//GEN-END:variables
}
