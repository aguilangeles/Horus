/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volumen;

import archivos.Conexion;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Maria
 */
class ControlDesactivacion {

    public ControlDesactivacion(int integer, DefaultTableModel model) {
        Conexion conexion = new Conexion();
        int lastIDvolumen = new GetLastId(conexion).getLastidVolume();
        if (integer <= lastIDvolumen) {
            int idvolumen = integer;
            Desactivar desactivar = new Desactivar(conexion, model, idvolumen);
            if (desactivar.modificarEstado()) {
                JOptionPane.showMessageDialog(null, "Cambio de estado exitoso"
                        + "\n Vuelva a cargar la pantalla", "Cambio de estado", JOptionPane.INFORMATION_MESSAGE);

            }
        }
        conexion.desconectar();
        System.out.println("afuera");
//        System.exit(0);
    }

}
