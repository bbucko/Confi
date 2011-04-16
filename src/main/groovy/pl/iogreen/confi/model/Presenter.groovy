package pl.iogreen.confi.model

import groovyx.gaelyk.obgaektify.ObgaektifiableLongId
import javax.persistence.Transient

class Presenter extends ObgaektifiableLongId implements Serializable {

    String name
    String surname
    String description

    @Transient
    String getFullName() {
        "${name} ${surname}"
    }
}
