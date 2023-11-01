package org.dartrhevan.fieldaccessor.writer

import java.io.Writer

data class FieldWriter(val name: String, val type: String) : Writable {
    override fun write(os: Writer) {
        TODO("Not yet implemented")
    }
}
