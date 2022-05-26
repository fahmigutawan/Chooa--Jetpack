package com.example.chooa.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import com.example.chooa.ui.other.MyHomeScreen
import com.example.chooa.ui.other.MyOnboard
import com.example.chooa.ui.other.MySplash
import com.example.chooa.util.route.FirstLayerRoute
import com.example.chooa.util.viewmodel.MyViewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun FirstLayerNav(
    viewModel: MyViewModel,
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    snackbarHostState: SnackbarHostState
) {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = FirstLayerRoute.Splash.route
    ) {
        composable(route = FirstLayerRoute.Splash.route) {
            MySplash(navController = navController, scope = scope)
        }
        composable(route = FirstLayerRoute.Onboard.route) {
            MyOnboard(
                navController = navController,
                scope = scope,
                viewModel = viewModel,
                snackbarHostState = snackbarHostState
            )
        }
        composable(route = FirstLayerRoute.Home.route) {
            MyHomeScreen(
                navController = navController,
                scope = scope,
                viewModel = viewModel,
                snackbarHostState = snackbarHostState
            )
        }
    }
}