package pl.iogreen.confi.model

import com.googlecode.objectify.Key
import groovyx.gaelyk.obgaektify.ObgaektifiableLongId
import javax.persistence.Transient
import pl.iogreen.confi.validation.Error

class Talk extends ObgaektifiableLongId implements Serializable, Validatable {

    String title
    String description

    Date from
    Date to

    Key<Presenter> presenterKey

    @Transient
    Presenter getPresenter() {
        Presenter.fetch(presenterKey.id)
    }

    @Transient
    @Override
    List<Error> validate() {
        def errors = []

        if (!title) {
            errors << new Error(field: "title", message: "Title is required")
        }

        if (!description) {
            errors << new Error(field: "description", message: "Description is required")
        }

        if (!from) {
            errors << new Error(field: "from", message: "Date 'From' is required")
        }

        if (!to) {
            errors << new Error(field: "to", message: "Date 'To' is required")
        }

        if (to && from && to < from) {
            errors << new Error(field: "to", message: "Date 'To' cannot be later then from")
        }

        if(!presenterKey) {
            errors << new Error(field: "presenter", message: "Presenter is required")
        }

        return errors
    }
}
