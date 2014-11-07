/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caratula;

import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import archivos.Conexion;

import entidades.Volumen;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetFiltrosCombos extends JComboBox<Object> {

  private Volumen volumen;

  public GetFiltrosCombos(Volumen volumen) {
    this.volumen = volumen;

  }

  public DefaultComboBoxModel getTipoDocumento() {
    DefaultComboBoxModel tipoDocumento = new DefaultComboBoxModel();
    try
      {
      Conexion conexion = new Conexion();
      if (conexion.isConexion())
        {
        String query = "select distinct ca.tipo_doc "
                + "from caratulas ca where ca.idVolumen ="
                + volumen.getId();
        conexion.Execute(query);
        while (conexion.resultado.next())
          {
          Object resultado = conexion.resultado.getObject(1);
          tipoDocumento.addElement(resultado);
          }
        }
      conexion.desconectar();
      } catch (SQLException ex)
      {
      JOptionPane.showMessageDialog(this, ex.getMessage(),
              GetFiltrosCombos.class.getName(), JOptionPane.ERROR_MESSAGE);
      }
    return tipoDocumento;
  }

  public DefaultComboBoxModel getSubTiposDocumento() {
    DefaultComboBoxModel subtipoDocumento =
            new CreateSubtipo(volumen).getSubTiposDocumento();
    return subtipoDocumento;
  }
}
