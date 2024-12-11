package com.example.week9.repository

import com.example.week9.data.dao.MahasiswaDao
import com.example.week9.data.entity.Mahasiswa

class LocalRepositoryMhs(
    private val mahasiswaDao: MahasiswaDao
): RepositoryMhs {
    override suspend fun insertMhs(mahassiswa: Mahasiswa) {
        mahasiswaDao.insertMahasiswa(mahassiswa)
    }

}