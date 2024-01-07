package com.jlanda.glorycalculator.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jlanda.glorycalculator.ui.navigation.AppNavigation
import com.jlanda.glorycalculator.ui.theme.GloryCalculatorTheme
import kotlinx.coroutines.GlobalScope
import java.net.HttpURLConnection

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //MobileAds.initialize(this){}
        setContent {
            GloryCalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}


// @Preview(showSystemUi = true)
// @Composable