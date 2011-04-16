package pl.iogreen.confi.model

import com.googlecode.objectify.Key
import groovyx.gaelyk.obgaektify.ObgaektifiableLongId
import javax.persistence.Transient

class Talk extends ObgaektifiableLongId implements Serializable {

    String title
    String description
    String shortDescription
    Date from
    Date to

    Key<Presenter> presenterKey

    @Transient
    Presenter getPresenter() {
        Presenter.fetch(presenterKey.id)
    }
}
