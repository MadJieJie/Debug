package com.madjiejie.debug.model;


/**
 * @author Created by MadJieJie on 2017/3/25-14:42.
 * @brief
 * @attention
 */
public class Model implements IModel
{
	private static final String account = "MadJieJie";
	private static final String password = "123456";
	
	private String getAccount()
	{
		return account;
	}
	
	private String getPassword()
	{
		return password;
	}
	
	public void setDataToView(IModelToView iModelToView)
	{
		iModelToView.setAccount(getAccount());
		iModelToView.setAccount(getPassword());
	}
	
}
