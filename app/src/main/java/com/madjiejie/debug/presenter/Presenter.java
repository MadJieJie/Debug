package com.madjiejie.debug.presenter;

import com.madjiejie.debug.model.IModel;
import com.madjiejie.debug.model.IModelToView;
import com.madjiejie.debug.model.Model;
import com.madjiejie.debug.ui.IView;
import com.madjiejie.debug.ui.MainActivity;

/**
 * @author Created by MadJieJie on 2017/3/25-14:44.
 * @brief
 * @attention
 */

public class Presenter implements IPresenter
{
	private IModel mIModel ;
	private IView mIView  ;
	public Presenter()
	{
		mIModel = new Model();
		mIView = new MainActivity();
	}
	
	

	
	@Override
	public void setDataToView ()
	{
		mIModel.setDataToView(new IModelToView()
		{
			@Override
			public void setAccount ( String account )
			{
				mIView.setAccount(account);
			}
			
			@Override
			public void setPassword ( String password )
			{
				mIView.setAccount(password);
			}
		});
	}
}
