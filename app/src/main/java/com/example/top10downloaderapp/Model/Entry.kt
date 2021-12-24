package com.example.top10downloaderapp.Model

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root


@Root(strict = false)
class Entry {
    @field:Element(name = "name")
    var name: String? = null

    @field:ElementList(name="link",inline = true)
    var links: List<Link>? =null

    @field:ElementList(name = "image", inline = true)
    var images: List<Image>? = null
}