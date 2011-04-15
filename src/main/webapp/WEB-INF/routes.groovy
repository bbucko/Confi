// routes for the blobstore service example

get "/favicon.ico", redirect: "/images/gaelyk-small-favicon.png"

get "/", forward: "/index.groovy"

get "/presenters", forward: "/presenters.groovy"
get "/presenters/*", forward: "/presenters.groovy"

get "/talks", forward: "/talks.groovy"
get "/talk/@id", forward: "/talk.groovy?id=@id"
