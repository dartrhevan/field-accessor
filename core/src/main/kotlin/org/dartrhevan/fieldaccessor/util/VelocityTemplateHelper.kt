package org.dartrhevan.fieldaccessor.util

import org.apache.velocity.VelocityContext
import org.apache.velocity.app.VelocityEngine
import org.apache.velocity.runtime.RuntimeConstants
import java.io.Writer

class VelocityTemplateHelper private constructor() {
    private val velocityEngine = VelocityEngine()

    init {
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "class,file");
        velocityEngine.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.Log4JLogChute");
        velocityEngine.setProperty("runtime.log.logsystem.log4j.logger", "VELLOGGER");
        velocityEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        velocityEngine.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogSystem");

        velocityEngine.init()

    }

    fun substitute(templateName: String, ctx: Map<String, Any>, writer: Writer) =
        velocityEngine.getTemplate(templateName).merge(VelocityContext(ctx), writer)

    companion object {
        val INSTANCE = VelocityTemplateHelper()
    }
}