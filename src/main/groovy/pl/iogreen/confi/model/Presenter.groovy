package pl.iogreen.confi.model

import com.google.appengine.api.datastore.Email
import com.google.appengine.api.datastore.Link
import groovyx.gaelyk.obgaektify.ObgaektifiableLongId
import javax.persistence.Transient
import pl.iogreen.confi.validation.Error

class Presenter extends ObgaektifiableLongId implements Serializable, Validatable {

    String name
    String surname
    String description
    Link url
    Email email
    Long foreignId

    @Transient
    String getFullName() {
        "${name} ${surname}"
    }

    @Transient
    @Override
    List<Error> validate() {
        def errors = []
        return errors
    }
}
