package com.nasa.robot.external.validation;

public interface Spec<T> {

    boolean isValid(T validable);

    String getMessage();
}
