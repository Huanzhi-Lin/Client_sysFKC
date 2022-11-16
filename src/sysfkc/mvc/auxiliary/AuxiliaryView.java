package sysfkc.mvc.auxiliary;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.frm.mvc.BaseView;
import com.frm.mvc.IModelArgsExt;
import com.frm.mvc.MVC;
import com.frm.mvc.ModelArgsExt;
import com.frm.proto.PDTO;

import sysfkc.mvc.chatonline.ChatInterfaceCtrl;
import sysfkc.mvc.clientMain01.ClientMainCtrl01;
import sysfkc.mvc.login.LoginCtrl;
import sysfkc.mvc.register.RegisterCtrl;

/**
 * @author LinHuanZhi
 * @time 2021年12月21日
 * @email lhz034069@163.com
 * @description 
 */
public class AuxiliaryView extends BaseView implements ActionListener{
	private JTextArea textArea;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuxiliaryView window = new AuxiliaryView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AuxiliaryView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setTitle("AuxiliaryView");
		frame.setBounds(100, 100, 253, 339);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		textArea = new JTextArea();
		panel.add(textArea);
		
		btnSql = new JButton("SQL Injection LoginView");
		frame.getContentPane().add(btnSql);
		
		btnNormalRegView = new JButton("Normal RegisterView");
		frame.getContentPane().add(btnNormalRegView);
		
		btnLogout = new JButton("Logout");
//		btnLogout.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		frame.getContentPane().add(btnLogout);
		
		btnExit = new JButton("Exit");
//		btnExit.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		frame.getContentPane().add(btnExit);
	}
	JButton btnSql;
	JButton btnNormalRegView;
	JButton btnLogout;
	JButton btnExit;
	private String str1[] = {
		"sql注入登录",
		"正常登录",
		"注销登录",
		"退出系统",
	};
	private String str2[] = {
		"聊天室",
		"竞赛室",
		"注销登录",
		"退出系统",
	};
	private int currentType;
	protected void onOpen(ArrayList<Object> params) {
		JButton btns[] = {
			btnSql, btnNormalRegView, btnLogout, btnExit
		};
		int type = this.isParamsNullorEmpty() ? AuxiliaryModel.TYPE_COMPETITION : (int) params.get(0);
		currentType = type;
		String[] strs = type==AuxiliaryModel.TYPE_COMPETITION ? str2 : str1;
		for(int i = 0; i < strs.length; i++) {
			if(btns[i] != null) {
				JButton btn = btns[i];
				btn.setText(strs[i]);
				btn.addActionListener(this);
//				btn.setSize(300, 50);
			}
		}
		String info = "你可以选择以下操作...";
		this.textArea.setText(info);
	}

	@Override
	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(b);
	}

	@Override
	public void updateView(PDTO pdto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void mClear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void mClose() {
		// TODO Auto-generated method stub
		frame.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btnExit) {
			System.exit(0);
		}
		else if(e.getSource() == this.btnLogout) {
//			logoutDealer();
//			MVC.openModule(ServicenumberCtrl.class);
//			MVC.closeModule(AuxiliaryCtrl.class);
			JOptionPane.showMessageDialog(frame, "此功能暂未开放");
		}
		else if(e.getSource() == this.btnNormalRegView) {
			if(isSqlInjectView()) {				
				MVC.openModule(RegisterCtrl.class);
				MVC.closeModule(AuxiliaryCtrl.class);
			}else {
//				JOptionPane.showMessageDialog(frame, "此功能暂未开放");
//				MVC.openModule(ClientMainCtrl.class);
				MVC.openModule(ClientMainCtrl01.class);
			}
		}
		else if(e.getSource() == this.btnSql) {
			if(isSqlInjectView()) {				
				IModelArgsExt m = new ModelArgsExt();
				m.onOpenAdd(AuxiliaryModel.TYPE_SQL_LOGIN);
				MVC.openModule(LoginCtrl.class, m);
				MVC.closeModule(AuxiliaryCtrl.class);
			}
			else if(isCompetitionView()) {
				MVC.openModule(ChatInterfaceCtrl.class);
			}
			else {
				System.out.println("unhandle type...");
			}
		}
	}
	
	private boolean isSqlInjectView() {
		return currentType == AuxiliaryModel.TYPE_SQL_LOGIN;
	}
	private boolean isCompetitionView() {
		return currentType == AuxiliaryModel.TYPE_COMPETITION;
	}

}
