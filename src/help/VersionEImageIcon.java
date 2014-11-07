/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package help;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author aguilangeles@gmail.com
 */
public final class VersionEImageIcon extends JFrame {

  public static final String VERSION = "Horus 1.0.07";
  public static final String VERSIONXML = "C:\\_App\\XmlOcrStats\\XmlOcrStats_1.0.10.exe";

  public VersionEImageIcon() {
  }

  public VersionEImageIcon(JFrame frame) {
    // cambia la version y la imagen
    setImagenIcon(frame);
    frame.setTitle(VERSION);
  }

  public VersionEImageIcon(JFrame frame, String mensaje) {
    setImagenIcon(frame);
    frame.setTitle(mensaje + " " + VERSION);
  }

  public void setearMensaje(JFrame frame, String mensaje) {
    setImagenIcon(frame);
    frame.setTitle(mensaje);
  }

  public void setImagenIcon(JFrame frame) {
    String rutaImagen = "Logos\\nuevo logo sin letras UTN.png";
    ImageIcon im = new ImageIcon(rutaImagen);
    setIconImage(im.getImage());
    frame.setIconImage(im.getImage());
  }

  public static Color setcolor() {
    Color c = new Color(204, 243, 255);
    return c;
  }

  public void centrar(JFrame frame, JButton guardar) {
    Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
    int height = pantalla.height;
    int width = pantalla.width;
    frame.setLocationRelativeTo(guardar);
  }
}
