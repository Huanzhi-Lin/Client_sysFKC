package sysfkc.mvc.servicenumber;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.frm.cnet.CSocketMgr;
import com.frm.mvc.BaseView;
import com.frm.mvc.IModelArgsExt;
import com.frm.mvc.MVC;
import com.frm.mvc.ModelArgsExt;
import com.frm.proto.PDTO;

import sysfkc.a_proto.apdto.PDTO_TICKER;
import sysfkc.mvc.auxiliary.AuxiliaryCtrl;
import sysfkc.mvc.auxiliary.AuxiliaryModel;
import sysfkc.mvc.login.LoginCtrl;

public class ServicenumberView extends BaseView {
	private JButton btnLink;
	private JButton btnEnter;
	private JLabel jlb;
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServicenumberView window = new ServicenumberView();
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
	public ServicenumberView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5E7F\u5DDE\u5357\u65B9\u5B66\u9662\u77E5\u8BC6\u7ADE\u8D5B\u7CFB\u7EDF");
		frame.getContentPane().setFont(new Font("����", Font.BOLD, 12));
		frame.setBounds(100, 100, 527, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5E7F\u5DDE\u5357\u65B9\u5B66\u9662\u77E5\u8BC6\u7ADE\u8D5B\u7CFB\u7EDF");
		lblNewLabel.setBounds(91, 33, 313, 27);
		lblNewLabel.setFont(new Font("����", Font.BOLD, 23));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u670D\u52A1\u53F7\u767B\u5F55");
		lblNewLabel_1.setFont(new Font("����", Font.ITALIC, 15));
		lblNewLabel_1.setBounds(205, 80, 104, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(189, 144, 139, 21);
		frame.getContentPane().add(textField);
		textField.setText(CSocketMgr.cs.getServerIP());
		
		JLabel lblNewLabel_2 = new JLabel("\u670D\u52A1\u53F7\uFF1A");
		lblNewLabel_2.setFont(new Font("����", Font.ITALIC, 15));
		lblNewLabel_2.setBounds(116, 145, 63, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("连接");
		this.btnLink = btnNewButton;
		
		btnNewButton.setFont(new Font("����", Font.ITALIC, 15));
		btnNewButton.setBounds(189, 197, 130, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("进入系统");
		this.btnEnter = btnNewButton_1;
		btnEnter.setVisible(false);
		btnNewButton_1.setFont(new Font("Dialog", Font.ITALIC, 15));
		btnNewButton_1.setBounds(189, 197, 130, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("已成功连接服务器！");
		this.jlb = lblNewLabel_3;
		jlb.setVisible(false);
		lblNewLabel_3.setBounds(199, 172, 129, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				String ip = textField.getText();
				CSocketMgr.cs.setServerIP(ip);
				CSocketMgr.cs.connectToServer();
			}
		});
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				IModelArgsExt m = new ModelArgsExt();
//				m.onOpenAdd(AuxiliaryModel.TYPE_SQL_LOGIN);
//				MVC.openModule(AuxiliaryCtrl.class, m);
				MVC.openModule(LoginCtrl.class);
				MVC.closeModule(ServicenumberCtrl.class);
			}
		});
	}

	public void updateView(PDTO_TICKER dto) {
		this.btnEnter.setVisible(true);
		this.btnLink.setVisible(false);
		this.jlb.setVisible(true);
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

	@Override
	public void updateView(PDTO pdto) {
		// TODO Auto-generated method stub
		
	}
}
