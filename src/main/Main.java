/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import archivos.Inicio;
import javax.swing.SwingUtilities;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class Main {
/// llamar a la 
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable(){
      public void run() {
        new Inicio().setVisible(true);
      }
    });

  }
}
