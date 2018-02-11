package Ventanas;

import Clases.Empleado;
import Clases.Fondo;
import java.util.Collections;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Manu
 */
public class Insertar extends javax.swing.JFrame {
    
    PrincipalVisualizar ventPrinc; //OBJETO DE TIPO VENTANA PRINCIPAL PARA PODER ACCEDER A ELLA
    private String sexo; //VARIABLE PARA RECOGER EL VALOR DEL DATO SEXO
    private float sueldoFloat;    //VARIABLE PARA RECOGER EL VALOR DEL DATO SUELDO
    
    static ImageIcon fem = new ImageIcon("src/img/mujer.png"); //CREACION DE LOS OBJETOS DE TIPO ICONO
    static ImageIcon masc = new ImageIcon("src/img/hombre.png"); //DECLARADAS ESTATICAS PARA PODER USARLAS EN LA VENTANA PRINCIPAL

    private ButtonGroup grupo = new ButtonGroup(); //PARA LA AGRUPACION DE BOTONES PARA NO PERMITIR LA MULTISELECCION

    public Insertar(PrincipalVisualizar ven) {
        setContentPane(new Fondo(PrincipalVisualizar.fondo)); //REUTILIZO EL FONDO DE LA VENTANA PRINCIPAL       
        initComponents();
        ventPrinc = ven; //VINCULO LA VENTANA QUE RECIBO POR PARAMETRO CON LA QUE HE DECLARADO COMO DATO DE ESTA CLASE
        this.setLocationRelativeTo(ven);//CENTRA LA VENTANA SOBRE LA QUE SE ABRE
        this.setVisible(true); //ACTIVA LA VISUALIZACION DE LA VENTANA
        this.setResizable(false); //NO PERMITE REESCALAR LA VENTANA
        ajustarVentana();  //METODO PARA AJUSTAR LA VENTANA
        grupoRadioButton(); //LLAMADA AL METODO QUE AGRUPA LOS BOTONES DE RADIO
    }
    
    void ajustarVentana() {
        Clases.GestionVisual.ajustarImagenABoton(icon_mujer, fem);
        Clases.GestionVisual.ajustarImagenABoton(ico_hombre, masc);
    }
    
    void grupoRadioButton() {
        grupo.add(hombre);
        grupo.add(mujer);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        sueldo = new javax.swing.JTextField();
        hombre = new javax.swing.JRadioButton();
        mujer = new javax.swing.JRadioButton();
        accept = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        ico_hombre = new javax.swing.JLabel();
        icon_mujer = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("DATOS DEL EMPLEADO");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("NOMBRE");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("SUELDO");

        nombre.setFont(new java.awt.Font("Comic Sans MS", 2, 16)); // NOI18N
        nombre.setForeground(new java.awt.Color(102, 102, 102));
        nombre.setBorder(null);
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });

        sueldo.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        sueldo.setForeground(new java.awt.Color(102, 102, 102));
        sueldo.setBorder(null);
        sueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sueldoActionPerformed(evt);
            }
        });

        hombre.setText("H");
        hombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hombreActionPerformed(evt);
            }
        });

        mujer.setText("M");
        mujer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mujerActionPerformed(evt);
            }
        });

        accept.setText("ACEPTAR");
        accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptActionPerformed(evt);
            }
        });

        cancel.setText("VOLVER");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("SEXO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(accept))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ico_hombre, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(icon_mujer, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mujer)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(sueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ico_hombre, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(icon_mujer, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(hombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(mujer, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel)
                    .addComponent(accept))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void sueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sueldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sueldoActionPerformed

    private void acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptActionPerformed
        Empleado emp;
        String sueldoString = this.sueldo.getText();
        String nombreString = this.nombre.getText();
        
        
        
        if (nombreString.equals("")) {
            ventPrinc.getError().play(); //LLAMO AL SONIDO DE ERROR DE LA VENTANA PRINCIPAL
            JOptionPane.showMessageDialog(this, "INTRODUZCA UN NOMBRE", "ERROR", JOptionPane.ERROR_MESSAGE);
            
        } else if (sueldoString.equals("")) {
            ventPrinc.getError().play(); //LLAMO AL SONIDO DE ERROR DE LA VENTANA PRINCIPAL
            JOptionPane.showMessageDialog(this, "INTRODUZCA UN SUELDO", "ERROR", JOptionPane.ERROR_MESSAGE);
            
        } else if (!hombre.isSelected() && !mujer.isSelected()) {
            ventPrinc.getError().play(); //LLAMO AL SONIDO DE ERROR DE LA VENTANA PRINCIPAL
            JOptionPane.showMessageDialog(this, "INTRODUZCA EL SEXO", "ERROR", JOptionPane.ERROR_MESSAGE);
            
        } else {
            try {
                sueldoFloat = Float.parseFloat(sueldoString);
            } catch (NumberFormatException e) {
                ventPrinc.getError().play(); //LLAMO AL SONIDO DE ERROR DE LA VENTANA PRINCIPAL
                JOptionPane.showMessageDialog(this, "INTRODUZCA UN VALOR NUMERICO PARA EL SUELDO", "ERROR", JOptionPane.ERROR_MESSAGE);
                
                sueldo.setText(null);
            }
            
            if (!nombre.getText().equals("") && !sueldo.getText().equals("") && (hombre.isSelected() || mujer.isSelected())) {
                if (hombre.isSelected()) {
                    sexo = "Hombre";
                } else {
                    sexo = "Mujer";
                }
                emp = new Empleado(nombreString, sueldoFloat, sexo);
                ventPrinc.getListado().add(emp);
                ventPrinc.escribirFichero();
                Collections.sort(ventPrinc.getListado());
                ventPrinc.visualizarDatos(0);
                ventPrinc.setPos(0);   //PARA QUE AL VOLVER A LA PRINCIPAL, APAREZCA EL PRIMER EMPLEADO
                
                nombre.setText("");
                sueldo.setText("");
                grupo.clearSelection();
                ventPrinc.ON_OFFBotones();
                ventPrinc.getValidar().play();  //EJECUTO EL SONIDO DE VALIDAR
                JOptionPane.showMessageDialog(this, "EMPLEADO " + nombreString + " AÑADIDO ", "CORRECTO!", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_acceptActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.ventPrinc.setVisible(true);
        ventPrinc.ON_OFFBotones();
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void hombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hombreActionPerformed
        sexo = "Hombre";
    }//GEN-LAST:event_hombreActionPerformed

    private void mujerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mujerActionPerformed
        sexo = "Mujer";
    }//GEN-LAST:event_mujerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accept;
    private javax.swing.JButton cancel;
    private javax.swing.JRadioButton hombre;
    private javax.swing.JLabel ico_hombre;
    private javax.swing.JLabel icon_mujer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton mujer;
    public static javax.swing.JTextField nombre;
    public static javax.swing.JTextField sueldo;
    // End of variables declaration//GEN-END:variables
}
