package com.p.dietapp.view.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.p.dietapp.navigation.NAVROUTE
import com.p.dietapp.navigation.RouteAction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerItems(routeAction: RouteAction, scope: CoroutineScope, drawerState: DrawerState) {
    Column(modifier = Modifier.background(Color.White)) {
        StatusView()
        MenuItemView(nav = NAVROUTE.MAIN, routeAction = routeAction, scope, drawerState)
        MenuItemView(nav = NAVROUTE.SCHEDULE, routeAction = routeAction, scope, drawerState)
        MenuItemView(nav = NAVROUTE.SETTING, routeAction = routeAction, scope, drawerState)
    }
}

@Composable
fun StatusView() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.Yellow)) {
        Text(text = "XXX")
        Text(text = "신장 : XXXcm")
        Text(text = "체중 : XXkg")
        Text(text = "목표 체중 : XXkg")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuItemView(
    nav: NAVROUTE,
    routeAction: RouteAction,
    scope: CoroutineScope,
    drawerState: DrawerState
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            routeAction.navTo(nav)
            scope.launch { drawerState.close() }
        }) {
        Text(text = nav.description, modifier = Modifier.padding(8.dp))
    }
}