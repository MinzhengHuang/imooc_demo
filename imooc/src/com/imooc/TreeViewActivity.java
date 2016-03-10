package com.imooc;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.imooc.treeview.FileBean;
import com.imooc.treeview.Node;
import com.imooc.treeview.OrgBean;
import com.imooc.treeview.SimpleTreeListViewAdapter;
import com.imooc.treeview.TreeListViewAdapter.OnTreeNodeClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Android 打造任意层级树形控件 考验你的数据结构和设计
 *
 * http://blog.csdn.net/lmj623565791/article/details/40212367
 *
 */
public class TreeViewActivity extends Activity {

	private ListView mlvTree;
	private SimpleTreeListViewAdapter<OrgBean> mAdapter;
	private List<FileBean> mDatas;
	private List<OrgBean> mDatas2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_treeview);
		mlvTree = (ListView) findViewById(R.id.lv);
		initDatas();
		try {
			mAdapter = new SimpleTreeListViewAdapter<OrgBean>(mlvTree, this,
					mDatas2, 0);
			mlvTree.setAdapter(mAdapter);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		initEvent();
	}

	private void initEvent() {
		mAdapter.setOnTreeNodeClickListener(new OnTreeNodeClickListener() {
			@Override
			public void onClick(Node node, int position) {
				if (node.isLeaf()) {
					Toast.makeText(TreeViewActivity.this, node.getName(),
							Toast.LENGTH_SHORT).show();
				}
			}
		});

		mlvTree.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					final int position, long id) {
				// DialogFragment
				final EditText et = new EditText(TreeViewActivity.this);
				new AlertDialog.Builder(TreeViewActivity.this).setTitle("Add Node")
						.setView(et)
						.setPositiveButton("Sure", new OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {

								if (TextUtils.isEmpty(et.getText().toString()))
									return;
								mAdapter.addExtraNode(position, et.getText()
										.toString());
							}
						}).setNegativeButton("Cancel", null).show();

				return true;
			}
		});
	}

	private void initDatas() {
		mDatas = new ArrayList<FileBean>();
		FileBean bean = new FileBean(1, 0, "根目录1");
		mDatas.add(bean);
		bean = new FileBean(2, 0, "根目录2");
		mDatas.add(bean);
		bean = new FileBean(3, 0, "根目录3");
		mDatas.add(bean);
		bean = new FileBean(4, 1, "根目录1-1");
		mDatas.add(bean);
		bean = new FileBean(5, 1, "根目录1-2");
		mDatas.add(bean);
		bean = new FileBean(6, 5, "根目录1-2-1");
		mDatas.add(bean);
		bean = new FileBean(7, 3, "根目录3-1");
		mDatas.add(bean);
		bean = new FileBean(8, 3, "根目录3-2");
		mDatas.add(bean);

		// initDatas
		mDatas2 = new ArrayList<OrgBean>();
		OrgBean bean2 = new OrgBean(1, 0, "根目录1");
		mDatas2.add(bean2);
		bean2 = new OrgBean(2, 0, "根目录2");
		mDatas2.add(bean2);
		bean2 = new OrgBean(3, 0, "根目录3");
		mDatas2.add(bean2);
		bean2 = new OrgBean(4, 1, "根目录1-1");
		mDatas2.add(bean2);
		bean2 = new OrgBean(5, 1, "根目录1-2");
		mDatas2.add(bean2);
		bean2 = new OrgBean(6, 5, "根目录1-2-1");
		mDatas2.add(bean2);
		bean2 = new OrgBean(7, 3, "根目录3-1");
		mDatas2.add(bean2);
		bean2 = new OrgBean(8, 3, "根目录3-2");
		mDatas2.add(bean2);

	}
}
