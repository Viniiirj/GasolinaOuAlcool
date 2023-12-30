package com.viniramos.gasolinaoualcool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.viniramos.gasolinaoualcool.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var btnCalcular: Button
    private lateinit var binding: ActivityMainBinding

    private lateinit var textInputGasolina: TextInputLayout
    private lateinit var editGasolina: TextInputEditText

    private lateinit var textInputAlcool: TextInputLayout
    private lateinit var editAlcool: TextInputEditText


    private lateinit var precoGasolina: String
    private lateinit var precoAlcool: String

    private lateinit var textResultado: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        inicializarComponentesInterface()
        btnCalcular.setOnClickListener{
           calcularMelhorPreco()


        }
    }

    private fun novaTela() {
        val intent = Intent(this, DetalhesActivity::class.java)
        intent.putExtra("gasolina", precoGasolina)
        intent.putExtra("alcool", precoAlcool)
        intent.putExtra("resultado", textResultado)
        startActivity(intent)
    }



    private fun calcularMelhorPreco() {

         precoAlcool = editAlcool.text.toString()
         precoGasolina = editGasolina.text.toString()

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

            textResultado = if (resultado >= 0.7){
                 "Gasolina"
            } else {
                "Alcool"
            }
            novaTela()

        }

    }

    private fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean {

        textInputGasolina.error = null
        textInputAlcool.error = null


        if ( precoGasolina.isEmpty() ){
            textInputGasolina.error = "Digite o preço do gasolina"
            return false

        } else if ( precoAlcool.isEmpty()){
            textInputAlcool.error = "Digite o preço do álcool"
            return false

        }


        return true

    }

    private fun inicializarComponentesInterface() {
        textInputAlcool = findViewById( R.id.text_input_alcool )
        editAlcool = findViewById( R.id.text_result_alcool )

        textInputGasolina = findViewById( R.id.text_input_gasolina )
        editGasolina = findViewById( R.id.text_result_gasolina )

        btnCalcular = findViewById( R.id.btn_calcular )

    }


}