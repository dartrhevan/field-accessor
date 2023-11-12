package org.dartrhevan.fieldaccessor.model

data class FieldInfo(val name: String, val type: String) {
    val getterName = "get" + name.capitalize()
    val setterName = "set" + name.capitalize()

    override fun toString(): String = "$type $name"
}
