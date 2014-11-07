/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sedes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import archivos.Conexion;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetCamposParaOSNList {

  private static int distrito_valid;
  private static int distrito_invalid;
  private static int partida_valid;
  private static int partida_invalid;
  private static int subcuenta_valid;
  private static int subcuenta_invalid;
  private static int digito_valid;
  private static int digito_invalid;
  private static double porc_digito_valid;
  private static int anio_valid;
  private static int anio_invalid;
  private static int bimestre_valid;
  private static int bimestre_invalid;
  private static double porc_distrito_valid;
  private static double porc_distrito_invalid;
  private static double porc_partida_valid;
  private static double porc_partida_invalid;
  private static double porc_subc_valid;
  private static double porc_subc_invalid;
  private static double porc_digito_invalid;
  private static double porc_bimestre_valid;
  private static double porc_bimestre_invalid;
  private static double porc_anio_valid;
  private static double porc_anio_invalid;
  private static int subtipo;

  public static List<String> setconsulta(int idVolumen) {
    List<String> listado = new ArrayList<>();
    try
      {
      Conexion conexion = new Conexion();
      if (conexion.isConexion())
        {
        String query = "select  "
                + "ca.subtipo_doc "
                + ", sum(o.distrito_valid) "
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
                + " from  "
                + " campos c "
                + " join osn_metadatos o "
                + " on c.idIdc = o.idIdc "
                + " join idc  i "
                + " on i.id = c.idIdc "
                + " join caratulas ca "
                + " on ca.idIdc = i.id "
                + " where i.idVolumen =" + idVolumen
                + " group by ca.subtipo_doc";
        conexion.Execute(query);
        while (conexion.resultado.next())
          {
          subtipo = conexion.resultado.getInt(1);
          distrito_valid = conexion.resultado.getInt(2);
          distrito_invalid = conexion.resultado.getInt(3);
          porc_distrito_valid = conexion.resultado.getDouble(4);
          porc_distrito_invalid = conexion.resultado.getDouble(5);

          partida_valid = conexion.resultado.getInt(6);
          partida_invalid = conexion.resultado.getInt(7);
          porc_partida_valid = conexion.resultado.getDouble(8);
          porc_partida_invalid = conexion.resultado.getDouble(9);

          subcuenta_valid = conexion.resultado.getInt(10);
          subcuenta_invalid = conexion.resultado.getInt(11);
          porc_subc_valid = conexion.resultado.getDouble(12);
          porc_subc_invalid = conexion.resultado.getDouble(13);

          digito_valid = conexion.resultado.getInt(14);
          digito_invalid = conexion.resultado.getInt(15);
          porc_digito_valid = conexion.resultado.getDouble(16);
          porc_digito_invalid = conexion.resultado.getDouble(17);

          anio_valid = conexion.resultado.getInt(18);
          anio_invalid = conexion.resultado.getInt(19);
          porc_anio_valid = conexion.resultado.getDouble(20);
          porc_anio_invalid = conexion.resultado.getDouble(21);

          bimestre_valid = conexion.resultado.getInt(22);
          bimestre_invalid = conexion.resultado.getInt(23);
          porc_bimestre_valid = conexion.resultado.getDouble(24);
          porc_bimestre_invalid = conexion.resultado.getDouble(25);
          String resultado = getString();
          listado.add(resultado);
          }
        }
      conexion.desconectar();
      } catch (SQLException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(), GetCamposParaOSNList.class.getName(), JOptionPane.ERROR_MESSAGE);
//      Logger.getLogger(GetCamposParaOSNList.class.getName()).log(Level.SEVERE, null, ex);
      }
    return listado;
  }

  private static String getString() {
    String porc = " %";
    return "subtipo=" + subtipo
            + ", distrito_valid=" + distrito_valid
            + ", distrito_invalid=" + distrito_invalid
            + ", porc_distrito_valid=" + porc_distrito_valid + porc
            + ", porc_distrito_invalid=" + porc_distrito_invalid + porc
            + ", partida_valid=" + partida_valid
            + ", partida_invalid=" + partida_invalid
            + ", porc_partida_valid=" + porc_partida_valid + porc
            + ", porc_partida_invalid=" + porc_partida_invalid + porc
            + ", subcuenta_valid=" + subcuenta_valid
            + ", subcuenta_invalid=" + subcuenta_invalid
            + ", porc_subc_valid=" + porc_subc_valid + porc
            + ", porc_subc_invalid=" + porc_subc_invalid + porc
            + ", digito_valid=" + digito_valid
            + ", digito_invalid=" + digito_invalid
            + ", porc_digito_valid=" + porc_digito_valid + porc
            + ", porc_digito_invalid=" + porc_digito_invalid + porc
            + ", anio_valid=" + anio_valid
            + ", anio_invalid=" + anio_invalid
            + ", porc_anio_valid=" + porc_anio_valid + porc
            + ", porc_anio_invalid=" + porc_anio_invalid + porc
            + ", bimestre_valid=" + bimestre_valid
            + ", bimestre_invalid=" + bimestre_invalid
            + ", porc_bimestre_valid=" + porc_bimestre_valid + porc
            + ", porc_bimestre_invalid=" + porc_bimestre_invalid + porc + ", ";
  }
}
