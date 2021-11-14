package com.example.android_lab5.etc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EventViewModel : ViewModel() {
    /*
    ---App Crash---
    private val events: MutableLiveData<List<EventData>> by lazy {
        MutableLiveData<List<EventData>>().also {
            loadEvents()
        }
    }

    ---Work, but hardcoded---  */
    private val events: MutableLiveData<List<EventData>> by lazy {
        MutableLiveData<List<EventData>>().also {
            it.postValue(loadEvents())
        }
    }


    fun getEvents(): LiveData<List<EventData>> {
        return events
    }
    /*
    ---App Crash---
    private fun loadEvents() {
        val list = listOf<EventData>(EventData("Christmas", "some desc to Christmas", "25.12"),
            EventData("New Year", "some desc to New Year", "31.12"),
            EventData("Birthday", "some desc to Birthday", "32.12"),
            EventData("Tire Fitter Day", "<3", "26.04"))
        events.postValue(list)
    }

    ---Work, but hardcoded--- */
    private fun loadEvents(): List<EventData> {
        return listOf<EventData>(EventData("Christmas", "some desc to Christmas", "25.12"),
            EventData("New Year", "some desc to New Year", "31.12"),
            EventData("Birthday", "some desc to Birthday", "32.12"),
            EventData("Tire Fitter Day", "<3", "26.04"))
    }


}
