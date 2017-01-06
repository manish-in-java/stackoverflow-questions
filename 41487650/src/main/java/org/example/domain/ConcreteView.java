package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "v_concrete")
public class ConcreteView extends AbstractView<ConcreteView>
{
}
