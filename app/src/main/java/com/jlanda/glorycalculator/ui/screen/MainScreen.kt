package com.jlanda.glorycalculator.ui.screen

import android.widget.AutoCompleteTextView.OnDismissListener
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jlanda.glorycalculator.R
import com.jlanda.glorycalculator.data.calculate

@Composable
fun MainScreen (navController: NavController){
    var wins by remember { mutableStateOf("") }
    var bestrating by remember { mutableStateOf("") }
    var resultadoTotal by remember { mutableStateOf("0") }
    var showDialog by rememberSaveable { mutableStateOf(false) }

    DialogResult(showDialog, resultadoTotal, {showDialog=false}, {showDialog=false})
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

    Column (Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

        OutlinedTextField(
            value = wins,
            onValueChange = { wins = it },
            label = { Text("Wins Ranked") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.padding(5.dp))
        OutlinedTextField(
            value = bestrating,
            onValueChange = { bestrating = it },
            label = { Text("Best Rating") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Button(onClick = {
            val calc = calculate()
            if (wins != "" && bestrating != ""){
                var tempres = calc.calculateMaxWin(wins.toInt()) + calc.calculateBestRating(bestrating.toInt())
                resultadoTotal = tempres.toString()
                showDialog = true
            }


//
//            var result = res.calculateMaxWin(wins.toInt()) + res.calculateBestRating(bestrating.toInt())
//            DialogResult(rslt = result.toString())
//            //navController.navigate(AppScreens.ResultScreen.route + "/" + result)
        }) {
            Text(text = "Calculate")
        }

    }

}

@Composable
fun DialogResult(show:Boolean, resultado:String, onDismiss:()->Unit, onConfirm:()->Unit){
    if (show) {
        val texto = "Total :$resultado"
        AlertDialog(onDismissRequest = {onDismiss()},
            confirmButton = {
                TextButton(
                    onClick = {
                        onConfirm()
                    }
                ) {
                    Text("Confirm")
                }},
            title = { Text(text = "Resultado de Glorys")},
            text = { Text(text = texto)}
        )
    }
}
