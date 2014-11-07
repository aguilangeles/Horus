/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package idc;

import entidades.Idc;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class DefineTablaIdc {

  private List<Idc> listaIdc;
  private int idSede;

  public DefineTablaIdc(JTable tabla, List<Idc> lista) {
    this.listaIdc = lista;
    DefaultTableModel modelo = getModel();
    tabla.setModel(modelo);
    tabla.getColumnModel().getColumn(0).setPreferredWidth(25);
    tabla.getColumnModel().getColumn(1).setPreferredWidth(300);
  }

  private DefaultTableModel getModel() {
    DefaultTableModel modelo1 = new DefaultTableModel() {
      @Override
      public boolean isCellEditable(int fila, int columna) {
        return false;
      }
    };
    setColumnas(modelo1);
    setContenido(modelo1);
    return modelo1;
  }

  private void setContenido(DefaultTableModel model) {
    for (Idc idc : listaIdc)
      {
      setStringContenido(idc.toString(), model);
      }
  }

  private void setStringContenido(String contenido, DefaultTableModel model) {
    String[] split = contenido.split(", ");
    model.addRow(new Object[]
      {
      split[0], split[1], split[2], split[3], split[4]
      });
  }

  private void setColumnas(DefaultTableModel modelo1) {
    modelo1.addColumn("Id");
    modelo1.addColumn("Nombre");
    modelo1.addColumn("Estado");
    modelo1.addColumn("Tipo");
    modelo1.addColumn("SubTipo");
  }
}
