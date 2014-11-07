/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package help;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class LLamarProcesoExterno {

  public LLamarProcesoExterno() {
    setExe();
  }

  private static void setExe() {
    try
      {
      Process p = Runtime.getRuntime().exec(getExte());
      } catch (IOException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "Problemas al ejecutar proceso", JOptionPane.ERROR_MESSAGE);
      Logger.getLogger(LLamarProcesoExterno.class.getName()).log(Level.SEVERE, null, ex);
      /* Se lanza una excepción si no se encuentra en ejecutable o el fichero no es ejecutable. */
      }
  }

  private static String getExte() {
    String ret = "";
    File file = new File("C:\\_App\\XmlOcrStats");
    FileFilter filefilter = new FileFilter() {
      @Override
      public boolean accept(File pathname) {
        return pathname.isDirectory();
      }
    };

    if (file.exists())
      {
      File[] listoffiles = file.listFiles();
      for (int i = 0; i < listoffiles.length; i++)
        {
        File file1 = listoffiles[i];
        if (file1.getName().endsWith(".exe"))
          {
          if (file1.getAbsolutePath().equals(VersionEImageIcon.VERSIONXML))
            {
            ret = (file1.getAbsolutePath());
            }
          }
        }
      }
    return ret;
  }
}
