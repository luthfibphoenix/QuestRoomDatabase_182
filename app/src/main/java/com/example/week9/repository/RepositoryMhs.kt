package com.example.week9.repository

import com.example.week9.data.entity.Mahasiswa

interface RepositoryMhs {
    suspend fun insertMhs(mahassiswa: Mahasiswa)
}