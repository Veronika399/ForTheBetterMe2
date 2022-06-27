package com.example.forthebetterme.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="note")
data class Note(

    @PrimaryKey(autoGenerate=true) var id: Long,

    @ColumnInfo(name="Naslov")
     val naslov: String,


    @ColumnInfo(name="Sadržaj")
    val sadrzaj: String,

    @ColumnInfo(name="Datum")
     val datum: String

    ){

}

