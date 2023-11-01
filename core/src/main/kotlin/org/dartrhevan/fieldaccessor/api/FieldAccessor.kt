package org.dartrhevan.fieldaccessor.api

interface FieldAccessor<T> {
    fun<V> get(obj: T, fieldName: String): V
    fun<V> set(obj: T, fieldName: String, value: V)
}