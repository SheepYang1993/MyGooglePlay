package com.sheepyang.googleplay.ui.holder;

import android.view.View;
import android.widget.TextView;

import com.sheepyang.googleplay.R;
import com.sheepyang.googleplay.domain.CategoryInfo;
import com.sheepyang.googleplay.utils.UIUtils;

/**
 * 分类模块标题holder
 * 
 * @author Kevin
 * @date 2015-11-1
 */
public class TitleHolder extends BaseHolder<CategoryInfo> {

	public TextView tvTitle;

	@Override
	public View initView() {
		View view = UIUtils.inflate(R.layout.list_item_title);
		tvTitle = (TextView) view.findViewById(R.id.tv_title);
		return view;
	}

	@Override
	public void refreshView(CategoryInfo data) {
		tvTitle.setText(data.title);
	}

}
