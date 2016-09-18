package org.example;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.FIELD, ElementType.PARAMETER })
@Pattern(regexp = "a@b.com")
@Size(min = 4, max = 50)
@Inherited
public @interface InheritedIdentity
{
}
