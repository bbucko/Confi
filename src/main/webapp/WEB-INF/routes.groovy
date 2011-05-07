get "/", forward: "/index.groovy"

get "/presenters", forward: "/presenters.groovy"
get "/presenters/*", forward: "/presenters.groovy"

get "/talks", forward: "/talks.groovy"
get "/talk/@id", forward: "/talk.groovy?id=@id"

get "/admin", forward: "/admin/index.groovy"

get "/admin/talks", forward: "/admin/talks.groovy"

get "/admin/talk", forward: "/admin/talk.groovy"
post "/admin/talk", forward: "/admin/talk.groovy"

get "/admin/talk/@id", forward: "/admin/talk.groovy?id=@id"
post "/admin/talk/@id", forward: "/admin/talk.groovy?id=@id"

get "/admin/presenters", forward: "/admin/presenters.groovy"

get "/admin/presenter", forward: "/admin/presenter.groovy"
post "/admin/presenter", forward: "/admin/presenter.groovy"

get "/admin/presenter/@id", forward: "/admin/presenter.groovy?id=@id"
post "/admin/presenter/@id", forward: "/admin/presenter.groovy?id=@id"

get "/favicon.ico", redirect: "/images/gaelyk-small-favicon.png"

get "*", forward: "/notFound.groovy"