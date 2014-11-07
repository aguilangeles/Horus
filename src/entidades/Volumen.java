/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class Volumen {

  private int id;
  private int idSede;
  private String ruta;
  private String sigla;
  private int cantidad_idc;
  private int estado;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getSigla() {
    return sigla;
  }

  public void setSigla(String sigla) {
    this.sigla = sigla;
  }

  public int getIdSede() {
    return idSede;
  }

  public void setIdSede(int idSede) {
    this.idSede = idSede;
  }

  public String getRuta() {
    return ruta;
  }

  public void setRuta(String ruta) {
    this.ruta = ruta;
  }

  public int getCantidad_idc() {
    return cantidad_idc;
  }

  public void setCantidad_idc(int cantidad_idc) {
    this.cantidad_idc = cantidad_idc;
  }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

  @Override
  public String toString() {
    return id + ", " + idSede + ", " + ruta + ", " + cantidad_idc+", "+ estado;
//    return id + ", " + idSede + " (" + getSigla() + "), " + ruta + ", " + cantidad_idc;
  }

  public Volumen(int id, int idSede, String ruta, int cantidad_idc, int estado) {
    this.id = id;
    this.idSede = idSede;
    this.sigla = (idSede == 1) ? "GNA" : "OSN";
    this.ruta = ruta;
    this.cantidad_idc = cantidad_idc;
    this.estado = estado;
  }
}
