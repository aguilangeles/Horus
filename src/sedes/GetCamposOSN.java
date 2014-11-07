/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sedes;

import help.CamposConPorc_Osn;
import java.sql.SQLException;
import archivos.Conexion;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetCamposOSN extends CamposConPorc_Osn {

  public GetCamposOSN(String condicion) {
    getContenidos(condicion);
  }

  private void getContenidos(String condicion) {
    try
      {
      Conexion conexion = new Conexion();
      if (conexion.isConexion())
        {
        String query = "select  "
                + "  sum(o.distrito_valid) "
                + ", sum(o.distrito_invalid) "
                + ", sum(o.distrito_valid)*100/ (sum(o.distrito_valid)+sum(o.distrito_invalid))  "
                + ", sum(o.distrito_invalid)*100/ (sum(o.distrito_valid)+sum(o.distrito_invalid)) "
                + ", sum(o.partida_valid) "
                + ", sum(o.partida_invalid) "
                + ", sum(o.partida_valid) *100/(sum(o.partida_valid)+sum(o.partida_invalid))  "
                + ", sum(o.partida_invalid)*100/(sum(o.partida_valid)+sum(o.partida_invalid))  "
                + ", sum(o.subcuenta_valid) "
                + ", sum(o.subcuenta_invalid) "
                + ", sum(o.subcuenta_valid)*100/(sum(o.subcuenta_valid)+sum(o.subcuenta_invalid))  "
                + ", sum(o.subcuenta_invalid)*100/(sum(o.subcuenta_valid)+sum(o.subcuenta_invalid))  "
                + ", sum(o.digito_valid) "
                + ", sum(o.digito_invalid)  "
                + ", sum(o.digito_valid)*100/(sum(o.digito_valid)+sum(o.digito_invalid))  "
                + ", sum(o.digito_invalid)*100/(sum(o.digito_valid)+sum(o.digito_invalid))  "
                + ", sum(o.anio_valid)   "
                + ", sum(o.anio_invalid) "
                + ", sum(o.anio_valid) *100/(sum(o.anio_valid)+sum(o.anio_invalid))  "
                + ", sum(o.anio_invalid)*100/(sum(o.anio_valid)+sum(o.anio_invalid))  "
                + ", sum(o.bimestre_valid) "
                + ", sum(o.bimestre_invalid) "
                + ", sum(o.bimestre_valid)*100/(sum(o.bimestre_valid)+sum(o.bimestre_invalid))  "
                + ", sum(o.bimestre_invalid)*100/(sum(o.bimestre_valid)+sum(o.bimestre_invalid))  "
                + "from  "
                + "campos c "
                + "join osn_metadatos o "
                + "on c.idIdc = o.idIdc "
                + "join idc  i "
                + "on i.id = c.idIdc "
                + condicion;
        conexion.Execute(query);
        while (conexion.resultado.next())
          {
          distrito_valid = conexion.resultado.getInt(1);
          distrito_invalid = conexion.resultado.getInt(2);
          porc_distrito_valid = conexion.resultado.getDouble(3);
          porc_distrito_invalid = conexion.resultado.getDouble(4);

          partida_valid = conexion.resultado.getInt(5);
          partida_invalid = conexion.resultado.getInt(6);
          porc_partida_valid = conexion.resultado.getDouble(7);
          porc_partida_invalid = conexion.resultado.getDouble(8);

          subcuenta_valid = conexion.resultado.getInt(9);
          subcuenta_invalid = conexion.resultado.getInt(10);
          porc_subc_valid = conexion.resultado.getDouble(11);
          porc_subc_invalid = conexion.resultado.getDouble(12);

          digito_valid = conexion.resultado.getInt(13);
          digito_invalid = conexion.resultado.getInt(14);
          porc_digito_valid = conexion.resultado.getDouble(15);
          porc_digito_invalid = conexion.resultado.getDouble(16);

          anio_valid = conexion.resultado.getInt(17);
          anio_invalid = conexion.resultado.getInt(18);
          porc_anio_valid = conexion.resultado.getDouble(19);
          porc_anio_invalid = conexion.resultado.getDouble(20);

          bimestre_valid = conexion.resultado.getInt(21);
          bimestre_invalid = conexion.resultado.getInt(22);
          porc_bimestre_valid = conexion.resultado.getDouble(23);
          porc_bimestre_invalid = conexion.resultado.getDouble(24);
          }
        }
      conexion.desconectar();
      } catch (SQLException ex)
      {
      JOptionPane.showConfirmDialog(null, ex.getMessage(),
              GetCamposOSN.class.getName(), JOptionPane.ERROR_MESSAGE);
      }

  }
}
