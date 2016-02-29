package cn.anline.ui.wxopen;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

/**
 * 
 * @company KCS互联网有限公司
 * 
 * @copyright KCS互联网有限公司版权所有 (c) 2014-2015
 * 
 * @author kincai
 * 
 * @description 动画工具
 * 
 * @project Zhuanti_Coustom_View_youku_menu
 * 
 * @package com.kincai.zhuanti_coustom_view_youku_menu
 * 
 * @time 2015-7-24 下午7:18:13
 * 
 */
public class AnimUtil {
	/** 记录当前执行的动画数量 */
	public static int animCount = 0;

	/**
	 * 显示或隐藏菜单
	 * 
	 * @param rl
	 *            view
	 * @param startOffset
	 *            延时时间
	 * @param isShow
	 *            isShow == true 显示 isShow == false 隐藏
	 */
	public static void showOrChoseMenu(RelativeLayout rl, int startOffset,
			boolean isShow) {

		// RotateAnimation(float fromDegrees, float toDegrees, int pivotXType,
		// float pivotXValue, int pivotYType, float pivotYValue)
		// pivotXValue: 0-1
		/**
		 * float fromDegrees, float toDegrees,角度从多少道多少 int pivotXType
		 * x方向基于点的类型父控件或自己 float pivotXValue ,x方向基于的位置
		 * 
		 */
		RotateAnimation animation = null;
		if (isShow) {
			for (int i = 0; i < rl.getChildCount(); i++) {
				rl.getChildAt(i).setEnabled(true);
			}
			animation = new RotateAnimation(-180, 0,
					RotateAnimation.RELATIVE_TO_SELF, 0.5f,
					RotateAnimation.RELATIVE_TO_SELF, 1);
		} else {
			for (int i = 0; i < rl.getChildCount(); i++) {
				rl.getChildAt(i).setEnabled(false);
			}
			animation = new RotateAnimation(0, -180,
					RotateAnimation.RELATIVE_TO_SELF, 0.5f,
					RotateAnimation.RELATIVE_TO_SELF, 1);
		}

		animation.setDuration(500);
		animation.setFillAfter(true);// 动画结束后保持当时的状态 就是动画结束的时候 就停止在那里不动了
		animation.setStartOffset(startOffset);// 延时

		animation.setAnimationListener(new MyAnimationListener());

		rl.startAnimation(animation);
	}

	/**
	 * 动画监听
	 */
	static class MyAnimationListener implements AnimationListener {
		@Override
		public void onAnimationStart(Animation animation) {
			animCount++;
		}

		@Override
		public void onAnimationEnd(Animation animation) {
			animCount--;
		}

		@Override
		public void onAnimationRepeat(Animation animation) {
		}

	}
}
