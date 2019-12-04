package com.taleb.roomdemo.demo1

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Student::class],version = 1)
abstract class MyDatabase: RoomDatabase() {

    abstract fun studentDAO():StudentDAO

}