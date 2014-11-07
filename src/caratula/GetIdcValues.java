/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caratula;

import archivos.Conexion;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetIdcValues {

  private String name;
  private int papeles;
  private int papelesvalidos;
  private int papelesInvalidos;
  private int caratulas;
  private int imagenes;
  private int anversos;
  private int reversos;
  private String estado;
  private String resto;

  public GetIdcValues(String condicion) {
    getIdcs(condicion);
  }

  private void getIdcs(String nombre) {
    try
      {
      Conexion conexion = new Conexion();
      if (conexion.isConexion())
        {
        String query = "SELECT "
                + "nombre_idc, "
                + "papeles, "
                + "pap_validos, "
                + "pap_invalidos, "
                + "cant_caratulas, "
                + "imagenes, "
                + "anversos, "
                + "reversos, "
                + "estado "
                + "FROM idc "
                + "where nombre_idc = '" + nombre + "';";
        conexion.Execute(query);
        while (conexion.resultado.next())
          {
          name = conexion.resultado.getString(1);
          papeles = conexion.resultado.getInt(2);
          papelesvalidos = conexion.resultado.getInt(3);
          papelesInvalidos = conexion.resultado.getInt(4);
          caratulas = conexion.resultado.getInt(5);
          imagenes = conexion.resultado.getInt(6);
          anversos = conexion.resultado.getInt(7);
          reversos = conexion.resultado.getInt(8);
          estado = conexion.resultado.getString(9);
          }
        }
      conexion.desconectar();

      } catch (SQLException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(),
              GetIdcValues.class.getName(), JOptionPane.ERROR_MESSAGE);
      }
  }

  public String getName() {
    return name;
  }

  public String getShortName() {
    String[] rt = getName().split("#");
    return rt[2] + "-" + rt[3];
  }

  @Override
  public String toString() {
    return " Nombre=" + name
            + ", estado=" + estado
            + ", papeles=" + papeles
            + ", papeles_validos=" + papelesvalidos
            + ", papeles_ nvalidos=" + papelesInvalidos
            + ", caratulas=" + caratulas
            + ", imagenes=" + imagenes
            + ", anversos=" + anversos
            + ", reversos=" + reversos
            + ", ";
  }
}
