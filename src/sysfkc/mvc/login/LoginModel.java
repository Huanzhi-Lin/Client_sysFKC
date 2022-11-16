package sysfkc.mvc.login;

import com.frm.mvc.BaseModel;
import com.frm.proto.PDTO;
import com.frm.proto.PID;

import sysfkc.a_proto.apdto.PDTO_DENGLU;

public class LoginModel extends BaseModel {
	private PDTO_DENGLU loginDt;
	private PDTO_DENGLU loginSqlDt;
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void mClear() {
		// TODO Auto-generated method stub
		this.loginDt = null;
		this.loginSqlDt = null;
	}

	@Override
	public void updateDt(PDTO pdto) {
		// TODO Auto-generated method stub
		if(pdto.getPId() == PID.PID_YZP_DNEGLU) {	
			this.loginDt = (PDTO_DENGLU) pdto;
		}
		else if(pdto.getPId() == PID.PID_SQL_LOGIN) {
			this.loginSqlDt = (PDTO_DENGLU) pdto;			
		}
		else {
			System.err.println("UNhandle PID type...");
		}
	}
	
	public String getUserName() {
		return this.loginDt.nickName;
	}
	public String getSqlUserName() {
		return "sqlInjection：欢迎用户：" + this.loginSqlDt.nickName + "\n";
	}
	public String getAccount() {
		return this.loginSqlDt.account;
	}

}
