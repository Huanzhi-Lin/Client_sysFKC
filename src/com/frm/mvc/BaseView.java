package com.frm.mvc;

import java.util.ArrayList;

import com.frm.cnet.CSocketMgr;
import com.frm.proto.PDTO;
import com.frm.utils.PrintUtils;

/**
 * @author LinHuanZhi
 * @time 2021年11月24日
 * @email lhz034069@163.com
 * @description 
 */
public abstract class BaseView extends BaseMVCCom{
//	private JFrame jf = null;
	public ArrayList<Object> onOpenParams;
	public boolean isParamsNullorEmpty() { return onOpenParams == null || onOpenParams.isEmpty(); }
	public BaseView() {
		// TODO Auto-generated constructor stub
		// PrintUtils.pr("constructor-BaseView...........");
//		initialize(); //TODO - 子类自动创建，交给子类了
//		initListener(); //TODO - giveup = 子类initialize后无法保证顺序，所以giveup
	}
		
	protected void doOpen(ArrayList<Object> params) {
		this.onOpen(params);
	}
	
	/**
	 * @param params
	 * @description 界面打开调用方法，用于子类重写
	 */
	protected void onOpen(ArrayList<Object> params) {
		
	}
	protected abstract void setVisible(boolean b);
//	protected abstract void initialize(); //TODO - 子类自动创建，交给子类了
//	protected abstract void initListener(); //TODO - giveup
	/**
	 * @param pdto
	 * @description 更新界面 
	 */
	public abstract void updateView(PDTO pdto);
	protected void mClear() {
		this.onOpenParams = null;
	}
	protected abstract void mClose();
//	protected abstract void mInject();
	

}

//DO_NOTHING_ON_CLOSE:无操作
//HIDE_ON_CLOSE:隐藏窗口
//DISPOSE_ON_CLOSE：隐藏当前窗口，并释放窗体占有的其他资源。在窗口被关闭的时候会dispose这个窗口。
//EXIT_ON_CLOSE：结束窗口所在的应用程序。在窗口被关闭的时候会退出JVM。 