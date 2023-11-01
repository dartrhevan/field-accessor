package org.dartrhevan.fieldaccessor.api


@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.TYPE)
annotation class FieldAccess(val readOnly: Boolean = false)
