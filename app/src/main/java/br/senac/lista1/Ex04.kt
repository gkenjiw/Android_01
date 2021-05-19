package br.senac.lista1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import br.senac.lista1.databinding.ActivityEx04Binding

class Ex04 : AppCompatActivity() {
    lateinit var binding: ActivityEx04Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEx04Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initSpinners()

        binding.spinnerType.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long) {
                setItemsSpinnerGenre(position)
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                val itemsSpinnerGenre = arrayOf(getString(R.string.select_type_first))
                setSpinnerAdapter(itemsSpinnerGenre, binding.spinnerGenre)
            }
        }
    }

    private fun initSpinners() {
        val itemsSpinnerType = resources.getStringArray(R.array.array_type_universe)
        setSpinnerAdapter(itemsSpinnerType, binding.spinnerType)
        val itemsSpinnerGenre = arrayOf(getString(R.string.select_type_first))
        setSpinnerAdapter(itemsSpinnerGenre, binding.spinnerGenre)
    }

    private fun setSpinnerAdapter(array: Array<String>, spinner: Spinner) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, array)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    private fun setItemsSpinnerGenre(pos: Int) {
        when (pos) {
            0 -> {
                val itemsSpinnerGenre = arrayOf(getString(R.string.select_type_first))
                setSpinnerAdapter(itemsSpinnerGenre, binding.spinnerGenre)
            }
            1 -> {
                val itemsSpinnerGenre = resources.getStringArray(R.array.array_movie_genre)
                setSpinnerAdapter(itemsSpinnerGenre, binding.spinnerGenre)
            }
            2 -> {
                val itemsSpinnerGenre = resources.getStringArray(R.array.array_music_genre)
                setSpinnerAdapter(itemsSpinnerGenre, binding.spinnerGenre)
            }
            3 -> {
                val itemsSpinnerGenre = resources.getStringArray(R.array.array_book_genre)
                setSpinnerAdapter(itemsSpinnerGenre, binding.spinnerGenre)
            }
            4 -> {
                val itemsSpinnerGenre = resources.getStringArray(R.array.array_game_genre)
                setSpinnerAdapter(itemsSpinnerGenre, binding.spinnerGenre)
            }
        }
    }
}