package com.example.navigasiku.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilData(
    onBackBtnClick:()->Unit
) {
    val items = listOf(
        Pair(first = stringResource(id = R.string.nama_lengkap), second = "Anjani Dihapsari"),
        Pair(first = stringResource(id = R.string.jenis_kelamin), second = "Perempuan"),
        Pair(first = stringResource(id = R.string.alamat), second = "Kotamobagu"),
    )
}