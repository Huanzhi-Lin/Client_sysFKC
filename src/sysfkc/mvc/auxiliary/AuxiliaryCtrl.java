package sysfkc.mvc.auxiliary;

import com.frm.mvc.BaseCtrl;
import com.frm.mvc.IModelArgsExt;
import com.frm.proto.PDTO;
import com.frm.proto.PID;

/**
 * @author LinHuanZhi
 * @time 2021年12月21日
 * @email lhz034069@163.com
 * @description 
 */
public class AuxiliaryCtrl extends BaseCtrl{
	
	public AuxiliaryCtrl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuxiliaryCtrl(IModelArgsExt args) {
		super(args);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.view = new AuxiliaryView();
		this.model = new AuxiliaryModel();
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
