/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package help;

/**
 * agrego nombre como campo de gna
 *
 * @author aguilangeles@gmail.com
 */
public class CamposConPorc_Gna {

  protected int codEst_invalid;
  protected int codEst_invalidDB;
  protected int codEst_valid;
  protected int grado_invalid;
  protected int grado_invalidDB;
  protected int grado_valid;
  protected int nombre_invalid;
  protected int nombre_invalidDB;
  protected int nombre_valid;
  //
  protected double porc_codEst_invalid;
  protected double porc_codEst_invalidDB;
  protected double porc_codEst_valid;
  protected double porc_grado_invalid;
  protected double porc_grado_invalidDB;
  protected double porc_grado_valid;
  protected double porc_nombre_invalid;
  protected double porc_nombre_invalidDB;
  protected double porc_nombre_valid;

  @Override
  public String toString() {
    String porcent = " %";
    return "Grado valid=" + grado_valid
            + ", Grado invalid=" + grado_invalid
            + ", Grado invalidDB=" + grado_invalidDB
            + ", Porc grado valid=" + porc_grado_valid + porcent
            + ", Porc grado invalid=" + porc_grado_invalid + porcent
            + ", Porc grado invalidDB=" + porc_grado_invalidDB + porcent
            + ", CodEst valid=" + codEst_valid
            + ", CodEst invalid=" + codEst_invalid
            + ", CodEst invalidDB=" + codEst_invalidDB
            + ", Porc codEst valid=" + porc_codEst_valid + porcent
            + ", Porc codEst invalid=" + porc_codEst_invalid + porcent
            + ", Porc codEst invalidDB=" + porc_codEst_invalidDB + porcent
            + ", Nombre valid=" + nombre_valid
            + ", Nombre invalid=" + nombre_invalid
            + ", Nombre invalidDB=" + nombre_invalidDB
            + ", Porc nombre valid=" + porc_nombre_valid + porcent
            + ", Porc nombre invalid=" + porc_nombre_invalid + porcent
            + ", Porc nombre invalidDB=" + porc_nombre_invalidDB + porcent;
  }
}
