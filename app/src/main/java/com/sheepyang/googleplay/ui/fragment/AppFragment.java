package com.sheepyang.googleplay.ui.fragment;

import android.view.View;

import com.sheepyang.googleplay.domain.AppInfo;
import com.sheepyang.googleplay.http.protocol.AppProtocol;
import com.sheepyang.googleplay.ui.adapter.MyBaseAdapter;
import com.sheepyang.googleplay.ui.holder.AppHolder;
import com.sheepyang.googleplay.ui.holder.BaseHolder;
import com.sheepyang.googleplay.utils.UIUtils;
import com.sheepyang.googleplay.view.LoadingPage;
import com.sheepyang.googleplay.view.MyListView;

import java.util.ArrayList;


/**
 * 应用
 * 
 * @author Kevin
 * @date 2015-10-27
 */
public class AppFragment extends BaseFragment {

	private ArrayList<AppInfo> data;

	// 只有成功才走此方法
	@Override
	public View onCreateSuccessView() {
		MyListView view = new MyListView(UIUtils.getContext());
		view.setAdapter(new AppAdapter(data));
		return view;
	}

	@Override
	public LoadingPage.ResultState onLoad() {
		AppProtocol protocol = new AppProtocol();
		data = protocol.getData(0);
		return check(data);
	}

	class AppAdapter extends MyBaseAdapter<AppInfo> {

		public AppAdapter(ArrayList<AppInfo> data) {
			super(data);
		}

		@Override
		public BaseHolder<AppInfo> getHolder(int position) {
			return new AppHolder();
		}

		@Override
		public ArrayList<AppInfo> onLoadMore() {
			AppProtocol protocol = new AppProtocol();
			ArrayList<AppInfo> moreData = protocol.getData(getListSize());
			return moreData;
		}

	}

}
