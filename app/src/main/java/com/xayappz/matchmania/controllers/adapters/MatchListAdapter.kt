package com.xayappz.matchmania.controllers.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xayappz.matchmania.databinding.ListItemBinding
import com.xayappz.matchmania.models.Data

class MatchListAdapter(
    private val matchData: List<Data>,
    private val Timeline: Int?
) : RecyclerView.Adapter<MatchViewHolder>() {
    private lateinit var binding: ListItemBinding
    var onItemClick: ((Data) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MatchViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val openDate = matchData[position].openDate.toString()
        holder.itemView.setOnClickListener { onItemClick?.let { it1 -> it1(matchData.get(position)) } }
        if (openDate.isNotEmpty()) {
            val getTime = openDate.substring(10)
            binding.tvMatchTime.text = openDate
            when (Timeline) {
                0 -> {
                    binding.tvMatchTime.text = ""
                    binding.tvMatchTime.visibility = View.GONE
                }

                1 -> {
                    binding.tvMatchTime.text = getTime

                }

                2 -> {
                    binding.tvMatchTime.text = "Tomorrow $getTime"

                }

            }
        }
        holder.bind(matchData[position])

    }

    override fun getItemCount(): Int = matchData.size

}

class MatchViewHolder(
    private val binding: ListItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(match: Data) {
        binding.matchData = match
    }
}

