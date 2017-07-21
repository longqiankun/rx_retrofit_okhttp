package com.shiqichuban.lib.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.lqk.framework.util.ToastUtils;
import com.shiqichuban.lib.ui.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AlertDialog {
	private Context context;
	private Dialog dialog;
	private LinearLayout lLayout_bg;
	private TextView txt_title;
	private TextView txt_msg;
	private TextView btn_neg;
	private TextView btn_pos;
	private ImageView img_line;
	private EditText tv_edit;
	private RecyclerView rv_list;
	private Display display;
	private boolean showTitle = false;
	private boolean showMsg = false;
	private boolean showPosBtn = false;
	private boolean showNegBtn = false;
	private boolean showEdit = false;
	private boolean showSelect = false;

	private boolean isSingle=true;
	private Set<Integer> selected=new HashSet<>();

	private List<String> selectTexts;
	public AlertDialog(Context context) {
		this.context = context;
		WindowManager windowManager = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		display = windowManager.getDefaultDisplay();
	}

	public AlertDialog builder() {
		// 获取Dialog布局
		View view = LayoutInflater.from(context).inflate(
				R.layout.view_alertdialog, null);
		ButterKnife.bind(this,view);
		AutoUtils.autoSize(view);
		// 获取自定义Dialog布局中的控件
		lLayout_bg = (LinearLayout) view.findViewById(R.id.lLayout_bg);
		txt_title = (TextView) view.findViewById(R.id.txt_title);
		txt_msg = (TextView) view.findViewById(R.id.txt_msg);
		btn_neg = (TextView) view.findViewById(R.id.btn_neg);
		btn_pos = (TextView) view.findViewById(R.id.btn_pos);
		img_line = (ImageView) view.findViewById(R.id.img_line);
		tv_edit = (EditText) view.findViewById(R.id.tv_edit);
		rv_list = (RecyclerView) view.findViewById(R.id.rv_list);

		LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
		linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		rv_list.setLayoutManager(linearLayoutManager);
		// 定义Dialog布局和参数
		dialog = new Dialog(context, R.style.AlertDialogStyle);
		dialog.setContentView(view);

		// 调整dialog背景大小
		lLayout_bg.setLayoutParams(new FrameLayout.LayoutParams((int) (display
				.getWidth() * 0.6), LayoutParams.WRAP_CONTENT));

		return this;
	}

	public AlertDialog setTitle(String title) {
		showTitle = true;
		if ("".equals(title)) {
			txt_title.setText("标题");
		} else {
			txt_title.setText(title);
		}
		return this;
	}

	public AlertDialog setMsg(String msg) {
		showMsg = true;
//		if ("".equals(msg)) {
//			txt_msg.setText("内容");
//		} else {
//			txt_msg.setText(Html.fromHtml(msg));
//		}
		txt_msg.setText(Html.fromHtml(msg));
		return this;
	}

	public AlertDialog setMessage(String msg) {
		showMsg = true;
//		if ("".equals(msg)) {
//			txt_msg.setText("内容");
//		} else {
//			txt_msg.setText(Html.fromHtml(msg));
//		}
		txt_msg.setText(msg);
		return this;
	}

	public AlertDialog setCenterMessage(String msg){
		showMsg = true;
		txt_msg.setGravity(Gravity.CENTER);
		txt_msg.setText(msg);
		return this;
	}
	
	public AlertDialog setSpannedMsg(Spanned msg) {
		showMsg = true;
		if ("".equals(msg.toString())) {
			txt_msg.setText("内容");
		} else {
			txt_msg.setText(msg);
		}
		return this;
	}
	
	public AlertDialog setCancelable(boolean cancel) {
		dialog.setCancelable(cancel);
		return this;
	}
	
	public AlertDialog setCanceledOnTouchOutside(boolean cancel) {
		dialog.setCanceledOnTouchOutside(cancel);
		return this;
	}

	public AlertDialog setPositiveButton(String text,
										 final OnClickListener listener){
		return setPositiveButton(text,listener,true);
	}
	public AlertDialog setPositiveButton(String text,
			final OnClickListener listener,final boolean isDismiss) {
		showPosBtn = true;
		if ("".equals(text)) {
			btn_pos.setText("确定");
		} else {
			btn_pos.setText(text);
		}
		btn_pos.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				listener.onClick(v);
				if(isDismiss) {
					dialog.dismiss();
				}
			}
		});
		return this;
	}
	public AlertDialog setNegativeButton(String text,
										 final OnClickListener listener){
		return setNegativeButton(text,listener,true);
	}
	public AlertDialog setNegativeButton(String text,
			final OnClickListener listener,final boolean isDismiss) {
		showNegBtn = true;
		if ("".equals(text)) {
			btn_neg.setText("取消");
		} else {
			btn_neg.setText(text);
		}
		btn_neg.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				listener.onClick(v);
				if(isDismiss) {
					dialog.dismiss();
				}
			}
		});
		return this;
	}

	public AlertDialog setEdit(String text,String hint,String positionBtnText,String negativeBtnText,
										 final OnEditListener listener) {
		showEdit = true;
		showNegBtn=true;
		showPosBtn=true;
		if(!TextUtils.isEmpty(text)){
			tv_edit.setText(text);
		}
		if(!TextUtils.isEmpty(hint)){
			tv_edit.setHint(hint);
		}
		setPositiveButton(positionBtnText, new OnClickListener() {
			@Override
			public void onClick(View view) {
				String text=tv_edit.getText().toString();
				if(TextUtils.isEmpty(text)){
					ToastUtils.showToast(context,"请输入内容！");
					return;
				}
				listener.onEdit(text);
				dialog.dismiss();
			}
		},false);
		setNegativeButton(negativeBtnText, new OnClickListener() {
			@Override
			public void onClick(View view) {

			}
		});

		return this;
	}


	public AlertDialog setSelectLisnter(List<String> texts,String positionBtnText,String negativeBtnText,int defaultIndex,boolean isSingle,
										 final OnSelectListener listener) {
		selectTexts=texts;
		showSelect = true;
		this.isSingle=isSingle;
		selected.add(defaultIndex);
		if(texts!=null){
			rv_list.setAdapter(new SelectAdapter());
		}
		setPositiveButton(positionBtnText, new OnClickListener() {
			@Override
			public void onClick(View view) {

				if(selected==null||selected.size()==0){
					ToastUtils.showToast(context,"请先选择！");
					return;
				}
				listener.onSelect(selected);
				dialog.dismiss();
			}
		},false);
		setNegativeButton(negativeBtnText, new OnClickListener() {
			@Override
			public void onClick(View view) {

			}
		});
		return this;
	}

	private void setLayout() {
		if (!showTitle && !showMsg) {
			txt_title.setText("提示");
			txt_title.setVisibility(View.VISIBLE);
		}

		if (showTitle) {
			txt_title.setVisibility(View.VISIBLE);
		}

		if (showMsg) {
			txt_msg.setVisibility(View.VISIBLE);
		}

		if (!showPosBtn && !showNegBtn) {
			btn_pos.setText("确定");
			btn_pos.setVisibility(View.VISIBLE);
			btn_pos.setBackgroundResource(R.drawable.alertdialog_single_selector);
			btn_pos.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					dialog.dismiss();
				}
			});
		}

		if (showPosBtn && showNegBtn) {
			btn_pos.setVisibility(View.VISIBLE);
			btn_pos.setBackgroundResource(R.drawable.alertdialog_right_selector);
			btn_neg.setVisibility(View.VISIBLE);
			btn_neg.setBackgroundResource(R.drawable.alertdialog_left_selector);
			img_line.setVisibility(View.VISIBLE);
		}

		if (showPosBtn && !showNegBtn) {
			btn_pos.setVisibility(View.VISIBLE);
			btn_pos.setBackgroundResource(R.drawable.alertdialog_single_selector);
		}

		if (!showPosBtn && showNegBtn) {
			btn_neg.setVisibility(View.VISIBLE);
			btn_neg.setBackgroundResource(R.drawable.alertdialog_single_selector);
		}

		if(showEdit){
			tv_edit.setVisibility(View.VISIBLE);
		}
		if(showSelect){
			rv_list.setVisibility(View.VISIBLE);
		}
	}

	public void show() {
		setLayout();
		dialog.show();
	}

	public interface OnEditListener{
		void onEdit(String text);
	}
	public interface OnSelectListener{
		void onSelect(Set<Integer> selected);
	}


	private class SelectAdapter extends RecyclerView.Adapter{
		@Override
		public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.alert_dialog_list_item, parent, false);
			return new SelectHolder(view);
		}

		@Override
		public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
			SelectHolder holder1=	((SelectHolder)holder);
			holder1.position=position;
			holder1.tv_ttile.setText(selectTexts.get(position));
			if(isSingle){
				if(selected.contains(position)){
					holder1.iv_icon.setImageResource(R.drawable.radio_icon_on);
				}else {
					holder1.iv_icon.setImageResource(R.drawable.radio_icon_off);
				}
			}else {
				if(selected.contains(position)){
					holder1.iv_icon.setImageResource(R.drawable.check_icon_on);
				}else {
					holder1.iv_icon.setImageResource(R.drawable.check_icon_off);
				}
			}

		}

		@Override
		public int getItemCount() {
			return selectTexts.size();
		}


		private class SelectHolder extends RecyclerView.ViewHolder{
			int position;
			TextView tv_ttile ;
			ImageView iv_icon;
			public SelectHolder(View itemView) {
				super(itemView);
				tv_ttile=(TextView) itemView.findViewById(R.id.tv_ttile);
				iv_icon=(ImageView) itemView.findViewById(R.id.iv_icon);
				AutoUtils.autoSize(itemView);
				itemView.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View view) {
						if(isSingle){
							selected.clear();
							selected.add(position);
						}else {

							if(selected.contains(position)){
								selected.remove(position);
							}else {
								selected.add(position);
							}
						}
						notifyDataSetChanged();
					}
				});
			}
		}
	}
}
