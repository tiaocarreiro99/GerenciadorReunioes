/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.visao;

import gerenciadorreunioes.controle.AtaControl;
import gerenciadorreunioes.controle.GrupoControl;
import gerenciadorreunioes.controle.LoginControl;
import gerenciadorreunioes.controle.PautaControl;
import gerenciadorreunioes.controle.ReuniaoControl;
import gerenciadorreunioes.controle.ServidorControl;
import gerenciadorreunioes.modelo.Ata;
import gerenciadorreunioes.modelo.Grupo;
import gerenciadorreunioes.modelo.Pauta;
import gerenciadorreunioes.modelo.Reuniao;
import gerenciadorreunioes.modelo.Servidor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author Hernane
 */
public class GerenciarReunioesGUI extends javax.swing.JFrame {

    private GrupoControl grupoControl = new GrupoControl();
    private ServidorControl servControl = new ServidorControl();
    private DefaultListModel modelo = new DefaultListModel();
    private ArrayList<String> arrayGrupos = grupoControl.pegaCodigoNomeGrupos();
    private ArrayList<String> arrayServidores = new ArrayList<>();
    private AtaControl ataControl = new AtaControl();
    private PautaControl pautaControl = new PautaControl();
    private ReuniaoControl reuniaoControl = new ReuniaoControl();
    private LoginControl loginControl = new LoginControl();
    private Servidor serAux;

    /**
     * Creates new form GerenciarReunioesGUI
     */
    public GerenciarReunioesGUI() {
        initComponents();
        serAux = LoginControl.retornaServidorLogado();
        iniciaComponentes();
        listaReunioes();
    }

    private void iniciaComponentes() {
        jTextFieldNovoPonto.setEnabled(false);
        jButtonExcluirPontoPauta.setEnabled(false);
        jComboBoxGrupoParticipante.removeAllItems();
        jButtonCadastrar.setEnabled(false);
        for (int i = 0; i < arrayGrupos.size(); i++) {
            jComboBoxGrupoParticipante.addItem(arrayGrupos.get(i));
        }
        atualizaComboResponsavelAta();
    }

    private void atualizaComboResponsavelAta() {
        arrayServidores.removeAll(arrayServidores);
        ArrayList<Servidor> arrayAux = servControl.getParticipantesDoGrupo(pegaCodigoGrupo());
        for (int i = 0; i < arrayAux.size(); i++) {
            arrayServidores.add(arrayAux.get(i).getSiape() + " - " + arrayAux.get(i).getNome());
        }
        jComboBoxResponsavelATA.removeAllItems();
        for (int i = 0; i < arrayServidores.size(); i++) {
            jComboBoxResponsavelATA.addItem(arrayServidores.get(i));
        }
    }
    
    public void listaReunioes(){
        Grupo aux = reuniaoControl.pesquisaGrupo(serAux.getSiape());
        ArrayList<Reuniao> reunioes = reuniaoControl.reunioes(aux.getCodigo());
        DefaultListModel e = new DefaultListModel();
        jListReuniões.removeAll();
        for (int i = 0; i < reunioes.size(); i++) {
            e.addElement(reunioes.get(i).getCodigo() + " - " + reunioes.get(i).getNome());
        }
        jListReuniões.setModel(e);
    }
    
    public void deletarReuniao(){
        String selecionado = (String) jListReuniões.getSelectedValue();
        String[] pegaCodigo = selecionado.split(" - ");
        int cod = Integer.parseInt(pegaCodigo[0]);  
        boolean v = reuniaoControl.deleta(cod);
        if(v){
            JOptionPane.showMessageDialog(this, "Reunião deletada com sucesso");
            listaReunioes();
        } else{
        JOptionPane.showMessageDialog(this, "Não foi possível deltar esta reunião, tente novamente");
    }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxGrupoParticipante = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButtonNovoPonto = new javax.swing.JButton();
        jButtonExcluirPontoPauta = new javax.swing.JButton();
        jTextFieldNovoPonto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldHora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonConcluir = new javax.swing.JButton();
        jButtonCadastrar = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextFieldLocal = new javax.swing.JTextField();
        jComboBoxResponsavelATA = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListReuniões = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastrar Reunião", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N

        jLabel1.setText("Selecione um grupo para participar da reunião:");

        jComboBoxGrupoParticipante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxGrupoParticipanteMouseClicked(evt);
            }
        });
        jComboBoxGrupoParticipante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGrupoParticipanteActionPerformed(evt);
            }
        });

        jLabel2.setText("Pontos de pauta:");

        jButtonNovoPonto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/i54.jpg"))); // NOI18N
        jButtonNovoPonto.setText("Novo");
        jButtonNovoPonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoPontoActionPerformed(evt);
            }
        });

        jButtonExcluirPontoPauta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/deletar-foto_318-77143.jpg"))); // NOI18N
        jButtonExcluirPontoPauta.setText("Excluir");
        jButtonExcluirPontoPauta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirPontoPautaActionPerformed(evt);
            }
        });

        jTextFieldNovoPonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNovoPontoActionPerformed(evt);
            }
        });

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel3.setText("Pontos de pauta cadastrados:");

        jLabel4.setText("Selecione o participante responsável pela ATA:");

        jLabel5.setText("Data da Reunião:");

        jLabel6.setText("Horário da Reunião(HH:MM):");

        jLabel7.setText("Local da Reunião:");

        jButtonConcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/download (1).jpg"))); // NOI18N
        jButtonConcluir.setText("Concluir");
        jButtonConcluir.setToolTipText("");
        jButtonConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonConcluir)
                .addGap(93, 93, 93))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonConcluir)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jButtonCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/gravar.PNG"))); // NOI18N
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jLabel8.setText("Reuniões Cadastradas:");

        jScrollPane2.setViewportView(jListReuniões);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/deletar-foto_318-77143.jpg"))); // NOI18N
        jButton1.setText("Excluir Reunião");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dialog-close.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 217, Short.MAX_VALUE)
                        .addComponent(jButtonExcluirPontoPauta))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jComboBoxGrupoParticipante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonNovoPonto)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonCadastrar))
                        .addComponent(jTextFieldNovoPonto)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxResponsavelATA, javax.swing.GroupLayout.Alignment.LEADING, 0, 308, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldHora)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldLocal)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBoxGrupoParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jButtonNovoPonto)
                            .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(jTextFieldNovoPonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonExcluirPontoPauta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxResponsavelATA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(8, 8, 8)
                        .addComponent(jTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButtonCancelar))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNovoPontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNovoPontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNovoPontoActionPerformed

    private void jButtonNovoPontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoPontoActionPerformed
        jTextFieldNovoPonto.setEnabled(true);
        jButtonCadastrar.setEnabled(true);
        jButtonNovoPonto.setEnabled(false);
        jButtonExcluirPontoPauta.setEnabled(false);
    }//GEN-LAST:event_jButtonNovoPontoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        loginControl.abreTelaPrincipalDoServidor(serAux.getSiape(), serAux.getSenha());
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jComboBoxGrupoParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGrupoParticipanteActionPerformed
        atualizaComboResponsavelAta();
    }//GEN-LAST:event_jComboBoxGrupoParticipanteActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        cadastraPontoPauta();
        jButtonExcluirPontoPauta.setEnabled(false);
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonExcluirPontoPautaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirPontoPautaActionPerformed
        excluiPontoPauta();
        jButtonExcluirPontoPauta.setEnabled(false);
    }//GEN-LAST:event_jButtonExcluirPontoPautaActionPerformed

    private void jButtonConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConcluirActionPerformed
        cadastraReuniao();
        limpaCampos();
        listaReunioes();
    }//GEN-LAST:event_jButtonConcluirActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        jButtonExcluirPontoPauta.setEnabled(true);
    }//GEN-LAST:event_jList1MouseClicked

    private void jComboBoxGrupoParticipanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxGrupoParticipanteMouseClicked
        
    }//GEN-LAST:event_jComboBoxGrupoParticipanteMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       deletarReuniao();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConcluir;
    private javax.swing.JButton jButtonExcluirPontoPauta;
    private javax.swing.JButton jButtonNovoPonto;
    private javax.swing.JComboBox<String> jComboBoxGrupoParticipante;
    private javax.swing.JComboBox<String> jComboBoxResponsavelATA;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jListReuniões;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldHora;
    private javax.swing.JTextField jTextFieldLocal;
    private javax.swing.JTextField jTextFieldNovoPonto;
    // End of variables declaration//GEN-END:variables

    private void cadastraPontoPauta() {
        String pontoPauta = jTextFieldNovoPonto.getText();
        if (pontoPauta.equals("")) {
            JOptionPane.showMessageDialog(this, "Não é permitido cadastrar um Ponto de Pauta vazio !!!");
        } else {
            modelo.addElement(jTextFieldNovoPonto.getText());
            jList1.setModel(modelo);
        }
        jTextFieldNovoPonto.setText("");
        jTextFieldNovoPonto.setEnabled(false);
        jButtonNovoPonto.setEnabled(true);
        jButtonCadastrar.setEnabled(false);
    }

    private void excluiPontoPauta() {
        int i = jList1.getSelectedIndex();
        modelo.remove(i);
        jList1.setModel(modelo);
    }

    private int separaCodigo() {
        String selecionado = (String) jComboBoxResponsavelATA.getSelectedItem();
        String[] pegaSiape = selecionado.split(" - ");
        int siape = Integer.parseInt(pegaSiape[0]);
        return siape;
    }

    private ArrayList<String> pegaPontos() {
        ArrayList<String> pontos = new ArrayList<>();
        for (int i = 0; i < jList1.getModel().getSize(); i++) {
            pontos.add((String) jList1.getModel().getElementAt(i));
        }
        return pontos;
    }
    
    private void cadastraReuniao() {
        String data = new SimpleDateFormat("dd/MM/yyyy").format(jDateChooser1.getDate());
        boolean vazio = reuniaoControl.verificaCampos(jList1.getModel().getSize(), data, jTextFieldHora.getText(), jTextFieldLocal.getText());
        if (vazio) {
            JOptionPane.showMessageDialog(this, "Nenhum campo pode ficar vazio !!!");
        } else {
            Reuniao x = new Reuniao();
            String selecionado = (String) jComboBoxGrupoParticipante.getSelectedItem();
            String[] pegaNome = selecionado.split(" - ");
            String nome = pegaNome[1];
            String n = jTextFieldHora.getText() + " - " + nome + " - " + data;
            x.setNome(n);
            x.setData(data);
            x.setHorarioInicio(jTextFieldHora.getText());
            x.setHorarioFim("-");
            x.setLocal(jTextFieldLocal.getText());
            
            // acabar daqui !!!
            
            x.setSiapeResponsavelAta(separaCodigo());
            x.setReu_gruCodigo(pegaCodigoGrupo());
            reuniaoControl.adiciona(x);
            Ata a = new Ata();
            a.setAtaStatus("Aberta");
            a.setAta_reuCodigo(reuniaoControl.codReuniao(n));
            ataControl.adiciona(a);
            Pauta p = new Pauta();
            ArrayList<String> titulos = pegaPontos();
            for (int i = 0; i < titulos.size(); i++) {
                p.setTitulo(titulos.get(i));
                p.setPau_ataCodigo(ataControl.codAta(reuniaoControl.codReuniao(n)));
                p.setDefinicao(" - ");
                p.setEncaminhamento(" - ");
                pautaControl.adiciona(p);
            }
            JOptionPane.showMessageDialog(this, "Reunião: " + x.getNome() + " cadastrada com sucesso !!!");
        }
    }

    private int pegaCodigoGrupo() {
        String s = (String) jComboBoxGrupoParticipante.getSelectedItem();
        String[] pegaCodigo = s.split(" - ");
        int codigo = Integer.parseInt(pegaCodigo[0]);
        return codigo;
    }

    private void limpaCampos() {
        jTextFieldNovoPonto.setText("");
        jTextFieldHora.setText("");
        jTextFieldLocal.setText("");
        modelo.removeAllElements();
        jList1.setModel(modelo);
        jDateChooser1.setDateFormatString("");
    }

}
