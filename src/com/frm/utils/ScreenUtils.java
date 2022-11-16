package com.frm.utils;
import java.awt.Toolkit;



/**
 * @author LinHuanZhi
 * @time 2021年10月5日
 * @email lhz034069@163.com
 * @description 
 */
public class ScreenUtils {

	
	/**
	 * The width of screen.
	 * @return
	 */
	public static int screenWidth() {
		return Toolkit.getDefaultToolkit().getScreenSize().width; //certainly correct，can try with lower
	}
	
	/**
	 * The height of screen.
	 * @return
	 */
	public static int screenHeight() {
		return Toolkit.getDefaultToolkit().getScreenSize().height;
	}
	
	
}
