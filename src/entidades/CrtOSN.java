/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class CrtOSN {

  private int id;
  private String nombre;
  private String tipo_doc;
  private int subtipo_doc;
  private String id_C1;
  private int cantidad_sumarias;
  private String id_C2;
  private String caja;
  private String banco;
  private String sucursal;
  private String fecha_presentacion;
  private String id_C3;
  private String id_C4;
  private String estado;

  public CrtOSN(int id, String nombre, String estado, String tipo_doc, int subtipo_doc, String id_C1, int cantidad_sumarias, String id_C2, String caja, String banco, String sucursal, String fecha_presentacion, String id_C3, String id_C4) {
    this.id = id;
    this.nombre = nombre;
    this.estado = estado;
    this.tipo_doc = tipo_doc;
    this.subtipo_doc = subtipo_doc;
    this.id_C1 = id_C1;
    this.cantidad_sumarias = cantidad_sumarias;
    this.id_C2 = id_C2;
    this.caja = caja;
    this.banco = banco;
    this.sucursal = sucursal;
    this.fecha_presentacion = fecha_presentacion;
    this.id_C3 = id_C3;
    this.id_C4 = id_C4;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getTipo_doc() {
    return tipo_doc;
  }

  public void setTipo_doc(String tipo_doc) {
    this.tipo_doc = tipo_doc;
  }

  public int getSubtipo_doc() {
    return subtipo_doc;
  }

  public void setSubtipo_doc(int subtipo_doc) {
    this.subtipo_doc = subtipo_doc;
  }

  public String getId_C1() {
    return id_C1;
  }

  public void setId_C1(String id_C1) {
    this.id_C1 = id_C1;
  }

  public int getCantidad_sumarias() {
    return cantidad_sumarias;
  }

  public void setCantidad_sumarias(int cantidad_sumarias) {
    this.cantidad_sumarias = cantidad_sumarias;
  }

  public String getId_C2() {
    return id_C2;
  }

  public void setId_C2(String id_C2) {
    this.id_C2 = id_C2;
  }

  public String getCaja() {
    return caja;
  }

  public void setCaja(String caja) {
    this.caja = caja;
  }

  public String getBanco() {
    return banco;
  }

  public void setBanco(String banco) {
    this.banco = banco;
  }

  public String getSucursal() {
    return sucursal;
  }

  public void setSucursal(String sucursal) {
    this.sucursal = sucursal;
  }

  public String getFecha_presentacion() {
    return fecha_presentacion;
  }

  public void setFecha_presentacion(String fecha_presentacion) {
    this.fecha_presentacion = fecha_presentacion;
  }

  public String getId_C3() {
    return id_C3;
  }

  public void setId_C3(String id_C3) {
    this.id_C3 = id_C3;
  }

  public String getId_C4() {
    return id_C4;
  }

  public void setId_C4(String id_C4) {
    this.id_C4 = id_C4;
  }

  @Override
  public String toString() {
    return id
            + ", " + nombre
            + ", " + estado
            + ", " + tipo_doc
            + ", " + subtipo_doc
            + ", " + id_C1
            + ", " + cantidad_sumarias
            + ", " + id_C2
            + ", " + caja
            + ", " + banco
            + ", " + sucursal
            + ", " + fecha_presentacion
            + ", " + id_C3
            + ", " + id_C4;
  }
  public static String titulos() {
    return "id, nombre, tipo_doc, subtipo_doc, id_C1, cantidad_sumarias, id_C2, caja, banco, sucursal, fecha_presentacion, id_C3, id_C4, estado";
  }
}
