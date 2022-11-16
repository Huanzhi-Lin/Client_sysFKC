package com.frm.mvc;

import java.lang.reflect.Field;

import javax.swing.JFrame;

import com.frm.cnet.CSocketMgr;
import com.frm.proto.PDTO;
import com.frm.proto.PID;
import com.frm.proto.PdtoDispatch;
import com.frm.utils.ScreenUtils;

/**
 * @author LinHuanZhi
 * @time 2021年12月13日
 * @email lhz034069@163.com
 * @description 
 */
public abstract class BaseCtrl extends BaseMVCCom implements IObserver{
	protected BaseView view;
	protected BaseModel model;
	public BaseCtrl() {
		this(null);
	}
	public BaseCtrl(IModelArgsExt args) {
		this.init();
		if(this.view != null) CCenter.c.mAdd(this.getClass(), view);
		if(this.model != null) CCenter.c.mAdd(this.getClass(), model);
		this.viewPropertiesSet(/* args */);
		if(args == null) {			
			this.view.setVisible(true);
			this.view.doOpen(null);
		}else {			
			this.view.setVisible(args.isViewVis());
			this.view.onOpenParams = args.geOnOpentList();
			this.view.doOpen(args.geOnOpentList());
		}
		PID[] pIdList = this.registerPIDList();
		if(pIdList != null) {			
			for(PID pId: pIdList) {
				PdtoDispatch.p.nonRepeatRegister(pId, this);
			}
		}else {
			System.err.println(this.getClass().getName() + "exist null pIdList...");
		}
	}
	protected void mClearAll() {
		this.mClearView();
		this.model.mClear();
		this.model = null;
	}
	protected void mClearView() {
		this.view.mClear();
		this.view.mClose();
		this.view = null;
	}
	
	private void viewPropertiesSet(/* IModelArgsExt args */){
		Field f = null;
		try {
			f = this.view.getClass().getDeclaredField("frame");
			f.setAccessible(true);
		} catch (NoSuchFieldException e) {
			System.err.println("can't found field...");
		} catch (SecurityException e) {
			System.err.println("unSecurity...");
		}
		if(f != null) {			
			JFrame jf = null;
			try {
				jf = (JFrame)f.get(this.view);
			} catch (IllegalArgumentException e) {
				System.err.println("IllegalArgs...");
			} catch (IllegalAccessException e) {
				System.err.println("IllegalAccess...");
			}
			if(jf != null) {			
				boolean r = false;
				jf.setResizable(r);
				int w = jf.getWidth();
				int h = jf.getHeight();
				double offset = Math.random()*50+50;
				int x = (int)((ScreenUtils.screenWidth()-w) * 0.5 + offset);
				int y = (int)((ScreenUtils.screenHeight()-h) * 0.3 + offset);
				jf.setLocation(x, y);
			}
		}
	}
	
//	/**
//	 * enhance for sequence.
//	 */
//	protected abstract void init();
	
	public void updateSignal(PDTO pdto) {
		if(this.model != null) {
			this.updateModel(pdto);
		}
		if(this.view != null) {
			this.updateView(pdto);
		}
	}

}
