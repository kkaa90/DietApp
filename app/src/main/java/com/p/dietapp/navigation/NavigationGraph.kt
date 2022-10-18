package com.p.dietapp.navigation

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.p.dietapp.MainViewModel
import com.p.dietapp.view.LoadingView
import com.p.dietapp.view.NotificationView
import com.p.dietapp.view.ScheduleView
import com.p.dietapp.view.SettingView
import com.p.dietapp.view.menu.MainView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationGraph(starting :  String = NAVROUTE.LOADING.routeName){
    val navController = rememberNavController()

    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val routeAction = remember(navController) { RouteAction(navController) }
    val mainViewModel : MainViewModel = viewModel()

    NavHost(navController = navController, startDestination = starting){
        composable(NAVROUTE.LOADING.routeName){
            LoadingView(routeAction = routeAction)
        }
        composable(NAVROUTE.MAIN.routeName){
            MainView(routeAction = routeAction, scope, drawerState)
        }
        composable(NAVROUTE.SCHEDULE.routeName){
            ScheduleView(routeAction = routeAction)
        }
        composable(NAVROUTE.NOTIFICATION.routeName){
            NotificationView(routeAction = routeAction)
        }
        composable(NAVROUTE.SETTING.routeName){
            SettingView(routeAction = routeAction)
        }
    }
}