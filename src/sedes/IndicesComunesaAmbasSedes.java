/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sedes;

import help.RaizComun;
import java.sql.SQLException;
import archivos.Conexion;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class IndicesComunesaAmbasSedes extends RaizComun {

    private String contenidoEspecifico;

    public IndicesComunesaAmbasSedes(int idSede, String sigla) {
        getContenidoEnComun(idSede, sigla);
    }

    private void getContenidoEnComun(int idSede, String sigla) {
        try {
            Conexion conexion = new Conexion();
            if (conexion.isConexion()) {
                conexion.Execute("SELECT "
                        + " sum(papeles)  "
                        + ", sum(pap_validos)  "
                        + ", sum(pap_invalidos)"
                        + ", sum(pap_validos) *100/sum(papeles) "
                        + ", sum(pap_invalidos)*100/sum(papeles) "
                        + ", sum(imagenes) "
                        + ", sum(anversos) "
                        + ", sum(reversos) "
                        + ", sum(anversos)*100/sum(imagenes) "
                        + ", sum(reversos)*100/sum(imagenes)"
                        + ", sum(campos) "
                        + ", sum(campos_valid) "
                        + ", sum(campos_invalid)  "
                        + ", sum(campos_invalidDb) "
                        + ", sum(campos_valid) *100/sum(campos)  "
                        + ", sum(campos_invalid)*100/sum(campos)  "
                        + ", sum(campos_invalidDb)*100/sum(campos) "
                        + " FROM reporteocr_1.totales "
                        + " join volumen v "
                        + " on v.id = totales.idVolumen "
                        + " where totales.idsede =" + idSede
                        + " and v.estado = 1;");

                while (conexion.resultado.next()) {
                    papeles = (conexion.resultado.getInt(1));
                    papeles_validos = (conexion.resultado.getInt(2));
                    papeles_invalidos = (conexion.resultado.getInt(3));

                    porc_pap_validos = (conexion.resultado.getDouble(4));
                    porc_pap_invalidos = (conexion.resultado.getDouble(5));

                    imagenes = conexion.resultado.getInt(6);
                    anversos = (conexion.resultado.getInt(7));
                    reversos = (conexion.resultado.getInt(8));
                    porc_anversos = (conexion.resultado.getDouble(9));
                    porc_reversos = (conexion.resultado.getDouble(10));

                    campos = (conexion.resultado.getInt(11));
                    campos_valid = (conexion.resultado.getInt(12));
                    campos_invalid = (conexion.resultado.getInt(13));
                    campos_invaliddb = (conexion.resultado.getInt(14));

                    porc_campos_valid = (conexion.resultado.getDouble(15));
                    porc_campos_invalid = (conexion.resultado.getDouble(16));
                    porc_campos_invaliddb = (conexion.resultado.getDouble(17));
                }
            }
            setContenidoEspecifico(sigla);
            conexion.desconectar();
        } catch (SQLException ex) {
            //todo joptionpane
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    IndicesComunesaAmbasSedes.class.getName(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setContenidoEspecifico(String sigla) {
        switch (sigla) {
            case "GNA":
                GetCamposGNA gna = new GetCamposGNA(" where i.idSede=1");
                contenidoEspecifico = gna.toString();
                break;
            case "OSN":
                GetCamposOSN osn = new GetCamposOSN(" where i.idSede =2");
                contenidoEspecifico = osn.toString();
                break;
        }
    }

    public String getContenido() {
        return toString() + ", " + contenidoEspecifico;
    }
}
