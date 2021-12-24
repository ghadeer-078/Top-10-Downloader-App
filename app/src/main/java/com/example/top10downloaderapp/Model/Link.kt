package com.example.top10downloaderapp.Model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root


@Root(strict = false)
class Link {
    @field:Attribute(name = "href")
    var href: String? = null
}