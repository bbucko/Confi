import pl.iogreen.confi.model.Talk

request.title = "ConfiSchedule"
request.footer = "Footer"

final now = new Date()
final today = new Date().clearTime()
final tomorrow = (new Date() + 1.day).clearTime()

final String cacheKey = "todayTalks${today.time}"
if (!cacheKey in memcache) {
    log.info "Cache miss for ${cacheKey}"
    memcache[cacheKey] = Talk.search(filter: ["from >=": today, "from <": tomorrow], sort: ["from", "title"])
}

final todayTalks = memcache[cacheKey]
final nextTalks = Talk.search(filter: ["from >=": now], sort: ["from", "title"], limit: 5)

request.nowTalking = todayTalks.findAll {Talk talk -> talk.from < now && talk.to > now }
request.nextTalks = nextTalks.findAll {Talk talk -> talk.to > now }
forward '/WEB-INF/views/index.gtpl'