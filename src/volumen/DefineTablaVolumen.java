/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package volumen;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import entidades.Volumen;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class DefineTablaVolumen {

    private List<Volumen> volumenes;
    private DefaultTableModel modelo;

    public DefineTablaVolumen(JTable tabla, List<Volumen> getVolumenList) {
        this.volumenes = getVolumenList;
        modelo = getModel();
        tabla.setModel(modelo);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(40);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(242);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(40);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(40);
    }

    private DefaultTableModel getModel() {
        DefaultTableModel modelo1 = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        setColumnas(modelo1);
        setContenido(modelo1);
        return modelo1;

    }

    private void setContenido(DefaultTableModel model) {
        for (Volumen volumen : volumenes) {
            setStringContenido(volumen.toString(), model);
        }
    }

    private void setStringContenido(String contenido, DefaultTableModel model) {
        String[] split = contenido.split(", ");
        model.addRow(new Object[]{
            split[0], split[1], split[2], split[3], split[4],});
    }

    private void setColumnas(DefaultTableModel modelo1) {
        modelo1.addColumn("id");
        modelo1.addColumn("Sede");
        modelo1.addColumn("Nombre");
        modelo1.addColumn("IDCs");
        modelo1.addColumn("Est");
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

}
