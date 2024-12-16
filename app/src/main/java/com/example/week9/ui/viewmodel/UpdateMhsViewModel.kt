package com.example.week9.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.week9.repository.RepositoryMhs

class UpdateMhsViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryMhs: RepositoryMhs
) : ViewModel () {
     var updateUiState by mutableStateOf(MhsUIState())
         private set

    private val _nim: String = checkNotNull(savedStateHandle[DestinationEdit.NIM])
}