/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package volumen;

import help.RaizComun;
import java.sql.SQLException;
import archivos.Conexion;
import entidades.Volumen;
import javax.swing.JOptionPane;

/**
 * Estadisticas de papeles , imagenes, tipos y subtipos de un volumen
 *
 * @author aguilangeles@gmail.com
 */
public class GetPapelesImagenesYCamposVolumen extends RaizComun {

  private String tipoCantidad = "";
  private String subTipoCantidad = "";

  public GetPapelesImagenesYCamposVolumen(Volumen volumen) {
    consulta(volumen.getId(), volumen.getIdSede());
  }

  private void consulta(int idVolumen, int sede) {
    try
      {
      Conexion conexion = new Conexion();
      if (conexion.isConexion())
        {
        String query = "select   "
                + "  se.sigla  "
                + ", t.papeles  "
                + ", t.pap_validos  "
                + ", t.pap_invalidos  "
                + ", t.pap_validos *100/t.papeles   "
                + ", t.pap_invalidos *100/t.papeles  "
                + ", t.imagenes  "
                + ", t.anversos  "
                + ", t.reversos  "
                + ", t.anversos *100/t.imagenes  "
                + ", t.reversos *100/t.imagenes  "
                + ", t.campos   "
                + ", t.campos_valid "
                + ", t.campos_invalid "
                + ", t.campos_invalidDB  "
                + ", t.campos_valid*100/t.campos   "
                + ", t.campos_invalid*100/t.campos   "
                + ", t.campos_invalidDB*100/t.campos   "
                + "from totales t  "
                + "join sedes se  "
                + "on t.idSede = se.id  "
                + "where t.idVolumen =  " + idVolumen + " ;";
        conexion.Execute(query);
        while (conexion.resultado.next())
          {
          String sigla = conexion.resultado.getString(1);
          papeles = conexion.resultado.getInt(2);
          papeles_validos = conexion.resultado.getInt(3);
          papeles_invalidos = conexion.resultado.getInt(4);
          porc_pap_validos = conexion.resultado.getDouble(5);
          porc_pap_invalidos = conexion.resultado.getDouble(6);
          imagenes = conexion.resultado.getInt(7);
          anversos = conexion.resultado.getInt(8);
          reversos = conexion.resultado.getInt(9);
          porc_anversos = conexion.resultado.getDouble(10);
          porc_reversos = conexion.resultado.getDouble(11);
          campos = conexion.resultado.getInt(12);
          campos_valid = conexion.resultado.getInt(13);
          campos_invalid = conexion.resultado.getInt(14);
          campos_invaliddb = conexion.resultado.getInt(15);
          porc_campos_valid = conexion.resultado.getDouble(16);
          porc_campos_invalid = conexion.resultado.getDouble(17);
          porc_campos_invaliddb = conexion.resultado.getDouble(18);
          }
        }
      conexion.desconectar();
      getTiposYSubtipos(idVolumen, sede);
      } catch (SQLException ex)
      {
      //todo
      JOptionPane.showMessageDialog(null, ex.getMessage(), GetPapelesImagenesYCamposVolumen.class.getName(), JOptionPane.ERROR_MESSAGE);
      }
  }

  @Override
  public String getString() {
    return toString() + tipoCantidad + subTipoCantidad;
  }

  private void getTiposYSubtipos(int idVolumen, int sede) {
    for (String s : GetTipoSubtipoVolumen.tiposList(idVolumen))
      {
      tipoCantidad += s;
      }

    for (String ss : GetTipoSubtipoVolumen.subTiposList(idVolumen, sede))
      {
      subTipoCantidad += ss;
      }
  }
}
