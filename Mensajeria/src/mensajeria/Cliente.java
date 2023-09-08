/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajeria;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import java.time.LocalTime;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import static mensajeria.Servidor.dout;

/**
 *
 * @author rous2
 */
public class Cliente extends javax.swing.JFrame {
    static LocalTime horaActual = LocalTime.now();
    int contI=0, contV=0, contA=0;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    
    public Cliente() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        Historial = new javax.swing.JTextArea();
        Msg = new javax.swing.JTextField();
        Enviar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Multimedia = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Historial.setColumns(20);
        Historial.setRows(5);
        jScrollPane1.setViewportView(Historial);

        Enviar.setText("Enviar");
        Enviar.setBorder(null);
        Enviar.setBorderPainted(false);
        Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarActionPerformed(evt);
            }
        });

        jLabel2.setText("Cliente");

        Multimedia.setText("Archivos");
        Multimedia.setBorder(null);
        Multimedia.setBorderPainted(false);
        Multimedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MultimediaActionPerformed(evt);
            }
        });

        jButton2.setText("Imagenes");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Msg, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Enviar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Multimedia, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(Msg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Multimedia, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(206, 206, 206))
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(17, 17, 17)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(Enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Multimedia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Msg))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarActionPerformed
        try{

            String msg = "";
            msg = Msg.getText().trim();
            Historial.setText(Historial.getText().trim()+"\n\n Client\t"+msg);
            dout.writeUTF(msg);
            Msg.setText("");

        } catch (Exception e) {
        }
    }//GEN-LAST:event_EnviarActionPerformed

    private void MultimediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MultimediaActionPerformed
        File ruta;
        String rutas;
        JFileChooser jf = new JFileChooser();
        jf.setMultiSelectionEnabled(false);
        FileNameExtensionFilter filt = new FileNameExtensionFilter("JPG, MP4, MP3", "jpg", "mp4", "mp3");
        jf.setFileFilter(filt);
        int res = jf.showOpenDialog(this);

        if (res == JFileChooser.APPROVE_OPTION) {
            ruta = jf.getSelectedFile();
            rutas = ruta.getPath();

            String ex = getFileExtension(ruta);
            if(ex.equals("jpg")){
                contI++;
                rsdragdropfiles.RSDragDropFiles.setCopiar(rutas, "src/Img/"+contI+"."+ex);
            }else if(ex.equals("mp4")){
                contV++;
                rsdragdropfiles.RSDragDropFiles.setCopiar(rutas, "src/Vid/"+contV+"."+ex);
            }else if(ex.equals("mp3")){
                contA++;
                rsdragdropfiles.RSDragDropFiles.setCopiar(rutas, "src/Aud/"+contA+"."+ex);
            }

            try {
                String msg = "";
                msg = Msg.getText().trim();
                int hora = horaActual.getHour();
                int minutos = horaActual.getMinute();
                Historial.setText(Historial.getText().trim() + "\n\n Cliente "+hora+":"+minutos+": Nueva archivo");
               
                dout.writeUTF(msg);
                Msg.setText("");
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_MultimediaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(contI==0){
            
        }else{
            Imagenes img = new Imagenes(contI);
            img.setSize(360,310);
            img.setLocationRelativeTo(null);
            img.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        int lastIndex = fileName.lastIndexOf('.');
        if (lastIndex >= 0 && lastIndex < fileName.length() - 1) {
            return fileName.substring(lastIndex + 1);
        }
        return "";
    }
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
        
        try{
            s = new Socket("localhost", 1201);
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            
            String msgin = "";
            while(!msgin.equals("Salir")){
                msgin = din.readUTF();
                Historial.setText(Historial.getText().trim()+"\n\n Server\t"+msgin);
            }
            
        }catch(Exception e){
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Enviar;
    private static javax.swing.JTextArea Historial;
    private javax.swing.JTextField Msg;
    private javax.swing.JButton Multimedia;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
