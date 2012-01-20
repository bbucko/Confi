import pl.iogreen.confi.model.Talk

request.title = "ConfiSchedule"
request.footer = "Footer"

final now = new Date()
final today = new Date().clearTime()
final tomorrow = (new Date() + 1.day).clearTime()

def todayTalks = Talk.search(filter: ["from >=": today, "from <": tomorrow], sort: ["from", "title"])
def nextTalks = Talk.search(filter: ["from >=": today], sort: ["from", "title"], limit: 5)

request.nowTalking = todayTalks.findAll {Talk talk ->
    talk.from < now && talk.to > now
}
request.nextTalks = nextTalks.findAll {Talk talk ->
    talk.from > now && talk.to > now
}

log.info("${now} :: ${today} :: ${tomorrow}")

forward '/WEB-INF/views/index.gtpl'