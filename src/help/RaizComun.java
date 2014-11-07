/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package help;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class RaizComun {

  protected int papeles;
  protected int papeles_validos;
  protected int papeles_invalidos;
  protected double porc_pap_validos;
  protected double porc_pap_invalidos;
  protected int imagenes;
  protected int anversos;
  protected int reversos;
  protected double porc_anversos;
  protected double porc_reversos;
  protected int campos;
  protected int campos_valid;
  protected int campos_invalid;
  protected int campos_invaliddb;
  protected double porc_campos_valid;
  protected double porc_campos_invalid;
  protected double porc_campos_invaliddb;

  public String getString() {
    return papeles
            + ", " + papeles_validos
            + ", " + papeles_invalidos
            + ", " + porc_pap_validos
            + ", " + porc_pap_invalidos
            + ", " + imagenes
            + ", " + anversos
            + ", " + reversos
            + ", " + porc_anversos
            + ", " + porc_reversos
            + ", " + campos
            + ", " + campos_valid
            + ", " + campos_invalid
            + ", " + campos_invaliddb
            + ", " + porc_campos_valid
            + ", " + porc_campos_invalid
            + ", " + porc_campos_invaliddb;
  }

  @Override
  public String toString() {
    String prc = " %";
    return "Papeles=" + papeles
            + ", Papeles validos=" + papeles_validos
            + ", Papeles invalidos=" + papeles_invalidos
            + ", Porc pap validos=" + porc_pap_validos + prc
            + ", Porc pap invalidos=" + porc_pap_invalidos + prc
            + ", Imagenes=" + imagenes
            + ", Anversos=" + anversos
            + ", Reversos=" + reversos
            + ", Porc anversos=" + porc_anversos + prc
            + ", Porc reversos=" + porc_reversos + prc
            + ", Campos=" + campos
            + ", Campos valid=" + campos_valid
            + ", Campos invalid=" + campos_invalid
            + ", Campos invaliddb=" + campos_invaliddb
            + ", Porc campos valid=" + porc_campos_valid + prc
            + ", Porc campos invalid=" + porc_campos_invalid + prc
            + ", Porc campos invaliddb=" + porc_campos_invaliddb + prc;
  }
}
