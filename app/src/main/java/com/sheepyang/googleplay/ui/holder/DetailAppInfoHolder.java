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
 * 详情页-应用信息
 * 
 * @author Kevin
 * @date 2015-11-1
 */
public class DetailAppInfoHolder extends BaseHolder<AppInfo> {

	private ImageView ivIcon;
	private TextView tvName;
	private TextView tvDownloadNum;
	private TextView tvVersion;
	private TextView tvDate;
	private TextView tvSize;
	private RatingBar rbStar;
	private ImageOptions mImageOptions;

	@Override
	public View initView() {
		View view = UIUtils.inflate(R.layout.layout_detail_appinfo);

		ivIcon = (ImageView) view.findViewById(R.id.iv_icon);
		tvName = (TextView) view.findViewById(R.id.tv_name);
		tvDownloadNum = (TextView) view.findViewById(R.id.tv_download_num);
		tvVersion = (TextView) view.findViewById(R.id.tv_version);
		tvDate = (TextView) view.findViewById(R.id.tv_date);
		tvSize = (TextView) view.findViewById(R.id.tv_size);
		rbStar = (RatingBar) view.findViewById(R.id.rb_star);

		mImageOptions = BitmapHelper.getImageOptions();

		return view;
	}

	@Override
	public void refreshView(AppInfo data) {
		x.image().bind(ivIcon, HttpHelper.URL + "image?name="
				+ data.iconUrl);
		tvName.setText(data.name);
		tvDownloadNum.setText("下载量:" + data.downloadNum);
		tvVersion.setText("版本号:" + data.version);
		tvDate.setText(data.date);
		tvSize.setText(Formatter.formatFileSize(UIUtils.getContext(), data.size));
		rbStar.setRating(data.stars);
	}

}
