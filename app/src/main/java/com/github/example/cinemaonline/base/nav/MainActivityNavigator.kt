package com.github.example.cinemaonline.base.nav

import androidx.appcompat.app.AppCompatActivity
import com.github.example.cinemaonline.R
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivityNavigator(activity: AppCompatActivity) : AppNavigator(
    activity = activity,
    containerId = R.layout.activity_main
)