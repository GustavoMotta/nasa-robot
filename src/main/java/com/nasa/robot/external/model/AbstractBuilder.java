package com.nasa.robot.external.model;

import com.nasa.robot.external.context.ContextProvider;
import com.nasa.robot.external.validation.SpecValidator;

public abstract class AbstractBuilder<T> {

    protected T bean;
    
    protected AbstractBuilder(T bean) {
        this.bean = bean;
    }

    protected void beforeBuild() {
    }

    protected void validateBeforeBuild(SpecValidator validator) {

    }

    protected void validate(SpecValidator validator) {

    }

    protected void afterBuild(){

    }

    protected T doBuild() {
        return bean;
    }

    public T build() {
        SpecValidator validator = ContextProvider.getBean(SpecValidator.class);
        beforeBuild();
        validateBeforeBuild(validator);
        T bean = doBuild();
        validate(validator);
        afterBuild();
        return bean;
    }
}
