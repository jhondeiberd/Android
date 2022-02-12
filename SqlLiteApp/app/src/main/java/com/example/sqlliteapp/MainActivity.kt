package com.example.sqlliteapp

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sqlliteapp.db.DatingDBContract
import com.example.sqlliteapp.db.DatingDBHelper

class MainActivity : AppCompatActivity() {

    lateinit var dbHelper: DatingDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = DatingDBHelper(this)

        insertData()
        readData()

    }

    fun insertData(){
        //Map of colunm name + row value
        val values = ContentValues().apply {
            put(DatingDBContract.UserTable.USERNAME, "rezaUser")
            put(DatingDBContract.UserTable.PASSWORD, "rezaPassw")
            put(DatingDBContract.UserTable.FIRST_NAME, "rezaFirst")
            put(DatingDBContract.UserTable.LAST_NAME, "rezaLast")
        }

        val writeToDb = dbHelper.writableDatabase //EXPENSIVE if DB is closed
        //second arguments: What to do when there is no value
        //Because of null: If there is no value then we just do not insert
        val newRowId = writeToDb.insert(DatingDBContract.UserTable.TABLE_NAME, null, values)
    }

    fun readData() {
        val readFromDb = dbHelper.readableDatabase  //Expensive if DB is closed

        //Select Columns you want
        val projection = arrayOf(
            DatingDBContract.UserTable.USER_ID,
            DatingDBContract.UserTable.USERNAME,
            DatingDBContract.UserTable.PASSWORD,
            DatingDBContract.UserTable.FIRST_NAME,
            DatingDBContract.UserTable.LAST_NAME
        )

        //WHERE PART ONLY to avoid SQL Injection
        val selection = "${DatingDBContract.UserTable.USERNAME} = ? AND ${DatingDBContract.UserTable.PASSWORD} = ?"
        val selectionArgs = arrayOf("rezaUser", "rezaPassword")

        //sorting
        val orderBy = "${DatingDBContract.UserTable.FIRST_NAME} DESC"

        val cursor = readFromDb.query(
            DatingDBContract.UserTable.TABLE_NAME,
            projection,
            selection,
            selectionArgs,
            null,
            null,
            orderBy
        )

        //cursor starts at -1
        while(cursor.moveToNext()){
            Log.e("Reading DB", cursor.getString(cursor.getColumnIndexOrThrow(DatingDBContract.UserTable.USERNAME)))
        }

        with(cursor){
            while(this.moveToNext()) {//Moves from -1 row to next one
                Log.e("Reading DB", getString(getColumnIndexOrThrow(DatingDBContract.UserTable.USERNAME)))
            }
        }
        cursor.close()

    }
}