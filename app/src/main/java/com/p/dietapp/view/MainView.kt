package com.p.dietapp.view.menu

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.p.dietapp.navigation.RouteAction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(routeAction: RouteAction, scope: CoroutineScope, drawerState: DrawerState) {
    val vis = remember {
        mutableStateOf(false)
    }
    BackHandler() {
        if(drawerState.isClosed){
            vis.value = true
        }
        else {
            scope.launch { drawerState.close() }
        }
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        if(vis.value) CloseApp(vis = vis)
    }
    ModalNavigationDrawer(
        drawerContent = { DrawerItems(routeAction = routeAction, scope, drawerState) },
        drawerState = drawerState
    ) {
        Scaffold(topBar = { TopBar(routeAction = routeAction, scope, drawerState) }) { p ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(p)
            ) {
                Text(text = "메인입니다")
            }
        }
    }
}

@Composable
fun CloseApp(vis : MutableState<Boolean>) {
    val context = LocalContext.current as Activity
    AlertDialog(
        onDismissRequest = { vis.value=false },
        title = { Text(text = "종료") },
        text = { Text(text = "종료하시겠습니까") },
        confirmButton = { TextButton(onClick = { context.finish() }) {
            Text("종료")
        }},
        dismissButton = { TextButton(onClick = { vis.value=false }) {
            Text(text = "취소")
        }}
    )
}