/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class TiposDoc {

  private String tipo_documento;
  private int cantidad;
  private double porcentaje;

  public TiposDoc(String tipo_documento, int cantidad, double porcentaje) {
    this.tipo_documento = tipo_documento;
    this.cantidad = cantidad;
    this.porcentaje = porcentaje;
  }

  public String getTipo_documento() {
    return tipo_documento;
  }

  public void setTipo_documento(String tipo_documento) {
    this.tipo_documento = tipo_documento;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public double getPorcentaje() {
    return porcentaje;
  }

  public void setPorcentaje(double porcentaje) {
    this.porcentaje = porcentaje;
  }

  @Override
  public String toString() {
    return tipo_documento + ", " + cantidad + ", " + porcentaje;
  }
}
