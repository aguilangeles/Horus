/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package help;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class Write {

  static String xls = ".xls";
  private static  String PATHNAME = "InformeEnTxt/Reporte_" + new GetTime().getDateForTXT() + xls;
  private static HSSFSheet hoja;
  private String contenido;
  private static HSSFWorkbook libro;

  public Write() {
    libro = new HSSFWorkbook();
  }

  public static void createNewSheet(String nombre, JButton guardar) {
    try
      {
      hoja = libro.createSheet(nombre);
//      System.out.println("crando " + hoja.getSheetName());
      } catch (IllegalArgumentException e)
      {
      String exception = "The workbook already contains a sheet of this name";
      if (e.getMessage().equals(exception))
        {
          System.out.println(e.getMessage());
        guardar.setEnabled(false);
        } else
        {
        JOptionPane.showMessageDialog(null, e.getMessage(), "Error en la creacion del libro"
                + "", JOptionPane.INFORMATION_MESSAGE);
        }
      }
  }


  public static void writeReport(String contenido) {
    generarFilas(hoja, contenido);
      {
      FileOutputStream elFichero = null;
      try //      try
        {
        elFichero = new FileOutputStream(PATHNAME);
        try
          {
          libro.write(elFichero);
          } catch (IOException ex)
          {
          JOptionPane.showMessageDialog(null, ex.getMessage(), Write.class.getName(), JOptionPane.ERROR_MESSAGE);
          }
        elFichero.close();
        } catch (FileNotFoundException ex)
        {
        JOptionPane.showMessageDialog(null, ex.getMessage(), Write.class.getName(), JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex)
        {
        JOptionPane.showMessageDialog(null, ex.getMessage(), Write.class.getName(), JOptionPane.ERROR_MESSAGE);
        } finally
        {
        try
          {
          elFichero.close();
          } catch (IOException ex)
          {
          JOptionPane.showMessageDialog(null, ex.getMessage(), Write.class.getName(), JOptionPane.ERROR_MESSAGE);
          }
        }
      }
  }

  private static void escribirceldaCrt(String[] split, HSSFRow fila) {
    for (int i = 0; i < split.length; i++)
      {
      HSSFCell celda = fila.createCell(i);
      HSSFRichTextString texto = new HSSFRichTextString(split[i]);
      celda.setCellValue(texto);
      celda.getSheet().autoSizeColumn(i);

      }
  }

  public static void escribirContenido_Crt(String titulo, int row) {
    escribirTitulo(hoja, titulo, row);
      {
      FileOutputStream elFichero = null;
      try //      try
        {
        elFichero = new FileOutputStream(PATHNAME);
        try
          {
          libro.write(elFichero);
          } catch (IOException ex)
          {
          Logger.getLogger(Write.class.getName()).log(Level.SEVERE, null, ex);
          }
        elFichero.close();
        } catch (FileNotFoundException ex)
        {
        Logger.getLogger(Write.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
        Logger.getLogger(Write.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
        try
          {
          elFichero.close();
          } catch (IOException ex)
          {
          Logger.getLogger(Write.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
      }
  }

  private static void generarFilas(HSSFSheet hoja, String contenido) {
    String[] split = contenido.split(", ");
    for (int i = 0; i < split.length; i++)
      {
      getkeyValue(split[i], hoja.createRow(i));
      }
  }

  private static void escribirTitulo(HSSFSheet hoja, String titulo, int row) {
    HSSFRow fila = hoja.createRow(row);
    String[] split = titulo.split(", ");
    escribirceldaCrt(split, fila);
  }

  private static void getkeyValue(String campo, HSSFRow fila) {
    String[] split = campo.split("=");
    String titulo = split[0];
    getTexto(fila, titulo, 0);
    String valor = split[1];
    getTexto(fila, valor, 1);
  }

  private static void getTexto(HSSFRow fila, String valor, int numero) {
    HSSFCell celda = fila.createCell(numero);
    HSSFRichTextString texto = new HSSFRichTextString(valor);
    celda.setCellValue(texto);
    celda.getSheet().autoSizeColumn(numero);
  }
}
