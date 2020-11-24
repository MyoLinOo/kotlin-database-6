package com.myogardener.worldroomdatabase6.DB

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "table_word")
class Word (
    @PrimaryKey
    @ColumnInfo(name = "word_ame")
    var name:String

):Parcelable