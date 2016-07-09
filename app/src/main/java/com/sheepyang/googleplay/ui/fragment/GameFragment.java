package com.sheepyang.googleplay.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.sheepyang.googleplay.utils.UIUtils;
import com.sheepyang.googleplay.view.LoadingPage;


/**
 * 游戏
 * @author Kevin
 * @date 2015-10-27
 */
public class GameFragment extends BaseFragment {

	@Override
	public View onCreateSuccessView() {
		TextView view = new TextView(UIUtils.getContext());
		view.setText("GameFragment");
		return view;
	}

	@Override
	public LoadingPage.ResultState onLoad() {
		return LoadingPage.ResultState.STATE_SUCCESS;
	}

}
