/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package volumen;

import entidades.Volumen;
import help.LLamarProcesoExterno;
import help.VersionEImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Muestra la totalidad de volumenes ingresados en la base de datos
 *
 * @author aguilangeles@gmail.com
 */
public class VistaVolumenes extends javax.swing.JFrame {

    private DefineTablaVolumen tablavolumen;
    private Volumen volumenElegido;
    private GetVolumenesEnDatabase volumenesEnDatabase;
    private DefaultTableModel model;

    /**
     * Creates new form VistaVolumenes
     *
     * @param vervolumen
     */
    public VistaVolumenes(JButton vervolumen) {
        volumenesEnDatabase = new GetVolumenesEnDatabase();
        initComponents();
        VersionEImageIcon vi = new VersionEImageIcon(this, "Seleccione el volumen a mostrar");
        ppanel.setBackground(VersionEImageIcon.setcolor());
        vi.centrar(this, vervolumen);
        this.tablavolumen = new DefineTablaVolumen(tabla, volumenesEnDatabase.getVolumenList());
        this.model = tablavolumen.getModelo();
        tabla.addMouseListener(new MouseListenerForVolumen(tabla, volumenesEnDatabase, cargarnuevovol));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ppanel = new javax.swing.JPanel();
        atras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        cargarnuevovol = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        editar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        atras.setText("Atras");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Sede ", "Nombre", "cant IDCs", "Estado"
            }
        ));
        tabla.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(tabla);

        cargarnuevovol.setText("Cargar");
        cargarnuevovol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarnuevovolActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Click sobre una fila para seleccionar el volumen");

        editar.setText("Editar Estado");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ppanelLayout = new javax.swing.GroupLayout(ppanel);
        ppanel.setLayout(ppanelLayout);
        ppanelLayout.setHorizontalGroup(
            ppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ppanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(cargarnuevovol, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(ppanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ppanelLayout.setVerticalGroup(
            ppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ppanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atras)
                    .addComponent(cargarnuevovol)
                    .addComponent(editar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ppanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ppanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
      dispose();
  }//GEN-LAST:event_atrasActionPerformed

  private void cargarnuevovolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarnuevovolActionPerformed
      String mensaje = "El reporte solo sera posible si"
              + "\nel ejecutable se encuentra en la siguiente ubicacion"
              + "\n y corresponde a la siguiente version:"
              + "\n'" + VersionEImageIcon.VERSIONXML + "'";

      int selection = JOptionPane.showOptionDialog(rootPane, mensaje, "Compatibilidad de version",
              JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null//icono
              , new Object[]{
                  "Continuar", "Cancelar"
              }, "Continuar");
      if (selection != -1) {
          int selec = selection + 1;
          switch (selec) {
              case 1:
                  new LLamarProcesoExterno();
                  dispose();
                  break;
              case 2:
                  //cancele, no hago nada
                  break;
          }
      }
  }//GEN-LAST:event_cargarnuevovolActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        int seleccion;
        try {

            seleccion = Integer.parseInt(JOptionPane.showInputDialog(
                    tabla,
                    "Ingrese el id del volumen que desea desactivar",
                    JOptionPane.QUESTION_MESSAGE));  // el icono sera un iterrogante
        } catch (NumberFormatException e) {
            seleccion = Integer.parseInt(JOptionPane.showInputDialog(
                    tabla,
                    "El formato es incorrecto, por favor ingrese un numero ID",
                    JOptionPane.QUESTION_MESSAGE));  // el icono sera un iterrogante
        }
        new ControlDesactivacion(seleccion, model);

//        System.out.println("El usuario ha Fescrito " + seleccion);
    }//GEN-LAST:event_editarActionPerformed
    /**
     * @param args the command line arguments
     */
//  public static void main(String args[]) {
//    /* Set the Nimbus look and feel */
//    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//     */
//    try
//      {
//      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
//        {
//        if ("Nimbus".equals(info.getName()))
//          {
//          javax.swing.UIManager.setLookAndFeel(info.getClassName());
//          break;
//          }
//        }
//      } catch (ClassNotFoundException ex)
//      {
//      java.util.logging.Logger.getLogger(VistaVolumenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//      } catch (InstantiationException ex)
//      {
//      java.util.logging.Logger.getLogger(VistaVolumenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//      } catch (IllegalAccessException ex)
//      {
//      java.util.logging.Logger.getLogger(VistaVolumenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//      } catch (javax.swing.UnsupportedLookAndFeelException ex)
//      {
//      java.util.logging.Logger.getLogger(VistaVolumenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//      }
//    //</editor-fold>
//
//    /* Create and display the form */
////    java.awt.EventQueue.invokeLater(new Runnable() {
////      public void run() {
////        new VistaVolumenes().setVisible(true);
////      }
////    });
//  }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atras;
    private javax.swing.JButton cargarnuevovol;
    private javax.swing.JButton editar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel ppanel;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}