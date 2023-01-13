package com.example.mockbeantest.orderer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TestClassesOrder {
  public int value() default Integer.MAX_VALUE;
}
