package sysfkc.mvc.clientMain;

import com.frm.mvc.BaseCtrl;
import com.frm.proto.PDTO;
import com.frm.proto.PID;

@Deprecated
public class ClientMainCtrl extends BaseCtrl{

	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.view = new ClientMainView();
		this.model = new ClientMainModel();
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
