package br.senac.lista1

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.EditText
import br.senac.lista1.databinding.ActivityEx01Binding

class Ex01 : AppCompatActivity() {
    lateinit var binding: ActivityEx01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//      inserindo binding automático
        binding = ActivityEx01Binding.inflate(layoutInflater)
        setContentView(binding.root)

//      chamando método para cada dupla de checkBox e editText
        changeEnabled(binding.checkBoxPhone, binding.editPhone)
        changeEnabled(binding.checkBoxEmail, binding.editEmail)
        changeEnabled(binding.checkBoxCell, binding.editCell)

//      evento para quando clica no botão, se as validações estiverem certinhas, mostra a mensagem com os dados
        binding.buttonShow.setOnClickListener {
            if (validateEditTextWithCheckBox(binding.checkBoxPhone, binding.editPhone)
                    && validateEditTextWithCheckBox(binding.checkBoxEmail, binding.editEmail)
                    && validateEditTextWithCheckBox(binding.checkBoxCell, binding.editCell)
                    && validateEditText(binding.editName)) {
                showMessage()
            }
        }

        binding.buttonBack.setOnClickListener { finish() }
    }

//  método para mostrar uma janela com algum texto inserido na tela do usuário
    private fun alert(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
        builder
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null)
                .create()
                .show()
    }

//  método que monta a mensagem com os dados inseridos e mostra ao usuário
    private fun showMessage() {
        var msg = """${getString(R.string.name)}: ${binding.editName.text}
        |${getString(R.string.phone)}: ${binding.editPhone.text}
        |${getString(R.string.email)}: ${binding.editEmail.text}
        |${getString(R.string.whats)}: ${binding.editCell.text}
        |
        |${getString(R.string.preferences_contact)}
        """.trimMargin("|")
        if (binding.checkBoxPhone.isChecked) msg += "\n - ${getString(R.string.phone)}"

        if (binding.checkBoxEmail.isChecked) msg += "\n - ${getString(R.string.email)}"

        if (binding.checkBoxCell.isChecked) msg += "\n - ${getString(R.string.whats)}"

        alert(getString(R.string.data), msg)
    }

//  este método configura para o checkBox e editText inseridos no parâmetro para que o editText esteja clicável para escrever se a checkBox estiver marcada
    private fun changeEnabled(checkBox: CheckBox, editText: EditText) {
        checkBox.setOnClickListener {
            editText.isEnabled = false
            if (checkBox.isChecked) editText.isEnabled = true
        }
    }

//  método que valida o editText e a checkBox dos parametros para caso a mesma esteja marcada porém o texto em branco, assim mostrando uma mensagem de erro para o usuário e retornando falso, retorna verdadeiro se estiver tudo certo
    private fun validateEditTextWithCheckBox(checkBox: CheckBox, editText: EditText): Boolean {
        if (checkBox.isChecked && editText.text.isEmpty()) {
            alert("Erro", "Você marcou o campo ${editText.hint} e o deixou em branco.")
            return false
        }
        return true
    }

//  método que valida editText caso esteja vazia, funciona igual o método validateEditTextWithCheckBox porém sem a parte do checkBox
    private fun validateEditText(editText: EditText): Boolean {
        if (editText.text.isEmpty()) {
            alert("Erro", "Você deixou o campo ${editText.hint} em branco.")
            return false
        }
        return true
    }

}