package com.frm.mvc;

/**
 * @author LinHuanZhi
 * @time 2021年12月18日
 * @email lhz034069@163.com
 * @description 
 */
public class MVC {
	
	/**
	 * @param <T>
	 * @param clz
	 * @return
	 * @description 打开模块
	 */
	public static <T extends BaseCtrl> T openModule(Class<T> clz){
		return CCenter.c.openCtrl(clz);
	}
	public static <T extends BaseCtrl> T openModule(Class<T> clz, IModelArgsExt args){
		return CCenter.c.openCtrl(clz, args);
	}
	
	/**
	 * 
	 * @description 关闭模块
	 */
	public static <T extends BaseCtrl> void closeModule(Class<T> clz){
		CCenter.c.closeCtrl(clz);
	}
	
	
	/**
	 * 
	 * @description 仅关闭模块的View界面，保留model
	 */
	public static <T extends BaseCtrl> void closeView(Class<T> clz) {
		CCenter.c.closeView(clz);
	}
	
	
	/**
	 * @param <T>
	 * @param clz
	 * @return
	 * @description 得到model
	 */
	public static <T extends BaseCtrl, E extends BaseModel> E getModel(Class<T> clz, Class<E> e) {
		return (E) CCenter.getModel(clz);
	}
}
