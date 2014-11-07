/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package volumen;

import archivos.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class Desactivar {

    private String className = Desactivar.class.getName();
    private Conexion conexion;
    private DefaultTableModel modelo;
    private int aID, columna;
    public static final String DB_FAIL = "Error en el update Estado";

    public Desactivar(Conexion conexion, DefaultTableModel modelo, int aID) {
        this.conexion = conexion;
        this.modelo = modelo;
        this.aID = aID;
//        this.columna = columna;
    }

    private int obtenerEstado(Conexion conexion, int ide) {
        int ret = 0;
        try {
            String getEstado = "SELECT estado FROM  volumen  where id = " + aID + ";";
            System.out.println(getEstado);
            conexion.Execute(getEstado);
            while (conexion.resultado.next()) {
                int estado = conexion.resultado.getInt(1);
                if (estado == 1) {
                    ret = 2;
                } else if (estado == 2) {
                    ret = 1;
                }
            }
        } catch (SQLException ex) {
            System.out.println("=================");
            System.out.println(ex.getMessage());
            System.out.println("=================");
        }
        System.out.println("recibira estado " + ret);
        return ret;
    }

    public boolean modificarEstado() {
        int ide = -1 + aID;
        int estado = obtenerEstado(conexion, ide);
        String set = "UPDATE `reporteocr_1`.`volumen` SET `estado` =" + estado + " WHERE `id` = " + aID + ";";
        System.out.println(set);
        conexion.executeUpdate(set);
        modelo.setValueAt(estado, ide, 4);
        return true;
    }
}
