package sysfkc.mvc.clientMain01;

import com.frm.mvc.BaseCtrl;
import com.frm.proto.PDTO;
import com.frm.proto.PID;

public class ClientMainCtrl01 extends BaseCtrl{

	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.view = new ClientMainView01();
		this.model = new ClientMainModel01();
	}

	@Override
	public PID[] registerPIDList() {
		// TODO Auto-generated method stub
		PID[] pIdList = {
			PID.PID_QUESTION_ENTER_STATE,
		};
		return pIdList;
	}

	@Override
	public void updateModel(PDTO pdto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateView(PDTO pdto) {
		// TODO Auto-generated method stub
//		ClientMainView01 v = (ClientMainView01) this.view;
//		v.onUpdate
		this.view.updateView(pdto);
	}

	
}
