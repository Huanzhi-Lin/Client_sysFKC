package sysfkc.mvc.main;

import com.frm.mvc.CCenter;
import com.frm.mvc.MVC;

import sysfkc.mvc.servicenumber.ServicenumberCtrl;


//import sysfkc.mvc.MainUI.MainUIView;
//import sysfkc.mvc.login.LoginCtrl;

public class Main {

	public Main() {
//		CCenter.c.openCtrl(ServicenumberCtrl.class);
		MVC.openModule(ServicenumberCtrl.class);
//		CCenter.c.openCtrl(ClientCtrl.class);		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
}

