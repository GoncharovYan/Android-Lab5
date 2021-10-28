package com.example.android_lab5.etc

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_lab4.R

class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val eventName: TextView = itemView.findViewById(R.id.eventName)
    private val eventDescr: TextView = itemView.findViewById(R.id.eventDescription)
    private val eventDate: TextView = itemView.findViewById(R.id.eventDate)

    fun bind(event: EventData) {
        eventName.text = event.title
        eventDescr.text = event.desc
        eventDate.text = event.dateStart
    }
}