package com.sheepyang.googleplay.utils;

import android.widget.ImageView;

import com.sheepyang.googleplay.R;

import org.xutils.image.ImageOptions;

public class BitmapHelper {

	private static ImageOptions mImageOptions = null;

	// 单例, 懒汉模式
	public static ImageOptions getImageOptions() {
		if (mImageOptions == null) {
			synchronized (BitmapHelper.class) {
				if (mImageOptions == null) {
					mImageOptions = new ImageOptions.Builder()
//							.setSize(DensityUtil.dip2px(45), DensityUtil.dip2px(45))
//							.setRadius(DensityUtil.dip2px(5))
							// 如果ImageView的大小不是定义为wrap_content, 不要crop.
							.setCrop(true)
							// 加载中或错误图片的ScaleType
							//.setPlaceholderScaleType(ImageView.ScaleType.MATRIX)
							.setImageScaleType(ImageView.ScaleType.FIT_XY)
							//设置加载过程中的图片
							.setLoadingDrawableId(R.drawable.ic_default)
							//设置加载失败后的图片
							.setFailureDrawableId(R.drawable.ic_default)
							//设置使用缓存
							.setUseMemCache(true)
							//设置支持gif
							.setIgnoreGif(false)
							//设置显示圆形图片
							//.setCircular(false)
							.build();
				}
			}
		}

		return mImageOptions;
	}
}
