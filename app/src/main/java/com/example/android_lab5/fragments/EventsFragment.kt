package com.example.android_lab4.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_lab4.R
import com.example.android_lab5.etc.EventData
import com.example.android_lab5.etc.EventsAdapter

class EventsFragment : Fragment() {

    private val eventsAdapter = EventsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_events, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.RecyclerView).apply {
            adapter = eventsAdapter
            layoutManager = LinearLayoutManager(context)
        }

        val events = listOf<EventData>(EventData("Christmas", "some desc to Christmas", "25.12"),
            EventData("New Year", "some desc to New Year", "31.12"),
            EventData("Birthday", "some desc to Birthday", "32.12"),
            EventData("Tire Fitter Day", "<3", "26.04"))

        eventsAdapter.reload(events)
    }
}