/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package idc;

import caratula.GetIdcValues;
import entidades.Volumen;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
//import sedes.TablaNombreValor;

/**
 * action de acceso al contenido de un idc individual.
 *
 * @author aguilangeles@gmail.com
 */
public class MouseListenerAction implements MouseListener {

  private JTable tablaIdc;
  private Volumen volumen;
//
  private static String campos;

  public MouseListenerAction() {
  }

  public MouseListenerAction(JTable tablaIdc, Volumen volumen) {
    this.tablaIdc = tablaIdc;
    this.volumen = volumen;
  }

  @Override
  public void mouseClicked(MouseEvent e) {

    String select = (String) (tablaIdc.getValueAt(tablaIdc.getSelectedRow(), 1));
    switchCampos(select);
    final GetIdcValues idc = new GetIdcValues(select);
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        String contenido = idc.toString() + campos;
        new TablaNombreValor(contenido, idc.getShortName()).setVisible(true);
      }
    });
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

  private void switchCampos(String select) {
    switch (volumen.getIdSede())
      {
      case 1:
        GetIdcFromGNA gna = new GetIdcFromGNA(select);
        campos = gna.toString();
        break;
      case 2:
        GetIdcFromOSN osn = new GetIdcFromOSN(select);
        campos = osn.toString();
        break;
      }
  }
}
