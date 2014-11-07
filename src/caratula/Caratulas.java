/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caratula;

import entidades.CrtOSN;
import entidades.CrtGNA;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import help.VersionEImageIcon;
import entidades.Volumen;
import javax.swing.JComboBox;
import sedes.ContenidoCrtParaImprimir;

/**
 * trae la totalidad de caratulas segun el id de volumen
 *
 * @author aguilangeles@gmail.com
 */
public class Caratulas extends javax.swing.JFrame {

  private final String and = "' and ca.idVolumen = ";
  private Volumen volumen;
  private GetFiltrosCombos filtros;
  private List<CrtGNA> gnaList = null;
  private List<CrtOSN> osnList = null;

  /**
   * Creates new form Caratulas
   */
  public Caratulas() {
  }

  public Caratulas(Volumen volumen) {
    initComponents();
    this.volumen = volumen;
    setFiltros(volumen);
    setExtendedState(6);
    setFrame(volumen);
    verTodasLasCaratulas(volumen);
    verCaratulasPorTipo(volumen);
    verCaratulasPorSubtipo(volumen);
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
    tablaCaratulas = new javax.swing.JTable();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    verTodos = new javax.swing.JButton();
    Guardar = new javax.swing.JButton();
    tipo = new javax.swing.JComboBox();
    jLabel3 = new javax.swing.JLabel();
    subtipo = new javax.swing.JComboBox();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    atras.setText("Atras");
    atras.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        atrasActionPerformed(evt);
      }
    });

    tablaCaratulas.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {

      }
    ));
    jScrollPane1.setViewportView(tablaCaratulas);

    jLabel1.setText("Filtro por SubTipo");

    jLabel2.setText("Ver Todos");

    verTodos.setText("Ver Todos");
    verTodos.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        verTodosActionPerformed(evt);
      }
    });

    Guardar.setText("Guardar Todos");
    Guardar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        GuardarActionPerformed(evt);
      }
    });

    tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    jLabel3.setText("Filtro por Tipo");

    subtipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    javax.swing.GroupLayout ppanelLayout = new javax.swing.GroupLayout(ppanel);
    ppanel.setLayout(ppanelLayout);
    ppanelLayout.setHorizontalGroup(
      ppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(ppanelLayout.createSequentialGroup()
        .addGap(131, 131, 131)
        .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(131, 131, 131))
      .addGroup(ppanelLayout.createSequentialGroup()
        .addGap(13, 13, 13)
        .addGroup(ppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(ppanelLayout.createSequentialGroup()
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(27, 27, 27)
            .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(78, 78, 78)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(subtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(verTodos))
          .addComponent(jScrollPane1))
        .addContainerGap())
    );
    ppanelLayout.setVerticalGroup(
      ppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ppanelLayout.createSequentialGroup()
        .addGroup(ppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(ppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ppanelLayout.createSequentialGroup()
              .addGap(12, 12, 12)
              .addGroup(ppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(subtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ppanelLayout.createSequentialGroup()
              .addContainerGap()
              .addGroup(ppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(verTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
          .addComponent(tipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
        .addGap(18, 18, 18)
        .addGroup(ppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(atras)
          .addComponent(Guardar))
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

  private void verTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verTodosActionPerformed
    verTodasLasCaratulas(volumen);
  }//GEN-LAST:event_verTodosActionPerformed

  private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
    dispose();
  }//GEN-LAST:event_atrasActionPerformed

  private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
    new ContenidoCrtParaImprimir(volumen.getIdSede(), volumen.getRuta(), gnaList, osnList, Guardar);
  }//GEN-LAST:event_GuardarActionPerformed
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
//      java.util.logging.Logger.getLogger(Caratulas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//      } catch (InstantiationException ex)
//      {
//      java.util.logging.Logger.getLogger(Caratulas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//      } catch (IllegalAccessException ex)
//      {
//      java.util.logging.Logger.getLogger(Caratulas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//      } catch (javax.swing.UnsupportedLookAndFeelException ex)
//      {
//      java.util.logging.Logger.getLogger(Caratulas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//      }
//    //</editor-fold>
//
//    /* Create and display the form */
//    java.awt.EventQueue.invokeLater(new Runnable() {
//      public void run() {
//        new Caratulas().setVisible(true);
//      }
//    });
//  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton Guardar;
  private javax.swing.JButton atras;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JPanel ppanel;
  private javax.swing.JComboBox subtipo;
  private javax.swing.JTable tablaCaratulas;
  private javax.swing.JComboBox tipo;
  private javax.swing.JButton verTodos;
  // End of variables declaration//GEN-END:variables

  private void verTodasLasCaratulas(Volumen volumen) {
    String condicion = " where i.idvolumen =" + volumen.getId();
    setListado(volumen, condicion);
    DefineCaratulasJtable allCrt = new DefineCaratulasJtable(tablaCaratulas, volumen.getIdSede(), gnaList, osnList);
  }

  private void verCaratulasPorTipo(final Volumen volumen) {
    comboActionListener(tipo, " where ca.tipo_doc = '", and, volumen);
  }

  private void verCaratulasPorSubtipo(final Volumen volumen) {
    comboActionListener(subtipo, " where ca.subtipo_doc = '", and, volumen);
  }

  private void comboActionListener(final JComboBox filtro, final String where, final String and, final Volumen volumen) {
    filtro.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String condicion = where + filtro.getSelectedItem() +
                and + volumen.getId();
        setListado(volumen, condicion);
        DefineCaratulasJtable crtByTipo = new DefineCaratulasJtable(tablaCaratulas, volumen.getIdSede(), gnaList, osnList);
      }
    });
  }

  private void setListado(Volumen volumen, String condicion) {
    switch (volumen.getSigla())
      {
      case "GNA":
        gnaList = GetCaratulaGNAList.getListForCrtGNA(condicion);
        break;
      case "OSN":
        osnList = GetCaratulaOSNList.getListForCrtOSN(condicion);
        break;
      }
  }

  private void setFiltros(Volumen volumen) {
    this.filtros = new GetFiltrosCombos(volumen);
    this.tipo.setModel(filtros.getTipoDocumento());
    this.subtipo.setModel(filtros.getSubTiposDocumento());
  }

  private void setFrame(Volumen volumen) {
    VersionEImageIcon vi = new VersionEImageIcon(this, "Crt "+volumen.getRuta());
    ppanel.setBackground(VersionEImageIcon.setcolor());
  }
}