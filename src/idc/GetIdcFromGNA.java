/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package idc;

import archivos.Conexion;
import help.CamposConPorc_Gna;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetIdcFromGNA extends CamposConPorc_Gna {

  private int campos;

  public GetIdcFromGNA(String condicion) {
    getcamposgna(condicion);
  }

  private void getcamposgna(String condicion) {
    try
      {
      Conexion conexion = new Conexion();
      if (conexion.isConexion())
        {
        String query = "SELECT "
                + "c.campos,"
                + "gna.grado_valid, "
                + "gna.grado_invalid, "
                + "gna.grado_invalidDB, "
                + "gna.codEst_valid, "
                + "gna.codEst_invalid, "
                + "gna.codEst_invalidDB, "
                + "gna.nombre_valid, "
                + "gna.nombre_invalid, "
                + "gna.nombre_invalidDB "
                + "FROM gna_metadatos gna "
                + "join idc i "
                + "on i.id = gna.idIdc "
                + "join campos c "
                + "on c.idIdc = i.id "
                + "where i.nombre_idc ='" + condicion + "';";
        conexion.Execute(query);
        while (conexion.resultado.next())
          {
          campos = conexion.resultado.getInt(1);
          grado_valid = conexion.resultado.getInt(2);
          grado_invalid = conexion.resultado.getInt(3);
          grado_invalidDB = conexion.resultado.getInt(4);
          codEst_valid = conexion.resultado.getInt(5);
          codEst_invalid = conexion.resultado.getInt(6);
          codEst_invalidDB = conexion.resultado.getInt(7);
          nombre_valid = conexion.resultado.getInt(8);
          nombre_invalid = conexion.resultado.getInt(9);
          nombre_invalidDB = conexion.resultado.getInt(10);

          }
        }
      conexion.desconectar();
      } catch (SQLException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(), GetIdcFromGNA.class.getName(),
              JOptionPane.ERROR_MESSAGE);
      }
  }

  @Override
  public String toString() {
    return "Campos=" + campos
            + ", Grado_valid=" + grado_valid
            + ", Grado_invalid=" + grado_invalid
            + ", Grado_invalidDB=" + grado_invalidDB
            + ", CodEst_valid=" + codEst_valid
            + ", CodEst_invalidDB=" + codEst_invalidDB
            + ", CodEst_invalid=" + codEst_invalid
            + ", Nombre_valid=" + nombre_valid
            + ", Nombre_invalidDB=" + nombre_invalidDB
            + ", Nombre_invalid=" + nombre_invalid;
  }
}
