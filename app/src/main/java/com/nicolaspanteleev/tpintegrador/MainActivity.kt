package com.nicolaspanteleev.tpintegrador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.nicolaspanteleev.tpintegrador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.comparador.observe(this){
            if (binding.editText1.text.toString()==""||binding.editText2.text.toString()=="")
                binding.textView.text=getString(R.string.str_void)
            else if (it.compare())
                binding.textView.text=getString(R.string.str_same)
            else
                binding.textView.text=getString(R.string.str_different)
        }

        binding.compareButton.setOnClickListener{
            mainViewModel.updateComparador(binding.editText1.text.toString(),binding.editText2.text.toString())
        }
    }
}