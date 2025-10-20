package com.example.superapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.scientificcalculathor.Calculator
import com.example.superapp.TextEditor.TextEditor
import com.example.superapp.TextEditor.TextEditorNav
import com.example.superapp.ui.theme.SuperAppTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperAppTheme {
                Navigator()
            }
        }
    }
}

@Composable
fun Homepage(navController : NavController){
    Column(){
        ElevatedButton (onClick = {navController.navigate(Destination.Calculator)}){
            Text("Calculator")
        }

        ElevatedButton (onClick = {navController.navigate(Destination.TextEditor)}){
            Text("Text Editor")
        }
    }
}

object Destination{
    val Calculator = "Calculator"
    val TextEditor = "Text_Editor"
    val Homepage = "Homepage"
}

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun Navigator(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destination.Homepage
    ) {
//        // Definisi Destinasi (Graph)
//        composable("home") {
//            HomeScreen(onNavigateToDetail = { navController.navigate("detail/1") })
//        }
//        composable("detail/{itemId}") { backStackEntry ->
//            val itemId = backStackEntry.arguments?.getString("itemId")
//            DetailScreen(itemId)
//        }
        composable(Destination.Calculator){
            Calculator(navController = navController)
        }

        composable(Destination.TextEditor){
            TextEditorNav(navController = navController)
        }

        composable(Destination.Homepage){
            Homepage(navController = navController)
        }
    }
}
