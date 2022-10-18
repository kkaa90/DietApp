package com.p.dietapp.view.menu

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.p.dietapp.navigation.NAVROUTE
import com.p.dietapp.navigation.RouteAction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(routeAction: RouteAction, scope: CoroutineScope, drawerState: DrawerState) {
    CenterAlignedTopAppBar(
        title = { Text(text = "다이어트") },
        navigationIcon = {
            IconButton(onClick = { scope.launch { drawerState.open() } }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "메뉴")
            }
        },
        actions = {
            IconButton(onClick = { routeAction.navTo(NAVROUTE.NOTIFICATION) }) {
                Icon(imageVector = Icons.Filled.Notifications, contentDescription = "알림")
            }
        }
    )
}