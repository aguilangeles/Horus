/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package volumen;

import archivos.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetTipoSubtipoVolumen {

  public static List<String> tiposList(int idVolumen) {
    List<String> lista = new ArrayList<>();
    try
      {
      Conexion conexion = new Conexion();
      if (conexion.isConexion())
        {
        String query = "select distinct(c.tipo_doc) "
                + "    , sum(i.imagenes) 'imagenes por tipo' "
                + "    from caratulas c  "
                + "    join idc i "
                + "    on c.idIdc = i.id "
                + "    where c.idVolumen = " + idVolumen
                + "    group by c.tipo_doc; ";
        conexion.Execute(query);
        while (conexion.resultado.next())
          {
          String tipo_doc = conexion.resultado.getString(1);
          int cantidad = conexion.resultado.getInt(2);
          String resultado = ", Tipo " + tipo_doc + "=" + cantidad;
          lista.add(resultado);
          }
        }
      conexion.desconectar();
      } catch (SQLException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(), GetTipoSubtipoVolumen.class.getName(), JOptionPane.ERROR_MESSAGE);
//      Logger.getLogger(ConsultaGenerica.class.getName()).log(Level.SEVERE, null, ex);
      }
    return lista;
  }

  public static List<String> subTiposList(int idVolumen, int idSede) {
    List<String> lista = new ArrayList<>();
    try
      {
      Conexion conexion = new Conexion();
      if (conexion.isConexion())
        {
        String query = "select distinct "
                + "(c.subtipo_doc) "
                + ", sum(i.imagenes)  "
                + "from "
                + "caratulas c "
                + "join "
                + "idc i ON c.idIdc = i.id "
                + "where "
                + "c.idVolumen = " + idVolumen
                + getcondicion(idSede)
                + "group by c.subtipo_doc; ";
        conexion.Execute(query);
        while (conexion.resultado.next())
          {
          int subtipo_doc = conexion.resultado.getInt(1);
          int cantidad = conexion.resultado.getInt(2);
          String resultado = ", subtipo " + subtipo_doc + "=" + cantidad;
          lista.add(resultado);
          }
        }
      conexion.desconectar();
      } catch (SQLException ex)
      {
      Logger.getLogger(GetTipoSubtipoVolumen.class.getName()).log(Level.SEVERE, null, ex);
      }
    return lista;
  }

  private static String getcondicion(int idSede) {
    String ret = (idSede == 1) ? " and c.tipo_doc = 'REC' " : " ";
    return ret;
  }
}
