package com.taleb.roomdemo.demo1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.taleb.roomdemo.R
import kotlinx.android.synthetic.main.activity_demo_one.*

class DemoOneActivity : AppCompatActivity() {

    private lateinit var database:MyDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_one)

        database = Room.databaseBuilder(this,MyDatabase::class.java,"roomdemo.db")
            .allowMainThreadQueries()
            .build()

        // 1
        //insertAndRead()
        // 2
        //searchAndRead()
        // 3
        //readAndUpdate()
        // 4
        //readAndDelete()

    }


    private fun readAndDelete(){
        val getList = database.studentDAO().getAll()
        val studentAli = getList[1]

        // Delete student with id == 2
        database.studentDAO().delete(studentAli)
        // End Delete

        // Read student database and show in TextView
        val updatedList = database.studentDAO().getAll()
        dbResultTextView.append("Ali rafiepour deleted): \n\n")
        for (student in updatedList)
            dbResultTextView.append("${student.firstName} ${student.lastName}\n")
    }


    private fun readAndUpdate(){
        val getList = database.studentDAO().getAll()
        val studentHadi = getList[2]
        studentHadi.lastName = "updated rafiepour"

        // Update student with id == 3
        database.studentDAO().update(studentHadi)
        // End Update

        // Read student database and show in TextView
        val updatedList = database.studentDAO().getAll()
        dbResultTextView.append("Updated List (Hadi rafiepour -> Hadi updated rafiepour): \n\n")
        for (student in updatedList)
            dbResultTextView.append("${student.firstName} ${student.lastName}\n")
    }


    private fun searchAndRead() {
        val getList = database.studentDAO().search("Taleb")

        dbResultTextView.append("Search Result For \"Taleb\": \n\n")
        for (student in getList)
            dbResultTextView.append("${student.firstName} ${student.lastName}\n")
    }


    private fun insertAndRead() {
        // Insert Student List into student table
        val studentList = arrayListOf<Student>()
        studentList.add(Student("Taleb","rafiepour"))
        studentList.add(Student("Ali","rafiepour"))
        studentList.add(Student("Hadi","rafiepour"))
        studentList.add(Student("Hamid","rafiepour"))
        studentList.add(Student("Mehdi","rafiepour"))
        studentList.add(Student("Taleb","Talebi"))
        //
        database.studentDAO().insertAll(studentList)
        // End Insert

        // Read Student List from student table
        val getList = database.studentDAO().getAll()
        // End Read

        // Set Data to TextView
        dbResultTextView.append("get all: \n\n")
        for (student in getList)
            dbResultTextView.append("${student.firstName} ${student.lastName}\n")
    }
}
