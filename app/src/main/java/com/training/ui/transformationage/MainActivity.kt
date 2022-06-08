package com.training.ui.transformationage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.training.ui.transformationage.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        setListeners()
        setupObserver()
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