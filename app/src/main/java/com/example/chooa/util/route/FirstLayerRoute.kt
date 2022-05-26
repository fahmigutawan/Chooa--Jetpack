package com.example.chooa.util.route

sealed class FirstLayerRoute(val route:String){
    object Splash:FirstLayerRoute("splash")
    object Onboard:FirstLayerRoute("onboard")
    object Home:FirstLayerRoute("home")
}