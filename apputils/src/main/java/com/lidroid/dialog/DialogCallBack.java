package com.lidroid.dialog;
public interface DialogCallBack {
	
	/**
	 * 当是 选择是what为IDialog.YES , IDialog.CANCLE<br/>
	 * 当时 item时为对应的item的位置
	 * @param what
	 */
	public void onClick(int what);
	
}
