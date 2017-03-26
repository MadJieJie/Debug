package com.madjiejie.debug.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Created by MadJieJie on 2017/3/26-9:02.
 * @brief
 * @attention
 */

public class SQLiteOpenUtils extends SQLiteOpenHelper
{
	private static final String NAME = "MadJieJie.db";
	private static final int VERSION = 1;
	
	public SQLiteOpenUtils ( Context context)
	{
		super(context, NAME, null, VERSION);
	}
	
	/**
	 * Create MadJieJie db.
	 * @param db
	 */
	@Override
	public void onCreate ( SQLiteDatabase db )
	{
		db.execSQL("CREATE TABLE user(" +
						   "id INTEGER PRIMARY KEY AUTOINCREMENT," +
				           "account VARCHAR(50) NOT NULL," +                //account
				           "password VARCHAR(50) NOT NULL" +                //password
				           ")");
	}
	
	@Override
	public void onUpgrade ( SQLiteDatabase db, int oldVersion, int newVersion )
	{
		
	}
}
