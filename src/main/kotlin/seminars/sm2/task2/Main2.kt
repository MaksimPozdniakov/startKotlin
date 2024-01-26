package main.kotlin.seminars.sm2.task2

fun printOperationResult(operation: Operation) {
    val result = operation.calculate()
    println(result)
}

fun main() {
    // Соответствует формуле 4 + 2.5 * 2
    printOperationResult(
        Plus(
            Value(4.0),
            Multiply(
                Value(2.5),
                Value(2.0)
            )
        )
    )

    // Соответствует формуле (1 + 3.5) * (2.5 + 2)
    printOperationResult(
        Multiply(
            Plus(
                Value(1.0),
                Value(3.5)
            ),
            Plus(
                Value(2.5),
                Value(2.0)
            )
        )
    )

    // Соответствует формуле 10
    printOperationResult(
        Value(10.0)
    )
}

sealed interface Operation {
    fun calculate(): Double
}

class Value(private val d: Double) : Operation {
    override fun calculate(): Double {
        return d
    }
}

class Multiply(private val left: Operation, private val right: Operation) : Operation {
    override fun calculate(): Double {
        return left.calculate() * right.calculate()
    }
}

class Plus(private val left: Operation, private val right: Operation) : Operation {
    override fun calculate(): Double {
        return left.calculate() + right.calculate()
    }

}
