package br.senac.lista1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senac.lista1.databinding.ActivityEx05Binding
import java.lang.Exception

class Ex05 : AppCompatActivity() {
    lateinit var binding: ActivityEx05Binding
    var number1 = 0.0
    var number2 = 0.0
    var operator = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEx05Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener { insertNumberToText("1") }
        binding.button2.setOnClickListener { insertNumberToText("2") }
        binding.button3.setOnClickListener { insertNumberToText("3") }
        binding.button4.setOnClickListener { insertNumberToText("4") }
        binding.button5.setOnClickListener { insertNumberToText("5") }
        binding.button6.setOnClickListener { insertNumberToText("6") }
        binding.button7.setOnClickListener { insertNumberToText("7") }
        binding.button8.setOnClickListener { insertNumberToText("8") }
        binding.button9.setOnClickListener { insertNumberToText("9") }
        binding.button0.setOnClickListener { insertNumberToText("0") }
        binding.buttonDivision.setOnClickListener { getValue("÷") }
        binding.buttonMulti.setOnClickListener { getValue("x") }
        binding.buttonSum.setOnClickListener { getValue("+") }
        binding.buttonSub.setOnClickListener { getValue("-") }
        binding.buttonDot.setOnClickListener { insertNumberToText(getString(R.string.dot)) }
        binding.buttonDel.setOnClickListener { deleteLastChar() }
        binding.buttonEqual.setOnClickListener { calculate() }

    }

    private fun getValue(op: String) {
        try {
            var aux = binding.textViewShow.text.toString().replace(",", ".", false).toDouble()
            if(operator.isEmpty()) {
                number1 = aux
                operator = op
                binding.textViewShow.text = ""
            } else {
                number2 = aux
                operator = ""
            }

        } catch (e: Exception) {
            println(e)
        }
    }

    private fun insertNumberToText(number: String) {
        binding.textViewShow.append(number)
    }

    private fun deleteLastChar() {
        if (binding.textViewShow.text.any()) binding.textViewShow.text = binding.textViewShow.text.subSequence(0, binding.textViewShow.text.length-1)
    }

    private fun calculate() {
        when (operator) {
            "+" -> {
                number1 += number2
            }
            "-" -> {
                number1 -= number2
            }
            "x" -> {
                number1 *= number2
            }
            "÷" -> {
                number1 /= number2
            }
        }
        binding.textViewShow.text = number1.toString()
    }
}