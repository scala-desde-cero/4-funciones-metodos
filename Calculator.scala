object Calculator {
  def main(args: Array[String]): Unit = {
    if (args.length != 3) {
      println("Uso: Calculator <operacion> <numero1> <numero2>")
    } else {
      val operacion = args(0)
      val numero1 = args(1).toInt
      val numero2 = args(2).toInt

      val resultado = calcular(operacion, numero1, numero2)
      println(s"Resultado: $resultado")
    }
  }

  def calcular(operacion: String, numero1: Int, numero2: Int): Any = {
    if (numero2 == 0 && operacion == "/") {
      "No se puede dividir por 0"
    } else {
      operacion match {
        case "+" => numero1 + numero2
        case "-" => numero1 - numero2
        case "*" => numero1 * numero2
        case "/" => numero1 / numero2
        case _   => "Operación Incorrecta"
      }
    }
  }
}
