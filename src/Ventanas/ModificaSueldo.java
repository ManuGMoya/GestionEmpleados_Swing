package Ventanas;

import Clases.Empleado;
import Clases.Fondo;
import javax.swing.JOptionPane;

/**
 *
 * @author Manu
 */
public class ModificaSueldo extends javax.swing.JFrame {

    PrincipalVisualizar ventPrinc;
    private Empleado emp;

    public ModificaSueldo(PrincipalVisualizar ven) {
        setContentPane(new Fondo(PrincipalVisualizar.fondo));
        initComponents();
        ventPrinc = ven;
        this.setVisible(true);
        this.setLocationRelativeTo(ven);

        emp = (Empleado) ventPrinc.getListado().get(ventPrinc.getPos());
        nombre.setText(emp.getNombre());
        nombre.setEditable(false);
        sueldo.setText(Float.toString(emp.getSueldo()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        sueldo = new javax.swing.JTextField();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setText("INDIQUE EL NUEVO SUELDO DE ");

        nombre.setFont(new java.awt.Font("Comic Sans MS", 2, 16)); // NOI18N
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });

        sueldo.setFont(new java.awt.Font("Comic Sans MS", 2, 16)); // NOI18N
        sueldo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sueldoMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sueldoNEW(evt);
            }
        });
        sueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sueldoActionPerformed(evt);
            }
        });

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
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(aceptar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cancelar)
                                .addGap(8, 8, 8))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(sueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(sueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(cancelar))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.ventPrinc.setVisible(true);
        this.ventPrinc.ON_OFFBotones();
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        float sueldoNuevo;
        try {
            if (sueldo.getText().equals("")) {
                ventPrinc.getError().play(); //EJECUTO EL SONIDO DE ERROR
                JOptionPane.showMessageDialog(this, "DEBE INSERTAR UN SUELDO", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                sueldoNuevo = Float.parseFloat(sueldo.getText());
                emp.setSueldo((float) sueldoNuevo);
                ventPrinc.getListado().set(ventPrinc.getPos(), emp);
                ventPrinc.escribirFichero();
                ventPrinc.getValidar().play();  //EJECUTO EL SONIDO DE VALIDAR
                JOptionPane.showMessageDialog(this, "EMPLEADO " + nombre.getText() + " MODIFICADO ", "CORRECTO!", JOptionPane.INFORMATION_MESSAGE);
                ventPrinc.visualizarDatos(ventPrinc.getPos()); //PARA VER LA MODIFICACION AL VOLVER A LA PRINCIPAL
                this.ventPrinc.setVisible(true);
                this.dispose();
            }

        } catch (NumberFormatException e) {
            ventPrinc.getError().play(); //EJECUTO EL SONIDO DE ERROR
            sueldo.setText(null);
            JOptionPane.showMessageDialog(this, "Debe insertar numeros en el campo sueldo", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void sueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sueldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sueldoActionPerformed

    private void sueldoNEW(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sueldoNEW
        System.out.println("hola");
    }//GEN-LAST:event_sueldoNEW

    private void sueldoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sueldoMouseEntered
        sueldo.setText("");
    }//GEN-LAST:event_sueldoMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField sueldo;
    // End of variables declaration//GEN-END:variables
}
