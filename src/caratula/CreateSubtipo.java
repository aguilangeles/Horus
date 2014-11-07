/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caratula;

import archivos.Conexion;
import entidades.Volumen;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
class CreateSubtipo {

  private Volumen volumen;

  public CreateSubtipo(Volumen volumen) {
    this.volumen = volumen;
  }

  public DefaultComboBoxModel getSubTiposDocumento() {
    DefaultComboBoxModel subtipoDocumento = new DefaultComboBoxModel();
    try
      {
      Conexion conexion = new Conexion();
      if (conexion.isConexion())
        {
        String query = getQuery();
        conexion.Execute(query);
        while (conexion.resultado.next())
          {
          Object resultado = conexion.resultado.getObject(1);
          subtipoDocumento.addElement(resultado);
          }
        }
      conexion.desconectar();
      } catch (SQLException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(),
              CreateSubtipo.class.getName(), JOptionPane.ERROR_MESSAGE);
      }
    return subtipoDocumento;
  }

  private String getQuery() {
    String ret = "";
    switch (volumen.getSigla())
      {
      case "GNA":
        ret = "select distinct ca.subtipo_doc "
                + "from caratulas ca where ca.idVolumen ="
                + volumen.getId() + " and ca.tipo_doc = 'REC' ;";
        break;
      case "OSN":
        ret = "select distinct ca.subtipo_doc "
                + "from caratulas ca where ca.idVolumen ="
                + volumen.getId();
        break;
      }
    return ret;
  }
}
