package com.test.fdj.ui.fragments.league

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.fdj.databinding.ItemLeagueBinding
import com.test.fdj.model.League

class LeagueAdapter(
    private val items: List<League>,
    private val onItemClicked: (onClickCallback: String) -> Unit
) :
    RecyclerView.Adapter<LeagueAdapter.LeagueView>() {

    class LeagueView(binding: ItemLeagueBinding) : RecyclerView.ViewHolder(binding.root) {
        var tvLeague = binding.tvLeague
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: LeagueView, position: Int) {
        holder.setIsRecyclable(false)
        val league = items[position]
        holder.tvLeague.text = league.strLeague
        holder.tvLeague.setOnClickListener { onItemClicked(league.strLeague) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueView {
        val binding = ItemLeagueBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return LeagueView(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
