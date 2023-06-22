package com.test.fdj.ui.fragments.team

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.fdj.databinding.ItemTeamBinding
import com.test.fdj.model.Team


class TeamAdapter(
    private val items: List<Team>,
    context: Context
) :
    RecyclerView.Adapter<TeamAdapter.TeamView>() {
    private val glideManager = Glide.with(context)

    class TeamView(binding: ItemTeamBinding) : RecyclerView.ViewHolder(binding.root) {
         var imvTeam = binding.imvTeam
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: TeamView, position: Int) {
        holder.setIsRecyclable(false)
        val team = items[position]
        glideManager
            .load(team.strTeamBadge)
            .into(holder.imvTeam)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamView {
        val binding = ItemTeamBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamView(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
