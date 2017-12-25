package org.example.domain;

import javax.persistence.*;

@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "person")
public class Person extends Model
{
}
