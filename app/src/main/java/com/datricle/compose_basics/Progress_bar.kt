package com.datricle.compose_basics

import android.icu.number.IntegerWidth
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Delay
import java.lang.reflect.Modifier
import java.net.CookieHandler
import java.nio.file.Files.size
import java.time.Duration


class Progress_bar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
       Box(contentAlignment = Alignment.Center,
           modifier = androidx.compose.ui.Modifier.fillMaxSize()
       ){
           CircularProgressBar(percentage = 0.8f, number = 100)
       }
        }
    }
}

@Composable
fun CircularProgressBar(
    percentage: Float,
    number: Int,
    fontSize: TextUnit = 28.sp,
    radius: Dp = 50.dp,
    color: Color = Color.Red,
    stokeWidth: Dp = 8.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0
) {
    var animationPLayed by remember {
        mutableStateOf(false)
    }
    val curPercentage = animateFloatAsState(
        targetValue = if (animationPLayed) percentage else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = animDelay
        )
    )
    LaunchedEffect(key1 = true) {
        animationPLayed = true
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = androidx.compose.ui.Modifier.size(radius * 2f)
    ) {
        Canvas(modifier = androidx.compose.ui.Modifier.size(radius * 2f)) {
            drawArc(
                color = color,
                -90f,
                360 * curPercentage.value,
                useCenter = false,
               style = Stroke(stokeWidth.toPx(),cap= StrokeCap.Round)
                )
        }
        Text(text = (curPercentage.value * number).toInt().toString(),
            color =Color.Black,
            fontSize = fontSize,
            fontWeight = FontWeight.SemiBold
        )
    }
}