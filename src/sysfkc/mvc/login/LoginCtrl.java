package sysfkc.mvc.login;

import com.frm.mvc.BaseCtrl;
import com.frm.mvc.IModelArgsExt;
import com.frm.proto.PDTO;
import com.frm.proto.PID;

import sysfkc.a_proto.apdto.PDTO_DENGLU;
import sysfkc.a_proto.apdto.PDTO_DENGLUFAIL;
import sysfkc.a_proto.apdto.PDTO_ZHUCE;
import sysfkc.mvc.register.RegisterView;

public class LoginCtrl extends BaseCtrl {

	public LoginCtrl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginCtrl(IModelArgsExt args) {
		super(args);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.view = new LoginView();
		this.model = new LoginModel();
	}

	@Override
	public PID[] registerPIDList() {   //自动将服务器返回的结果 触发下面的方法
		
		PID[] pIdList = {
				PID.PID_YZP_DNEGLU,
				PID.PID_SQL_LOGIN,
				PID.PID_YZP_DENGLUFAIL,
		};
		return pIdList;
	}
		
	@Override
	public void updateModel(PDTO pdto) {
		// TODO Auto-generated method stub
		this.model.updateDt(pdto);
	}

	public void updateView(PDTO pdto) {
		//进这个方法，就代表服务器已经把处理结果返回到这里了
//		this.view.弹窗方法；
		PID pId = pdto.getPId();
		if(pId==PID.PID_YZP_DNEGLU || pId==PID.PID_SQL_LOGIN) { //这两个是 登录和sql登录返回的
			PDTO_DENGLU info = ((PDTO_DENGLU)pdto);
			//客户端弹出提示框：“登录成功”
			if(info.isSucc) {
				((LoginView)this.view).openDengluTangchuang();
			}else {
				((LoginView)this.view).openDengluTangchuangFail();
			}
		}
		if(pId == PID.PID_YZP_DENGLUFAIL){ //登录失败，带有错误信息的
			((LoginView)this.view).openDengluFailTangchuang((PDTO_DENGLUFAIL)pdto);
		}
	}
	
	
}
