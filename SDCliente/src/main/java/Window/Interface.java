package Window;

import Dominio.Cliente;
import java.io.IOException;
import static java.lang.constant.ConstantDescs.NULL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

public class Interface extends javax.swing.JFrame {

    private Cliente cliente;

    public Interface() {
        this.cliente = new Cliente();
        initComponents();
        preencherComboBoxes();

    }

    private void preencherComboBoxes() {
        String[] usuarios;
        try {
            usuarios = cliente.getUsuarios();
            clienteBox.setModel(new DefaultComboBoxModel<>(usuarios));

            // Obter a lista de filmes do servidor
            String[] filmes = cliente.getFilmes();
            DefaultComboBoxModel<String> filmesModel = new DefaultComboBoxModel<>(filmes);
            filmeBox.setModel(filmesModel);
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cliente = new javax.swing.JLabel();
        clienteBox = new javax.swing.JComboBox<>();
        filme = new javax.swing.JLabel();
        filmeBox = new javax.swing.JComboBox<>();
        notaBox = new javax.swing.JComboBox<>();
        nota = new javax.swing.JLabel();
        buttonEnviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaResposta = new javax.swing.JTextArea();
        buttonRecomendacao = new javax.swing.JButton();
        buttonListar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Cliente.setText("CLIENTE:");

        filme.setText("FILME:");

        filmeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filmeBoxActionPerformed(evt);
            }
        });

        notaBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 - Nao conheço", "1 - Ruim", "2 - Bom", "3 - Otimo" }));
        notaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notaBoxActionPerformed(evt);
            }
        });

        nota.setText("NOTA:");

        buttonEnviar.setText("Enviar");
        buttonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEnviarActionPerformed(evt);
            }
        });

        textAreaResposta.setColumns(20);
        textAreaResposta.setRows(5);
        jScrollPane1.setViewportView(textAreaResposta);

        buttonRecomendacao.setText("Recomendação");
        buttonRecomendacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRecomendacaoActionPerformed(evt);
            }
        });

        buttonListar.setText("Listar");
        buttonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonListarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel5.setText("Avaliações/Recomendações de Filmes ");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nota)
                            .addComponent(Cliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(notaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(clienteBox, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(filme)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filmeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonRecomendacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonListar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonEnviar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(47, 47, 47)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filme)
                    .addComponent(filmeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clienteBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cliente))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(notaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nota))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonEnviar)
                    .addComponent(buttonListar)
                    .addComponent(buttonRecomendacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEnviarActionPerformed
        int usuario = clienteBox.getSelectedIndex();
        int filme = filmeBox.getSelectedIndex();
        int nota = notaBox.getSelectedIndex();
        String resposta = cliente.enviarAvaliacao(usuario, filme, nota);
        this.textAreaResposta.setText(resposta);
        System.out.println("Resposta do servidor: " + resposta);
    }//GEN-LAST:event_buttonEnviarActionPerformed

    private void buttonRecomendacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRecomendacaoActionPerformed
        // TODO add your handling code here:
        int usuario = clienteBox.getSelectedIndex();
        String resposta = cliente.solicitarRecomendacao(usuario);

        if ("".equals(resposta)) {
            this.textAreaResposta.setText("Não há Recomendações");
            System.out.println("Não há recomendações");
        } else {
            this.textAreaResposta.setText("Recomendações:\n" + resposta);
            System.out.println("Resposta do servidor LISTAR: " + resposta);
        }
    }//GEN-LAST:event_buttonRecomendacaoActionPerformed

    private void buttonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListarActionPerformed
        // TODO add your handling code here:
        int usuarioIndex = clienteBox.getSelectedIndex();
        String resposta = cliente.listarAvaliacoes(usuarioIndex);
        if ("".equals(resposta)) {
            textAreaResposta.setText("Não há avaliações");
        } else {
            textAreaResposta.setText("Avaliações:\n" + resposta);
        }
    }//GEN-LAST:event_buttonListarActionPerformed

    private void notaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notaBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notaBoxActionPerformed

    private void filmeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filmeBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filmeBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cliente;
    private javax.swing.JButton buttonEnviar;
    private javax.swing.JButton buttonListar;
    private javax.swing.JButton buttonRecomendacao;
    private javax.swing.JComboBox<String> clienteBox;
    private javax.swing.JLabel filme;
    private javax.swing.JComboBox<String> filmeBox;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nota;
    private javax.swing.JComboBox<String> notaBox;
    private javax.swing.JTextArea textAreaResposta;
    // End of variables declaration//GEN-END:variables
}
