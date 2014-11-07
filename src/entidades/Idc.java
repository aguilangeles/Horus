/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class Idc {

  private int id;
  private String nombre;
  private String estado;
  private String tipo;
  private int subtipo;

  public Idc(int id, String nombre, String estado, String tipo, int subtipo) {
    this.id = id;
    this.nombre = nombre;
    this.estado = estado;
    this.tipo = tipo;
    this.subtipo = subtipo;
  }

  @Override
  public String toString() {
    return id
            + ", " + nombre
            + ", " + estado
            + ", " + tipo
            + ", " + subtipo;
  }
}
