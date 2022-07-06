package com.example.earthquakedisplay

import com.example.earthquakedisplay.ui.MainActivity
import org.junit.Before
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