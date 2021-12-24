package com.example.top10downloaderapp.Model

import org.simpleframework.xml.Root
import org.simpleframework.xml.Text


@Root(strict = false)
class Image {
    @field:Text
    var link : String? = null
}