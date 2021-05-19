package br.senac.lista1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senac.lista1.databinding.ActivityEx09DetalheBinding

class Ex09Detalhe : AppCompatActivity() {
    lateinit var binding: ActivityEx09DetalheBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEx09DetalheBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var number1 = intent.getDoubleExtra("number1", 0.0)
        var number2 = intent.getDoubleExtra("number2", 0.0)

        binding.buttonSumNumbers.setOnClickListener { calculate(number1, number2, 0) }
        binding.buttonSubNumbers.setOnClickListener { calculate(number1, number2, 1) }
        binding.buttonDivideNumbers.setOnClickListener { calculate(number1, number2, 2) }
        binding.buttonMultiplication.setOnClickListener { calculate(number1, number2, 3) }
    }

    private fun calculate(n1: Double, n2: Double, op: Int) {
        var returnIntent = Intent()
        when (op) {
            0 -> { returnIntent.putExtra("result", n1 + n2) }
            1 -> { returnIntent.putExtra("result", n1 - n2) }
            2 -> { returnIntent.putExtra("result", n1 / n2) }
            3 -> { returnIntent.putExtra("result", n1 * n2) }
        }
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
    }
}