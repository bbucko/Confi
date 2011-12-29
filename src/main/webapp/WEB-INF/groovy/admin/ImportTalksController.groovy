import com.googlecode.objectify.Key
import pl.iogreen.confi.model.Presenter
import pl.iogreen.confi.model.Talk

println "Importing from ${params.importUrl ?: 'http://2012.33degree.org/talk/list.xml'}"

def talksUrl = (params.importUrl ?: 'http://2012.33degree.org/talk/list.xml').toURL().get()
def talks = new XmlSlurper().parseText(talksUrl.text).talk.findAll {it.type == 'Talk'}
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
    def dateFrom = new Date(0)
    def dateTo = new Date(0)
    def room = 'TBD'

    final String timeSlotId = it.timeslot.@id
    final String roomId = it.room.@id

    if (timeSlotId) {
        log.info "fetching http://2012.33degree.org/timeslot/show/${timeSlotId}.xml"
        def timeSlotUrl = (params.timeslotUrl ?: "http://2012.33degree.org/timeslot/show/${timeSlotId}.xml").toURL().get()
        def timeSlotXml = new XmlSlurper().parseText(timeSlotUrl.text)

        dateFrom = Date.parse("yyyy-MM-dd HH:mm:ss.SSS z", timeSlotXml.startTime.text())
        dateTo = Date.parse("yyyy-MM-dd HH:mm:ss.SSS z", timeSlotXml.endTime.text())
    }

    if (roomId) {
        log.info "fetching http://2012.33degree.org/room/show/${roomId}.xml"
        def roomUrl = (params.roomUrl ?: "http://2012.33degree.org/room/show/${roomId}.xml").toURL().get()
        def roomXml = new XmlSlurper().parseText(roomUrl.text)

        room = roomXml.name.text()
    }

    if (existingTalk) {
        println "Found matching talk. ${existingTalk}"
        talk = existingTalk[0]
        talk.title = it.topic.text()
        talk.description = it.description.text()
        talk.presenterKey = presenterKey
        talk.from = dateFrom
        talk.to = dateTo
        talk.room = room
    } else {
        println "New talk created."
        talk = new Talk(description: it.description.text(), title: it.topic.text(), foreignId: it.@id.toLong(), from: dateFrom, to: dateTo, presenterKey: presenterKey, room: room)
    }

    if (!talk.validate()) {
        dao.put talk
    } else {
        talk.validate().each {println it.message}
    }
}
println "<br />"


println "Import finished"