package com.frm.mvc;

import java.util.ArrayList;

/**
 * @author LinHuanZhi
 * @time 2021年11月24日
 * @email lhz034069@163.com
 * @description 
 */
public interface IModelArgsExt{
	public boolean isViewVis();
	public void setViewVis(boolean viewVis);
	public void onOpenAdd(Object o);
	public Object onOpenGet(int idx);
	public ArrayList<Object> geOnOpentList();
}
