package sysfkc.mvc.sqlTest;

import com.frm.mvc.BaseCtrl;
import com.frm.proto.PDTO;
import com.frm.proto.PID;

/**
 * @author LinHuanZhi
 * @time 2021年12月21日
 * @email lhz034069@163.com
 * @description 
 */
public class SqlTestCtrl extends BaseCtrl{

	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.view = new SqlTestView();
		this.model = new SqlTestModel();
		
	}

	@Override
	public PID[] registerPIDList() {
		// TODO Auto-generated method stub
		PID[] pIdList = {
				PID.PID_SQL_LOGIN,
				PID.PID_YZP_DENGLUFAIL,
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
