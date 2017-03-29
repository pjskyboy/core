package com.github.sanity.kweb.plugins.foundation.grid

import com.github.sanity.kweb.dom.attributes.attr
import com.github.sanity.kweb.dom.attributes.classes
import com.github.sanity.kweb.dom.element.Element
import com.github.sanity.kweb.dom.element.creation.ElementCreator
import com.github.sanity.kweb.dom.element.creation.tags.DivElement
import com.github.sanity.kweb.dom.element.creation.tags.div
import com.github.sanity.kweb.plugins.foundation.FoundationElement

open class FRowElement(parent: DivElement) : DivElement(parent)

fun ElementCreator<FoundationElement<Element>>.row(expanded : Boolean = false, attributes: Map<String, Any> = attr)
        = FRowElement(div(attributes = attributes.classes("row").classes("expanded", onlyIf = expanded)))


open class FColumnElement(parent: DivElement) : DivElement(parent)

    fun ElementCreator<FRowElement>.column(small : Int? = null, medium : Int? = null, large : Int? = null) : FColumnElement {
        assert(small != null || medium != null || large != null)
        val classes = ArrayList<String>()
        if (small != null)  classes.add("small-$small")
        if (medium != null)  classes.add("medium-$medium")
        if (large != null)  classes.add("large-$large")

        return FColumnElement(div(attributes = attr.classes("column").classes(classes)))
    }


