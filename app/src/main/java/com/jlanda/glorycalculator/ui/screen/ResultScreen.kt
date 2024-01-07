package com.jlanda.glorycalculator.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jlanda.glorycalculator.R

@Composable
fun ResultScreen (navController: NavController, result:Int?){
    Column {
        Image(
            painter = painterResource(id = R.drawable.brawlhalla_logo),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 12.dp)
                .size(120.dp)
        )
        Text(
            text = "Glory Calculator!",
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            fontSize = 30.sp,
            textAlign = TextAlign.Center)
    }

    Column (
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Text(text = "Resultado!")
        Spacer(modifier = Modifier.padding(20.dp))
        val res = result?.toInt()
        Text(text = "$res Glorys")
    }

}