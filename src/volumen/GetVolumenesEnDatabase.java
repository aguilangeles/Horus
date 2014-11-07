/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package volumen;

import entidades.Volumen;
import archivos.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetVolumenesEnDatabase {

  private  List<Volumen> volumenList = new ArrayList<>();

  public GetVolumenesEnDatabase() {
    getVolumenes();
  }

  private void getVolumenes() {
    Volumen volumen;
    try
      {
      Conexion conexion = new Conexion();

      if (conexion.isConexion())
        {
        String query = "SELECT"
                + " id "
                + ", idSede "
                + ", volumen "
                + ", cantidad_idcs "
                + ", estado "
                + "FROM `reporteocr_1`.`volumen` where estado = 1 ;";
        conexion.Execute(query);
        while (conexion.resultado.next())
          {
          int id = conexion.resultado.getInt(1);
          int idSede = conexion.resultado.getInt(2);
          String ruta = conexion.resultado.getString(3);
          int cantidad_idc = conexion.resultado.getInt(4);
          int estado = conexion.resultado.getInt(5);
          volumen = new Volumen(id, idSede, ruta, cantidad_idc, estado);
          if (!volumenList.contains(volumen))
            {
            volumenList.add(volumen);
            }
          }
        }
      conexion.desconectar();
      } catch (SQLException ex)
      {//todo joptionpane
        JOptionPane.showMessageDialog(null, ex.getMessage(), GetVolumenesEnDatabase.class.getName(), JOptionPane.ERROR_MESSAGE);
//      Logger.getLogger(GetVolumenesEnDatabase.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

  public  List<Volumen> getVolumenList() {
    return volumenList;
  }
}
