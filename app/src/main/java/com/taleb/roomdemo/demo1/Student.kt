package com.taleb.roomdemo.demo1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @ColumnInfo(name = "name")
    var firstName: String,
    @ColumnInfo(name = "lastName")
    var lastName: String
) {
    @PrimaryKey(autoGenerate = true)
    var ID: Int? = null
}