package org.example;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class ValidationTest
{
  @Test
  public void testBeanValidationDirectly()
  {
    final List<Bean> beans = Arrays.asList(new Bean(0, null), new Bean(1000, null));

    final Set<ConstraintViolation<List<Bean>>> violations = getValidator().validate(beans);

    assertNotNull(violations);
    assertFalse(violations.isEmpty());
  }

  @Test
  public void testWrappedBeanValidation()
  {
    final Wrapper wrapper = new Wrapper(new Bean(0, null), new Bean(1000, null));

    final Set<ConstraintViolation<Wrapper>> violations = getValidator().validate(wrapper);

    assertNotNull(violations);
    assertFalse(violations.isEmpty());
  }

  private Validator getValidator()
  {
    return Validation.buildDefaultValidatorFactory().getValidator();
  }
}
