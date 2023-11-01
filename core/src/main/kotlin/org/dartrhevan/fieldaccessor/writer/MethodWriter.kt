package org.dartrhevan.fieldaccessor.writer

import java.io.Writer

data class MethodWriter(val params: List<String>, val returnType: String, val isOverriden: Boolean) : Writable {
    override fun write(os: Writer) {
        TODO("Not yet implemented")
    }
}
