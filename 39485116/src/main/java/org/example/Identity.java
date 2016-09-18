package org.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.FIELD, ElementType.PARAMETER })
@Pattern(regexp = "a@b.com")
@Size(min = 4, max = 50)
public @interface Identity
{
}
