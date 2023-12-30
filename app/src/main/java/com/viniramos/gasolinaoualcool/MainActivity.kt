package com.viniramos.gasolinaoualcool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var btnCalcular: Button

    private lateinit var textInputGasolina: TextInputLayout
    private lateinit var editGasolina: TextInputEditText

    private lateinit var textInputAlcool: TextInputLayout
    private lateinit var editAlcool: TextInputEditText
    protected lateinit var textResutados: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializarComponentesInterface()
        btnCalcular.setOnClickListener{
           calcularMelhorPreco()


        }
    }

    protected fun calcularMelhorPreco() {
        val precoAlcool = editAlcool.text.toString()
        val precoGasolina = editGasolina.text.toString()

        val resultadoValidacao = validarCampos(precoAlcool, precoGasolina)

        if( resultadoValidacao ) {
            /*
            Calculo de melhor preço
            se(valorAlcool / valorGasolina) >= 0.7 é melhor utilizar gasolina
            senão é melhor utilizar alcool
             */

            val precoAlcoolDouble = precoAlcool.toDouble()
            val precoGasolinaDouble = precoGasolina.toDouble()
            val resultado = precoAlcoolDouble / precoGasolinaDouble

            if (resultado >= 0.7){
                textResutados.text= "Gasolina"
            } else {
                textResutados.text= "Alcool"
            }
        }

    }

    private fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean {

        textInputGasolina.error = null
        textInputAlcool.error = null

        if ( precoAlcool.isEmpty()){
            textInputAlcool.error = "Digite o preço do álcool"
            return false

        } else if ( precoGasolina.isEmpty() ){
            textInputGasolina.error = "Digite o preço do gasolina"
            return false

        }
        val intent = Intent(this, DetalhesActivity::class.java)


        startActivity( intent )

        return true

    }

    private fun inicializarComponentesInterface() {
        textInputAlcool = findViewById( R.id.text_input_alcool )
        editAlcool = findViewById( R.id.text_result_alcool )

        textInputGasolina = findViewById( R.id.text_input_gasolina )
        editGasolina = findViewById( R.id.text_result_gasolina )

        btnCalcular = findViewById( R.id.btn_calcular )

//        textResutado = findViewById( R.id.text_resultado )
    }


}