package com.imooc.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.imooc.R;
import com.imooc.TreeViewActivity;

public class FirstFragment extends Fragment implements OnClickListener{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_first, container, false);
		view.findViewById(R.id.btn_treeview).setOnClickListener(this);
		return view;

	}

	@Override
	public void onClick(View v) {
		Intent intent=null;
		switch (v.getId()) {
		case R.id.btn_treeview:
			intent=new Intent(getActivity(), TreeViewActivity.class);
			break;
		default:
			break;
		}
		startActivity(intent);
	}
}
