package com.example.chooa.ui.modelview

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.chooa.navigation.FirstLayerNav
import com.example.chooa.ui.theme.ChooaTheme
import com.example.chooa.ui.theme.GrayBlack
import com.example.chooa.util.viewmodel.MyViewModel

val Context.myDataStore: DataStore<Preferences> by preferencesDataStore(name = "local_cache")

class MainActivity : ComponentActivity() {
    val myViewModel by viewModels<MyViewModel>()

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChooaTheme {
                val scope = rememberCoroutineScope()
                val scaffoldState = rememberScaffoldState()
                val snackbarHostState = scaffoldState.snackbarHostState
                Scaffold(
                    scaffoldState = scaffoldState,
                ) {
                    Surface(modifier = Modifier.fillMaxSize(), color = GrayBlack) {
                        FirstLayerNav(
                            viewModel = myViewModel,
                            scope = scope,
                            scaffoldState = scaffoldState,
                            snackbarHostState = snackbarHostState
                        )
                    }
                }

            }
        }
    }
}