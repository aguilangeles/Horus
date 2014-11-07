/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package volumen;

import entidades.Volumen;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

/**
 * action de acceso al contenido de un idc individual.
 *
 * @author aguilangeles@gmail.com
 */
class MouseListenerForVolumen implements MouseListener {

  private JTable tablaIdc;
  private GetVolumenesEnDatabase volumenesEnDatabas;
  private Volumen volumenElegido;
  private JButton cargarnuevo;

  public MouseListenerForVolumen() {
  }

  public MouseListenerForVolumen(JTable tablaIdc, GetVolumenesEnDatabase volumenesEnDatabas, JButton cargarnuevo) {
    this.tablaIdc = tablaIdc;
    this.volumenesEnDatabas = volumenesEnDatabas;
    this.cargarnuevo = cargarnuevo;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    int row = tablaIdc.getSelectedRow();
    if (row != -1)
      {
      volumenElegido = volumenesEnDatabas.getVolumenList().get(row);
      SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
          new PanelVolumenes(volumenElegido, cargarnuevo).setVisible(true);
        }
      });
      }
  }

  @Override
  public void mousePressed(MouseEvent e) {
    //
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    //
  }

  @Override
  public void mouseEntered(MouseEvent e) {
//
  }

  @Override
  public void mouseExited(MouseEvent e) {
//
  }
}
