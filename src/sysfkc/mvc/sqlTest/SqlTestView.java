package sysfkc.mvc.sqlTest;

import java.awt.Component;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.frm.mvc.BaseView;
import com.frm.mvc.MVC;
import com.frm.proto.PDTO;
import com.frm.proto.PID;

import sysfkc.a_proto.apdto.PDTO_DENGLU;
import sysfkc.a_proto.apdto.PDTO_DENGLUFAIL;
import sysfkc.mvc.login.LoginCtrl;
import sysfkc.mvc.login.LoginModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author LinHuanZhi
 * @time 2021年12月21日
 * @email lhz034069@163.com
 * @description 
 */
public class SqlTestView extends BaseView{

	private JTextArea textArea;
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SqlTestView window = new SqlTestView();
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
	public SqlTestView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Sql注入测试界面");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane sp = new JScrollPane((Component) null);
		sp.setBounds(0, 0, 436, 195);
		frame.getContentPane().add(sp);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		sp.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setText("在此处输入密码获得用户名（模拟）");
		textField.setToolTipText("");
		textField.setBounds(0, 200, 278, 59);
		textField.setColumns(10);
		frame.getContentPane().add(textField);
		
		JButton btnNewButton = new JButton("注销登录");
		btnNewButton.setBounds(298, 231, 138, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("模拟登录");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PDTO_DENGLU dt = new  PDTO_DENGLU();
				dt.account = MVC.getModel(LoginCtrl.class, LoginModel.class).getAccount();
				dt.passWord = textField.getText();
				sendPack(PID.PID_SQL_LOGIN, dt);
			}
		});
		btnNewButton_1.setBounds(298, 205, 138, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
	protected void onOpen(ArrayList<Object> params) {
		String info = MVC.getModel(LoginCtrl.class, LoginModel.class).getSqlUserName();
		textArea.append(info);
	}
	@Override
	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(b);
	}

	@Override
	public void updateView(PDTO pdto) {
		// TODO Auto-generated method stub
		if(pdto.getPId() == PID.PID_SQL_LOGIN) {			
			String info = "sqlInjection：" + ((PDTO_DENGLU)pdto).nickName + "\n";
			textArea.append(info);
		}
		else if(pdto.getPId() == PID.PID_YZP_DENGLUFAIL) {
			PDTO_DENGLUFAIL fail = (PDTO_DENGLUFAIL)pdto;
			JOptionPane.showMessageDialog(frame, "serverInfo：" + fail.error);
		}
		else {
			System.out.println("unhandle pid type...");
		}
	}

	@Override
	protected void mClose() {
		// TODO Auto-generated method stub
		frame.dispose();
	}
}
