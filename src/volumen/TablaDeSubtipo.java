/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package volumen;

import help.VersionEImageIcon;
import entidades.Volumen;
import sedes.GetCamposParaGNAList;
import sedes.GetCamposParaOSNList;
import sedes.DefineTablaContenidosGenerales;
import help.Write;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class TablaDeSubtipo extends javax.swing.JFrame {

  private DefineTablaContenidosGenerales contenidosGenerales;
  private String especifico = "";
  private Volumen volumen;

  /**
   * Creates new form TablaTipoYSubtipo
   *
   * @param volumen
   */
  public TablaDeSubtipo(Volumen volumen) {
    initComponents();
    this.volumen = volumen;
    VersionEImageIcon vi = new VersionEImageIcon(this, "Subtipos " + volumen.getRuta());
    ppanel.setBackground(VersionEImageIcon.setcolor());
    getSede(volumen.getIdSede(), volumen.getId());
    Write.createNewSheet("Subtipos " + volumen.getRuta(), guardar);
    this.contenidosGenerales = new DefineTablaContenidosGenerales(TablaTipo, especifico);
  }

  private void getSede(int idSede, int idVolumen) {
    switch (idSede)
      {
      case 1:
        for (String string : GetCamposParaGNAList.setConsulta(idVolumen))
          {
          this.especifico += string;
          }
        break;
      case 2:
        for (String string : GetCamposParaOSNList.setconsulta(idVolumen))
          {
          this.especifico += string;
          }
        break;
      }
  }

  public TablaDeSubtipo() {
    initComponents();
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
    jScrollPane1 = new javax.swing.JScrollPane();
    TablaTipo = new javax.swing.JTable();
    jButton1 = new javax.swing.JButton();
    guardar = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    TablaTipo.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Nombre", "Valor"
      }
    ));
    jScrollPane1.setViewportView(TablaTipo);

    jButton1.setText("Atras");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    guardar.setText("Guardar");
    guardar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        guardarActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout ppanelLayout = new javax.swing.GroupLayout(ppanel);
    ppanel.setLayout(ppanelLayout);
    ppanelLayout.setHorizontalGroup(
      ppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(ppanelLayout.createSequentialGroup()
        .addGap(23, 23, 23)
        .addComponent(jButton1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
        .addComponent(guardar)
        .addGap(24, 24, 24))
      .addGroup(ppanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        .addContainerGap())
    );
    ppanelLayout.setVerticalGroup(
      ppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ppanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
        .addGap(45, 45, 45)
        .addGroup(ppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jButton1)
          .addComponent(guardar))
        .addGap(39, 39, 39))
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

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    dispose();
  }//GEN-LAST:event_jButton1ActionPerformed

  private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
    Write.writeReport(especifico);
  }//GEN-LAST:event_guardarActionPerformed
  /**
   * @param args the command line arguments //
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
//      java.util.logging.Logger.getLogger(TablaTipoYSubtipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//      } catch (InstantiationException ex)
//      {
//      java.util.logging.Logger.getLogger(TablaTipoYSubtipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//      } catch (IllegalAccessException ex)
//      {
//      java.util.logging.Logger.getLogger(TablaTipoYSubtipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//      } catch (javax.swing.UnsupportedLookAndFeelException ex)
//      {
//      java.util.logging.Logger.getLogger(TablaTipoYSubtipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//      }
//    //</editor-fold>
//
//    /* Create and display the form */
//    java.awt.EventQueue.invokeLater(new Runnable() {
//      public void run() {
//        new TablaTipoYSubtipo().setVisible(true);
//      }
//    });
//  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTable TablaTipo;
  private javax.swing.JButton guardar;
  private javax.swing.JButton jButton1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JPanel ppanel;
  // End of variables declaration//GEN-END:variables
}
