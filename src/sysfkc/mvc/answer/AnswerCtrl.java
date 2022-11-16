package sysfkc.mvc.answer;

import com.frm.mvc.BaseCtrl;
import com.frm.mvc.IModelArgsExt;
import com.frm.proto.PDTO;
import com.frm.proto.PID;

@Deprecated
public class AnswerCtrl extends BaseCtrl {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
//		this.model = new AnswerModel();
		this.view = new AnswerView(); 
	}
	
	public AnswerCtrl(IModelArgsExt args) {
		super(args);
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
