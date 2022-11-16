package sysfkc.mvc.login;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

//import jdk.internal.misc.FileSystemOption;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.frm.mvc.BaseView;
import com.frm.mvc.IModelArgsExt;
import com.frm.mvc.MVC;
import com.frm.mvc.ModelArgsExt;
import com.frm.proto.PDTO;
import com.frm.proto.PID;

import sysfkc.a_proto.apdto.PDTO_DENGLU;
import sysfkc.a_proto.apdto.PDTO_DENGLUFAIL;
import sysfkc.mvc.auxiliary.AuxiliaryCtrl;
import sysfkc.mvc.auxiliary.AuxiliaryModel;
import sysfkc.mvc.register.RegisterCtrl;
import sysfkc.mvc.sqlTest.SqlTestCtrl;

public class LoginView extends BaseView implements ActionListener {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=389,-16
	 */
	private final JLabel label = new JLabel("New label");
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
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
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5E7F\u5DDE\u5357\u65B9\u5B66\u9662\u77E5\u8BC6\u7ADE\u8D5B\u7CFB\u7EDF");
		frame.setBounds(100, 100, 527, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(218, 110, 129, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u5E7F\u5DDE\u5357\u65B9\u5B66\u9662\u77E5\u8BC6\u7ADE\u8D5B\u7CFB\u7EDF");
		lblNewLabel_2.setFont(new Font("����", Font.BOLD, 25));
		lblNewLabel_2.setBounds(97, 20, 332, 42);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("账        号：");
		lblNewLabel_1.setFont(new Font("����", Font.ITALIC, 15));
		lblNewLabel_1.setBounds(113, 111, 91, 18);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2_1 = new JLabel("密        码：");
		lblNewLabel_2_1.setFont(new Font("����", Font.ITALIC, 15));
		lblNewLabel_2_1.setBounds(113, 163, 94, 18);
		frame.getContentPane().add(lblNewLabel_2_1);

		JButton btnNewButton_1 = new JButton("\u767B\u5F55");
		btnLogin = btnNewButton_1;
		
		/** 登录事件处理 */
		btnNewButton_1.addActionListener(this);
//				new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				 PDTO_DENGLU b = new  PDTO_DENGLU();
//				 b.account = textField.getText();
//				 b.passWord = passwordField.getText();
//				if(StringUtil.isEmpty(b.account)) {
//					JOptionPane.showMessageDialog(null, "账号不能为空！");
//					return;
//				}
//				if(StringUtil.isEmpty(b.passWord)) {
//					JOptionPane.showMessageDialog(null, "密码不能为空！");
//					return;	
//				}
//				sendPack(PID.PID_YZP_DNEGLU, b);   // 利用sendPack()将结构体发送给服务器
//			}
//		});
		btnNewButton_1.setBounds(128, 224, 120, 23);
		frame.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel_3 = new JLabel("\u8D26\u53F7\u5BC6\u7801\u767B\u5F55");
		lblNewLabel_3.setFont(new Font("����", Font.BOLD, 15));
		lblNewLabel_3.setBounds(210, 70, 113, 18);
		frame.getContentPane().add(lblNewLabel_3);

		passwordField = new JPasswordField();
		passwordField.setBounds(218, 163, 129, 21);
		frame.getContentPane().add(passwordField);

		JButton btnNewButton_1_1 = new JButton("前往注册");
		btnNewButton_1_1.setBounds(275, 224, 113, 23);
		frame.getContentPane().add(btnNewButton_1_1);
		// 为返回添加事件---点击可以返回到注册
		btnNewButton_1_1.addActionListener(this);
//				new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				MVC.openModule(RegisterCtrl.class);
//				MVC.closeModule(LoginCtrl.class);
//			}
//		});
		btnRtn = btnNewButton_1_1;
		 //添加键盘事件
		passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
            	if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            		loginDeal();
            	}
            }
        });
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
	protected void setVisible(boolean arg0) {
		// TODO Auto-generated method stub
		frame.setVisible(arg0);
	}

	private int currentType;
	private JButton btnRtn;
	private JButton btnLogin;

	protected void onOpen(ArrayList<Object> params) {
		int type = this.isParamsNullorEmpty() ? AuxiliaryModel.TYPE_NONE : (int) params.get(0);
		currentType = type;
		btnRtn.setEnabled(!this.isSqlInjectView());
	}

	public void openDengluTangchuang() {
		// TODO Auto-generated method stub
//		int isDelete=JOptionPane.showConfirmDialog(frame, "登录成功","登录完成",JOptionPane.YES_NO_CANCEL_OPTION);
		Object[] options = { "OK" }; // 登录成功弹出提示框 “登录成功”

		int isDelete = JOptionPane.showOptionDialog(frame, "登录成功！", "欢迎你", JOptionPane.PLAIN_MESSAGE,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		if (isDelete == JOptionPane.YES_OPTION) {
			if (this.isSqlInjectView()) {
				MVC.openModule(SqlTestCtrl.class);
			} else {
//				MVC.openModule(ChatInterfaceCtrl.class);
				IModelArgsExt m = new ModelArgsExt();
				m.onOpenAdd(AuxiliaryModel.TYPE_COMPETITION);
				MVC.openModule(AuxiliaryCtrl.class, m);
			}
//		int isDelete=JOptionPane.showConfirmDialog(frame, "登录成功","登录完成",JOptionPane.YES_NO_CANCEL_OPTION);

//		Object[] options = {"OK"};       //登录成功弹出提示框 “登录成功”
//		
//		int isDelete = JOptionPane.showOptionDialog(frame,
//	                   "登录成功！","欢迎你",
//	                   JOptionPane.PLAIN_MESSAGE,
//	                   JOptionPane.PLAIN_MESSAGE,
//	                   null,
//	                   options,
//	                   options[0]);
//		if(isDelete == JOptionPane.ERROR_MESSAGE) {
//			MVC.openModule(ChatInterfaceCtrl.class);
			MVC.closeView(LoginCtrl.class);
//		}

//		
//		if(isDelete == JOptionPane.YES_OPTION){
////			CCenter.c.openCtrl(ChatInterfaceCtrl.class);
////			CCenter.c.closeCtrl(LoginCtrl.class);
//			MVC.openModule(ChatInterfaceCtrl.class);
//			MVC.closeView(LoginCtrl.class);
		}
	}
	
	public void openDengluTangchuangFail() {
		// TODO Auto-generated method stub
		Object[] options = { "OK" }; 
		System.err.println("=======");
		int isDelete = JOptionPane.showOptionDialog(frame, "登录失败", "很遗憾", JOptionPane.PLAIN_MESSAGE,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		if (isDelete == JOptionPane.YES_OPTION) {
			//不做处理
		}
	}

	public void openDengluFailTangchuang(PDTO_DENGLUFAIL info) {
		JOptionPane.showMessageDialog(frame, "serverInfo：" + info.error);
	}

	@Override
	public void updateView(PDTO pdto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == btnLogin) {
			this.loginDeal();
		} else if (e.getSource() == btnRtn) {
			if (this.isSqlInjectView()) {
				// 不可用
			} else {
				MVC.openModule(RegisterCtrl.class);
				MVC.closeModule(LoginCtrl.class);
			}
		}
	}
	
	private void loginDeal(){
		PDTO_DENGLU b = new PDTO_DENGLU();
		b.account = textField.getText();
		b.passWord = passwordField.getText();

		if (b.account.length() > 0) {
			int i = b.passWord.indexOf(" ");
			if (i != -1) {
				JOptionPane.showMessageDialog(null, "账号不能有空格！");
				return;
			}
		}

		if (b.passWord.length() > 0) {
			int i = b.passWord.indexOf(" ");
			if (i != -1) {
				JOptionPane.showMessageDialog(null, "密码不能有空格！");
				return;
			}
		}

		if (StringUtil.isEmpty(b.account)) {
			JOptionPane.showMessageDialog(null, "账号不能为空！");
			return;
		}
		if (StringUtil.isEmpty(b.passWord)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}

		if (this.isSqlInjectView()) {
			sendPack(PID.PID_SQL_LOGIN, b);
		} else {
			sendPack(PID.PID_YZP_DNEGLU, b); // 利用sendPack()将结构体发送给服务器
		}
	}

	private boolean isSqlInjectView() {
		return currentType == AuxiliaryModel.TYPE_SQL_LOGIN;
	}

}
