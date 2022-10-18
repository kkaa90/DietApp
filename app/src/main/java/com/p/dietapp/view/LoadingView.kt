package com.p.dietapp.view

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.p.dietapp.navigation.RouteAction

@Composable
fun LoadingView(routeAction: RouteAction) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LaunchedEffect(true){
            Handler(Looper.getMainLooper()).postDelayed({
                routeAction.goMain()
            },2000)
        }
        Text(text = "앱 아이콘", fontSize = 40.sp)
    }
}