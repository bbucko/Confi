package pl.iogreen.confi.model

import pl.iogreen.confi.validation.Error

public interface Validatable {

    List<Error> validate()

}