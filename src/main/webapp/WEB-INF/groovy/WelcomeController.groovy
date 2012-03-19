import pl.iogreen.confi.model.Talk

request.title = "ConfiSchedule"
request.footer = "Footer"

final now = new Date()
final today = new Date().clearTime()
final tomorrow = today + 1.day

final String cacheKey = "todayTalks${today.time}"
if (!(cacheKey in memcache)) {
    log.info "Cache miss for ${cacheKey}"
    memcache[cacheKey] = Talk.search(filter: ["from >=": today, "from <": tomorrow], sort: ["from", "title"])
}

final nextTalks = Talk.search(filter: ["from >=": now], sort: ["from", "title"], limit: 5)
def nowTalking

try {
    nowTalking = memcache[cacheKey].findAll {Talk talk -> talk.from <= now && talk.to > now }
} catch (Exception ex) {
    log.info("Exception occured while retrieving stuff from memcache")
    memcache[cacheKey] = Talk.search(filter: ["from >=": today, "from <": tomorrow], sort: ["from", "title"])
    nowTalking = memcache[cacheKey].findAll {Talk talk -> talk.from <= now && talk.to > now }
}


request.nowTalking = nowTalking
request.nextTalks = nextTalks
forward '/WEB-INF/views/index.gtpl'