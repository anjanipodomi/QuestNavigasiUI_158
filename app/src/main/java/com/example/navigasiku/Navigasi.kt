package com.example.navigasiku

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

enum class Navigasi{
    Formulirku,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
) {
    Scaffold { isiRuang->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulirku.name,
            modifier = Modifier.padding(paddingValues= isiRuang)
        ) {
            composable(route = Navigasi.Formulirku.name) {
                FormIsian(
                    onSubmitBtnClick = {
                        navController.navigate(route= Navigasi.Detail.name)
                    }
                )
            }
        }
    }
}