import com.googlecode.objectify.Key
import pl.iogreen.confi.model.Presenter
import pl.iogreen.confi.model.Talk

println "Importing from ${params.importUrl ?: 'http://localhost:8090/33degree_grails/talk/list.xml'}"

def url = (params.importUrl ?: 'http://localhost:8090/33degree_grails/talk/list.xml').toURL().get()
def talks = new XmlSlurper().parseText(url.text).talk.findAll {it.type == 'Talk'}
println "Importing ${talks.size()} talks... <br />"
talks.each {
    println "Importing talk: ${it.@id} :: ${it.topic.text()}... "
    def presenter = Presenter.search(filter: ["foreignId = ": it.speaker.@id.toLong()])

    if (!presenter) {
        println "No presenter found with id ${it.speaker.@id}. Import presenters before importing talks."
        return
    }
    def presenterKey = new Key<Presenter>(Presenter.class, presenter[0].id)


    def existingTalk = Talk.search(filter: ["foreignId = ": it.@id.toLong()])
    def talk
    if (existingTalk) {
        println "Found matching talk. ${existingTalk}"
        talk = existingTalk[0]
        talk.title = it.topic.text()
        talk.description = it.description.text()
        talk.presenterKey = presenterKey
    } else {
        println "New talk created."
        talk = new Talk(description: it.description.text(), title: it.topic.text(), foreignId: it.@id.toLong(), from: new Date() - 10 * 1000 * 60, to: new Date() + 10 * 1000 * 60, presenterKey: presenterKey, room: 'To')
    }

    if (!talk.validate()) {
        dao.put talk
    } else {
        talk.validate().each {println it.message}
    }

    println "<br />"
}

println "Import finished"