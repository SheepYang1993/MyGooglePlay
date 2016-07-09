package com.sheepyang.googleplay.ui.holder;

import android.view.View;
import android.widget.ImageView;

import com.sheepyang.googleplay.R;
import com.sheepyang.googleplay.domain.AppInfo;
import com.sheepyang.googleplay.http.HttpHelper;
import com.sheepyang.googleplay.utils.BitmapHelper;
import com.sheepyang.googleplay.utils.UIUtils;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;


/**
 * 首页详情页-截图
 * 
 * @author Kevin
 * @date 2015-11-3
 */
public class DetailPicsHolder extends BaseHolder<AppInfo> {

	private ImageView[] ivPics;
	private ImageOptions mImageOptions;

	@Override
	public View initView() {
		View view = UIUtils.inflate(R.layout.layout_detail_picinfo);

		ivPics = new ImageView[5];
		ivPics[0] = (ImageView) view.findViewById(R.id.iv_pic1);
		ivPics[1] = (ImageView) view.findViewById(R.id.iv_pic2);
		ivPics[2] = (ImageView) view.findViewById(R.id.iv_pic3);
		ivPics[3] = (ImageView) view.findViewById(R.id.iv_pic4);
		ivPics[4] = (ImageView) view.findViewById(R.id.iv_pic5);

		mImageOptions = BitmapHelper.getImageOptions();

		return view;
	}

	@Override
	public void refreshView(AppInfo data) {
		final ArrayList<String> screen = data.screen;

		for (int i = 0; i < 5; i++) {
			if (i < screen.size()) {
				x.image().bind(ivPics[i], HttpHelper.URL + "image?name="
						+ screen.get(i));
				
//				ivPics[i].setOnClickListener(new OnClickListener() {
//					
//					@Override
//					public void onClick(View v) {
//						//跳转activity, activity展示viewpager
//						//将集合通过intent传递过去, 当前点击的位置i也可以传过去
//						Intent intent = new Intent();
//						intent.putExtra("list", screen);
//					}
//				});
			} else {
				ivPics[i].setVisibility(View.GONE);
			}
		}

	}

}
