package com.taleb.roomdemo.demo1

import androidx.room.*

@Dao
interface StudentDAO {

    @Query("SELECT * FROM Student")
    fun getAll(): List<Student>

    @Insert
    fun insertAll(students: List<Student>)

    @Query("SELECT * FROM STUDENT WHERE name= :name")
    fun search(name: String):List<Student>

    @Update
    fun update(student: Student)

    @Delete
    fun delete(student: Student)
}