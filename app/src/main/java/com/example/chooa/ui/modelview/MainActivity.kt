package com.example.chooa.ui.modelview

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChooaTheme {
                val scope = rememberCoroutineScope()

                Surface(modifier = Modifier.fillMaxSize(), color = GrayBlack) {
                    FirstLayerNav(
                        viewModel = myViewModel,
                        scope = scope
                    )
                }
            }
        }
    }
}