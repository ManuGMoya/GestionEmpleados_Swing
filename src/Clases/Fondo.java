package Clases;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Fondo extends Container {

    public ImageIcon imagen;

    public Fondo(ImageIcon foto) {
        imagen = foto;
    }

    @Override
    public void paint(Graphics g) {
        Rectangle r = g.getClipBounds();
        g.setColor(this.getBackground());
        g.fillRect(r.x, r.y, r.width, r.height);
        g.drawImage(imagen.getImage(), 0, 0, this.getWidth(), this.getHeight(), this.getBackground(), this);//ajusta el tamaÃ±o a la pantalla
        super.paint(g);
    }

}
