package com.example.week9.ui.viewmodel

import com.example.week9.data.entity.Mahasiswa


fun Mahasiswa.toDetailUiEvent() : MahasiswaEvent {
    return MahasiswaEvent(
        nim = nim,
        nama = nama,
        jenisKelamin = jenisKelamin,
        alamat = alamat,
    )
}