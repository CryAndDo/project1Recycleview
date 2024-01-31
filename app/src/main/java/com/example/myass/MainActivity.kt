package com.example.myass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myass.StateAdapter.OnStateClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.myass.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    var states = ArrayList<State>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerView = binding.list
        setInitialData();
        val stateClickListener: OnStateClickListener = object : OnStateClickListener {
            override fun onStateClick(state: State?, position: Int) {
                Toast.makeText(
                    applicationContext, "Был выбран пункт " + state!!.surname,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        val adapter = StateAdapter(this,R.layout.list_item,states,stateClickListener)
// устанавливаем для списка адаптер
        recyclerView.adapter = adapter
    }

    private fun setInitialData() {
        states.add(State("Албания", 5, 3,1, R.drawable.xok))
        states.add(State("Аджир", 5, 3,1, R.drawable.xok))
        states.add(State("Австрия", 5, 3,1, R.drawable.xok))
        states.add(State("Азербайджан", 5, 3,1, R.drawable.xok))
    }
}