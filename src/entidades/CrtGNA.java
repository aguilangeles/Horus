/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class CrtGNA {

  private int id;
  private String nombre;
  private String estado;
  private String tipo;
  private int subtipo;
  private String id_C1;
  private String caja;
  private String anio;
  private String mes;
  private String liquidacion;
  private String unidad;
  private String id_C2;
  private String id_C3;
  private String id_C4;

  public CrtGNA(int id, String nombre, String estado, String tipo, int subtipo,
          String id_C1, String caja, String anio, String mes, String liquidacion,
          String unidad, String id_C2, String id_C3, String id_C4) {
    this.id = id;
    this.nombre = nombre;
    this.estado = estado;
    this.tipo = tipo;
    this.subtipo = subtipo;
    this.id_C1 = id_C1;
    this.caja = caja;
    this.anio = anio;
    this.mes = mes;
    this.liquidacion = liquidacion;
    this.unidad = unidad;
    this.id_C2 = id_C2;
    this.id_C3 = id_C3;
    this.id_C4 = id_C4;
  }

  public int getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public String getTipo() {
    return tipo;
  }

  public int getSubtipo() {
    return subtipo;
  }

  public String getId_C1() {
    return id_C1;
  }

  public String getCaja() {
    return caja;
  }

  public String getAnio() {
    return anio;
  }

  public String getMes() {
    return mes;
  }

  public String getLiquidacion() {
    return liquidacion;
  }

  public String getUnidad() {
    return unidad;
  }

  public String getId_C2() {
    return id_C2;
  }

  public String getId_C3() {
    return id_C3;
  }

  public String getId_C4() {
    return id_C4;
  }

  @Override
  public String toString() {
    return id
            + ", " + nombre
            + ", " + estado
            + ", " + tipo
            + ", " + subtipo
            + ", " + id_C1
            + ", " + caja
            + ", " + anio
            + ", " + mes
            + ", " + liquidacion
            + ", " + unidad
            + ", " + id_C2
            + ", " + id_C3
            + ", " + id_C4;
  }
  public static String titulos() {
    String ret = "id , nombre , estado , tipo ,  subtipo , id_c1 , caja , anio ,"
            + " mes , liquidacion , unidad , id_c2 , id_c3 , id_c4";
    return ret;
  }
}
