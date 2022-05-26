package com.example.chooa.ui.other

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.navigation.NavController
import com.example.chooa.R
import com.example.chooa.ui.modelview.myDataStore
import com.example.chooa.ui.theme.GrayLight
import com.example.chooa.ui.theme.GraySolid
import com.example.chooa.util.other.MyButton
import com.example.chooa.util.route.FirstLayerRoute
import com.example.chooa.util.viewmodel.MyViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.*

@Composable
fun MyOnboard(
    navController: NavController,
    scope: CoroutineScope,
    viewModel: MyViewModel,
    snackbarHostState: SnackbarHostState
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = Modifier.padding(start = 32.dp, end = 32.dp),
                painter = painterResource(id = R.drawable.ic_people_with_umbrella),
                contentDescription = "Onboard logo"
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Mari Kenalan, Siapa Namamu?",
                fontSize = 14.sp,
                fontFamily = FontFamily(
                    Font(R.font.poppins_reguler)
                ),
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                modifier = Modifier.padding(start = 64.dp, end = 64.dp),
                value = viewModel.onboardTextField,
                onValueChange = { viewModel.onboardTextField = it },
                textStyle = TextStyle(
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_reguler))
                ),
                shape = RoundedCornerShape(corner = CornerSize(16.dp)),
                colors = TextFieldDefaults
                    .textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = Color.White
                    )
            )
            Spacer(modifier = Modifier.height(16.dp))
            MyButton(
                onClick = {
                    if (viewModel.onboardTextField.isEmpty()) {
                        scope.launch {
                            snackbarHostState.currentSnackbarData?.dismiss()
                            snackbarHostState.showSnackbar(
                                "Harap Masukkan Nama Anda",
                                duration = SnackbarDuration.Short
                            )
                        }
                    } else {
                        scope.launch {
                            context.myDataStore.edit {
                                it[booleanPreferencesKey("isFirstTime")] = false
                                it[stringPreferencesKey("nickname")] = viewModel.onboardTextField
                            }

                            navController.navigate(FirstLayerRoute.Home.route) {
                                popUpTo(FirstLayerRoute.Onboard.route) { inclusive = true }
                            }
                        }
                    }
                },
            ) {
                Text(
                    modifier = Modifier.padding(all = 8.dp),
                    text = "Lanjutkan",
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.poppins_reguler)),
                    fontSize = 14.sp,
                )
            }
        }

    }
}