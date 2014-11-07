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
public final class GetCamposParaGNAList {

  private static int grado_valid;
  private static int grado_invalid;
  private static int grado_invalidDB;
  private static int codEst_valid;
  private static int codEst_invalid;
  private static int codEst_invalidDB;
  private static int nombre_valid;
  private static int nombre_invalid;
  private static int nombre_invalidDB;
  private static double porc_grado_valid;
  private static double porc_grado_invalid;
  private static double porc_grado_invalidDB;
  private static double porc_codEst_valid;
  private static double porc_codEst_invalid;
  private static double porc_codEst_invalidDB;
  private static double porc_nombre_valid;
  private static double porc_nombre_invalid;
  private static double porc_nombre_invalidDB;
  private static int subtipo;

  public static List<String> setConsulta(int idVolumen) {
    List<String> listado = new ArrayList<>();
    try
      {
      Conexion conexion = new Conexion();
      if (conexion.isConexion())
        {
        String query =
                " select  "
                + "ca.subtipo_doc "
                + ", sum(g.grado_valid)as ' grado valid' "
                + ", sum(g.grado_invalid)as  ' grado invalid' "
                + ", sum(g.grado_invalidDB)as ' grado invalid DB' "
                + ", sum(g.grado_valid)*100/(sum(g.grado_valid)+sum(g.grado_invalid)+sum(g.grado_invalidDB)) '% g v' "
                + ", sum(g.grado_invalid)*100/(sum(g.grado_valid)+sum(g.grado_invalid)+sum(g.grado_invalidDB))'% g i '  "
                + ", sum(g.grado_invalidDB)*100/(sum(g.grado_valid)+sum(g.grado_invalid)+sum(g.grado_invalidDB))'% g i db'  "
                + ", sum(g.codEst_valid) as ' codEst valid' "
                + ", sum(g.codEst_invalid) as ' codEst invalid' "
                + ", sum(g.codEst_invalidDB) as ' codEst invalidDB' "
                + ", sum(g.codEst_valid)*100/(sum(g.grado_valid)+sum(g.grado_invalid)+sum(g.grado_invalidDB)) '% g v ' "
                + ", sum(g.codEst_invalid)*100/(sum(g.grado_valid)+sum(g.grado_invalid)+sum(g.grado_invalidDB)) '% g i ' "
                + ", sum(g.codEst_invalidDB)*100/(sum(g.grado_valid)+sum(g.grado_invalid)+sum(g.grado_invalidDB)) '% g i db' "
                + ", sum(g.nombre_valid)  "
                + ", sum(g.nombre_invalid)  "
                + ", sum(g.nombre_invalidDB) "
                + ", sum(g.nombre_valid)*100/(sum(g.nombre_valid)+sum(g.nombre_invalid)+sum(g.nombre_invalidDB)) "
                + ", sum(g.nombre_invalid)*100/(sum(g.nombre_valid)+sum(g.nombre_invalid)+sum(g.nombre_invalidDB))  "
                + ", sum(g.nombre_invalidDB)*100/(sum(g.nombre_valid)+sum(g.nombre_invalid)+sum(g.nombre_invalidDB))  "
                + " from campos c  "
                + " join gna_metadatos g "
                + " on c.idIdc = g.idIdc "
                + " join idc i "
                + " on i.id =c.idIdc "
                + " join caratulas ca "
                + " on ca.idIdc = i.id "
                + getConsultaBySede(idVolumen)
                + " group by ca.subtipo_doc ;";
        conexion.Execute(query);
        while (conexion.resultado.next())
          {
          subtipo = conexion.resultado.getInt(1);
          grado_valid = conexion.resultado.getInt(2);
          grado_invalid = conexion.resultado.getInt(3);
          grado_invalidDB = conexion.resultado.getInt(4);
          porc_grado_valid = conexion.resultado.getDouble(5);
          porc_grado_invalid = conexion.resultado.getDouble(6);
          porc_grado_invalidDB = conexion.resultado.getDouble(7);
          codEst_valid = conexion.resultado.getInt(8);
          codEst_invalid = conexion.resultado.getInt(9);
          codEst_invalidDB = conexion.resultado.getInt(10);
          porc_codEst_valid = conexion.resultado.getDouble(11);
          porc_codEst_invalid = conexion.resultado.getDouble(12);
          porc_codEst_invalidDB = conexion.resultado.getDouble(13);
          nombre_valid = conexion.resultado.getInt(14);
          nombre_invalid = conexion.resultado.getInt(15);
          nombre_invalidDB = conexion.resultado.getInt(16);
          porc_nombre_valid = conexion.resultado.getDouble(17);
          porc_nombre_invalid = conexion.resultado.getDouble(18);
          porc_nombre_invalidDB = conexion.resultado.getDouble(19);
          String resultado = getString();
          listado.add(resultado);
          }
        }
      conexion.desconectar();
      } catch (SQLException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(), GetCamposParaGNAList.class.getName(), JOptionPane.ERROR_MESSAGE);
      }
    return listado;
  }

  private static String getConsultaBySede(int idVolumen) {
    String condicion = "";
    condicion = "where i.idVolumen =" + idVolumen
            + " and ca.tipo_doc ='REC' ";
    return condicion;
  }

  private static String getString() {
    String porcent = " %";
    return "subtipo=" + subtipo
            + ", grado_valid=" + grado_valid
            + ", grado_invalid=" + grado_invalid
            + ", grado_invalidDB=" + grado_invalidDB
            + ", porc_grado_valid=" + porc_grado_valid + porcent
            + ", porc_grado_invalid=" + porc_grado_invalid + porcent
            + ", porc_grado_invalidDB=" + porc_grado_invalidDB + porcent
            + ", codEst_valid=" + codEst_valid
            + ", codEst_invalid=" + codEst_invalid
            + ", codEst_invalidDB=" + codEst_invalidDB
            + ", porc_codEst_valid=" + porc_codEst_valid + porcent
            + ", porc_codEst_invalid=" + porc_codEst_invalid + porcent
            + ", porc_codEst_invalidDB=" + porc_codEst_invalidDB + porcent
            + ", nombre_valid=" + nombre_valid
            + ", nombre_invalid=" + nombre_invalid
            + ", nombre_invalidDB=" + nombre_invalidDB
            + ", porc_nombre_valid=" + porc_nombre_valid + porcent
            + ", porc_nombre_invalid=" + porc_nombre_invalid + porcent
            + ", porc_nombre_invalidDB=" + porc_nombre_invalidDB + porcent
            + ", ";
  }
}
