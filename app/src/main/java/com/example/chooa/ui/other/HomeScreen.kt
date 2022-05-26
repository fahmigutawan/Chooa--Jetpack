package com.example.chooa.ui.other

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.navigation.NavController
import com.example.chooa.ui.modelview.myDataStore
import com.example.chooa.ui.theme.GraySolid
import com.example.chooa.util.viewmodel.MyViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition", "FlowOperatorInvokedInComposition")
@Composable
fun MyHomeScreen(
    navController: NavController,
    scope: CoroutineScope,
    viewModel: MyViewModel,
    snackbarHostState: SnackbarHostState
) {
    val scrHeight = LocalConfiguration.current.screenHeightDp
    val scrWidth = LocalConfiguration.current.screenWidthDp
    val context = LocalContext.current
    getNicknameToViewModel(context = context, scope = scope, viewModel = viewModel)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height((scrHeight * 1 / 8).dp)
                .background(color = GraySolid),
        ) {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {

                Text(
                    text = "Halo, ${viewModel.homeName}"
                )
            }
        }
    }
}

fun getNicknameToViewModel(context: Context, scope: CoroutineScope, viewModel: MyViewModel) {
    val namaTmp: Flow<String> = context.myDataStore.data.map {
        it[stringPreferencesKey("nickname")] ?: "NullCache"
    }
    scope.launch {
        viewModel.homeName = namaTmp.first()
    }
}