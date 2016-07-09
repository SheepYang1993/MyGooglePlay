package com.sheepyang.googleplay.ui.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sheepyang.googleplay.R;
import com.sheepyang.googleplay.domain.SubjectInfo;
import com.sheepyang.googleplay.http.HttpHelper;
import com.sheepyang.googleplay.utils.BitmapHelper;
import com.sheepyang.googleplay.utils.UIUtils;

import org.xutils.image.ImageOptions;
import org.xutils.x;


/**
 * 专题holder
 * 
 * @author Kevin
 * @date 2015-10-30
 */
public class SubjectHolder extends BaseHolder<SubjectInfo> {

	private ImageView ivPic;
	private TextView tvTitle;

	private ImageOptions mImageOptions;

	@Override
	public View initView() {
		View view = UIUtils.inflate(R.layout.list_item_subject);
		ivPic = (ImageView) view.findViewById(R.id.iv_pic);
		tvTitle = (TextView) view.findViewById(R.id.tv_title);

		mImageOptions = BitmapHelper.getImageOptions();

		return view;
	}

	@Override
	public void refreshView(SubjectInfo data) {
		tvTitle.setText(data.des);
		x.image().bind(ivPic, HttpHelper.URL + "image?name=" + data.url);
	}

}
