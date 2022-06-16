package com.training.ui.transformationage.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.training.ui.transformationage.ui.DogsAdapter
import com.training.ui.transformationage.viewmodels.MainActivityViewModel
import com.training.ui.transformationage.R
import com.training.ui.transformationage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val  mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    val dogsadapter: DogsAdapter by lazy {
        DogsAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        setListeners()
        setupObserver()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(R.menu.main_menu == R.id.action_adicionar) {
            //TODO chamar tela de adicionar nova nota
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setListeners() {
        binding.apply {
            var nameDog = nameDogEditText.toString()
            var ageDog = ageDogEditText.toString()

            calculateButton.setOnClickListener {
                mainActivityViewModel.calculateAgeDog(5, "Bob")
            }
        }
    }

    private fun setupObserver() {
        mainActivityViewModel.result.observe(this, Observer {
            binding.resultTextView.text = it
        })
    }
}