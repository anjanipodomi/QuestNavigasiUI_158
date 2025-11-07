package com.example.navigasiku.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.navigasiku.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(
    jenisK: List<String> = listOf("Laki-laki", "Perempuan"),
    onSubmitBtnClick: (nama: String, alamat: String, jenis: String?) -> Unit
) {
    // State untuk text field
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    // State untuk radio button
    var selectedJenis by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.home), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier.padding(paddingValues = isiRuang),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it }, // ini yang bikin bisa ketik
                singleLine = true,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(250.dp),
                label = { Text("Nama Lengkap") }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Jenis Kelamin", color = Color.Black)
            Row {
                jenisK.forEach { item ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(end = 16.dp)
                    ) {
                        RadioButton(
                            selected = selectedJenis == item,
                            onClick = { selectedJenis = item }
                        )
                        Text(text = item)
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = alamat,
                onValueChange = { alamat = it }, // ini yang bikin bisa ketik
                singleLine = true,
                modifier = Modifier.width(250.dp),
                label = { Text("Alamat") }
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp),
                onClick = { onSubmitBtnClick(nama, alamat, selectedJenis) }
            ) {
                Text(text = stringResource(id = R.string.submit))
            }
        }
    }
}
