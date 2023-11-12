package org.dartrhevan.fieldaccessor.generator

import org.dartrhevan.fieldaccessor.model.ClassInfo
import org.dartrhevan.fieldaccessor.util.VelocityTemplateHelper
import java.io.Writer

fun generateFieldAccessorProperties(classesToAccessors: Map<String, String>, writer: Writer) =
    VelocityTemplateHelper.INSTANCE.substitute(
        "accessors.properties.vm", mutableMapOf("classes" to classesToAccessors.entries), writer
    )

fun generateFieldAccessor(accessorName: String, classInfo: ClassInfo, writer: Writer) =
    VelocityTemplateHelper.INSTANCE.substitute(
        "FieldAccessorStatic.vm", mapOf(
            "className" to classInfo.name,
            "fields" to classInfo.fields,
            "package" to classInfo.pckg,
            "accessorName" to accessorName
        ), writer
    )