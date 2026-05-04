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

// ============================================================
// EJERCICIO 1: Control de Gastos Diarios
// Crea un Array<Double> con gastos de los últimos 15 días.
// Calcula total, promedio, gasto más alto y más bajo
// SIN usar funciones como .sum()
// ============================================================
fun ejercicio1() {
    val gastos = arrayOf(
        12000.0, 45000.0, 8500.0, 32000.0, 15000.0,
        27000.0, 9800.0, 61000.0, 14500.0, 38000.0,
        5000.0, 22000.0, 19000.0, 43000.0, 11000.0
    )

    // Calculamos el total manualmente con un ciclo (sin .sum())
    var total = 0.0
    var maximo = gastos[0]
    var minimo = gastos[0]

    for (gasto in gastos) {
        total += gasto                          // Acumulamos el total
        if (gasto > maximo) maximo = gasto      // Actualizamos el máximo
        if (gasto < minimo) minimo = gasto      // Actualizamos el mínimo
    }

    val promedio = total / gastos.size          // Promedio = total / cantidad

    println("Total gastado: $${total}")
    println("Promedio diario: $${promedio}")
    println("Gasto más alto: $${maximo}")
    println("Gasto más bajo: $${minimo}")
}

// ============================================================
// EJERCICIO 2: Filtro de Empleados Senior
// Lista de Pair<String, Int> (Nombre, Edad).
// Filtra los mayores de 30 años y muestra sus nombres en MAYÚSCULAS
// ============================================================
fun ejercicio2() {
    val empleados = listOf(
        Pair("Ana López", 28),
        Pair("Carlos Ruiz", 35),
        Pair("María García", 42),
        Pair("Pedro Sánchez", 25),
        Pair("Laura Martínez", 31),
        Pair("Juan Torres", 29),
        Pair("Sofía Díaz", 38)
    )

    println("Empleados Senior (más de 30 años):")
    // filter filtra los pares donde la edad (second) > 30
    // map transforma cada par en solo el nombre (first) en mayúsculas
    val senior = empleados
        .filter { it.second > 30 }
        .map { it.first.uppercase() }

    for (nombre in senior) {
        println("  - $nombre")
    }
}

// ============================================================
// EJERCICIO 3: Limpieza de Contactos Duplicados
// Usa un Set para obtener números únicos y mostrarlos ordenados
// ============================================================
fun ejercicio3() {
    // Lista con números repetidos (20 números simulados)
    val contactos = listOf(
        "3001234567", "3109876543", "3001234567", "3205551234",
        "3109876543", "3001234567", "3154443210", "3205551234",
        "3009998877", "3154443210", "3001234567", "3009998877",
        "3112223344", "3205551234", "3112223344", "3009998877",
        "3001234567", "3154443210", "3112223344", "3109876543"
    )

    // Un Set elimina automáticamente los duplicados
    val unicos = contactos.toSet()
    // Ordenamos los números únicos
    val ordenados = unicos.sorted()

    println("Contactos únicos ordenados (${ordenados.size} de ${contactos.size}):")
    for (numero in ordenados) {
        println("  $numero")
    }
}

// ============================================================
// EJERCICIO 4: Análisis de Carrito de Compras
// Crea un Map<String, Int> que cuente cuántas unidades hay de cada producto
// ============================================================
fun ejercicio4() {
    // Lista de productos que el cliente agregó (con repetidos)
    val carrito = listOf(
        "Manzana", "Leche", "Pan", "Manzana", "Huevos",
        "Leche", "Manzana", "Pan", "Mantequilla", "Leche",
        "Huevos", "Pan", "Manzana", "Mantequilla", "Leche"
    )

    // Creamos un mapa mutable para contar unidades
    val conteo = mutableMapOf<String, Int>()

    for (producto in carrito) {
        // Si el producto ya existe, sumamos 1; si no, lo iniciamos en 1
        conteo[producto] = (conteo[producto] ?: 0) + 1
    }

    println("Resumen del carrito:")
    for ((producto, cantidad) in conteo) {
        println("  $producto: $cantidad unidades")
    }
}

// ============================================================
// EJERCICIO 5: Historial de Navegación Reversible
// Invierte manualmente un Array<String> de las últimas 5 URLs
// ============================================================
fun ejercicio5() {
    val historial = arrayOf(
        "google.com",
        "github.com",
        "stackoverflow.com",
        "kotlinlang.org",
        "youtube.com"
    )

    println("Historial original (del más antiguo al más reciente):")
    for (url in historial) println("  -> $url")

    // Invertimos manualmente usando índices (sin .reversed())
    // Intercambiamos el primer con el último, el segundo con el penúltimo, etc.
    var izquierda = 0
    var derecha = historial.size - 1
    while (izquierda < derecha) {
        val temp = historial[izquierda]
        historial[izquierda] = historial[derecha]
        historial[derecha] = temp
        izquierda++
        derecha--
    }

    println("\nHistorial invertido (botón Atrás):")
    for (url in historial) println("  <- $url")
}

// ============================================================
// EJERCICIO 6: Compatibilidad de Intereses (Match)
// Dados dos Set<String>, encuentra intereses comunes y exclusivos
// ============================================================
fun ejercicio6() {
    val interesesPersona1 = setOf("Música", "Cine", "Senderismo", "Cocina", "Viajes")
    val interesesPersona2 = setOf("Cine", "Videojuegos", "Senderismo", "Lectura", "Música")

    // intersect devuelve los elementos que están en AMBOS conjuntos
    val enComun = interesesPersona1.intersect(interesesPersona2)

    // subtract devuelve los que están en el primero pero NO en el segundo
    val exclusivosPersona1 = interesesPersona1.subtract(interesesPersona2)

    println("Intereses en común: $enComun")
    println("Exclusivos de Persona 1: $exclusivosPersona1")

    val compatibilidad = (enComun.size * 100) / interesesPersona1.size
    println("Compatibilidad: $compatibilidad%")
    if (compatibilidad >= 60) println("¡Buena combinación para una cita!")
    else println("Podrían tener poco en común.")
}

// ============================================================
// EJERCICIO 7: Inventario de Despensa
// MutableMap<String, Int> para gestionar alimentos.
// Implementa lógica para consumir (restar) y alertar si se agota (eliminar)
// ============================================================
fun ejercicio7() {
    val despensa = mutableMapOf(
        "Arroz" to 5,
        "Frijoles" to 3,
        "Aceite" to 2,
        "Sal" to 10,
        "Azúcar" to 4
    )

    println("Inventario inicial: $despensa")

    // Función interna para consumir un producto
    fun consumir(producto: String, cantidad: Int) {
        val actual = despensa[producto]
        if (actual == null) {
            println("⚠️  '$producto' no está en la despensa.")
            return
        }
        val restante = actual - cantidad
        if (restante <= 0) {
            // Se agotó: eliminamos del mapa
            despensa.remove(producto)
            println("❌ '$producto' se agotó y fue eliminado del inventario.")
        } else {
            despensa[producto] = restante
            println("✅ Consumido $cantidad de '$producto'. Quedan: $restante")
        }
    }

    consumir("Arroz", 3)
    consumir("Aceite", 2)
    consumir("Frijoles", 5)

    println("\nInventario final: $despensa")
}

// ============================================================
// EJERCICIO 8: Cálculo de Promedio Académico
// Lista de Pair<Double, Double> (nota, porcentaje de valor).
// Calcula la nota final definitiva ponderada
// ============================================================
fun ejercicio8() {
    // Pair(nota, porcentaje) — el porcentaje debe sumar 1.0 en total
    val calificaciones = listOf(
        Pair(4.5, 0.30),  // Parcial 1: vale 30%
        Pair(3.8, 0.30),  // Parcial 2: vale 30%
        Pair(4.2, 0.40)   // Final:     vale 40%
    )

    var notaFinal = 0.0
    for ((nota, porcentaje) in calificaciones) {
        notaFinal += nota * porcentaje  // Suma ponderada
    }

    println("Notas y pesos:")
    for ((nota, peso) in calificaciones) {
        println("  Nota: $nota  |  Peso: ${(peso * 100).toInt()}%  |  Aporte: ${nota * peso}")
    }
    println("Nota final definitiva: ${"%.2f".format(notaFinal)}")
}

// ============================================================
// EJERCICIO 9: Traductor de Códigos de País
// Dado un mapa "ISO Code" -> "Nombre de País", recórrelo y muestra mensajes
// ============================================================
fun ejercicio9() {
    val paises = mapOf(
        "CO" to "Colombia",
        "MX" to "México",
        "AR" to "Argentina",
        "ES" to "España",
        "US" to "Estados Unidos",
        "BR" to "Brasil"
    )

    println("Directorio de países:")
    // Desestructuramos cada entrada del mapa en clave (iso) y valor (nombre)
    for ((iso, nombre) in paises) {
        println("  El código [$iso] pertenece a [$nombre]")
    }
}

// ============================================================
// EJERCICIO 10: Rotación de Turnos de Trabajo
// Rota una lista de 7 empleados k posiciones para distribuir descansos
// ============================================================
fun ejercicio10() {
    val empleados = mutableListOf(
        "Ana", "Carlos", "María", "Pedro", "Laura", "Juan", "Sofía"
    )
    val k = 2  // Rotamos 2 posiciones

    println("Turno original: $empleados")

    // Rotación: movemos los últimos k al inicio
    // Ej: [A,B,C,D,E] rotado 2 = [D,E,A,B,C]
    val rotados = empleados.takeLast(k) + empleados.dropLast(k)

    println("Turno rotado $k posiciones: $rotados")
}

// ============================================================
// EJERCICIO 11: Organizador de Maleta
// Agrupa objetos en Map<Int, List<String>> según su peso en kg
// ============================================================
fun ejercicio11() {
    // Pair(nombre del objeto, peso en kg)
    val objetos = listOf(
        Pair("Camisa", 1),
        Pair("Zapatos", 2),
        Pair("Laptop", 2),
        Pair("Pantalón", 1),
        Pair("Cargador", 1),
        Pair("Libro", 1),
        Pair("Cámara", 2),
        Pair("Neceser", 3)
    )

    // groupBy agrupa por el peso (second del par)
    // El resultado es Map<Int, List<Pair<String,Int>>>
    val agrupados = mutableMapOf<Int, MutableList<String>>()

    for ((objeto, peso) in objetos) {
        // Si no existe la clave del peso, la creamos con lista vacía
        if (!agrupados.containsKey(peso)) {
            agrupados[peso] = mutableListOf()
        }
        agrupados[peso]!!.add(objeto)
    }

    println("Objetos agrupados por peso:")
    for ((peso, items) in agrupados.toSortedMap()) {
        println("  ${peso}kg -> $items")
    }

    val pesoTotal = objetos.sumOf { it.second }
    println("Peso total de la maleta: ${pesoTotal}kg")
    if (pesoTotal > 10) println("⚠️  ¡Excede el límite de la aerolínea (10kg)!")
    else println("✅ Dentro del límite de la aerolínea.")
}

// ============================================================
// EJERCICIO 12: Verificador de Ruta Reversible
// Verifica si una lista de coordenadas es "espejo" (palíndromo)
// ============================================================
fun ejercicio12() {
    // Una ruta es espejo si es igual al revés
    val ruta1 = listOf("A1", "B2", "C3", "B2", "A1")  // Es espejo
    val ruta2 = listOf("X1", "Y2", "Z3", "W4")          // No es espejo

    fun esEspejo(ruta: List<String>): Boolean {
        var inicio = 0
        var fin = ruta.size - 1
        while (inicio < fin) {
            if (ruta[inicio] != ruta[fin]) return false  // Si algún par no coincide, no es palíndromo
            inicio++
            fin--
        }
        return true
    }

    println("Ruta 1: $ruta1 -> ${if (esEspejo(ruta1)) "✅ Es espejo" else "❌ No es espejo"}")
    println("Ruta 2: $ruta2 -> ${if (esEspejo(ruta2)) "✅ Es espejo" else "❌ No es espejo"}")
}

// ============================================================
// EJERCICIO 13: Reparto de Pedidos por Camión
// Divide 50 paquetes en lotes de 10 usando un ciclo manual
// ============================================================
fun ejercicio13() {
    // Creamos 50 paquetes simulados
    val paquetes = (1..50).map { "PKG-$it" }
    val tamanoLote = 10

    println("Distribución de paquetes en camiones:")

    var camion = 1
    var i = 0
    // Recorremos la lista en pasos de 'tamanoLote'
    while (i < paquetes.size) {
        val lote = paquetes.subList(i, minOf(i + tamanoLote, paquetes.size))
        println("  Camión $camion: ${lote.size} paquetes -> ${lote.first()} ... ${lote.last()}")
        i += tamanoLote
        camion++
    }
    println("Total camiones necesarios: ${camion - 1}")
}

// ============================================================
// EJERCICIO 14: Identificador de Ticket Único
// Encuentra el primer ID que aparece SOLO una vez en la lista
// ============================================================
fun ejercicio14() {
    val tickets = listOf(101, 203, 101, 305, 203, 407, 305, 509, 407, 509, 611)

    // Contamos cuántas veces aparece cada ID
    val conteo = mutableMapOf<Int, Int>()
    for (ticket in tickets) {
        conteo[ticket] = (conteo[ticket] ?: 0) + 1
    }

    // Buscamos el primero con conteo = 1 (aparece solo una vez)
    var primerUnico: Int? = null
    for (ticket in tickets) {
        if (conteo[ticket] == 1) {
            primerUnico = ticket
            break
        }
    }

    println("Tickets reportados: $tickets")
    println("Frecuencia: $conteo")
    println("Primer ticket único (no repetido): $primerUnico")
}

// ============================================================
// EJERCICIO 15: Calculadora de IVA Selectiva
// Aplica 19% de IVA solo a productos que cuesten más de $50.000
// ============================================================
fun ejercicio15() {
    val precios = mapOf(
        "Leche" to 3500.0,
        "Televisor" to 850000.0,
        "Pan" to 4000.0,
        "Celular" to 1200000.0,
        "Arroz" to 8000.0,
        "Audífonos" to 75000.0,
        "Jabón" to 3200.0
    )

    val IVA = 0.19
    val LIMITE = 50000.0

    println("Precios con IVA selectivo (aplica a productos > \$50.000):")
    val preciosConIVA = mutableMapOf<String, Double>()
    for ((producto, precio) in precios) {
        val precioFinal = if (precio > LIMITE) precio * (1 + IVA) else precio
        preciosConIVA[producto] = precioFinal
        val etiqueta = if (precio > LIMITE) " (+19% IVA)" else " (sin IVA)"
        println("  $producto: \$${"%.0f".format(precioFinal)}$etiqueta")
    }
}

// ============================================================
// EJERCICIO 16: Mantenimiento de Sensores
// Elimina de una MutableList los sensores cuyos IDs sean múltiplos de 3
// ============================================================
fun ejercicio16() {
    val sensores = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
    println("Sensores iniciales: $sensores")

    // Usamos removeAll con un predicado que selecciona los múltiplos de 3
    // (aquellos donde el ID % 3 == 0)
    sensores.removeAll { it % 3 == 0 }

    println("Sensores activos (múltiplos de 3 removidos): $sensores")
}

// ============================================================
// EJERCICIO 17: Mapa de Almacén (Matriz 4x4)
// Suma la diagonal principal y la diagonal secundaria
// ============================================================
fun ejercicio17() {
    // Representamos el almacén como una matriz 4x4
    val almacen = arrayOf(
        intArrayOf(10, 5, 3, 8),
        intArrayOf(2, 15, 7, 1),
        intArrayOf(9, 4, 20, 6),
        intArrayOf(3, 11, 2, 25)
    )

    val n = almacen.size
    var diagonalPrincipal = 0   // De arriba-izquierda a abajo-derecha
    var diagonalSecundaria = 0  // De arriba-derecha a abajo-izquierda

    for (i in 0 until n) {
        diagonalPrincipal += almacen[i][i]          // [0][0], [1][1], [2][2], [3][3]
        diagonalSecundaria += almacen[i][n - 1 - i] // [0][3], [1][2], [2][1], [3][0]
    }

    println("Mapa del almacén:")
    for (fila in almacen) println("  ${fila.toList()}")
    println("Diagonal principal (pasillo central): $diagonalPrincipal")
    println("Diagonal secundaria: $diagonalSecundaria")
}

// ============================================================
// EJERCICIO 18: Fusión de Recetas
// Combina dos Map<String, Double> sumando cantidades de ingredientes comunes
// ============================================================
fun ejercicio18() {
    val recetaChef1 = mapOf(
        "Harina" to 500.0,
        "Azúcar" to 200.0,
        "Mantequilla" to 100.0,
        "Leche" to 300.0
    )
    val recetaChef2 = mapOf(
        "Harina" to 300.0,
        "Huevos" to 4.0,
        "Azúcar" to 150.0,
        "Vainilla" to 10.0
    )

    // Fusionamos: si el ingrediente está en ambas recetas, sumamos las cantidades
    val listaFusionada = mutableMapOf<String, Double>()

    for ((ingrediente, cantidad) in recetaChef1) {
        listaFusionada[ingrediente] = cantidad
    }
    for ((ingrediente, cantidad) in recetaChef2) {
        listaFusionada[ingrediente] = (listaFusionada[ingrediente] ?: 0.0) + cantidad
    }

    println("Lista de compras fusionada:")
    for ((ingrediente, cantidad) in listaFusionada) {
        println("  $ingrediente: ${cantidad}g")
    }
}

// ============================================================
// EJERCICIO 19: Ranking de Apps por Calificación
// Ordena manualmente una lista de Pair<String, Double> de mayor a menor
// ============================================================
fun ejercicio19() {
    val apps = mutableListOf(
        Pair("Instagram", 4.2),
        Pair("TikTok", 4.7),
        Pair("Twitter", 3.8),
        Pair("WhatsApp", 4.5),
        Pair("Spotify", 4.6),
        Pair("Netflix", 4.3),
        Pair("YouTube", 4.4),
        Pair("Duolingo", 4.8),
        Pair("Telegram", 4.1),
        Pair("LinkedIn", 3.9),
        Pair("Snapchat", 3.7),
        Pair("Pinterest", 4.0)
    )

    // Ordenamiento burbuja de mayor a menor por calificación (second)
    for (i in 0 until apps.size - 1) {
        for (j in 0 until apps.size - 1 - i) {
            if (apps[j].second < apps[j + 1].second) {
                val temp = apps[j]
                apps[j] = apps[j + 1]
                apps[j + 1] = temp
            }
        }
    }

    println("Top 10 Apps por calificación:")
    for (pos in 0 until minOf(10, apps.size)) {
        println("  ${pos + 1}. ${apps[pos].first} -> ${apps[pos].second}⭐")
    }
}

// ============================================================
// EJERCICIO 20: Unión de Agendas Ordenadas
// Combina dos listas alfabéticas en una sola sin usar .sort()
// ============================================================
fun ejercicio20() {
    val agenda1 = listOf("Ana", "Carlos", "Elena", "Jorge", "Mónica")
    val agenda2 = listOf("Beatriz", "Daniel", "Felipe", "Laura", "Pedro")

    val fusionada = mutableListOf<String>()
    var i = 0
    var j = 0

    // Merge de dos listas ordenadas: comparamos elemento por elemento
    while (i < agenda1.size && j < agenda2.size) {
        if (agenda1[i] <= agenda2[j]) {
            fusionada.add(agenda1[i])
            i++
        } else {
            fusionada.add(agenda2[j])
            j++
        }
    }
    // Agregamos los elementos restantes de cualquier lista que no terminó
    while (i < agenda1.size) { fusionada.add(agenda1[i]); i++ }
    while (j < agenda2.size) { fusionada.add(agenda2[j]); j++ }

    println("Agenda 1: $agenda1")
    println("Agenda 2: $agenda2")
    println("Agenda maestra fusionada: $fusionada")
}

// ============================================================
// EJERCICIO 21: Días de Mantenimiento (Primos)
// En un edificio de 100 pisos, genera la lista de pisos primos
// ============================================================
fun ejercicio21() {
    // Una función que determina si un número es primo
    fun esPrimo(n: Int): Boolean {
        if (n < 2) return false
        for (i in 2..Math.sqrt(n.toDouble()).toInt()) {
            if (n % i == 0) return false  // Si tiene un divisor, no es primo
        }
        return true
    }

    // Usamos un Array de marcas (booleanos)
    val marcas = Array(101) { false }  // false = sin mantenimiento especial

    val pisosPrimos = mutableListOf<Int>()
    for (piso in 1..100) {
        if (esPrimo(piso)) {
            marcas[piso] = true
            pisosPrimos.add(piso)
        }
    }

    println("Pisos con mantenimiento especial (números primos):")
    println(pisosPrimos)
    println("Total de pisos: ${pisosPrimos.size}")
}

// ============================================================
// EJERCICIO 22: Pila de Platos Sucios
// Simula una pila LIFO con push (agregar) y pop (retirar el de arriba)
// ============================================================
fun ejercicio22() {
    // Usamos una lista mutable como pila (LIFO: Last In, First Out)
    val pila = mutableListOf<String>()

    // Función push: agrega un plato encima de la pila
    fun push(plato: String) {
        pila.add(plato)
        println("🍽️  Añadido: $plato | Pila: $pila")
    }

    // Función pop: retira el plato de arriba (el último agregado)
    fun pop(): String? {
        if (pila.isEmpty()) {
            println("✅ No hay más platos que lavar.")
            return null
        }
        val plato = pila.removeAt(pila.size - 1)
        println("🫧 Lavando: $plato | Pila restante: $pila")
        return plato
    }

    push("Plato grande")
    push("Vaso")
    push("Plato pequeño")
    push("Taza")

    println("\n--- Comenzando a lavar ---")
    pop()
    pop()
    pop()
    pop()
    pop() // Intento cuando ya está vacía
}

// ============================================================
// EJERCICIO 23: Seguimiento de Dieta
// Crea una nueva lista con la diferencia entre calorías de hoy
// y el promedio de los días anteriores
// ============================================================
fun ejercicio23() {
    val calorias = listOf(2000.0, 1800.0, 2200.0, 1900.0, 2100.0, 1750.0, 2300.0)

    val diferencias = mutableListOf<Double>()

    for (i in calorias.indices) {
        if (i == 0) {
            // El primer día no tiene días anteriores, diferencia = 0
            diferencias.add(0.0)
        } else {
            // Calculamos el promedio de los días ANTERIORES al día i
            var suma = 0.0
            for (j in 0 until i) {
                suma += calorias[j]
            }
            val promedio = suma / i
            diferencias.add(calorias[i] - promedio)
        }
    }

    println("Día | Calorías | Promedio anterior | Diferencia")
    println("-".repeat(55))
    for (i in calorias.indices) {
        val diff = diferencias[i]
        val signo = if (diff > 0) "+" else ""
        println("  ${i + 1}   | ${calorias[i].toInt()}     |  calculado        | $signo${"%.1f".format(diff)}")
    }
}

// ============================================================
// EJERCICIO 24: Organización de Contenedores
// Verifica si los paréntesis ( y ) en un manifiesto están balanceados
// ============================================================
fun ejercicio24() {
    fun estaBalanceado(manifiesto: String): Boolean {
        var contador = 0
        for (char in manifiesto) {
            if (char == '(') contador++      // Abrimos un contenedor
            else if (char == ')') contador-- // Cerramos un contenedor
            if (contador < 0) return false   // Más cierres que aperturas -> inválido
        }
        return contador == 0  // Debe terminar en 0 para estar balanceado
    }

    val manifiestos = listOf(
        "(()())" to "Carga A",
        "(()" to "Carga B",
        "()()()" to "Carga C",
        ")(" to "Carga D",
        "((()))" to "Carga E"
    )

    for ((manifiesto, nombre) in manifiestos) {
        val estado = if (estaBalanceado(manifiesto)) "✅ Balanceado" else "❌ Desbalanceado"
        println("$nombre '$manifiesto': $estado")
    }
}

// ============================================================
// EJERCICIO 25: Rendimiento de Maratón
// Elimina el tiempo más rápido y el más lento (outliers) para calcular el promedio real
// ============================================================
fun ejercicio25() {
    val tiempos = mutableListOf(
        245.0, 310.0, 278.0, 195.0, 302.0,
        289.0, 315.0, 263.0, 401.0, 271.0
    ) // en minutos

    println("Tiempos originales: $tiempos")

    // Encontramos el mínimo y el máximo sin usar funciones de colección
    var minTiempo = tiempos[0]
    var maxTiempo = tiempos[0]
    for (t in tiempos) {
        if (t < minTiempo) minTiempo = t
        if (t > maxTiempo) maxTiempo = t
    }

    // Eliminamos UNA ocurrencia del mínimo y UNA del máximo
    tiempos.remove(minTiempo)
    tiempos.remove(maxTiempo)

    var suma = 0.0
    for (t in tiempos) suma += t
    val promedio = suma / tiempos.size

    println("Tiempo más rápido eliminado: $minTiempo min")
    println("Tiempo más lento eliminado: $maxTiempo min")
    println("Tiempos restantes: $tiempos")
    println("Promedio real de entrenamiento: ${"%.2f".format(promedio)} min")
}

// ============================================================
// EJERCICIO 26: Compresión de Logs de Servidor
// Convierte una secuencia de estados repetidos en una lista resumida de pares
// Ej: ["UP","UP","DOWN"] -> [("UP", 2), ("DOWN", 1)]
// ============================================================
fun ejercicio26() {
    val logs = listOf("UP", "UP", "DOWN", "DOWN", "DOWN", "UP", "UP", "UP", "DOWN", "UP")

    val comprimidos = mutableListOf<Pair<String, Int>>()
    var i = 0

    while (i < logs.size) {
        val estado = logs[i]
        var contador = 1

        // Contamos cuántas veces se repite el estado actual consecutivamente
        while (i + contador < logs.size && logs[i + contador] == estado) {
            contador++
        }

        comprimidos.add(Pair(estado, contador))
        i += contador  // Saltamos los que ya contamos
    }

    println("Logs originales: $logs")
    println("Logs comprimidos:")
    for ((estado, veces) in comprimidos) {
        println("  \"$estado\" aparece $veces ${if (veces == 1) "vez" else "veces"}")
    }
}

// ============================================================
// EJERCICIO 27: Premios a Vendedores
// Identifica qué vendedores superaron el promedio del equipo
// ============================================================
fun ejercicio27() {
    val ventas = mapOf(
        "Andrea" to 8500000.0,
        "Bernardo" to 12000000.0,
        "Carmen" to 7200000.0,
        "Diego" to 15500000.0,
        "Elena" to 9800000.0,
        "Felipe" to 11000000.0,
        "Gloria" to 6500000.0
    )

    // Calculamos el promedio del equipo manualmente
    var totalVentas = 0.0
    for ((_, venta) in ventas) {
        totalVentas += venta
    }
    val promedio = totalVentas / ventas.size

    println("Promedio del equipo: \$${"%.0f".format(promedio)}")
    println("\n🏆 Vendedores que superaron el promedio (BONO):")
    for ((vendedor, venta) in ventas) {
        if (venta > promedio) {
            val exceso = venta - promedio
            println("  ✅ $vendedor: \$${"%.0f".format(venta)} (+\$${"%.0f".format(exceso)} sobre el promedio)")
        }
    }

    println("\n📋 Vendedores por debajo del promedio:")
    for ((vendedor, venta) in ventas) {
        if (venta <= promedio) {
            println("  ❌ $vendedor: \$${"%.0f".format(venta)}")
        }
    }
}