/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package idc;

import entidades.Idc;
import archivos.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class VerIDC {

  public static List<Idc> getIdcWhere(String condicion) {
    List<Idc> idcs = new ArrayList<>();
    Idc idc;
    try
      {
      Conexion conexion = new Conexion();
      if (conexion.isConexion())
        {
        String query = "select   "
                + " i.id "
                + ", i.nombre_idc "
                + ", i.estado "
                + ", ca.tipo_doc "
                + ", ca.subtipo_doc "
                + "from idc i  "
                + "join caratulas ca "
                + "on i.id = ca.idIdc "
                + condicion + ";";
        conexion.Execute(query);
        while (conexion.resultado.next())
          {
          int id = conexion.resultado.getInt(1);
          String nombre = conexion.resultado.getString(2);
          String estado = conexion.resultado.getString(3);
          String tipo = conexion.resultado.getString(4);
          int subtipo = conexion.resultado.getInt(5);
          idc = new Idc(id, nombre, estado, tipo, subtipo);
          idcs.add(idc);
          }
        }
      conexion.desconectar();
      } catch (SQLException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(),
              VerIDC.class.getName(), JOptionPane.ERROR_MESSAGE);
      }
    return idcs;
  }
}
