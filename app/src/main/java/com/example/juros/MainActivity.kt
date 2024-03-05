package com.example.juros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun calcSimples (view: View) {
        val edtValorFinanciado = findViewById<EditText>(R.id.edtValorFinanciado)
        val edtTotalJuros = findViewById<EditText>(R.id.edtTaxaJuros)
        val edtTotalMeses = findViewById<EditText>(R.id.edtTotalMeses)
        val taxaAA = findViewById<Button>(R.id.radioAA)
        val ValorF = edtValorFinanciado?.text.toString().toDouble()
        val JurosTotal = edtTotalJuros?.text.toString().toDouble()
        val MesesTotal = edtTotalMeses?.text.toString().toDouble()
        var calcmont = 0.0
        var calcjuros = 0.0
        var calcparcela = 0.0

        if (taxaAA.isSelected) {
            val taxa = JurosTotal/12.0
            calcmont =  ValorF + (ValorF * taxa * MesesTotal)
            calcjuros = calcmont - ValorF
            calcparcela = calcmont/MesesTotal
        }
        else {
            calcmont =  ValorF + (ValorF * JurosTotal * MesesTotal)
            calcjuros = calcmont - ValorF
            calcparcela = calcmont/MesesTotal
        }
        val intent = Intent (this, ResultadoJuros::class.java).apply {
            putExtra("calcmont", calcmont)
            putExtra("calcjuros", calcjuros)
            putExtra("calcparcela", calcparcela)
        }
        startActivity(intent)
    }
    fun calcComposto (view: View) {
        val edtValorFinanciado = findViewById<EditText>(R.id.edtValorFinanciado)
        val edtTotalJuros = findViewById<EditText>(R.id.edtTaxaJuros)
        val edtTotalMeses = findViewById<EditText>(R.id.edtTotalMeses)
        val taxaAA = findViewById<Button>(R.id.radioAA)
        val ValorF = edtValorFinanciado?.text.toString().toDouble()
        val JurosTotal = edtTotalJuros?.text.toString().toDouble()
        val MesesTotal = edtTotalMeses?.text.toString().toDouble()
        var calcmont = 0.0
        var calcjuros = 0.0
        var calcparcela = 0.0

        if (taxaAA.isSelected) {
            val taxa = Math.pow(1+JurosTotal,(1/12.0))-1
            calcmont =  ValorF * (1 + JurosTotal).pow(MesesTotal)
            calcjuros = calcmont - ValorF
            calcparcela = calcmont/MesesTotal
        }
        else {
            calcmont =  ValorF + (ValorF * JurosTotal * MesesTotal)
            calcjuros = calcmont - ValorF
            calcparcela = calcmont/MesesTotal
        }
        val intent = Intent (this, ResultadoJuros::class.java).apply {
            putExtra("calcmont", calcmont)
            putExtra("calcjuros", calcjuros)
            putExtra("calcparcela", calcparcela)
        }
        startActivity(intent)
    }
}