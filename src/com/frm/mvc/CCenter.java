package com.frm.mvc;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.frm.proto.PdtoDispatch;
import com.frm.utils.PrintUtils;

/**
 * @author LinHuanZhi
 * @time 2021年11月10日
 * @email lhz034069@163.com
 * @description 优化/注解
 */
public class CCenter/* <T extends BaseCtrl> */ {
	private int TYPE_CTRL = 0;
	private int TYPE_VIEW = 1;
	private int TYPE_MODEL = 2;
	private static Map<Class<? extends BaseCtrl>, BaseCtrl> INSTANCES = new HashMap<>();
	private static Map<Class<? extends BaseCtrl>, BaseView> VIEWS = new HashMap<>();
	private static Map<Class<? extends BaseCtrl>, BaseModel> MODELS = new HashMap<>();
	public void mAdd(Class<? extends BaseCtrl> clz, BaseView bv) {
		VIEWS.put(clz, bv);
	}
	public static BaseView getView(Class<? extends BaseCtrl> clz) {
		return VIEWS.get(clz);
	}
	public void mAdd(Class<? extends BaseCtrl> clz, BaseModel bm) {
		MODELS.put(clz, bm);
	}
	public static BaseModel getModel(Class<? extends BaseCtrl> clz) {
		return MODELS.get(clz);
	}
//	@SuppressWarnings("rawtypes")
	public static CCenter c = new CCenter(); 
	private CCenter() {}
	
	private <T extends BaseCtrl> BaseCtrl getIns(Class<T> clz, IModelArgsExt args) {
		BaseCtrl b = null;
		try {
			b = this.isContain(TYPE_CTRL, clz) ? INSTANCES.get(clz) : 
				(args == null) ? INSTANCES.put(clz, clz.getDeclaredConstructor().newInstance()) :
				INSTANCES.put(clz, clz.getDeclaredConstructor(IModelArgsExt.class).newInstance(args));
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	private <T extends BaseCtrl> boolean isContain(int t, Class<T> clz) {
		return t==TYPE_CTRL ? INSTANCES.containsKey(clz) : t==TYPE_VIEW ? VIEWS.containsKey(clz) : MODELS.containsKey(clz);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends BaseCtrl> T openCtrl(Class<T> clz, IModelArgsExt args) {
		return (T)c.getIns(clz, args);
	}
	/**
	 * @param <T>
	 * @param clz
	 * @return
	 * @description 使用MVC.openModule();
	 */
	@SuppressWarnings("unchecked") @Deprecated
	public <T extends BaseCtrl> T openCtrl(Class<T> clz) {
		return (T)c.getIns(clz, null);
	}
	
	/**
	 * @param <T>
	 * @param clz
	 * @description 使用MVC.closeModule
	 */
	@Deprecated
	public <T extends BaseCtrl> void closeCtrl(Class<T> clz) {
		if(this.isContain(TYPE_CTRL, clz)) {
			int len = INSTANCES.size();
			BaseCtrl ctrl = INSTANCES.remove(clz);
			BaseModel model = MODELS.remove(clz);
			ctrl.mClearAll();
			PdtoDispatch.p.unRegister(ctrl);
			len = len - INSTANCES.size();
			if(len==1) {
				System.out.println("ctrl closed succeed.");
			}else{
				System.out.println("ctrl closed exception."); 
			}
		}else {			
			System.err.println("can't found ctrl instance.");
		}
		this.showInsList();
	}
	
	/**
	 * @param <T>
	 * @param clz
	 * @description 使用MVC.closeView()
	 */
	@Deprecated
	public <T extends BaseCtrl> void closeView(Class<T> clz) {
		if(this.isContain(TYPE_VIEW, clz)) {
			int len = VIEWS.size();
			BaseView view = VIEWS.remove(clz);
			if(this.isContain(TYPE_CTRL, clz)) {
				BaseCtrl bc = INSTANCES.get(clz);
				bc.mClearView();
			}else {
				System.err.println("view clear exception."); 
			}
			len = len - VIEWS.size();
			if(len==1) {
				System.out.println("view closed succeed.");
			}else{
				System.out.println("view closed exception."); 
			}
		}else {			
			System.err.println("can't found view instance.");
		}
	}
	
	
	public void showInsList() {
		PrintUtils.pEnter(this, "showInsList");
		INSTANCES.forEach((clz, ibc)->{
//			String cName = clz.getClass().getName();
			String cName = "";
			String iName = ibc.getClass().getName();
			System.out.println("cName：" + cName + " | iName：" + iName);
		});
	}
	
//	public int getExistCount() {
//		return INSTANCES.size();
//	}
	
//	private void methodReflectInvoke() {
//		Clz p = new Clz();
//		Class clazz = p.getClass();
//		Method method = clazz.getMethod("methodName", null);
//		//123
//		method.invoke(p, null);
//	}
	
}
