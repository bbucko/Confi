import pl.iogreen.confi.model.Talk

request.title = "Welcome to 33rd Degree 2012"
request.footer = "Footer"

final now = new Date()
final today = new Date().clearTime()
final tomorrow = (new Date() + 1.day).clearTime()

def previousTalksToday = Talk.search(filter: ["from >=": today, "from <=": now], sort: ["from", "title"])
def nextTalksOfDay = Talk.search(filter: ["from >=": now, "from <": tomorrow], sort: ["from", "title"], limit: 3)

request.nowTalking = previousTalksToday.findAll {Talk talk -> talk.to.after(now)}
request.nextTalks = nextTalksOfDay

log.info("${now} :: ${today} :: ${tomorrow}")

forward '/WEB-INF/views/index.gtpl'