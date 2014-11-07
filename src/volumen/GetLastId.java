/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volumen;

import archivos.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maria
 */
class GetLastId {

    private int lastidVolume;

    public GetLastId(Conexion conexion) {
        try {
            if (conexion.isConexion()) {
                conexion.Execute("Select max(id) from volumen");
                while (conexion.resultado.next()) {
                    lastidVolume = conexion.resultado.getInt(1);
                }
            }
//            conexion.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(GetLastId.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getLastidVolume() {
        return lastidVolume;
    }

}
