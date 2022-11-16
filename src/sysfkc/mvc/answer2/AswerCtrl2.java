package sysfkc.mvc.answer2;

import com.frm.mvc.BaseCtrl;
import com.frm.mvc.IModelArgsExt;
import com.frm.proto.PDTO;
import com.frm.proto.PID;

import sysfkc.mvc.answer.AnswerModel;
import sysfkc.mvc.answer.AnswerView;

public class AswerCtrl2 extends BaseCtrl {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		this.view = new AnswerView2();
		this.model = new AnswerModel2();

	}
	
//	public AswerCtrl2(IModelArgsExt args) {
//		super(args);
//	}

	@Override
	public PID[] registerPIDList() {
		// TODO Auto-generated method stub
		PID[] pIdList = {
			PID.PID_QUESTION_PREPARE_START,
			PID.PID_QUESTION_INFO_UPDATE,
			PID.PID_QUESTION_SHOW_RESULT,
			PID.PID_QUESTION_END,
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
		this.view.updateView(pdto);
	}


}
