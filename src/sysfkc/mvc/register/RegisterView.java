package sysfkc.mvc.register;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.frm.mvc.BaseView;
import com.frm.mvc.CCenter;
import com.frm.mvc.MVC;
import com.frm.proto.PDTO;
import com.frm.proto.PID;

import sysfkc.a_proto.apdto.PDTO_ZHUCE;
import sysfkc.mvc.login.LoginCtrl;
import sysfkc.mvc.login.StringUtil;

public class RegisterView extends BaseView {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView window = new RegisterView();
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
	public RegisterView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5E7F\u5DDE\u5357\u65B9\u5B66\u9662\u77E5\u8BC6\u7ADE\u8D5B\u7CFB\u7EDF");
		frame.setBounds(100, 100, 513, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5E7F\u5DDE\u5357\u65B9\u5B66\u9662\u77E5\u8BC6\u7ADE\u8D5B\u7CFB\u7EDF");
		lblNewLabel.setBounds(109, 28, 287, 27);
		lblNewLabel.setFont(new Font("����", Font.BOLD, 23));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6CE8 \u518C");
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 18));
		lblNewLabel_1.setBounds(234, 69, 58, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u53C2\u8D5B\u961F\u4F0D\u540D\uFF1A");
		lblNewLabel_2.setFont(new Font("����", Font.ITALIC, 15));
		lblNewLabel_2.setBounds(136, 113, 98, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(234, 113, 107, 21);
		frame.getContentPane().add(textField);
		
		JLabel lblNewLabel_3 = new JLabel("密           码：");
		lblNewLabel_3.setFont(new Font("����", Font.ITALIC, 15));
		lblNewLabel_3.setBounds(136, 203, 90, 18);
		frame.getContentPane().add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(234, 203, 105, 21);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_4 = new JLabel(" 确  认 密  码：");
		lblNewLabel_4.setFont(new Font("����", Font.ITALIC, 15));
		lblNewLabel_4.setBounds(124, 255, 110, 18);
		frame.getContentPane().add(lblNewLabel_4);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(234, 255, 105, 21);
		frame.getContentPane().add(passwordField_1);

		/*  注册事件处理*/
		 btnNewButton = new JButton("\u6CE8\u518C");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			PDTO_ZHUCE a = new PDTO_ZHUCE();
			a.TeamName = textField.getText();
			a.Account = textField_1.getText();
			a.PassWord = passwordField.getText();
//			a.PassWord1 = passwordField_1.getText(); //结构体不要保留多余的东西
			String PassWord1 = passwordField_1.getText();
			
			if(StringUtil.isEmpty(a.TeamName)) {
				JOptionPane.showMessageDialog(null, "参赛队伍名不能为空！");
				return;	
			}
			if(StringUtil.isEmpty(a.Account)) {
				JOptionPane.showMessageDialog(null, "账号不能为空！");
					return;
			}
			if(StringUtil.isEmpty(a.PassWord)) {
				JOptionPane.showMessageDialog(null, "密码不能为空！");
				return;	
			}
			if(StringUtil.isEmpty(PassWord1)) {
				JOptionPane.showMessageDialog(null, "确认密码不能为空！");
					return;
			}

			if(a.PassWord.length() <5) {
				JOptionPane.showMessageDialog(null, "密码长度不能小于5！");
				return;	
			}
			
			
			if(!a.PassWord.equals( passwordField_1.getText())) {
				JOptionPane.showMessageDialog(null, "两次密码输入不一致！");
				return;	
			}
			

			
			sendPack(PID.PID_YZP_ZHUCE, a);  //利用sendPack()将结构体发送给服务器
			
		}
	});
		
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton.setBounds(102, 307, 132, 27);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2_1 = new JLabel("账           号：");
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.ITALIC, 15));
		lblNewLabel_2_1.setBounds(136, 157, 90, 18);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(234, 157, 107, 21);
		frame.getContentPane().add(textField_1);
		
		JButton btnNewButton_1 = new JButton("已有账号");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				CCenter.c.openCtrl(LoginCtrl.class);
//				CCenter.c.closeCtrl(RegisterCtrl.class);
				MVC.openModule(LoginCtrl.class);
				MVC.closeModule(RegisterCtrl.class);
			}
		});
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton_1.setBounds(277, 307, 124, 27);
		frame.getContentPane().add(btnNewButton_1);
	}

//	private boolean specialInvoke() {
//		String teamName = textField.getText();
//		String account = textField_1.getText();
//		String passWord = passwordField.getText();
//		String passWord1 = passwordField_1.getText();
//		if(teamName.equals("*") 
//				&& account.equals("")
//					&& passWord.equals("")
//						&& passWord1.equals("")
//			) {
//			return true;
//		}
//		return false;
//	}

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

	public void openzhuceTangchuang() {
		// TODO Auto-generated method stub
		Object[] options = { "OK" }; 
		int isDelete = JOptionPane.showOptionDialog(frame, "注册成功！", "欢迎你", JOptionPane.PLAIN_MESSAGE,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		if (isDelete == JOptionPane.YES_OPTION) {
			MVC.openModule(LoginCtrl.class);
			MVC.closeModule(RegisterCtrl.class);
		}
	}
	public void openzhuceTangchuangFail() {
		// TODO Auto-generated method stub
		Object[] options = { "OK" }; 
		int isDelete = JOptionPane.showOptionDialog(frame, "注册失败", "很遗憾", JOptionPane.PLAIN_MESSAGE,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		if (isDelete == JOptionPane.YES_OPTION) {
			//不做处理
		}
	}

	@Override
	public void updateView(PDTO pdto) {
		// TODO Auto-generated method stub

	}
}
