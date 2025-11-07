package com.example.navigasiku
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigasiku.view.FormIsian
import com.example.navigasiku.view.TampilData


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
                FormIsian { nama, alamat, jenisKelamin ->
                    navController.currentBackStackEntry?.savedStateHandle?.set("nama", nama)
                    navController.currentBackStackEntry?.savedStateHandle?.set("alamat", alamat)
                    navController.currentBackStackEntry?.savedStateHandle?.set("jenisKelamin", jenisKelamin)
                    navController.navigate(Navigasi.Detail.name)
                }
            }

            composable(route = Navigasi.Detail.name) {
                val previousBackStackEntry = navController.previousBackStackEntry
                val nama = previousBackStackEntry?.savedStateHandle?.get<String>("nama") ?: ""
                val alamat = previousBackStackEntry?.savedStateHandle?.get<String>("alamat") ?: ""
                val jenisKelamin = previousBackStackEntry?.savedStateHandle?.get<String>("jenisKelamin")

                TampilData(
                    nama = nama,
                    alamat = alamat,
                    jenisKelamin = jenisKelamin,
                    onBackBtnClick = { cancelAndBackToFormulir(navController) }
                )
            }
        }
    }
}

private fun cancelAndBackToFormulir(
    navController: NavHostController
) {
    navController.popBackStack(route= Navigasi.Formulirku.name, inclusive = false)
}