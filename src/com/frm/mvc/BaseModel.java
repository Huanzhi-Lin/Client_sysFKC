package com.frm.mvc;

import com.frm.proto.PDTO;

/**
 * @author LinHuanZhi
 * @time 2021年11月24日
 * @email lhz034069@163.com
 * @description 
 */
public abstract class BaseModel extends BaseMVCCom{

	public BaseModel() {
		// TODO Auto-generated constructor stub
		this.init();
	}
	
	protected abstract void init();
	
	/**
	 * @param pdto
	 * @return 
	 * @description 更新数据 
	 */
	public abstract void updateDt(PDTO pdto);
	protected abstract void mClear();

}
