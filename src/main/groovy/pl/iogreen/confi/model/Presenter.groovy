package pl.iogreen.confi.model

class Presenter {
    String id

    String name
    String surname
    String description

    String fullName() {
        "${name} ${surname}"
    }
}
