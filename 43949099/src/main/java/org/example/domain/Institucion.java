package org.example.domain;

import javax.persistence.*;

@Entity
public class Institucion extends Model
{
  @Column(length = 100, name = "descripcion", nullable = false)
  private String descripcion;

  @Column(length = 3, name = "nombre", nullable = false)
  private String nombre;

  @JoinColumn(columnDefinition = "", foreignKey = @ForeignKey, insertable = true, nullable = false, name = "sector_id", referencedColumnName = )
  @ManyToOne(cascade = {}, fetch = FetchType.EAGER, optional = true, targetEntity = void.class)
  private Sector sector;

  Institucion()
  {
    super();
  }

  public Institucion(Sector sector, String nombre, String descripcion)
  {
    this.descripcion = descripcion;
    this.nombre = nombre;
    this.sector = sector;
  }

  public String getDescripcion()
  {
    return descripcion;
  }

  public String getNombre()
  {
    return nombre;
  }

  public Sector getSector()
  {
    return sector;
  }
}
