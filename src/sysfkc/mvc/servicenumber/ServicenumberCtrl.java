package sysfkc.mvc.servicenumber;

import com.frm.mvc.BaseCtrl;
import com.frm.proto.PDTO;
import com.frm.proto.PID;

import sysfkc.a_proto.apdto.PDTO_TICKER;

public class ServicenumberCtrl extends BaseCtrl{

	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.view = new ServicenumberView();
		this.model = new ServicenumberModel();
	}

	@Override
	public PID[] registerPIDList() {
		// TODO Auto-generated method stub
		PID[] pIdList = {
				PID.PID_TICKER
		};
		return pIdList;
	}

	@Override
	public void updateModel(PDTO pdto) {
		// TODO Auto-generated method stub
		switch(pdto.getPId()) {
			case PID_TICKER:
				((ServicenumberModel)model).updateModel((PDTO_TICKER)pdto);		
				break;
			default:
				System.err.println("未找到匹配协议名..." + pdto.getPId());
				break;
		}
	}

	@Override
	public void updateView(PDTO pdto) {
		// TODO Auto-generated method stub
		switch(pdto.getPId()) {
			case PID_TICKER:		
				((ServicenumberView)view).updateView((PDTO_TICKER) pdto);
				break;
			default:
				System.err.println("未找到匹配协议名..." + pdto.getPId());
				break;
		}
		
	}

}
