package com.example.androidarch.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Author: lzh
 * date: 2019/4/12
 * desc:
 */
@Entity(tableName = "users", indices = {})
public class User {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "name")
    public String name;
}

@Entity(tableName = "book", foreignKeys = @ForeignKey(entity = User.class, parentColumns = "id", childColumns = "userId"))
class Book {
    @PrimaryKey()
    public int bookId;

    @ColumnInfo(name = "user_id")
    public int userId;
}