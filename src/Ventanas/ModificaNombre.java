package Ventanas;

import Clases.Empleado;
import Clases.Fondo;
import java.util.Collections;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author Manu
 */
public class ModificaNombre extends javax.swing.JFrame {

    PrincipalVisualizar ventPrinc; //OBJETO DE TIPO VENTANA PRINCIPAL PARA PODER ACCEDER A ELLA
    private Empleado emp;

    ButtonGroup grupo = new ButtonGroup();

    public ModificaNombre(PrincipalVisualizar ven) {
        setContentPane(new Fondo(PrincipalVisualizar.fondo));
        initComponents();
        ventPrinc = ven;
        this.setLocationRelativeTo(ven);
        this.setVisible(true);
        this.setResizable(false);
        agruparRadioButton();
        emp = (Empleado) ventPrinc.getListado().get(ventPrinc.getPos());
        nombre.setText(emp.getNombre());
    }

    void agruparRadioButton() {
        grupo.add(hombre);
        grupo.add(mujer);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        hombre = new javax.swing.JRadioButton();
        mujer = new javax.swing.JRadioButton();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setText("INSERTE EL NUEVO NOMBRE PARA :");

        nombre.setFont(new java.awt.Font("Comic Sans MS", 2, 16)); // NOI18N
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });

        hombre.setText("Hombre");

        mujer.setText("Mujer");

        aceptar.setText("ACEPTAR");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        cancelar.setText("CANCELAR");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(hombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(mujer))
                    .addComponent(nombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(aceptar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hombre)
                    .addComponent(mujer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(aceptar)
                .addGap(18, 18, 18)
                .addComponent(cancelar)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.ventPrinc.setVisible(true);
        this.ventPrinc.ON_OFFBotones();
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        if (nombre.getText().equals("")) {
            ventPrinc.getError().play(); //EJECUTO EL SONIDO DE ERROR
            JOptionPane.showMessageDialog(this, "DEBE INSERTAR UN NOMBRE", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (!mujer.isSelected() && !hombre.isSelected()) {
            ventPrinc.getError().play(); //EJECUTO EL SONIDO DE ERROR
            JOptionPane.showMessageDialog(this, "DEBE INDICAR EL SEXO", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            emp.setNombre(nombre.getText());
            if (hombre.isSelected()) {
                emp.setSexo("Hombre");
                ventPrinc.getListado().set(ventPrinc.getPos(), emp);
            } else {
                emp.setSexo("Mujer");
                ventPrinc.getListado().set(ventPrinc.getPos(), emp);
            }
            Collections.sort(ventPrinc.getListado());
            ventPrinc.escribirFichero();
            ventPrinc.getValidar().play();  //EJECUTO EL SONIDO DE VALIDAR
            ventPrinc.visualizarDatos(0);
            ventPrinc.setPos(0);   //PARA QUE AL VOLVER A LA PRINCIPAL, APAREZCA EL PRIMER EMPLEADO
            JOptionPane.showMessageDialog(this, "EMPLEADO " + nombre.getText() + " MODIFICADO ", "CORRECTO!", JOptionPane.INFORMATION_MESSAGE);
            this.ventPrinc.setVisible(true);
            ventPrinc.ON_OFFBotones();
            this.dispose();
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JRadioButton hombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton mujer;
    private javax.swing.JTextField nombre;
    // End of variables declaration//GEN-END:variables
}
