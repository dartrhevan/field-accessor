package org.dartrhevan.fieldaccessor.model

data class ClassInfo(val pckg: String, val name: String, val fields: Collection<FieldInfo>)