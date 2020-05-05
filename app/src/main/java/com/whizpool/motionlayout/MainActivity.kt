package com.whizpool.motionlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    private val totalItems = 2
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        previous.setOnClickListener {

            val nextIndex = currentIndex - 1

            if (nextIndex < 0)
            {
                return@setOnClickListener
            }

            currentIndex = nextIndex
            changeView()
        }

        next.setOnClickListener {

            val nextIndex = currentIndex + 1

            if (nextIndex >= totalItems)
            {
                return@setOnClickListener
            }

            currentIndex = nextIndex
            changeView()
        }

        changeView()
    }

    private fun changeView()
    {
        frame.removeAllViews()

        val layoutId = when (currentIndex)
        {
            0 -> R.layout.layout_1
            else -> R.layout.layout_2
        }

        frame.addView(layoutInflater.inflate(layoutId, frame, false))
    }
}