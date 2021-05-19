package br.senac.lista1

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import br.senac.lista1.databinding.ActivityEx09Binding

class Ex09 : AppCompatActivity() {
    lateinit var binding: ActivityEx09Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEx09Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSend.setOnClickListener {
            if (validateEditText(binding.editTextNumber1) && validateEditText(binding.editTextNumber2))
                sendValues()
        }
    }

    private fun sendValues() {
        val i = Intent(this, Ex09Detalhe::class.java)
        i.putExtra("number1", binding.editTextNumber1.text.toString().toDouble())
        i.putExtra("number2", binding.editTextNumber2.text.toString().toDouble())
        startActivityForResult(i, 1)
    }

    override fun onActivityResult(requestCode: Int,
                                  resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                binding.textViewResult.text = intent.getDoubleExtra("result", 0.0).toString()
            }
        }
    }

    private fun alert(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
        builder
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .create()
            .show()
    }

    private fun validateEditText(editText: EditText): Boolean {
        if (editText.text.isEmpty()) {
            alert("Erro", "Você deixou o campo ${editText.hint} em branco.")
            return false
        }
        return true
    }
}