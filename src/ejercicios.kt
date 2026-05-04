fun desafio1() {
    val gastos = arrayOf(100.0, 200.0, 150.0, 300.0, 250.0)

    var total = 0.0
    var max = gastos[0]
    var min = gastos[0]

    for (gasto in gastos) {
        total += gasto

        if (gasto > max) max = gasto
        if (gasto < min) min = gasto
    }

    val promedio = total / gastos.size

    println("Total: $total")
    println("Promedio: $promedio")
    println("Máximo: $max")
    println("Mínimo: $min")
}