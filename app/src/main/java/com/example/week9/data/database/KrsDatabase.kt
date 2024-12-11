package com.example.week9.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.week9.data.dao.MahasiswaDao
import com.example.week9.data.entity.Mahasiswa




@Database(entities = [Mahasiswa::class], version = 1, exportSchema = false)
abstract class KrsDatabase  : RoomDatabase() {

    //Mendefinisikan fungsi untuk mengkases data Mahasiswa
    abstract fun mahasiswaDao(): MahasiswaDao

    companion object{
        @Volatile //memastikan bahwa nilai variabel Instance selalu sama di setiap
        private var Instance: KrsDatabase? = null

        fun getDatabase(context: Context): KrsDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    KrsDatabase::class.java, //Class database
                    "KrsDatabase" //nama database
                )
                    .build().also { Instance = it }
            }
        }
    }
}