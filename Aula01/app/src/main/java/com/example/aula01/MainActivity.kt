    package com.example.aula01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

    class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular = findViewById<Button>(R.id.button)
        val IMCTextView = findViewById<TextView>(R.id.textViewIMC)
        val textViewClass = findViewById<TextView>(R.id.textViewClass)

        val pesoEditText = findViewById<EditText>(R.id.peso)
        val alturaEditText = findViewById<EditText>(R.id.altura)


        calcular.setOnClickListener{

            var classificacao: String? = null

            val peso = pesoEditText.text.toString().toFloatOrNull()
            val altura = alturaEditText.text.toString().toFloatOrNull()

            if (peso != null && altura != null){
                var imc:Float = peso / (altura*altura)
                if (imc < 18.5) {
                    classificacao = "Baixo Peso"
                } else if (imc < 24.9) {
                    classificacao = "eutrofia (peso adequado)"
                }else if (imc < 34.9) {
                    classificacao = "obesidade grau 1"
                }else if (imc < 39.9) {
                    classificacao = "obesidade grau 2"
                }else {
                    classificacao = "Obesidade extrema"
                }
                IMCTextView.text = "IMC: %.2f".format(imc)
                textViewClass.text = classificacao
            } else {
                IMCTextView.text = "NULL"
            }


        }
    }
}