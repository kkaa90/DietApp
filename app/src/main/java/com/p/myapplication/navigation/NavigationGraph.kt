package com.p.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.p.myapplication.MainViewModel

@Composable
fun NavigationGraph(starting :  String = NAVROUTE.LOADING.routeName){
    val navController = rememberNavController()

    val routeAction = remember(navController) { RouteAction(navController) }
    val mainViewModel : MainViewModel = viewModel()

    NavHost(navController = navController, startDestination = starting){
        composable(NAVROUTE.LOADING.routeName){

        }
        composable(NAVROUTE.MAIN.routeName){

        }
        composable(NAVROUTE.SCHEDULE.routeName){

        }
        composable(NAVROUTE.NOTIFICATION.routeName){

        }
        composable(NAVROUTE.SETTING.routeName){

        }
    }
}