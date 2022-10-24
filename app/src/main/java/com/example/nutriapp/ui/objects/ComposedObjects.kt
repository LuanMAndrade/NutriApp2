package com.example.nutriapp.ui.objects

import android.widget.ProgressBar
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.semantics.ProgressBarRangeInfo
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CircularProgressBar(modifier: Modifier,
                        color: Color = Color.Green,
                        total : Float = 100f,
                        done : Float,
                        startAngle : Float = -90f,
                        radius : Float,
                        width: Float = 20f,
                        fontSize : Int = 15,
                        text : String = ""){

    var animationPlayed by remember {
        mutableStateOf(false)
    }

    val curPercentage = animateFloatAsState(
        targetValue = if (animationPlayed) done else 0f,
        animationSpec = tween(2000) )

    LaunchedEffect(key1 = true){
        animationPlayed = !animationPlayed
    }
    Box(modifier = modifier.padding(10.dp),
        contentAlignment = Alignment.Center) {

        Canvas(modifier = Modifier.size((radius*2).dp) ){
            drawArc(color = color,
                startAngle = startAngle,
                sweepAngle = (curPercentage.value/total) * 360,
                useCenter = false,
                style = Stroke(width, cap = StrokeCap.Round))
        }

        Text(text = "${done.toInt()}/${total.toInt()}\n"+text,
        fontWeight = FontWeight.Bold,
            fontSize = fontSize.sp,
            textAlign = TextAlign.Center
        )
    }



}