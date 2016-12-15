package org.example.domain;

import javax.persistence.*;

@Entity
@Table(name = "incidencias")
public class Incidencias extends Modelo
{
  @JoinColumn(name = "tipo_id", nullable = false)
  @ManyToOne
  private TiposIncidencias tipo;

  @Column(length = 100, name = "titulo", nullable = false)
  private String titulo;

  Incidencias()
  {
    super();
  }

  public Incidencias(TiposIncidencias tipo, String titulo)
  {
    this.tipo = tipo;
    this.titulo = titulo;
  }

  public TiposIncidencias getTipo()
  {
    return tipo;
  }

  public String getTitulo()
  {
    return titulo;
  }

  public void setTitulo(String titulo)
  {
    this.titulo = titulo;
  }
}
