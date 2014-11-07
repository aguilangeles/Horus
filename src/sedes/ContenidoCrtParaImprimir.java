/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sedes;

import entidades.CrtGNA;
import entidades.CrtOSN;
import help.Write;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class ContenidoCrtParaImprimir {

  public ContenidoCrtParaImprimir(int idSede, String nombre, List<CrtGNA> listaGNA, List<CrtOSN> listaOSN, JButton guardar) {
    setContenidoParaImprimir(idSede, nombre,listaGNA, listaOSN, guardar);
  }

  private void setContenidoParaImprimir(int idSede, String nombre,List<CrtGNA> listaGNA, List<CrtOSN> listaOSN, JButton guardar) {
    int contador = 1;
    switch (idSede)
      {
      case 1:
        Write.createNewSheet("Crt_"+nombre, guardar);
        Write.escribirContenido_Crt(CrtGNA.titulos(), 0);
        for (CrtGNA gna : listaGNA)
          {
          contador++;
          Write.escribirContenido_Crt(gna.toString(), contador);
          }
        break;
      case 2:
        Write.createNewSheet("Crt_"+nombre, guardar);
        Write.escribirContenido_Crt(CrtOSN.titulos(), 0);

        for (CrtOSN osn : listaOSN)
          {
          contador++;
          Write.escribirContenido_Crt(osn.toString(), contador);
          }
        break;
      }
  }


}
