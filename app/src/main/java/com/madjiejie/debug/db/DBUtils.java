package com.madjiejie.debug.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * @author Created by MadJieJie on 2017/3/26-9:08.
 * @brief
 * @attention
 */

public class DBUtils
{
	
	private DBUtils ()
	{
		throw new UnsupportedOperationException("can't init");
	}
	
	/**
	 * Insert into user's data.
	 *
	 * @param context
	 * @param account
	 * @param password
	 * @return
	 */
	public static boolean insertUserData ( Context context, final String account, final String password )
	{
		SQLiteOpenUtils sqLiteOpenUtils = new SQLiteOpenUtils(context);
		SQLiteDatabase db = sqLiteOpenUtils.getWritableDatabase();
//		try
//		{
//			db.execSQL("INSERT  user(account,password) VALUES(?,?)", new String[]{ account, password });
			db.execSQL("INSERT INTO user(account,password) VALUES(?,?)", new String[]{ account, password });
			return true;
//		} catch( SQLException e )
//		{
//			e.printStackTrace();
//			return false;
//		} finally
//		{
//			if ( db != null )
//				db.close();
//			if ( sqLiteOpenUtils != null )
//				sqLiteOpenUtils.close();
//		}

	}
	
}
