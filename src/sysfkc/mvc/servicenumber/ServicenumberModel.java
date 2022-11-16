package sysfkc.mvc.servicenumber;

import com.frm.mvc.BaseModel;
import com.frm.proto.PDTO;

import sysfkc.a_proto.apdto.PDTO_TICKER;

public class ServicenumberModel extends BaseModel{
	private boolean connFlag = false;
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void mClear() {
		// TODO Auto-generated method stub
		
	}

	public boolean isConnFlag() {
		return connFlag;
	}

	public void setConnFlag(boolean connFlag) {
		this.connFlag = connFlag;
	}
	
	public void updateModel(PDTO_TICKER dto) {
		this.setConnFlag(true);
	}

	@Override
	public void updateDt(PDTO pdto) {
		// TODO Auto-generated method stub
		
	}

	
}
