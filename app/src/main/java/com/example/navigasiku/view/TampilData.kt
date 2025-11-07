package com.example.navigasiku.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

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
    Scaffold (modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {Text(text = stringResource(id = R.string.tampil), color = Color.White)},
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = colorResource(id=R.color.teal_700))
            )
        }) { isiRuang->
        Column(modifier = Modifier.padding(paddingValues = isiRuang),
            verticalArrangement = Arrangement.SpaceBetween) {
            Column(modifier = Modifier.padding(all= dimensionResource(id=R.dimen.padding_medium)),
                verticalArrangement = Arrangement.spacedBy (space= dimensionResource(id = 10dp))) {
                items.forEach { item ->
                    Column {
                        Text(text = item.first.uppercase(), fontSize = 16.sp)
                        Text(text = item.second, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Cursive, fontSize = 22.sp)
                    }
                    HorizontalDivider(thickness = 1.dp, color = Color.Cyan)
                }
            }
        }
    }
}