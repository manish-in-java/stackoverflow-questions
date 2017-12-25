package org.example.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue(value = "application_user")
@Entity
public class ApplicationUser extends Person
{
}
