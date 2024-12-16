package com.example.week9.ui.view.mahasiswa

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Update
import com.example.week9.ui.viewmodel.MahasiswaViewModel
import com.example.week9.ui.viewmodel.PenyediaViewModel
import kotlinx.coroutines.launch
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.week9.ui.customwidget.CustomToppAppBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext


@Composable
fun UpdateMhsView(
    onBack: () -> Unit,
    onNavigate: () -> Unit,
    modifier: androidx.compose.ui.Modifier = Modifier,
    viewModel: MahasiswaViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val uiState = viewModel.updateUiState
    val snackbarHostState = remember{ SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(uiState.snackbarMessage) {
        println("LaunchedEffect triggered")
        uiState.snackbarMessage?.let {  message ->
            println("Snackbar message: $message")
            coroutineScope.launch {
                println("Launcing coroutine for snackbar")
                snackbarHostState.showSnackbar(
                    message = message,
                    duration = SnackbarDuration.Long
                )
                viewModel.resetSnackbarMessage()
            }
        }
    }


    Scaffold(
        modifier = modifier,
        snackbarHost = { androidx.compose.material3.SnackbarHost(hostState = snackbarHostState)},
        topBar = {
            CustomToppAppBar(
                judul = "Edit Mahasiswa",
                showBackButton = true,
                onBack = onBack,
            )
        }
    ){padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ){
            InsertBodyMhs(
                uiState = uiState,
                onValueChange = { updatedEvent ->
                    viewModel.updateState(updatedEvent)
                },
                onClick = {
                    coroutineScope.launch {
                        if (viewModel.validateFields()) {
                            viewModel.updateData()
                            delay(600)
                            withContext(Dispatchers.Main) {
                                onNavigate()
                            }
                        }
                    }
                }
            )
        }
    }
}