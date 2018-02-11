package Ventanas;

import Clases.Empleado;
import Clases.Fondo;
import Clases.GestionVisual;
import java.applet.AudioClip;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Manu
 */
public class PrincipalVisualizar extends javax.swing.JFrame {

    ObjectInputStream ficheroEntrada;
    ObjectOutputStream ficheroSalida;

    private Empleado emp;
    public static LinkedList<Empleado> listado = new LinkedList();
    private static int pos = 0;

    //IMAGENES PARA EL FONDO Y LOS BOTONES
    static ImageIcon fondo = new ImageIcon("src/img/fondo3.jpg"); //LA DECLARO ESTATICA PARA PODER USARLA EN OTRAS VENTANAS
    ImageIcon b_atras = new ImageIcon("src/img/b_atras.png");
    ImageIcon b_alante = new ImageIcon("src/img/b_alante.png");
    ImageIcon b_buscar = new ImageIcon("src/img/b_buscar1.png");
    ImageIcon b_salir = new ImageIcon("src/img/salir.png");

    //DEClARACION DE LOS OBJETOS DE TIPO AUDIOCLIP PARA LOS SONIDOS CON SUS RESPECTIVOS GETS PARA USARLOS EN LAS DEMAS VENTANAS,
    AudioClip error = java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/error.wav"));
    AudioClip validar = java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/validar.wav"));
    AudioClip elimina = java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/eliminaUsu.wav"));
    AudioClip cerrar = java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/cerrar.wav"));
    AudioClip inicio= java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/inicio.wav"));

    public AudioClip getError() {
        return error;
    }

    public AudioClip getValidar() {
        return validar;
    }

    public AudioClip getElimina() {
        return elimina;
    }

    //AGRUPACION DE BOTONES PARA NO PERMITIR MULTIPLE SELECCION.
    ButtonGroup grupo = new ButtonGroup();

    public LinkedList<Empleado> getListado() { //PARA PODER TRABAJAR CON EL LISTADO EN LAS OTRAS VENTANAS
        return listado;
    }

    public static int getPos() { //PARA POSICIONAR LA VISTA DESDE OTRAS VENTANAS O CLASES
        return pos;
    }

    public static void setPos(int pos) {//PARA POSICIONAR LA VISTA DESDE OTRAS VENTANAS O CLASES
        PrincipalVisualizar.pos = pos;
    }

    //CONSTRUCTOR DE LA VENTANA
    public PrincipalVisualizar() {
        inicio.play();
        setContentPane(new Fondo(fondo)); //IMAGEN FONDO DE LA VENTANA
        initComponents();
        this.setLocationRelativeTo(null);  //PARA QUE LA VENTANA APAREZCA CENTRADA
        this.setResizable(false);  //PARA NO PERMITIR MODIFICAR EL TAMAÑO DE LA VENTANA
        ajustarVentana();
        comprobarFichero();
        Collections.sort(listado);
        visualizarDatos(pos);
    }

    //METODO QUE LLAMA AL METODO ESTATICO DE LA CLASE GESTIONVISUAL PARA AJUSTAR LOS ICONOS AL TAMAÑO DE LOS BOTONES.
    void ajustarVentana() {
        Clases.GestionVisual.ajustarImagenABoton(atras, b_atras);
        Clases.GestionVisual.ajustarImagenABoton(alante, b_alante);
        Clases.GestionVisual.ajustarImagenABoton(bus, b_buscar);
        Clases.GestionVisual.ajustarImagenABoton(sal, b_salir);
        nombre.setEditable(false);
        sueldo.setEditable(false);
        ON_OFFBotones();
    }

    //METODO PARA LA ACTIVACION/DESACTIVACION DE LOS BOTONES.
    void ON_OFFBotones() {
        if (listado.size() > 1) {             //SI EL LISTADO TIENE CONTENIDO...
            if (pos == 0) {                   //...Y SE ENCUENTRE EN EL PRINCIPIO DEL LISTADO
                atras.setEnabled(false);
                alante.setEnabled(true);
            } else if ((pos) == (listado.size() - 1)) {//Y SE ENCUENTRE AL FINAL DEL LISTADO
                alante.setEnabled(false);
                atras.setEnabled(true);
            } else {                          //ESTE EN MEDIO DEL LISTADO
                alante.setEnabled(true);
                atras.setEnabled(true);
            }
        } else {
            alante.setEnabled(false);
            atras.setEnabled(false);
        }
    }

    //PARA COMPROBAR SI HAY UN FICHERO Y EN CASO AFIRMATIVO, CARGAR LOS DATOS EN EL ARRAY
    void comprobarFichero() {
        listado.clear();
        try {
            ficheroEntrada = new ObjectInputStream(new FileInputStream("Fichero.txt"));
            while (true) {
                emp = (Empleado) ficheroEntrada.readObject();
                listado.add(emp);
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException | ClassNotFoundException ex) {
        }
    }

    //METODO QUE 'PINTA' LOS CUADROS DE TEXTO DE LA VENTANA
    public void visualizarDatos(int pos) {
        if (!listado.isEmpty()) {
            ON_OFFBotones();
            emp = (Empleado) listado.get(pos);
            empleado.setText("DATOS DEL EMPLEADO  " + (pos + 1) + " :");
            nombre.setText(emp.getNombre());
            sueldo.setText(String.valueOf(emp.getSueldo()));
            if (emp.getSexo().equalsIgnoreCase("Hombre")) {
                GestionVisual.ajustarImagenABoton(sexo, Insertar.masc);
            } else {
                GestionVisual.ajustarImagenABoton(sexo, Insertar.fem);
            }
        }
    }

    //GUARDA LOS CAMBIOS EN EL FICHERO.
    void escribirFichero() {
        try {
            ficheroSalida = new ObjectOutputStream(new FileOutputStream("Fichero.txt", false));
            Iterator it = listado.iterator();
            while (it.hasNext()) {
                emp = (Empleado) it.next();
                ficheroSalida.writeObject(emp);
                System.out.println("añadido!");
            }
        } catch (IOException ex) {
            Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        empleado = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        sueldo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        atras = new javax.swing.JButton();
        mod = new javax.swing.JButton();
        bus = new javax.swing.JButton();
        ins = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        sal = new javax.swing.JButton();
        sexo = new javax.swing.JLabel();
        alante = new javax.swing.JButton();
        borraEmp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        empleado.setBackground(new java.awt.Color(255, 255, 0));
        empleado.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        empleado.setForeground(new java.awt.Color(0, 0, 0));
        empleado.setText("DATOS DEL EMPLEADO");

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("NOMBRE");

        nombre.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N

        sueldo.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        sueldo.setToolTipText("");
        sueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sueldoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("SUELDO");

        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });

        mod.setText(" MODIFICAR EMPLEADO");
        mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modActionPerformed(evt);
            }
        });

        bus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busActionPerformed(evt);
            }
        });

        ins.setText("INSERTAR");
        ins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("BUSCAR");

        sal.setText("SALIR");
        sal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salActionPerformed(evt);
            }
        });

        alante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alanteActionPerformed(evt);
            }
        });

        borraEmp.setText("BORRAR EMPLEADO");
        borraEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borraEmpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bus, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(alante, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(sueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(borraEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mod)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(ins, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sal, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bus, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alante, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ins)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mod)
                        .addGap(18, 18, 18)
                        .addComponent(borraEmp))
                    .addComponent(sal, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        pos--;
        ON_OFFBotones();
        visualizarDatos(pos);
    }//GEN-LAST:event_atrasActionPerformed

    private void sueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sueldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sueldoActionPerformed

    private void modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modActionPerformed

        String opciones[] = {"NOMBRE", "SUELDO", "CANCELAR"};

        if (listado.isEmpty()) {
            error.play(); //EJECUTO EL SONIDO DE ERROR 
            JOptionPane.showMessageDialog(this, "NO HAY DATOS PARA MODIFICAR", "NO HAY DATOS", JOptionPane.ERROR_MESSAGE);
        } else {
            int num = JOptionPane.showOptionDialog(this, "INDIQUE EL DATO A MODIFICAR", "MODIFICAR", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, 0);
            switch (num) {
                case (0):
                    new ModificaNombre(this);
                    this.setVisible(false);
                    break;
                case (1):
                    new ModificaSueldo(this);
                    this.setVisible(false);
                    break;
                case (2):
                    break;
            }
        }
    }//GEN-LAST:event_modActionPerformed

    private void insActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insActionPerformed
        new Insertar(this);
        this.setVisible(false);
    }//GEN-LAST:event_insActionPerformed

    private void busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busActionPerformed
        boolean encontrado = false;

        if (listado.isEmpty()) {
            error.play(); //EJECUTO EL SONIDO DE ERROR 
            JOptionPane.showMessageDialog(this, "NO HAY DATOS PARA BUSCAR", "NO HAY DATOS", JOptionPane.ERROR_MESSAGE);

        } else {
            String nombreBuscar = JOptionPane.showInputDialog(this, "INTRODUZCA EL NOMBRE A BUSCAR: ", "NOMBRE?", JOptionPane.QUESTION_MESSAGE);
            System.out.println(nombreBuscar);
            try {
                if (nombreBuscar.equals("")) {
                    error.play(); //EJECUTO EL SONIDO DE ERROR
                    JOptionPane.showMessageDialog(this, "DEBE INSERTAR UN NOMBRE", "ERROR", JOptionPane.ERROR_MESSAGE);

                } else {
                    Iterator it;
                    it = listado.iterator();
                    while (it.hasNext()) {
                        emp = (Empleado) it.next();
                        if (nombreBuscar.equalsIgnoreCase(emp.getNombre())) {
                            validar.play();
                            JOptionPane.showMessageDialog(this, nombreBuscar + " ESTA EN LA LISTA", "", JOptionPane.DEFAULT_OPTION);
                            pos = listado.indexOf(emp);
                            visualizarDatos(listado.indexOf(emp));
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        error.play(); //EJECUTO EL SONIDO DE ERROR 
                        JOptionPane.showMessageDialog(this, nombreBuscar + " NO ESTA EN LA LISTA", "", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (NullPointerException e) {

            }

        }
    }//GEN-LAST:event_busActionPerformed

    private void salActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this, "¿Desea salir de la aplicación?", "Salir de Aplicación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (opcion == JOptionPane.YES_OPTION) {
            cerrar.play();
            this.dispose();
    }//GEN-LAST:event_salActionPerformed
    }
    private void alanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alanteActionPerformed
        pos++;
        ON_OFFBotones();
        visualizarDatos(pos);
    }//GEN-LAST:event_alanteActionPerformed

    private void borraEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borraEmpActionPerformed

        try {
            emp = (Empleado) listado.get(this.pos);
            String[] opciones = {"SI", "NO"};
            int op = JOptionPane.showOptionDialog(rootPane, "¿ESTA SEGURO DE BORRAR A " + emp.getNombre() + "?", "MODIFICAR DATOS EMPLEADO", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, 0);
            if (op == 0) {
                if (listado.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "NO HAY MÁS EMPLEADOS PARA BORRAR", "NO HAY DATOS", JOptionPane.ERROR_MESSAGE);
                } else {
                    elimina.play();
                    listado.remove(pos);
                    escribirFichero();
                    comprobarFichero();
                    Collections.sort(listado);
                    pos = 0;
                    ON_OFFBotones();
                    visualizarDatos(0);
                    if (listado.size() == 0) {
                        nombre.setText("");
                        sueldo.setText("");
                        empleado.setText("DATOS DEL EMPLEADO");
                        sexo.setIcon(null);
                    }
                    System.out.println(listado.size());
                }
            }
        } catch (IndexOutOfBoundsException e) {
            error.play(); //EJECUTO EL SONIDO DE ERROR 
            JOptionPane.showMessageDialog(this, "NO HAY EMPLEADOS PARA BORRAR", "NO HAY DATOS", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_borraEmpActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalVisualizar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alante;
    private javax.swing.JButton atras;
    private javax.swing.JButton borraEmp;
    private javax.swing.JButton bus;
    private javax.swing.JLabel empleado;
    private javax.swing.JButton ins;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton mod;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton sal;
    private javax.swing.JLabel sexo;
    private javax.swing.JTextField sueldo;
    // End of variables declaration//GEN-END:variables
}
