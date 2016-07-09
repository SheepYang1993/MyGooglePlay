package com.sheepyang.googleplay.ui.holder;

import android.text.format.Formatter;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.sheepyang.googleplay.R;
import com.sheepyang.googleplay.domain.AppInfo;
import com.sheepyang.googleplay.http.HttpHelper;
import com.sheepyang.googleplay.utils.BitmapHelper;
import com.sheepyang.googleplay.utils.UIUtils;

import org.xutils.image.ImageOptions;
import org.xutils.x;


/**
 * 应用holder
 * 
 * @author Kevin
 * @date 2015-10-28
 */
public class AppHolder extends BaseHolder<AppInfo> {

	private TextView tvName, tvSize, tvDes;
	private ImageView ivIcon;
	private RatingBar rbStar;

	private ImageOptions mImageOptions;

	@Override
	public View initView() {
		// 1. 加载布局
		View view = UIUtils.inflate(R.layout.list_item_home);
		// 2. 初始化控件
		tvName = (TextView) view.findViewById(R.id.tv_name);
		tvSize = (TextView) view.findViewById(R.id.tv_size);
		tvDes = (TextView) view.findViewById(R.id.tv_des);
		ivIcon = (ImageView) view.findViewById(R.id.iv_icon);
		rbStar = (RatingBar) view.findViewById(R.id.rb_star);

		mImageOptions = BitmapHelper.getImageOptions();

		return view;
	}

	@Override
	public void refreshView(AppInfo data) {
		tvName.setText(data.name);
		tvSize.setText(Formatter.formatFileSize(UIUtils.getContext(), data.size));
		tvDes.setText(data.des);
		rbStar.setRating(data.stars);

		x.image().bind(ivIcon, HttpHelper.URL + "image?name=" + data.iconUrl, mImageOptions);
	}

}
