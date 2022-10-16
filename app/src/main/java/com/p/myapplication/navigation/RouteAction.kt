package com.p.myapplication.navigation

import androidx.navigation.NavHostController

class RouteAction(navHostController: NavHostController) {
    val navTo : (NAVROUTE) -> Unit = {route ->
        navHostController.navigate(route.routeName)
    }

    val navWithNum: (String) -> Unit = {route ->
        navHostController.navigate(route)
    }

    val goBack : () -> Unit = {
        navHostController.popBackStack()
    }

    val goMain : () -> Unit = {
        navHostController.navigate(NAVROUTE.MAIN.routeName){
            popUpTo(0)
        }
    }
}