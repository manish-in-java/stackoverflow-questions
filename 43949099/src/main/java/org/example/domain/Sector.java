package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Sector extends Model
{
  @Column(length = 100, name = "descripcion", nullable = false)
  private String descripcion;

  @Column(length = 3, name = "nombre", nullable = false)
  private String nombre;

  Sector()
  {
    super();
  }

  public Sector(String nombre, String descripcion)
  {
    this.descripcion = descripcion;
    this.nombre = nombre;
  }

  public String getDescripcion()
  {
    return descripcion;
  }

  public String getNombre()
  {
    return nombre;
  }
}
