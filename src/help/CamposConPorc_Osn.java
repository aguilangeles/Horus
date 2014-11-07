/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package help;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class CamposConPorc_Osn {

  protected int anio_invalid;
  protected int anio_valid;
  protected int bimestre_invalid;
  protected int bimestre_valid;
  protected int digito_invalid;
  protected int digito_valid;
  protected int distrito_invalid;
  protected int distrito_valid;
  protected int partida_invalid;
  protected int partida_valid;
  protected double porc_anio_invalid;
  protected double porc_anio_valid;
  protected double porc_bimestre_invalid;
  protected double porc_bimestre_valid;
  protected double porc_digito_invalid;
  protected double porc_digito_valid;
  protected double porc_distrito_invalid;
  protected double porc_distrito_valid;
  protected double porc_partida_invalid;
  protected double porc_partida_valid;
  protected double porc_subc_invalid;
  protected double porc_subc_valid;
  protected int subcuenta_invalid;
  protected int subcuenta_valid;

  @Override
  public String toString() {
    String porc = " %";
    return "Distrito valid=" + distrito_valid
            + ", Distrito invalid=" + distrito_invalid
            + ", Porc distrito valid=" + porc_distrito_valid + porc
            + ", Porc distrito invalid=" + porc_distrito_invalid + porc
            + ", Partida valid=" + partida_valid
            + ", Partida invalid=" + partida_invalid
            + ", Porc partida valid=" + porc_partida_valid + porc
            + ", Porc partida invalid=" + porc_partida_invalid + porc
            + ", Subcuenta valid=" + subcuenta_valid
            + ", Subcuenta invalid=" + subcuenta_invalid
            + ", Porc subc valid=" + porc_subc_valid + porc
            + ", Porc subc invalid=" + porc_subc_invalid + porc
            + ", Digito valid=" + digito_valid
            + ", Digito invalid=" + digito_invalid
            + ", Porc digito valid=" + porc_digito_valid + porc
            + ", Porc digito invalid=" + porc_digito_invalid + porc
            + ", Anio valid=" + anio_valid
            + ", Anio invalid=" + anio_invalid
            + ", Porc anio valid=" + porc_anio_valid + porc
            + ", Porc anio invalid=" + porc_anio_invalid + porc
            + ", Bimestre valid=" + bimestre_valid
            + ", Bimestre invalid=" + bimestre_invalid
            + ", Porc bimestre valid=" + porc_bimestre_valid + porc
            + ", Porc bimestre invalid=" + porc_bimestre_invalid + porc;
  }
}
