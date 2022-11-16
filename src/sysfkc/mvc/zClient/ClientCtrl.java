package sysfkc.mvc.zClient;

import com.frm.mvc.BaseCtrl;
import com.frm.proto.PDTO;
import com.frm.proto.PID;

@Deprecated
public class ClientCtrl extends BaseCtrl{

	public ClientCtrl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.view = new ClientView();
		this.model = new ClientModel();
	}

	@Override
	public PID[] registerPIDList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateModel(PDTO pdto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateView(PDTO pdto) {
		// TODO Auto-generated method stub
		
	}

	

}
