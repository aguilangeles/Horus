/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caratula;

import entidades.CrtOSN;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aguilangeles@gmail.com
 */
class SetModeloForOSN {

  public SetModeloForOSN(DefaultTableModel modelo1, List<CrtOSN> lista) {
    setTitulos(modelo1);
    setContenido(lista, modelo1);
  }

  private void setString(String contenido, DefaultTableModel model) {
    String[] split = contenido.split(", ");
    model.addRow(new Object[]
      {
      split[0], split[1], split[2], split[3], split[4], split[5], split[6],
      split[7], split[8], split[9], split[10], split[11], split[12], split[13]
      });
  }

  private void setTitulos(DefaultTableModel modelo1) {
    modelo1.addColumn("Id");
    modelo1.addColumn("Nombre");
    modelo1.addColumn("Estado");
    modelo1.addColumn("Tipo");
    modelo1.addColumn("SubTipo");
    modelo1.addColumn("id_c1");
    modelo1.addColumn("sumarias");
    modelo1.addColumn("id_c2");
    modelo1.addColumn("caja");
    modelo1.addColumn("banco");
    modelo1.addColumn("sucursal");
    modelo1.addColumn("fech_pres");
    modelo1.addColumn("id_c3");
    modelo1.addColumn("id_c4");
  }

  private void setContenido(List<CrtOSN> lista, DefaultTableModel modelo1) {
    for (CrtOSN o : lista)
      {
      setString(o.toString(), modelo1);
      }
  }
}
