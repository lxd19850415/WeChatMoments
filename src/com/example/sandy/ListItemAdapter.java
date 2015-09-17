package com.example.sandy;

import java.util.ArrayList;

import com.example.sandy.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.Config;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ListItemAdapter extends BaseAdapter {

	private Context mContext;
	private ArrayList<ItemEntity> items;

	public ListItemAdapter(Context ctx, ArrayList<ItemEntity> items) {
		this.mContext = ctx;
		this.items = items;
	}

	@Override
	public int getCount() {
		return items == null ? 0 : items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
//		if (convertView == null) {
			holder = new ViewHolder();
			convertView = View.inflate(mContext, R.layout.list_item, null);
			holder.iv_avatar = (ImageView) convertView
					.findViewById(R.id.iv_avatar);
			holder.tv_title = (TextView) convertView
					.findViewById(R.id.tv_title);
			holder.tv_content = (TextView) convertView
					.findViewById(R.id.tv_content);
			holder.gridview = (ImageGridView) convertView
					.findViewById(R.id.gridview);
			holder.tv_comment = (TextView) convertView
					.findViewById(R.id.tv_comment);
//			convertView.setTag(holder);
//		} else {
//			holder = (ViewHolder) convertView.getTag();
//		}
		ItemEntity itemEntity = items.get(position);
		holder.tv_title.setText(itemEntity.getTitle());
		holder.tv_content.setText(itemEntity.getContent());
		if (itemEntity.getComments() != null
				&& itemEntity.getComments().size() > 0) {
			String contentStr = itemEntity.getComments().get(0).toString();
			holder.tv_comment.setText(contentStr);

		} else {
			holder.tv_comment.setText("");
			holder.tv_comment.setVisibility(View.GONE);
		}
		// 使用ImageLoader加载网络图片
		DisplayImageOptions options = new DisplayImageOptions.Builder()//
				.showImageOnLoading(R.drawable.ic_launcher) // 加载中显示的默认图片
				.showImageOnFail(R.drawable.ic_launcher) // 设置加载失败的默认图片
				.cacheInMemory(true) // 内存缓存
				.cacheOnDisk(true) // sdcard缓存
				.bitmapConfig(Config.RGB_565)// 设置图片颜色配置
				.build();//
		ImageLoader.getInstance().displayImage(itemEntity.getAvatar(),
				holder.iv_avatar, options);
		final ArrayList<String> imageUrls = itemEntity.getImageUrls();
		Log.v("liuxd","index = " + position);
		if (imageUrls == null || imageUrls.size() == 0) { // 没有图片资源就隐藏GridView
			holder.gridview.setVisibility(View.GONE);
			Log.v("liuxd","index = " + position + "GONE");
		} else {
			holder.gridview
					.setAdapter(new ImageGridAdapter(mContext, imageUrls));
		}
		// 点击宫格图片，查看大图
		holder.gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				imageBrower(position, imageUrls);
			}
		});
		return convertView;
	}

	/**
	 * 打开图片查看�?
	 * 
	 * @param position
	 * @param urls2
	 */
	protected void imageBrower(int position, ArrayList<String> urls2) {
		Intent intent = new Intent(mContext, ImageBrowserActivity.class);
		// 图片url,为了演示这里使用常量，一般从数据库中或网络中获取
		intent.putExtra(ImageBrowserActivity.EXTRA_IMAGE_URLS, urls2);
		intent.putExtra(ImageBrowserActivity.EXTRA_IMAGE_INDEX, position);
		mContext.startActivity(intent);
	}

	/**
	 * listview组件复用，防止�?�卡顿�??
	 * 
	 * @author Administrator
	 * 
	 */
	class ViewHolder {
		private ImageView iv_avatar;
		private TextView tv_title;
		private TextView tv_content;
		private ImageGridView gridview;
		private TextView tv_comment;
	}
}
