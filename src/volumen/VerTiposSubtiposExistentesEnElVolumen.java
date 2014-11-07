/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package volumen;

import archivos.Conexion;
import entidades.TiposDoc;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class VerTiposSubtiposExistentesEnElVolumen {

  public VerTiposSubtiposExistentesEnElVolumen() {
  }

  public static List<TiposDoc> getTipos(int idVolumen) {
    List<TiposDoc> tiposList = new ArrayList<>();
    TiposDoc tipodoDoc;
    try
      {
      Conexion conexion = new Conexion();

      if (conexion.isConexion())
        {
        String query = "select c.tipo_doc "
                + ", count(c.tipo_doc)  "
                + ",  count(c.tipo_doc)*100/v.cantidad_idcs   "
                + "from caratulas c "
                + "join volumen v "
                + "on c.idVolumen = v.id "
                + "where idvolumen = " + idVolumen
                + " group by c.tipo_doc ;";
        conexion.Execute(query);
        while (conexion.resultado.next())
          {
          String tipo = conexion.resultado.getString(1);
          int cantidad = conexion.resultado.getInt(2);
          double porcentaje = conexion.resultado.getInt(3);
          tipodoDoc = new TiposDoc(tipo, cantidad, porcentaje);
          if (!tiposList.contains(tipodoDoc))
            {
            tiposList.add(tipodoDoc);
            }
          }
        }
      conexion.desconectar();
      } catch (SQLException ex)
      {
      Logger.getLogger(VerTiposSubtiposExistentesEnElVolumen.class.getName()).log(Level.SEVERE, null, ex);
      }
    return tiposList;
  }

  public static List<TiposDoc> getSubTipos(int idVolumen, int idSede) {
    List<TiposDoc> tiposList = new ArrayList<>();
    TiposDoc tipodoDoc;
    try
      {
      Conexion conexion = new Conexion();

      if (conexion.isConexion())
        {
        String query = getQuery(idSede, idVolumen);
        conexion.Execute(query);
        while (conexion.resultado.next())
          {
          String tipo = conexion.resultado.getString(1);
          int cantidad = conexion.resultado.getInt(2);
          double porcentaje = conexion.resultado.getInt(3);
          tipodoDoc = new TiposDoc(tipo, cantidad, porcentaje);
          if (!tiposList.contains(tipodoDoc))
            {
            tiposList.add(tipodoDoc);
            }
          }
        }
      conexion.desconectar();
      } catch (SQLException ex)
      {
      Logger.getLogger(VerTiposSubtiposExistentesEnElVolumen.class.getName()).log(Level.SEVERE, null, ex);
      }
    return tiposList;
  }

  private static String getQuery(int idSede, int idVolumen) {
    String ret = "";
    switch (idSede)
      {
      case 1:
        ret = " select c.subtipo_doc "
                + "    , count(c.subtipo_doc)   "
                + "    , count(c.subtipo_doc)*100/ "
                + "    (select  "
                + "    count(c.subtipo_doc)  "
                + "    from caratulas c  "
                + "    join volumen v "
                + "    on c.idVolumen = v.id "
                + "    where v.id =  " + idVolumen
                + "    and c.tipo_doc = 'REC'  "
                + "    order by c.subtipo_doc)  "
                + "    from caratulas c "
                + "    join volumen v "
                + "    on c.idVolumen = v.id "
                + "    where v.id =   " + idVolumen
                + "    and c.tipo_doc = 'REC' "
                + "    group by c.subtipo_doc;";
        break;
      case 2:
        ret = "select c.subtipo_doc "
                + ", count(c.subtipo_doc) as 'cantidad' "
                + ", count(c.subtipo_doc)*100/v.cantidad_idcs as 'porcentaje' "
                + "from caratulas c "
                + "join volumen v "
                + "on c.idVolumen = v.id "
                + "where v.id = " + idVolumen
                + " group by c.subtipo_doc;";
        break;
      }
    return ret;
  }
}
