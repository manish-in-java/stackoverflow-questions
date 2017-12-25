package org.example.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue(value = "tenant_user")
@Entity
public class TenantUser extends Person
{
}
