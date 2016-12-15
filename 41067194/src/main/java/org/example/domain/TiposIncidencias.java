package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tipos_incidencias")
public class TiposIncidencias extends Modelo
{
  @Column(length = 100, name = "name", nullable = false)
  private String nombre;

  TiposIncidencias()
  {
    super();
  }

  public TiposIncidencias(final String nombre)
  {
    this();

    setNombre(nombre);
  }

  public String getNombre()
  {
    return nombre;
  }

  public void setNombre(String nombre)
  {
    this.nombre = nombre;
  }
}
