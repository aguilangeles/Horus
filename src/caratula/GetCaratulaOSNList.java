/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caratula;

import entidades.CrtOSN;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import archivos.Conexion;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetCaratulaOSNList {

  public static List<CrtOSN> getListForCrtOSN(String condicion) {
    List<CrtOSN> lista = new ArrayList<>();
    CrtOSN osncrt;
    try
      {
      Conexion conexion = new Conexion();
      if (conexion.isConexion())
        {
        String query = "select   "
                + "i.id "
                + ", i.nombre_idc "
                + ", ca.estado"
                + ", ca.tipo_doc "
                + ", ca.subtipo_doc "
                + ", ca.id_c1 "
                + ", osn.sumarias "
                + ", ca.id_c2 "
                + ", osn.caja "
                + ", osn.banco "
                + ", osn.sucursal "
                + ", osn.fecha_presentacion "
                + ", ca.id_c3 "
                + ", ca.id_c4 "
                + "from idc i  "
                + "join campos cmp "
                + "on i.id = cmp.idIdc "
                + "join caratulas ca "
                + "on i.id = ca.idIdc "
                + "join osn_crt osn "
                + "on i.id = osn.idIdc "
                + condicion;
        conexion.Execute(query);
        while (conexion.resultado.next())
          {
          int id = conexion.resultado.getInt(1);
          String nombre = conexion.resultado.getString(2);
          String estado = conexion.resultado.getString(3);
          String tipo = conexion.resultado.getString(4);
          int subtipo = conexion.resultado.getInt(5);
          String id_C1 = conexion.resultado.getString(6);
          int cantidad_sumarias = conexion.resultado.getInt(7);
          String id_C2 = conexion.resultado.getString(8);
          String caja = conexion.resultado.getString(9);
          String banco = conexion.resultado.getString(10);
          String sucursal = conexion.resultado.getString(11);
          String fecha_presentacion = conexion.resultado.getString(12);
          String id_C3 = conexion.resultado.getString(13);
          String id_C4 = conexion.resultado.getString(14);
          osncrt = new CrtOSN(id, nombre, estado,
                  tipo, subtipo,
                  id_C1, cantidad_sumarias,
                  id_C2,
                  caja, banco, sucursal, fecha_presentacion,
                  id_C3, id_C4);
          lista.add(osncrt);
          }
        }
      conexion.desconectar();
      } catch (SQLException ex)
      {
      JOptionPane.showConfirmDialog(null, ex.getMessage(), GetCaratulaOSNList.class.getName(), JOptionPane.ERROR_MESSAGE);
//      Logger.getLogger(GetCaratulaOSNList.class.getName()).log(Level.SEVERE, null, ex);
      }
    return lista;
  }
}
