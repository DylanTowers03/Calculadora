package torres.kotlin.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    val sum = "+"
    val rest= "-"
    val multiplicacion= "*"
    val division= "/"
    val porcentaje= "%"

    var operacionActual =""
    var primerValor: Double = Double.NaN
    var sengundoValor: Double = Double.NaN

    lateinit var tvTemp:TextView
    lateinit var tvResult:TextView

    lateinit var formatoDecimal: DecimalFormat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        formatoDecimal = DecimalFormat("#.#######")
        tvTemp = findViewById(R.id.tvTemp)
        tvResult = findViewById(R.id.tvResult)


    }
    fun cambiarOperador (b:View){
        calcular()
        val boton:Button = b as Button
        if(boton.text.toString().trim()=="÷" ){
            operacionActual="/"
        }else if(boton.text.toString().trim()=="x" ){
            operacionActual="*"
        } else{
            operacionActual= boton.text.toString().trim ()
        }
        tvResult.text= formatoDecimal.format(primerValor) + operacionActual
        tvTemp.text=""
    }
    fun calcular(){
        if(primerValor.toString()!="NaN"){
            sengundoValor = tvTemp.text.toString().toDouble()
            tvTemp.text=""
            when(operacionActual){
                "+"->primerValor= (primerValor+sengundoValor)
                "-"->primerValor= (primerValor+sengundoValor)
                "*"->primerValor= (primerValor+sengundoValor)
                "/"->primerValor= (primerValor+sengundoValor)
                "%"->primerValor= (primerValor+sengundoValor)
            }
        }else{
            primerValor=tvTemp.text.toString().toDouble()
        }
    }
    fun selectNum(b: View){
        val boton:Button = b as Button
        tvTemp.text= tvTemp.text.toString()+ boton.text.toString()
    }
    fun resultado(b: View){
        calcular()
        tvResult.text=formatoDecimal.format(primerValor)
        primerValor= Double.NaN
        operacionActual= ""
        
    }
    fun borrar(b:View){
        val boton:Button = b as Button
        if (boton.text.toString().trim()=="C"){
            if (tvTemp.text.toString().isNotEmpty()){
                var datosActuales:CharSequence = tvTemp.text.toString()
                tvTemp.text=datosActuales.subSequence(0,datosActuales.length-1)
            }else {
                primerValor= Double.NaN
                sengundoValor= Double.NaN
                tvTemp.text= ""
                tvResult.text=""
            }
        }else if (boton.text.toString().trim()=="CA"){
            primerValor= Double.NaN
            sengundoValor= Double.NaN
            tvTemp.text= ""
            tvResult.text=""
        }
    }
}