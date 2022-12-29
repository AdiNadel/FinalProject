package adi.nadel.lec17.database

import adi.nadel.lec17.database.dao.PeopleDao
import adi.nadel.lec17.models.Person
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

const val DB_NAME = "AppDatabase"
const val DB_VERSION = 1

@Database(entities = [Person::class], version = DB_VERSION)
abstract class AppDatabase: RoomDatabase() {
    abstract fun peopleDao(): PeopleDao

    companion object{
        fun create(context: Context):AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }
}