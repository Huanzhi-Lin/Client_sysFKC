package com.frm.mvc;

import java.util.ArrayList;

/**
 * @author LinHuanZhi
 * @time 2021年11月24日
 * @email lhz034069@163.com
 * @description 
 */
public class ModelArgsExt implements IModelArgsExt{
	private boolean viewVis = true;
	private ArrayList<Object> onOpenList;
	
	public ModelArgsExt() {
		// TODO Auto-generated constructor stub
	}

	public boolean isViewVis() {
		return viewVis;
	}

	public void setViewVis(boolean viewVis) {
		this.viewVis = viewVis;
	}
	public void onOpenAdd(Object o) {
		this.onOpenListInit();
		this.onOpenList.add(o);
	}
	public Object onOpenGet(int idx) {
		this.onOpenListInit();
		return this.onOpenList.get(idx);
	}
	private void onOpenListInit() {
		if(this.onOpenList == null) this.onOpenList = new ArrayList<Object>();
	}

	@Override
	public ArrayList<Object> geOnOpentList() {
		this.onOpenListInit();
		return this.onOpenList;
	}
	
	
}
