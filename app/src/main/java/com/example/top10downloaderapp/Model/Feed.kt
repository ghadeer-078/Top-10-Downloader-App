package com.example.top10downloaderapp.Model

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.Root


@Root(strict = false)
@Namespace(prefix = "im",reference = "http://itunes.apple.com/rss")
class Feed {
    @field:ElementList(inline = true,name = "entry")
    var entries : List<Entry>? =null
}