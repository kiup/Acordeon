/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.topics;

import Sesion.Cuenta;
import Sesion.User;
import client.ThreadAcordeon;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import client.login.ViewLogin;
import java.rmi.RemoteException;
import java.sql.Time;
import java.util.Date;
import models.Log;
import topics.models.Concept;

/**
 *
 * @author Milka
 */
public class ViewAddConcept extends javax.swing.JFrame {

    private ThreadAcordeon thread;
    private User user;
    
    private static ViewAddConcept ventanaAniadirConcepto = null;
    
    private ViewAddConcept(ThreadAcordeon thread, User user) {
        initComponents();
        this.thread = thread;
        this.user = user;
        setLocation(820, 0);
        getLblIdTopic().setVisible(false);
    }
    
    public static ViewAddConcept obtenerVentanaAniadirConcepto (ThreadAcordeon thread, User user){
        if(ventanaAniadirConcepto == null){
            ventanaAniadirConcepto = new ViewAddConcept(thread, user);
            return ventanaAniadirConcepto;
        }
        return ventanaAniadirConcepto;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtConcepto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDefinicion = new javax.swing.JTextArea();
        btnAgregarConcepto = new javax.swing.JButton();
        lblAgregarConcepto = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        lblUsuarioLogeado = new javax.swing.JLabel();
        lblIdTopic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar concepto");

        jLabel1.setText("Concepto");

        jLabel2.setText("Definición");

        txtAreaDefinicion.setColumns(20);
        txtAreaDefinicion.setRows(5);
        jScrollPane1.setViewportView(txtAreaDefinicion);

        btnAgregarConcepto.setText("Agregar");
        btnAgregarConcepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarConceptoActionPerformed(evt);
            }
        });

        lblAgregarConcepto.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblAgregarConcepto.setText("Agregar nuevo concepto a...");

        btnCancelar.setText("Cancelar");

        lblUsuarioLogeado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(btnAgregarConcepto)
                        .addGap(77, 77, 77)
                        .addComponent(btnCancelar)))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAgregarConcepto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblIdTopic))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblUsuarioLogeado, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblUsuarioLogeado, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAgregarConcepto)
                    .addComponent(lblIdTopic))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarConcepto)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarConceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarConceptoActionPerformed
        try {
            // TODO add your handling code here:
            this.dispose();
            Cuenta cuentaIniciada = Cuenta.obtenerCuentaIniciada();
            Concept nuevoConcepto = new Concept(this.txtConcepto.getText(),this.txtAreaDefinicion.getText(),cuentaIniciada.getUserId(),Integer.parseInt(getLblIdTopic().getText()));
            thread.getManagerConcepts().getManagerConcept(0).createConcept(nuevoConcepto);
            ViewConcepts.obtenerVentanaConceptos(this.thread, this.user).setVisible(true);
            Date date = new Date();
            java.sql.Date datesql = new java.sql.Date(date.getYear(), date.getMonth(), date.getDay());
            Time time = new Time(date.getHours(),date.getMinutes(),date.getSeconds());
            Log log = new Log("alta", "concepto", datesql, time, user.getName());
            thread.getManagerLogs().createLog(log, user.getIdUser());
        } catch (RemoteException ex) {
            Logger.getLogger(ViewAddConcept.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarConceptoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarConcepto;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAgregarConcepto;
    private javax.swing.JLabel lblIdTopic;
    private javax.swing.JLabel lblUsuarioLogeado;
    private javax.swing.JTextArea txtAreaDefinicion;
    private javax.swing.JTextField txtConcepto;
    // End of variables declaration//GEN-END:variables

    public static ViewAddConcept getVentanaAniadirConcepto() {
        return ventanaAniadirConcepto;
    }

    public static void setVentanaAniadirConcepto(ViewAddConcept ventanaAniadirConcepto) {
        ViewAddConcept.ventanaAniadirConcepto = ventanaAniadirConcepto;
    }

    public JButton getBtnAgregarConcepto() {
        return btnAgregarConcepto;
    }

    public void setBtnAgregarConcepto(JButton btnAgregarConcepto) {
        this.btnAgregarConcepto = btnAgregarConcepto;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getLblAgregarConcepto() {
        return lblAgregarConcepto;
    }

    public JLabel getLblIdTopic() {
        return lblIdTopic;
    }

    public void setLblIdTopic(JLabel lblIdTopic) {
        this.lblIdTopic = lblIdTopic;
    }

    public void setLblAgregarConcepto(JLabel lblAgregarConcepto) {
        this.lblAgregarConcepto = lblAgregarConcepto;
    }

    public JLabel getLblUsuarioLogeado() {
        return lblUsuarioLogeado;
    }

    public void setLblUsuarioLogeado(JLabel lblUsuarioLogeado) {
        this.lblUsuarioLogeado = lblUsuarioLogeado;
    }

    public JTextArea getTxtAreaDefinicion() {
        return txtAreaDefinicion;
    }

    public void setTxtAreaDefinicion(JTextArea txtAreaDefinicion) {
        this.txtAreaDefinicion = txtAreaDefinicion;
    }

    public JTextField getTxtConcepto() {
        return txtConcepto;
    }

    public void setTxtConcepto(JTextField txtConcepto) {
        this.txtConcepto = txtConcepto;
    }
}