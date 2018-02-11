

package Clases;

import java.awt.Image;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Manu
 */
public class GestionVisual {
 
    
    //METODO QUE RECIBE UN OBJETO DE TIPO JBUTTON Y UN OBJETO TIPO ICON Y AJUSTA EL ICONO AL BOTON
    public static void ajustarImagenABoton(AbstractButton boton,ImageIcon icono){
        int alto=boton.getHeight();
        int ancho=boton.getWidth();        
        icono.setImage(icono.getImage().getScaledInstance(alto, ancho, Image.SCALE_DEFAULT));
        boton.setIcon(icono);
    }
    
    
    //SOBRECARGO EL METODO PARA PODER USARLO CON ETIQUETAS.
    public static void ajustarImagenABoton(JLabel boton,ImageIcon icono){
        int alto=boton.getHeight();
        int ancho=boton.getWidth();        
        icono.setImage(icono.getImage().getScaledInstance(alto, ancho, Image.SCALE_DEFAULT));
        boton.setIcon(icono);
    }
}

