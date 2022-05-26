package com.example.chooa.ui.other

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.navigation.NavController
import com.example.chooa.R
import com.example.chooa.ui.modelview.myDataStore
import com.example.chooa.util.route.FirstLayerRoute
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@SuppressLint("FlowOperatorInvokedInComposition")
@Composable
fun MySplash(navController: NavController, scope: CoroutineScope) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(start = 96.dp, end = 96.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "My logo"
            )
            Text(
                text = "Chooa",
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontSize = 36.sp
            )
        }
    }

    val context = LocalContext.current
    val isFirstTime: Flow<Boolean> = context.myDataStore.data.map {
        it[booleanPreferencesKey("isFirstTime")] ?: true
    }

    LaunchedEffect(key1 = navController, block = {
        scope.launch {
            delay(1500)
            if(isFirstTime.first()){
                navController.navigate(FirstLayerRoute.Onboard.route){
                    popUpTo(FirstLayerRoute.Splash.route){inclusive = true}
                }
            }else{
                navController.navigate(FirstLayerRoute.Home.route){
                    popUpTo(FirstLayerRoute.Splash.route){inclusive = true}
                }
            }
        }
    })
}