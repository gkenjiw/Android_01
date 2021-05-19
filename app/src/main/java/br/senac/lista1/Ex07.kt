package br.senac.lista1

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senac.lista1.databinding.ActivityEx07Binding

class Ex07 : AppCompatActivity() {
    lateinit var binding: ActivityEx07Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEx07Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBack.setOnClickListener { finish() }
        binding.buttonNext.setOnClickListener { sendTexts() }
    }

    private fun sendTexts() {
        if (binding.editText.text.isNotEmpty() && binding.editText2.text.isNotEmpty()) {
            val intent = Intent(this, Ex07Detalhe::class.java)
            intent.putExtra("text1", binding.editText.text.toString())
            intent.putExtra("text2", binding.editText2.text.toString())
            startActivity(intent)
        } else {
            alert("Erro", "Preencha os campos por favor.")
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
}