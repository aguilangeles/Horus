/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sedes;

import help.TablaGenerica;
import javax.swing.JTable;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class DefineTablaContenidosGenerales extends TablaGenerica {

  public DefineTablaContenidosGenerales(JTable tabla, String contenido) {
    super(contenido);
    tabla.setModel(getModel());
  }
}
