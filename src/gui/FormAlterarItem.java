package gui;

import beans.Itens;
import business.AdaptadorBDElectroSearch;
import business.Facade;
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

public class FormAlterarItem extends javax.swing.JFrame {

    private String nome;
    private String tipo;

    public FormAlterarItem() {
        initComponents();
        ButtonGroup group = new ButtonGroup();
        group.add(btRSim);
        group.add(btRNao);

        Vector<String> ntipos = listarComboBox();
        for (int i = 0; i < ntipos.size(); i++) {
            jcTipo.addItem(ntipos.get(i));
        }

        String nome = "";
        String tipo = "";
        String datasheet = "";
        String descricao = "";
        boolean disponivel = true;

        cmpNome.setText(nome);
        cmpDatasheet.setText(datasheet);
        cmpDescricao.setText(descricao);
        this.tipo = tipo;

        if (disponivel) {
            btRSim.setSelected(true);
            btRNao.setSelected(false);
        } else {
            btRNao.setSelected(true);
            btRSim.setSelected(false);
        }

        int j;
        for (int i = 1; i < ntipos.size(); i++) {
            if (this.tipo == ntipos.get(i)) {
                j = i;
                break;
            }
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

    public FormAlterarItem(String nome) {
        initComponents();
        this.nome = nome;
        System.out.println(this.nome);
        ButtonGroup group = new ButtonGroup();
        group.add(btRSim);
        group.add(btRNao);

        Vector<String> ntipos = listarComboBox();
        for (int i = 0; i < ntipos.size(); i++) {
            jcTipo.addItem(ntipos.get(i));
        }

        Itens item = Facade.getInstance().acharItem(nome);
//        System.out.println(rs);

        if (item != null) {

            String type = item.getTipo();
            String datasheet = item.getDatasheet();
            String descricao = item.getDescricao();
            boolean disponivel = item.isDisponivel();

            cmpNome.setText(nome);
            cmpDatasheet.setText(datasheet);
            cmpDescricao.setText(descricao);

            if (disponivel) {
                btRSim.setSelected(true);
                btRNao.setSelected(false);
            } else {
                btRNao.setSelected(true);
                btRSim.setSelected(false);
            }

            jcTipo.setSelectedItem(type);

        }

//        for(int i = 0; i < ntipos.size(); i++){
//            if (this.tipo == ntipos.get(i)) {
//                jcTipo.setSelectedIndex(i+1);
//                break;
//            }
//        }
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
    public void setNome(String nomr) {
        this.nome = nome;
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
        btVoltar = new javax.swing.JButton();
        jcTipo = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cmpOutroTipo = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("Edição de Itens");

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

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btSalvar)
                                .addGap(18, 18, 18)
                                .addComponent(btVoltar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jcTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmpOutroTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btRSim)
                                .addGap(18, 18, 18)
                                .addComponent(btRNao)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cmpDatasheet)
                            .addComponent(cmpNome))))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(218, 218, 218))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(61, 61, 61)
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
                    .addComponent(btVoltar)
                    .addComponent(btSalvar))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        setVisible(false);
        FormManterItens abrir = new FormManterItens();
        abrir.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed
    private void jcTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcTipoActionPerformed
    }//GEN-LAST:event_jcTipoActionPerformed
    private void btRNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRNaoActionPerformed
    }//GEN-LAST:event_btRNaoActionPerformed
    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        String name = cmpNome.getText();
        boolean estaLivre = verificarNome(nome);
//        if (name.equals(this.nome) || estaLivre) {
        String tipo = "";
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

        System.out.println(name);
        System.out.println(tipo);
        System.out.println(datasheet);
        System.out.println(descricao);

        if (!name.isEmpty() && !tipo.isEmpty() && !datasheet.isEmpty() && !descricao.isEmpty()) {
            ResultSet rs;
            String query;
            int id = 0;
            query = "select id from itens where nome = '" + this.nome + "';";
            
            Itens item = Facade.getInstance().acharItem(nome);
            
            if (item != null) {
                id = item.getId();
            }

            if (Facade.getInstance().alterarItem(id, name, tipo, disponivel, datasheet, descricao)) {
                JOptionPane.showMessageDialog(null, "Item atualizado com sucesso!");

                FormManterItens manterItens = new FormManterItens();
                setVisible(false);
                manterItens.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Erro! Tente novamente!!");

            }

        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }

//        } else {
//            JOptionPane.showMessageDialog(null, "Insira um componente não cadastrado!");
//        }

    }//GEN-LAST:event_btSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(FormAlterarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAlterarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAlterarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAlterarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FormAlterarItem novo;
                novo = new FormAlterarItem();

                // QUERIA CHAMAR C PARAMETRO SÓ Q AQUI DO JEITO NORMAL
                // N PRESTAVA. SÓ PROCUREI EM UM BUCADO DE BLOG E SEI LÁ OQ Q ELES
                // RESPONDEM AS PERGUNTAS E NAO ACHEI
                // O OUTRO ERRO Q EU TINHA TE MANDADO ERA NUM Q EU TAVA FAZENDO DO ZERO
                // P FICAR POO MESMO, TIPO A CLASSE ITENS COM AS COISAS BEM DIREITINHO
                // SÓ Q N IA DAR TEMPO, AÍ VIM P ESSE
                // chamo o construtor em outro Form e tirei o construtor vazio
                //não fiz muita coisa, só coloquei o construtor vazio novamente, tbm não testei, precisaria de login e fiquei com preguiça
                //pelo oq eu entendi, esse form só vai ser acionado a partir de outro form, então ele só vai ser instanciado
                //quando for passado o parâmetro. Se isso acontecer assim mesmo, não tem problema deixar esse construtor vazio, visto que ele 
                //nunca será executado a partir do próprio arquivo, entendeu? tipo, o construtor vazio vai ser só pra não dar erro no código, porém
                //ele nunca será utilizado.
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btRNao;
    private javax.swing.JRadioButton btRSim;
    private javax.swing.JButton btSalvar;
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
