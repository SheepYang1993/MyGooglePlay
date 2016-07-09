package com.sheepyang.googleplay.ui.fragment;

import android.view.View;

import com.sheepyang.googleplay.domain.SubjectInfo;
import com.sheepyang.googleplay.http.protocol.SubjectProtocol;
import com.sheepyang.googleplay.ui.adapter.MyBaseAdapter;
import com.sheepyang.googleplay.ui.holder.BaseHolder;
import com.sheepyang.googleplay.ui.holder.SubjectHolder;
import com.sheepyang.googleplay.utils.UIUtils;
import com.sheepyang.googleplay.view.LoadingPage;
import com.sheepyang.googleplay.view.MyListView;

import java.util.ArrayList;

/**
 * 专题
 * 
 * @author Kevin
 * @date 2015-10-27
 */
public class SubjectFragment extends BaseFragment {

	private ArrayList<SubjectInfo> data;

	@Override
	public View onCreateSuccessView() {
		MyListView view = new MyListView(UIUtils.getContext());
		view.setAdapter(new SubjectAdapter(data));
		return view;
	}

	@Override
	public LoadingPage.ResultState onLoad() {
		SubjectProtocol protocol = new SubjectProtocol();
		data = protocol.getData(0);
		return check(data);
	}

	class SubjectAdapter extends MyBaseAdapter<SubjectInfo> {

		public SubjectAdapter(ArrayList<SubjectInfo> data) {
			super(data);
		}

		@Override
		public BaseHolder<SubjectInfo> getHolder(int position) {
			return new SubjectHolder();
		}

		@Override
		public ArrayList<SubjectInfo> onLoadMore() {
			SubjectProtocol protocol = new SubjectProtocol();
			ArrayList<SubjectInfo> moreData = protocol.getData(getListSize());
			return moreData;
		}

	}
}
