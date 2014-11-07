/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sedes;

import help.CamposConPorc_Gna;
import java.sql.SQLException;
import archivos.Conexion;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetCamposGNA extends CamposConPorc_Gna {

  public GetCamposGNA(String condicion) {
    getCampos(condicion);
  }

  private void getCampos(String condicion) {
    try
      {
      Conexion conexion = new Conexion();
      if (conexion.isConexion())
        {
        String query =
                getQuery(condicion);
        conexion.Execute(query);
        while (conexion.resultado.next())
          {
          grado_valid = conexion.resultado.getInt(1);
          grado_invalid = conexion.resultado.getInt(2);
          grado_invalidDB = conexion.resultado.getInt(3);

          porc_grado_valid = conexion.resultado.getDouble(4);
          porc_grado_invalid = conexion.resultado.getDouble(5);
          porc_grado_invalidDB = conexion.resultado.getDouble(6);

          codEst_valid = conexion.resultado.getInt(7);
          codEst_invalid = conexion.resultado.getInt(8);
          codEst_invalidDB = conexion.resultado.getInt(9);

          porc_codEst_valid = conexion.resultado.getDouble(10);
          porc_codEst_invalid = conexion.resultado.getDouble(11);
          porc_codEst_invalidDB = conexion.resultado.getDouble(12);

          nombre_valid = conexion.resultado.getInt(13);
          nombre_invalid = conexion.resultado.getInt(14);
          nombre_invalidDB = conexion.resultado.getInt(15);

          porc_nombre_valid = conexion.resultado.getDouble(16);
          porc_nombre_invalid = conexion.resultado.getDouble(17);
          porc_nombre_invalidDB = conexion.resultado.getDouble(18);

          }
        }
      conexion.desconectar();
      } catch (SQLException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(), GetCamposGNA.class.getName(), JOptionPane.ERROR_MESSAGE);
//      Logger.getLogger(GetCamposGNA.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

  private String getQuery(String condicion) {
    String query =
            "  Select  "
            + "  sum(g.grado_valid)  "
            + ", sum(g.grado_invalid) "
            + ", sum(g.grado_invalidDB) "
            + ", sum(g.grado_valid) *"
            + " 100/(sum(g.grado_valid)+sum(g.grado_invalid)+sum(g.grado_invalidDB))  "
            + ", sum(g.grado_invalid) *"
            + " 100/(sum(g.grado_valid)+sum(g.grado_invalid)+sum(g.grado_invalidDB)) "
            + ", sum(g.grado_invalidDB) "
            + "* 100/(sum(g.grado_valid)+sum(g.grado_invalid)+sum(g.grado_invalidDB)) "
            + ", sum(g.codEst_valid)  "
            + ", sum(g.codEst_invalid)  "
            + ", sum(g.codEst_invalidDB)  "
            + ", sum(g.codEst_valid) "
            + "* 100/(sum(g.grado_valid)+sum(g.grado_invalid)+sum(g.grado_invalidDB))  "
            + ", sum(g.codEst_invalid)"
            + " * 100/(sum(g.grado_valid)+sum(g.grado_invalid)+sum(g.grado_invalidDB)) "
            + ", sum(g.codEst_invalidDB)"
            + " * 100/(sum(g.grado_valid)+sum(g.grado_invalid)+sum(g.grado_invalidDB)) "
            + ", sum(g.nombre_valid)  "
            + ", sum(g.nombre_invalid)  "
            + ", sum(g.nombre_invalidDB)  "
            + ", sum(g.nombre_valid) "
            + "* 100/(sum(g.nombre_valid)+sum(g.nombre_invalid)+sum(g.nombre_invalidDB))  "
            + ", sum(g.nombre_invalid)"
            + " * 100/(sum(g.nombre_valid)+sum(g.nombre_invalid)+sum(g.nombre_invalidDB)) "
            + ", sum(g.nombre_invalidDB)"
            + " * 100/(sum(g.nombre_valid)+sum(g.nombre_invalid)+sum(g.nombre_invalidDB)) "
            + "from campos c  "
            + "join idc i "
            + "on i.id= c.ididc "
            + "join gna_metadatos g "
            + "on i.id = g.ididc "
            + condicion + " ;";
    return query;
  }
}
