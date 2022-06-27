package com.example.sidetakehomeassignment

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.sidetakehomeassignment.domain.MainViewModel
import com.example.sidetakehomeassignment.ui.MainActivity
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    private var activity: MainActivity? = null

    @Before
    fun setup() {
         activity = Robolectric.buildActivity(MainActivity::class.java).create().get()

    }


}