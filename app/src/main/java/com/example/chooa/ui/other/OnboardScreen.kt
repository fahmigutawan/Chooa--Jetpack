package com.example.chooa.ui.other

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.chooa.R
import com.example.chooa.util.viewmodel.MyViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun MyOnboard(navController: NavController, scope: CoroutineScope, viewModel: MyViewModel) {
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
        }

    }
}