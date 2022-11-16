package sysfkc.mvc.chatonline;

import com.frm.mvc.BaseCtrl;
import com.frm.mvc.BaseModel;
import com.frm.proto.PDTO;
import com.frm.proto.PID;



public class ChatInterfaceCtrl extends BaseCtrl	{

	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.view = new ChatInterfaceView();
		this.model = new ChatInterfaceModel();
	}

	@Override
	public PID[] registerPIDList() {
		// TODO Auto-generated method stub
		PID[] pIdList = {
				PID.CHAT_INFO
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
		((ChatInterfaceView)this.view).updateView(pdto);
	}
}

	