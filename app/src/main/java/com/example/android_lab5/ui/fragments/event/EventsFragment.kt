package com.example.android_lab5.ui.fragments.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_lab4.R
import com.example.android_lab4.fragments.HolidayFragment
import com.example.android_lab5.etc.EventData
import com.example.android_lab5.etc.EventViewModel
import com.example.android_lab5.etc.EventsAdapter
import com.example.android_lab5.ui.MainActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

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

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = eventsAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        eventsAdapter.reload(listOf<EventData>(EventData("Christmas", "some desc to Christmas", "25.12"),
            EventData("New Year", "some desc to New Year", "31.12"),
            EventData("Birthday", "some desc to Birthday", "32.12"),
            EventData("Tire Fitter Day", "<3", "26.04")))

        val model: EventViewModel by viewModels()
        model.getEvents().observe(viewLifecycleOwner) {
            eventsAdapter.reload(it)
        }


        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.container, NewEventFragment()).addToBackStack(null).commit()
        }

    }
}