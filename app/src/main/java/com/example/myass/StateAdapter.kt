package com.example.myass

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myass.databinding.ListItemBinding

class StateAdapter(val context: Context, val layout: Int, val states: MutableList<State>,var onClickListener:OnStateClickListener) :
    RecyclerView.Adapter<StateAdapter.ViewHolder>() {
    interface OnStateClickListener {
        fun onStateClick(state: State?, position: Int)
    }
    private var inflater: LayoutInflater? = null

    init {
        this.inflater = LayoutInflater.from(context);
        this.onClickListener=onClickListener
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val flagView: ImageView
        val surnameView: TextView
        val ageView: TextView
        val number_of_gamesView: TextView
        val number_of_missed_pucksView: TextView

        init {
            val binding = view.let { ListItemBinding.bind(it) }
            flagView = binding.flag
            surnameView = binding.name
            ageView = binding.age
            number_of_gamesView = binding.numberOfGames
            number_of_missed_pucksView = binding.numberOfMissedPucks
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View? = inflater?.inflate(layout, parent, false)
        return ViewHolder(view!!)
    }

    override fun getItemCount(): Int {
        return states.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val state = states[position]
        holder.flagView.setImageResource(state.flag)
        holder.surnameView.text = state.surname
        holder.number_of_gamesView.text = state.number_of_games.toString()
        holder.number_of_missed_pucksView.text = state.number_of_missed_pucks.toString()
        holder.ageView.text = state.age.toString()
        holder.itemView.setOnClickListener {
            onClickListener?.onStateClick(state, position);
        }
    }
}