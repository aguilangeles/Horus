/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caratula;

import entidades.CrtOSN;
import entidades.CrtGNA;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class DefineCaratulasJtable {
  private List<CrtGNA> volumenesGna;
  private List<CrtOSN> volumenesOsn;
  private int idSede;

  public DefineCaratulasJtable(JTable tabla, int idSede, List<CrtGNA> listaGNA, List<CrtOSN> listaOSN) {
    this.idSede = idSede;
    this.volumenesGna = listaGNA;
    this.volumenesOsn = listaOSN;
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

    setColumnas(modelo1, idSede);
    return modelo1;
  }

  private void setColumnas(DefaultTableModel model, int idSede) {
    switch (idSede)
      {
      case 1:
        SetModeloForGNA modeloGNA = new SetModeloForGNA(model, volumenesGna);
        break;
      case 2:
        SetModeloForOSN modeloOSN = new SetModeloForOSN(model, volumenesOsn);
        break;
      }
  }
}
