package com.madjiejie.debug.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.madjiejie.debug.R;
import com.madjiejie.debug.utils.LogUtils;

public class MainActivity extends AppCompatActivity implements IView
{
	private EditText mAccount ;
	private EditText mPassword;
	
	@Override
	protected void onCreate ( Bundle savedInstanceState )
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		mAccount = ( EditText ) findViewById(R.id.account_et_main);
//		mPassword = ( EditText ) findViewById(R.id.password_et_main);
//		findViewById(R.id.login_btn_main).setOnClickListener(new View.OnClickListener()
//		{
//			@Override
//			public void onClick ( View v )
//			{
//				if(	mAccount.getText().toString()=="123" && mPassword.getText().toString()=="123")
//				{
//					Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
//				} else
//				{
//					Toast.makeText(getApplicationContext(),"fail",Toast.LENGTH_LONG).show();
//				}
//			}
//		});
		logDebug();
		logDebug();
		breakpointDebug(2,3);
		
	}
	
	/**
	 * LOG DEBUG
	 */
	private void logDebug()
	{
		LogUtils.d(getLocalClassName(), "logDebug: ");
		LogUtils.d(getTitle()+"");   //None tag parameter input . Just print title
		LogUtils.d(getLocalClassName(), "onCreate: "+getTitle());   //print title
	}
	
	/**
	 * BREAKPOINT
	 */
	private int breakpointDebug(int i,int j)
	{
		return  i/j;
	}
	
	@Override
	public void setAccount(String account)
	{
		mAccount.setText(account);
	}
	
	@Override
	public void setPassword(String password)
	{
		mPassword.setText(password);
	}
	
}
