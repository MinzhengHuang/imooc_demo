package com.imooc.treeview;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.imooc.R;

public class SimpleTreeListViewAdapter<T> extends TreeListViewAdapter<T> {
	public SimpleTreeListViewAdapter(ListView tree, Context context,
			List<T> datas, int defaultExpandLevel)
			throws IllegalArgumentException, IllegalAccessException {
		super(tree, context, datas, defaultExpandLevel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public View getConvertView(Node node, int position, View convertView,
			ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.list_item_treeview, parent, false);
			holder = new ViewHolder();
			holder.mivIcon = (ImageView) convertView
					.findViewById(R.id.iv_item_icon);
			holder.mtvText = (TextView) convertView
					.findViewById(R.id.tv_item_text);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		if (node.getIcon() == -1) {
			holder.mivIcon.setVisibility(View.INVISIBLE);
		} else {
			holder.mivIcon.setVisibility(View.VISIBLE);
			holder.mivIcon.setImageResource(node.getIcon());
		}

		holder.mtvText.setText(node.getName());

		return convertView;
	}

	private class ViewHolder {
		ImageView mivIcon;
		TextView mtvText;
	}

	/**
	 * 动态插入节点
	 * 
	 * @param position
	 * @param string
	 */
	public void addExtraNode(int position, String string) {
		Node node = mVisibleNodes.get(position);
		int indexOf = mAllNodes.indexOf(node);
		// Node
		Node extraNode = new Node(-1, node.getId(), string);
		extraNode.setParent(node);
		node.getChildren().add(extraNode);
		mAllNodes.add(indexOf + 1, extraNode);

		mVisibleNodes = TreeHelper.filterVisibleNodes(mAllNodes);
		notifyDataSetChanged();

	}

}
