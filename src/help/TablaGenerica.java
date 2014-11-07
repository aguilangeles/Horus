/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package help;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class TablaGenerica {

  protected String contenido;

  public TablaGenerica(String contenido) {
    this.contenido = contenido;
  }

  protected void addRowinTable(String contenido, DefaultTableModel model) {
    String[] split = contenido.split("=");
    model.addRow(new Object[]
      {
      split[0], split[1]
      });
  }

  protected DefaultTableModel getModel() {
    DefaultTableModel modelo1 = new DefaultTableModel() {
      @Override
      public boolean isCellEditable(int fila, int columna) {
        return false;
      }
    };
    modelo1.addColumn("Detalle");
    modelo1.addColumn("Valor");
    llenarContenido(contenido, modelo1);
    return modelo1;
  }

  protected void llenarContenido(String contenido, DefaultTableModel model) {
    String[] split = contenido.split(", ");
    for (int i = 0; i < split.length; i++)
      {
      addRowinTable(split[i] + "\n", model);
      }
  }

  protected void setContenido(String contenido) {
    this.contenido = contenido;
  }
}
