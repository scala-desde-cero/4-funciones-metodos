# 4-funciones-metodos


1. [Intro a Funciones](#schema1)
2. [Parámetros con nombre](#schema2)
3. [Compilación y Ejecución](#schema3)
4. [Definición de Parámetros por Defecto](#schema4)
5. [Número variable de parámetros](#schema5)


<hr>

<a name="schema1"></a>

## 1. Intro a Funciones

### **Función Básica**
Una función básica se define usando la palabra clave `def`:

```scala
def sum(a: Int, b: Int): Int = {
  a + b
}
```
### **Función Anónima (Lambdas)**
Puedes definir funciones anónimas (también conocidas como lambdas):

```scala
val sum = (a: Int, b: Int) => a + b
```
### **Función sin Argumentos**
Puedes definir funciones sin argumentos:

```scala
def greet(): Unit = {

  println("Hello, World!")
}
O sin los paréntesis si no hay efectos secundarios:

```scala
def greet: Unit = {
    println("Hello, World!")
}
```

### **Funciones de Alto Orden**
Las funciones de alto orden son funciones que pueden tomar otras funciones como argumentos o devolverlas como resultados. Esto es fundamental para la programación funcional en Scala:

```scala
def applyFunction(f: Int => Int, x: Int): Int = f(x)

val result = applyFunction(x => x * 2, 5) // result: 10
```
### **Currying**
El currying es una técnica en la que una función de múltiples argumentos se convierte en una secuencia de funciones de un solo argumento:

```scala
def add(a: Int)(b: Int): Int = a + b

val add3 = add(3) _ // add3: Int => Int
val result = add3(5) // result: 8
```
### **Métodos vs Funciones**
En Scala, los métodos se definen usando def y están asociados a clases o objetos, mientras que las funciones son objetos de primera clase y pueden ser asignadas a variables, pasadas como argumentos, y retornadas desde otras funciones. Aquí hay un ejemplo de ambos:

```scala
class Calculator {
  def add(a: Int, b: Int): Int = a + b // Método
}

val sumFunction = (a: Int, b: Int) => a + b // Función
```
### **Funciones Parciales**
Las funciones parciales son funciones que no están definidas para todos los valores de entrada. En Scala, puedes usar PartialFunction para definirlas:

```scala
val partialFunction: PartialFunction[Int, String] = {
  case 1 => "one"
  case 2 => "two"
}

if (partialFunction.isDefinedAt(1)) {
  println(partialFunction(1)) // Output: one
}
```
### **Funciones como Objetos de Primera Clase**
Las funciones en Scala son objetos de primera clase, lo que significa que puedes asignarlas a variables, pasarlas como argumentos y retornarlas desde otras funciones:

```scala
val double: Int => Int = _ * 2

def operateOnValue(value: Int, operation: Int => Int): Int = {
  operation(value)
}

val result = operateOnValue(5, double) // result: 10
```
### **Closures**
Las closures son funciones que capturan el entorno en el que fueron definidas:

```scala
var factor = 2
val multiplier = (i: Int) => i * factor

println(multiplier(3)) // Output: 6

factor = 3
println(multiplier(3)) // Output: 9
```
### **Funciones de Orden Superior Comunes**
Scala incluye muchas funciones de orden superior en sus colecciones, como map, filter, reduce, flatMap, etc.:

```scala
val numbers = List(1, 2, 3, 4, 5)

val doubled = numbers.map(_ * 2) // List(2, 4, 6, 8, 10)
val evenNumbers = numbers.filter(_ % 2 == 0) // List(2, 4)
val sum = numbers.reduce(_ + _) // 15
```
### **Recursión**
Scala admite recursión y la optimización de la recursión de cola (tail recursion):

```scala
def factorial(n: Int): Int = {
  if (n == 0) 1
  else n * factorial(n - 1)
}

// Recursión de cola
@scala.annotation.tailrec
def factorialTailRec(n: Int, acc: Int = 1): Int = {
  if (n == 0) acc
  else factorialTailRec(n - 1, n * acc)
}
```


<hr>

<a name="schema2"></a>

## 2. Parámetros con nombre


En Scala, los parámetros con nombre (o named parameters) permiten especificar los argumentos de una función o método utilizando los nombres de los parámetros en lugar de solo el orden de los argumentos. Esto mejora la legibilidad y la claridad del código, especialmente cuando una función tiene muchos parámetros o cuando algunos parámetros tienen valores por defecto.

### **Considera la siguiente función:**

```scala
def greet(name: String, age: Int, country: String): Unit = {
  println(s"Hello, my name is $name, I'm $age years old and I'm from $country.")
}
```
Puedes llamar a esta función usando parámetros posicionales (orden de los argumentos):

```scala
greet("Alice", 30, "USA")
```
Esto es claro en funciones con pocos parámetros, pero puede volverse confuso con funciones más complejas. Los parámetros con nombre permiten especificar explícitamente qué argumento corresponde a qué parámetro:

```scala
greet(name = "Alice", age = 30, country = "USA")
```
### **Ventajas de los Parámetros con Nombre**

1. **Claridad y Legibilidad:** Es más fácil entender qué valor corresponde a qué parámetro, especialmente cuando los parámetros tienen nombres descriptivos.

2. **Flexibilidad en el Orden:** Puedes pasar los argumentos en cualquier orden, siempre y cuando nombres cada parámetro:

```scala
greet(age = 30, country = "USA", name = "Alice")
```
3. **Valores por Defecto:** Los parámetros con nombre son especialmente útiles cuando se combinan con valores por defecto, permitiendo omitir algunos argumentos sin perder claridad:

```scala
def greet(name: String, age: Int = 25, country: String = "Unknown"): Unit = {
  println(s"Hello, my name is $name, I'm $age years old and I'm from $country.")
}

greet(name = "Bob") // Usa los valores por defecto para `age` y `country`
// Output: Hello, my name is Bob, I'm 25 years old and I'm from Unknown.
```

<hr>

<a name="schema3"></a>

## 3. Compilación y Ejecución

[Calculator.scala](Calculator.scala)
Guarda este código en un archivo llamado Calculator.scala.

1. Compilar
```bash
scalac Calculator.scala
```
2.  Ejecutar
```bash
scala Calculator + 10 5
```
Esto debería darte la salida:

```bash
Resultado: 15
```
Y aquí tienes la explicación de cómo funciona el código:

1. **Objeto Calculator:** Contiene el método main, que es el punto de entrada del programa.
2. **Método main:** Toma los argumentos de la línea de comandos, valida la entrada y llama al método calcular.
3. **Método calcular:** Realiza la operación aritmética basada en el operador proporcionado. Si el operador es / y numero2 es 0, devuelve un mensaje de error; de lo contrario, realiza la operación correspondiente.
4. **Compilación y Ejecución:** Compila y ejecuta el archivo Scala desde la línea de comandos.

<hr>

<a name="schema4"></a>

## 4. Definición de Parámetros por Defecto

Para definir un parámetro con un valor predeterminado, simplemente asigna un valor al parámetro en la declaración de la función.

```scala
def greet(name: String = "World"): Unit = {
  println(s"Hello, $name!")
}

greet()       // Salida: Hello, World!
greet("Alice") // Salida: Hello, Alice!
```
En este ejemplo, la función greet tiene un parámetro name con un valor predeterminado de "World". Si llamas a greet sin argumentos, se usará el valor predeterminado.

### **Uso de Múltiples Parámetros con Valores por Defecto**
Puedes definir múltiples parámetros con valores predeterminados en la misma función.

```scala
def greet(name: String = "World", greeting: String = "Hello"): Unit = {
  println(s"$greeting, $name!")
}

greet()                // Salida: Hello, World!
greet("Alice")         // Salida: Hello, Alice!
greet("Alice", "Hi")   // Salida: Hi, Alice!
```
<hr>

<a name="schema5"></a>

## 5. Número variable de parámetros

En Scala, puedes definir funciones con un número variable de parámetros utilizando la notación * en el tipo del último parámetro de la función. Esto se conoce como "parámetros repetidos" o "parámetros varargs". Aquí tienes una descripción de cómo funcionan y cómo puedes usarlos:

### **Definición de Parámetros Varargs**
```scala
def sum(values: Int*): Int = {
  values.sum
}
```
En este ejemplo, values: Int* indica que values es un número variable de parámetros enteros.

### **Llamando a Funciones con Parámetros Varargs**
```scala
val result1 = sum(1, 2, 3, 4, 5)   // result1: Int = 15
val result2 = sum(10, 20)           // result2: Int = 30
val result3 = sum()                 // result3: Int = 0
```
Puedes pasar cualquier número de argumentos al llamar a la función sum, incluso ninguno. Los argumentos pasados son tratados como una secuencia dentro de la función.

### **Accediendo a los Parámetros Varargs**
Dentro de la función, los parámetros varargs se comportan como una secuencia (Seq), lo que significa que puedes acceder a ellos usando métodos de secuencia.

```scala
def sum(values: Int*): Int = {
  values.foldLeft(0)(_ + _)
}
```
En este ejemplo, foldLeft se utiliza para sumar todos los valores pasados como argumentos.

### **Usos Comunes**
- **Funciones con un Número Variable de Argumentos:** Útil cuando no se sabe de antemano cuántos argumentos se pasarán a la función.
- **Envolver Funciones de la Biblioteca:** Puedes envolver funciones de biblioteca que aceptan un número variable de argumentos.
- **Construir Interfaces de Usuario y APIs:** Puedes crear interfaces de usuario y APIs que acepten un número variable de argumentos para mayor flexibilidad.