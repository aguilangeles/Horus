/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package idc;

import archivos.Conexion;
import help.CamposConPorc_Osn;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetIdcFromOSN extends CamposConPorc_Osn {

  private int campos;

  public GetIdcFromOSN(String condicion) {
    getcamposOsn(condicion);
  }

  private void getcamposOsn(String condicion) {
    try
      {
      Conexion conexion = new Conexion();
      if (conexion.isConexion())
        {
        String query = "SELECT "
                + "campos.campos,            "
                + "osn.distrito_valid, "
                + "osn.distrito_invalid, "
                + "osn.partida_valid, "
                + "osn.partida_invalid, "
                + "osn.subcuenta_valid, "
                + "osn.subcuenta_invalid, "
                + "osn.digito_valid, "
                + "osn.digito_invalid, "
                + "osn.anio_valid, "
                + "osn.anio_invalid, "
                + "osn.bimestre_valid, "
                + "osn.bimestre_invalid "
                + "FROM osn_metadatos osn "
                + "join idc idc "
                + "on idc.id = osn.idIdc "
                + "join campos campos "
                + "on campos.idIdc = idc.id "
                + "where idc.nombre_idc = '" + condicion + "';";
        conexion.Execute(query);
        while (conexion.resultado.next())
          {
          campos = conexion.resultado.getInt(1);
          distrito_valid = conexion.resultado.getInt(2);
          distrito_invalid = conexion.resultado.getInt(3);
          partida_valid = conexion.resultado.getInt(4);
          partida_invalid = conexion.resultado.getInt(5);
          subcuenta_valid = conexion.resultado.getInt(6);
          subcuenta_invalid = conexion.resultado.getInt(7);
          digito_valid = conexion.resultado.getInt(8);
          digito_invalid = conexion.resultado.getInt(9);
          anio_valid = conexion.resultado.getInt(10);
          anio_invalid = conexion.resultado.getInt(11);
          bimestre_valid = conexion.resultado.getInt(12);
          bimestre_invalid = conexion.resultado.getInt(13);
          }
        }
      conexion.desconectar();
      } catch (SQLException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(),
              GetIdcFromOSN.class.getName(), JOptionPane.ERROR_MESSAGE);
      }
  }

  @Override
  public String toString() {
    return "Campos=" + campos
            + ", Distrito_valid=" + distrito_valid
            + ", Distrito_invalid=" + distrito_invalid
            + ", Partida_valid=" + partida_valid
            + ", Partida_invalid=" + partida_invalid
            + ", Subcuenta_valid=" + subcuenta_valid
            + ", Subcuenta_invalid=" + subcuenta_invalid
            + ", Digito_valid=" + digito_valid
            + ", Digito_invalid=" + digito_invalid
            + ", Anio_valid=" + anio_valid
            + ", Anio_invalid=" + anio_invalid
            + ", Bimestre_valid=" + bimestre_valid
            + ", Bimestre_invalid=" + bimestre_invalid;
  }
}
