package sysfkc.mvc.register;

import com.frm.mvc.BaseCtrl;
import com.frm.proto.PDTO;
import com.frm.proto.PID;

import sysfkc.a_proto.apdto.PDTO_ZHUCE;

public class RegisterCtrl  extends BaseCtrl {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.view = new RegisterView();
		this.model = new RegisterModel();
	}

	@Override
	public PID[] registerPIDList() {   //自动将服务器返回的结果 触发下面的方法
		// TODO Auto-generated method stub
		PID[] pIdList = {
				PID.PID_YZP_ZHUCE,
		};
		return pIdList;
	}

	@Override
	public void updateModel(PDTO pdto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateView(PDTO pdto) {
		//进这个方法，就代表服务器已经把处理结果返回到这里了
//		this.view.弹窗方法；
		boolean a =  ((PDTO_ZHUCE)pdto).isSucc;
		if(a) {
			//客户端弹出提示框：“注册成功”
			((RegisterView)this.view).openzhuceTangchuang();
		}else {			
			((RegisterView)this.view).openzhuceTangchuangFail();
		}
	}

}
