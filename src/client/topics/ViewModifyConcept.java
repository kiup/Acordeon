/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.topics;

import Sesion.User;
import client.ThreadAcordeon;
import java.rmi.RemoteException;
import java.sql.Time;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import models.Log;
import topics.models.Concept;

/**
 *
 * @author juan
 */
public class ViewModifyConcept extends javax.swing.JFrame {

    private User user;
    private ThreadAcordeon thread;
    
    private ViewModifyConcept(ThreadAcordeon thread, User user) {
        initComponents();
        this.thread = thread;
        this.user = user;
        getLblIdConcept().setVisible(false);
        setLocation(820,0);
        txtDefinicion.setLineWrap(true);
        txtDefinicion.setWrapStyleWord(true);
    }
    
    private static ViewModifyConcept ventanaModificarConcepto = null;
     
    public static ViewModifyConcept obtenerVentanaModificarConcepto (ThreadAcordeon thread, User user){
        if(ventanaModificarConcepto == null){
            ventanaModificarConcepto = new ViewModifyConcept(thread, user);
            return ventanaModificarConcepto;
        }
        return ventanaModificarConcepto;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblModificarConcepto = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDefinicion = new javax.swing.JTextArea();
        btnCancelar = new javax.swing.JButton();
        lblUsuarioLogeado = new javax.swing.JLabel();
        lblIdConcept = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblModificarConcepto.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblModificarConcepto.setText("Modificar...");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setText("Definición");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        txtDefinicion.setColumns(20);
        jScrollPane3.setViewportView(txtDefinicion);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblUsuarioLogeado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(btnModificar)
                .addGap(72, 72, 72)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblModificarConcepto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblUsuarioLogeado, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)))
                .addComponent(lblIdConcept))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUsuarioLogeado, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdConcept))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblModificarConcepto)
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(144, 144, 144))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String nuevaDescripcion = getTxtDefinicion().getText();
        int id = Integer.parseInt(getLblIdConcept().getText());
        if(!nuevaDescripcion.equals("")){
            try {
                Concept conceptoModificado = new Concept(id, nuevaDescripcion);
                thread.getManagerConcepts().getManagerConcept(id).finalizemodifyConcept(conceptoModificado);
            } catch (RemoteException ex) {
                Logger.getLogger(ViewModifyConcept.class.getName()).log(Level.SEVERE, null, ex);
            }
            getTxtDefinicion().setText("");
            ViewConcepts.obtenerVentanaConceptos(this.thread, this.user).setVisible(true);
            JOptionPane.showMessageDialog(this, "Modificación realizada con éxito","Cambios guardados",JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
            Date date = new Date();
            java.sql.Date datesql = new java.sql.Date(date.getYear(), date.getMonth(), date.getDay());
            Time time = new Time(date.getHours(),date.getMinutes(),date.getSeconds());
            Log log = new Log("modificar", "concepto", datesql, time, user.getName());
            try {
                thread.getManagerLogs().createLog(log, this.user.getIdUser());
            } catch (RemoteException ex) {
                Logger.getLogger(ViewModifyConcept.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "No ha escrito un nombre nuevo","Error",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {
            // TODO add your handling code here:
            int id = Integer.parseInt(getLblIdConcept().getText());
            this.setVisible(false);
            thread.getManagerConcepts().getManagerConcept(id).cancelLock();
        } catch (RemoteException ex) {
            Logger.getLogger(ViewModifyConcept.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblIdConcept;
    private javax.swing.JLabel lblModificarConcepto;
    private javax.swing.JLabel lblUsuarioLogeado;
    private javax.swing.JTextArea txtDefinicion;
    // End of variables declaration//GEN-END:variables

    public static ViewModifyConcept getVentanaModificarConcepto() {
        return ventanaModificarConcepto;
    }

    public static void setVentanaModificarConcepto(ViewModifyConcept ventanaModificarConcepto) {
        ViewModifyConcept.ventanaModificarConcepto = ventanaModificarConcepto;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(JButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public void setjScrollPane3(JScrollPane jScrollPane3) {
        this.jScrollPane3 = jScrollPane3;
    }

    public JLabel getLblModificarConcepto() {
        return lblModificarConcepto;
    }

    public void setLblModificarConcepto(JLabel lblModificarConcepto) {
        this.lblModificarConcepto = lblModificarConcepto;
    }

    public JLabel getLblUsuarioLogeado() {
        return lblUsuarioLogeado;
    }

    public void setLblUsuarioLogeado(JLabel lblUsuarioLogeado) {
        this.lblUsuarioLogeado = lblUsuarioLogeado;
    }

    public JTextArea getTxtDefinicion() {
        return txtDefinicion;
    }

    public void setTxtDefinicion(JTextArea txtDefinicion) {
        this.txtDefinicion = txtDefinicion;
    }

    public JLabel getLblIdConcept() {
        return lblIdConcept;
    }

    public void setLblIdConcept(JLabel lblIdConcept) {
        this.lblIdConcept = lblIdConcept;
    }
}
