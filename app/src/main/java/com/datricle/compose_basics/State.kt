package com.datricle.compose_basics

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.datricle.compose_basics.ui.theme.Compose_basicsTheme

class State :ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            Compose_basicsTheme {

            }
        }
    }
}