/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caratula;

import entidades.CrtGNA;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import archivos.Conexion;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetCaratulaGNAList {

  public GetCaratulaGNAList() {
  }

  public static List<CrtGNA> getListForCrtGNA(String condicion) {
    List<CrtGNA> lista = new ArrayList<>();
    CrtGNA gnaCrt;
    try
      {
      Conexion conexion = new Conexion();
      if (conexion.isConexion())
        {
        String query = "select  "
                + " i.id "
                + ", i.nombre_idc "
                + ", ca.estado "
                + ", ca.tipo_doc "
                + ", ca.subtipo_doc "
                + ", ca.id_c1 "
                + ", gna.caja "
                + ", gna.anio "
                + ", gna.mes "
                + ", gna.liquidacion "
                + ", gna.unidad "
                + ", ca.id_c2 "
                + ", ca.id_c3 "
                + ", ca.id_c4 "
                + "from idc i  "
                + "join campos cmp "
                + "on i.id = cmp.idIdc "
                + "join caratulas ca "
                + "on i.id = ca.idIdc "
                + "join gna_crt gna "
                + "on i.id = gna.idIdc "
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
          String caja = conexion.resultado.getString(7);
          String anio = conexion.resultado.getString(8);
          String mes = conexion.resultado.getString(9);
          String liquidacion = conexion.resultado.getString(10);
          String unidad = conexion.resultado.getString(11);
          String id_C2 = conexion.resultado.getString(12);
          String id_C3 = conexion.resultado.getString(13);
          String id_C4 = conexion.resultado.getString(14);

          gnaCrt = new CrtGNA(id, nombre, estado, tipo, subtipo, id_C1, caja, anio, mes, liquidacion, unidad, id_C2, id_C3, id_C4);
          lista.add(gnaCrt);
          }
        }
      conexion.desconectar();
      } catch (SQLException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(), GetCaratulaGNAList.class.getName(), JOptionPane.ERROR_MESSAGE);
//      Logger.getLogger(GetCaratulaGNAList.class.getName()).log(Level.SEVERE, null, ex);
      }
    return lista;
  }
}
