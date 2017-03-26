package com.madjiejie.debug.db;

import android.support.test.InstrumentationRegistry;

import org.junit.Test;

/**
 * @author Created by MadJieJie on 2017/3/26-21:07.
 * @brief
 * @attention
 */
public class DBUtilsTest
{
	
	@Test
	public void insertUserData () throws Exception
	{
		DBUtils.insertUserData(InstrumentationRegistry.getTargetContext(),"dad","dad");
	}
	
}