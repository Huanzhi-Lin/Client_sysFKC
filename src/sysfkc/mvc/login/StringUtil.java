package sysfkc.mvc.login;

/**  字符串工具*/
public class StringUtil {
	
	/** 判断是否为空*/

	public static boolean isEmpty(String str) {
		if(str==null || "".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	/**判断是否不是空*/
	public static boolean isNotEmpty(String str) {
		if(str==null && !"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
}

