package mx.arr.androidexam

// Define el método que se ejecuta para avisar que hay un click sobre un renglón
interface ClickListener {
    //Hizo click en el renglon (posición)
    fun clicked(posicion: Int)
}