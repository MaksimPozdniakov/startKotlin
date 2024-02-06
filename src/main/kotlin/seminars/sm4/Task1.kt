package main.kotlin.seminars.sm4

interface SimpleLogger {
    val prefix: String

    fun log(message: String) {
        println(prefix + message)
    }
}

class SimpleLoggerImpl(
    override val prefix: String
) : SimpleLogger {

    init {
        println("SimpleLoggerImpl created")
    }
}

// TODO StackTraceLogger

class StackTraceLogger  (logger: SimpleLoggerImpl):SimpleLogger by logger
{
    override fun log(message: String){
        super.log(message)
        val stackTrace = Thread.currentThread().stackTrace
        stackTrace.forEachIndexed{index,entry -> if(index > 0)  println(entry)}

    }
}

val stackTraceLogger = StackTraceLogger(
    SimpleLoggerImpl("MyLogger: ")
)

fun main() {
    println("Enter main()")
    //stackTraceLogger.log("Hello world")
}
