package org.dartrhevan.fieldaccessor.util


const val PROPERTIES_FILE = "accessors.properties"

fun getFieldAccessorName(className: String) = "${className}FieldAccessor"