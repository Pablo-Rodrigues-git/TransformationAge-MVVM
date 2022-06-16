package com.training.ui.transformationage.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.training.ui.transformationage.ui.DogsAdapter
import com.training.ui.transformationage.viewmodels.MainActivityViewModel
import com.training.ui.transformationage.R
import com.training.ui.transformationage.databinding.ActivityMainBinding
import com.training.ui.transformationage.viewmodels.DogsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var dogsViewModel: DogsViewModel

    private val dogsadapter: DogsAdapter by lazy {
        DogsAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        recycler_view.adapter = dogsadapter
        recycler_view.layoutManager = LinearLayoutManager(this)

        dogsViewModel = ViewModelProviders.of(this).get(DogsViewModel::class.java)
        dogsViewModel.getDogs().observe(this, Observer { data ->
            data?.let {
                if (it.isEmpty()) {
                    Toast.makeText(this, "Lista vazia!", Toast.LENGTH_LONG).show()
                } else {
                    dogsadapter.add(it)
                }
            }
        })

        dogsViewModel.loadDogs()


//        setListeners()
//        setupObserver()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (R.menu.main_menu == R.id.action_adicionar) {
            //TODO chamar tela de adicionar nova nota
        }
        return super.onOptionsItemSelected(item)
    }

//    private fun setListeners() {
//        binding.apply {
//            var nameDog = nameDogEditText.toString()
//            var ageDog = ageDogEditText.toString()
//
//            calculateButton.setOnClickListener {
//                mainActivityViewModel.calculateAgeDog(5, "Bob")
//            }
//        }
//    }

//    private fun setupObserver() {
//        mainActivityViewModel.result.observe(this, Observer {
//            binding.resultTextView.text = it
//        })
//    }
}