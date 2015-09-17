package com.example.sandy;

import java.util.ArrayList;

import com.example.sandy.ItemEntity.Comment;
import com.example.sandy.R;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity implements
		SwipeRefreshLayout.OnRefreshListener {

	private ArrayList<ItemEntity> itemEntities;
	private ListView listview;
	private static final int REFRESH_COMPLETE = 0X110;
	private SwipeRefreshLayout mSwipeLayout;
	private ListItemAdapter mAdapter;
	// private Context mContext;
	private int appendCount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// mContext = this;
		listview = (ListView) findViewById(R.id.listView1);

		mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.id_swipe_ly);

		mSwipeLayout.setOnRefreshListener(this);
		mSwipeLayout.setColorScheme(android.R.color.holo_blue_bright,
				android.R.color.holo_green_light,
				android.R.color.holo_orange_light,
				android.R.color.holo_red_light);

		appendCount = 0;
		initData();
		mAdapter = new ListItemAdapter(this, itemEntities);
		listview.setAdapter(mAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * 初始化数据
	 */
	private void initData() {
		itemEntities = new ArrayList<ItemEntity>();

		ArrayList<Comment> comment_1 = new ArrayList<Comment>();
		comment_1.add(new Comment("小明", "给你点32个赞"));

		ItemEntity entity1 = new ItemEntity(
				"http://45.56.95.147/TempImage/Avatar/6cc3cb2f5e5943d2!200x200.jpg",
				"风淡云轻", "早起早睡，精神百倍", null, comment_1);
		itemEntities.add(entity1);

		ArrayList<String> urls_1 = new ArrayList<String>();
		urls_1.add("http://45.56.95.147/TempImage/3lian-com_010.jpg");
		ItemEntity entity2 = new ItemEntity(
				"http://45.56.95.147/TempImage/Avatar/5a3fa1a8af826816!200x200.jpg",
				"宛如", "下班去吃大餐，来的约起", urls_1, null);
		itemEntities.add(entity2);

		ArrayList<String> urls_2 = new ArrayList<String>();
		urls_2.add("http://45.56.95.147/TempImage/09b58PICzAk_1024.jpg");
		urls_2.add("http://45.56.95.147/TempImage/13b1OOOPIC73.jpg");
		urls_2.add("http://45.56.95.147/TempImage/15-1109150Q30812.jpg");

		ArrayList<Comment> comment_2 = new ArrayList<Comment>();
		comment_2.add(new Comment("宛如", "继续加油哦"));

		ItemEntity entity3 = new ItemEntity(
				"http://45.56.95.147/TempImage/Avatar/1ba3c992b5e34b66!200x200.jpg",
				"sandy", "大智若愚", urls_2, comment_2);
		itemEntities.add(entity3);

		ArrayList<String> urls_3 = new ArrayList<String>();
		urls_3.add("http://45.56.95.147/TempImage/20X58PICzs8.jpg");
		urls_3.add("http://45.56.95.147/TempImage/24b1OOOPIC04.jpg");
		urls_3.add("http://45.56.95.147/TempImage/26.jpg");
		urls_3.add("http://45.56.95.147/TempImage/11438440895facd9b0o.jpg");
		ItemEntity entity4 = new ItemEntity(
				"http://45.56.95.147/TempImage/Avatar/2012061911422366618.jpg",
				"霞姐", "只解题不解风情", urls_3, null);
		itemEntities.add(entity4);

		ArrayList<Comment> comment_3 = new ArrayList<Comment>();
		comment_3.add(new Comment("Snow", "太阳晒屁沟了"));

		ArrayList<String> urls_4 = new ArrayList<String>();
		urls_4.add("http://45.56.95.147/TempImage/26P58PICeEA.jpg");
		urls_4.add("http://45.56.95.147/TempImage/29b1OOOPIC90.jpg");
		urls_4.add("http://45.56.95.147/TempImage/73I58PICGuY.jpg");
		urls_4.add("http://45.56.95.147/TempImage/1235114505399826866.jpg");
		urls_4.add("http://45.56.95.147/TempImage/ae51f3deb48f8c549ee678603b292df5e0fe7f43.jpg");
		urls_4.add("http://45.56.95.147/TempImage/N4016P0N5XO3.jpg");
		urls_4.add("http://45.56.95.147/TempImage/84bOOOPIC13.jpg");
		ItemEntity entity5 = new ItemEntity(
				"http://45.56.95.147/TempImage/Avatar/c27142acc68a199a!200x200",
				"小懒虫", "现在才起来，昨天睡得真舒服", urls_4, comment_3);
		itemEntities.add(entity5);
	}

	private void appendItemEntities() {

		ArrayList<Comment> comment_1 = new ArrayList<Comment>();
		comment_1.add(new Comment("小明", "给你点32个赞"));

		ItemEntity entity1 = new ItemEntity(
				"http://45.56.95.147/TempImage/Avatar/6cc3cb2f5e5943d2!200x200.jpg",
				"风淡云轻", "早起早睡，精神百倍,刷新的条数" + appendCount, null, comment_1);
		itemEntities.add(0, entity1);
		appendCount++;

		ArrayList<String> urls_1 = new ArrayList<String>();
		urls_1.add("http://45.56.95.147/TempImage/3lian-com_010.jpg");
		ItemEntity entity2 = new ItemEntity(
				"http://45.56.95.147/TempImage/Avatar/5a3fa1a8af826816!200x200.jpg",
				"宛如", "下班去吃大餐，来的约起,刷新的条数" + appendCount, urls_1, null);
		itemEntities.add(0, entity2);
		appendCount++;

		ArrayList<String> urls_2 = new ArrayList<String>();
		urls_2.add("http://45.56.95.147/TempImage/09b58PICzAk_1024.jpg");
		urls_2.add("http://45.56.95.147/TempImage/13b1OOOPIC73.jpg");
		urls_2.add("http://45.56.95.147/TempImage/15-1109150Q30812.jpg");

		ArrayList<Comment> comment_2 = new ArrayList<Comment>();
		comment_2.add(new Comment("宛如", "继续加油哦"));

		ItemEntity entity3 = new ItemEntity(
				"http://45.56.95.147/TempImage/Avatar/1ba3c992b5e34b66!200x200.jpg",
				"sandy", "大智若愚,刷新的条数" + appendCount, urls_2, comment_2);
		itemEntities.add(0, entity3);
		appendCount++;

		ArrayList<String> urls_3 = new ArrayList<String>();
		urls_3.add("http://45.56.95.147/TempImage/20X58PICzs8.jpg");
		urls_3.add("http://45.56.95.147/TempImage/24b1OOOPIC04.jpg");
		urls_3.add("http://45.56.95.147/TempImage/26.jpg");
		urls_3.add("http://45.56.95.147/TempImage/11438440895facd9b0o.jpg");
		ItemEntity entity4 = new ItemEntity(
				"http://45.56.95.147/TempImage/Avatar/2012061911422366618.jpg",
				"霞姐", "只解题不解风情,刷新的条数" + appendCount, urls_3, null);
		itemEntities.add(0, entity4);
		appendCount++;

		ArrayList<String> urls_4 = new ArrayList<String>();
		urls_4.add("http://45.56.95.147/TempImage/26P58PICeEA.jpg");
		urls_4.add("http://45.56.95.147/TempImage/29b1OOOPIC90.jpg");
		urls_4.add("http://45.56.95.147/TempImage/73I58PICGuY.jpg");
		urls_4.add("http://45.56.95.147/TempImage/1235114505399826866.jpg");
		urls_4.add("http://45.56.95.147/TempImage/ae51f3deb48f8c549ee678603b292df5e0fe7f43.jpg");
		urls_4.add("http://45.56.95.147/TempImage/N4016P0N5XO3.jpg");
		urls_4.add("http://45.56.95.147/TempImage/84bOOOPIC13.jpg");

		ArrayList<Comment> comment_3 = new ArrayList<Comment>();
		comment_3.add(new Comment("Snow", "太阳晒屁沟了"));

		ItemEntity entity5 = new ItemEntity(
				"http://45.56.95.147/TempImage/Avatar/c27142acc68a199a!200x200",
				"小懒虫", "现在才起来，昨天睡得真舒服,刷新的条数" + appendCount, urls_4, comment_3);
		itemEntities.add(0, entity5);
		appendCount++;
	}

	@SuppressLint("HandlerLeak")
	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case REFRESH_COMPLETE:
				appendItemEntities();
				mAdapter.notifyDataSetChanged();
				// mAdapter = new ListItemAdapter(mContext, itemEntities);
				// listview.setAdapter(mAdapter);
				mSwipeLayout.setRefreshing(false);
				break;

			}
		};
	};

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub

		mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE, 2000);
	}
}
