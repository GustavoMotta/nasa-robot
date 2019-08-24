package com.nasa.robot.external.validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ValidationException;

@RunWith(SpringRunner.class)
@Import(SpecValidator.class)
public class SpecValidatorTest {

    @Autowired
    private SpecValidator validator;

    @Test
    public void deveChamarValidacaoSemSpec() {
        validator.run(new Foo());
    }

    @Test(expected = ValidationException.class)
    public void deveLancarErroValidacao() {
        Foo foo = new Foo();
        foo.setIdade(15);
        validator.run(foo, new ValidaFooIdadeSpec());
    }

    @Test
    public void naoDeveLancarErroValidacao() {
        Foo foo = new Foo();
        foo.setIdade(18);
        validator.run(foo, new ValidaFooIdadeSpec());
    }

    private static final class ValidaFooIdadeSpec implements Spec<Foo> {
        @Override
        public boolean isValid(Foo validable) {
            return validable.getIdade() > 17;
        }

        @Override
        public String getMessage() {
            return "Menor de idade";
        }
    }

    private static final class Foo implements Validable {

        private int idade;

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }
    }

}