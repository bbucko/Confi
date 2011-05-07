get "/", forward: "/index.groovy"

get "/presenters", forward: "/PresentersController.groovy"
get "/presenters/*", forward: "/PresentersController.groovy"

get "/presenter/@id", forward: "/PresenterController.groovy?id=@id"

get "/talks", forward: "/TalksController.groovy"
get "/talks/*", forward: "/TalksController.groovy"

get "/talk/@id", forward: "/TalkController.groovy?id=@id"

get "/admin", forward: "/admin/index.groovy"

get "/admin/talks", forward: "/admin/TalksController.groovy"

get "/admin/talk", forward: "/admin/TalkController.groovy"
post "/admin/talk", forward: "/admin/TalkController.groovy"

get "/admin/talk/@id", forward: "/admin/TalkController.groovy?id=@id"
post "/admin/talk/@id", forward: "/admin/TalkController.groovy?id=@id"

get "/admin/presenters", forward: "/admin/PresentersController.groovy"

get "/admin/presenter", forward: "/admin/PresenterController.groovy"
post "/admin/presenter", forward: "/admin/PresenterController.groovy"

get "/admin/presenter/@id", forward: "/admin/PresenterController.groovy?id=@id"
post "/admin/presenter/@id", forward: "/admin/PresenterController.groovy?id=@id"

get "/favicon.ico", redirect: "/images/gaelyk-small-favicon.png"

get "*", forward: "/NotFoundController.groovy"