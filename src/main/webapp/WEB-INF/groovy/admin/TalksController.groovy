package admin

import pl.iogreen.confi.model.Talk

request.talks = Talk.search()

forward '/WEB-INF/views/admin/talks.gtpl'