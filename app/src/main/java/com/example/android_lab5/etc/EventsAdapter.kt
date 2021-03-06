package com.example.android_lab5.etc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_lab4.R

class EventsAdapter : RecyclerView.Adapter<EventViewHolder>() {

    private var eventsList = listOf<EventData>()

    fun reload(events: List<EventData>) {
        eventsList = events
        notifyItemChanged(0, events.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.event_unit, parent, false)
        return EventViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(eventsList[position])
    }

    override fun getItemCount() = eventsList.size
}