import com.google.appengine.api.datastore.Email
import com.google.appengine.api.datastore.Link
import com.googlecode.objectify.Key
import pl.iogreen.confi.model.Presenter

println "Importing from ${params.importUrl ?: 'http://2012.33degree.org/speaker/list.xml'}"

def url = (params.importUrl ?: 'http://2012.33degree.org/speaker/list.xml').toURL().get()
def presenters = new XmlSlurper().parseText(url.text).speaker
println "Importing ${presenters.size()} presenters... <br />"
presenters.each {
    println "Importing presenter: ${it.@id} :: ${it.firstName.text()} ${it.lastName.text()}... "
    def existingPresenter = Presenter.search(filter: ["foreignId = ": it.@id.toLong()])
    def presenter
    if (existingPresenter) {
        println "Found matching presenter. ${existingPresenter}"
        presenter = existingPresenter[0]
        presenter.name = it.firstName.text()
        presenter.surname = it.lastName.text()
        presenter.description = it.bio.text()
    } else {
        println "New presenter created."
        presenter = new Presenter(name: it.firstName.text(), surname: it.lastName.text(), description: it.bio.text(), url: params.url as Link, email: params.email as Email, foreignId: it.@id.toLong())
    }

    if (!presenter.validate()) {
        dao.put presenter
    }

    println "<br />"
}

println "Import finished"