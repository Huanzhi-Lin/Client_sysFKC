package sysfkc.mvc.clientMain01;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.frm.mvc.BaseView;
import com.frm.mvc.MVC;
import com.frm.proto.PDTO;
import com.frm.proto.PID;

import sysfkc.a_proto.apdto.PDTO_BASE;
import sysfkc.a_proto.apdto.PDTO_QUEST_ENTER_ROOM;
import sysfkc.a_proto.apdto.PDTO_QUEST_ROOM_STATE;
import sysfkc.mvc.answer2.AswerCtrl2;
import sysfkc.mvc.login.LoginCtrl;
import sysfkc.mvc.login.LoginModel;

public class ClientMainView01 extends BaseView{

	private JFrame frame;
	private JTextField textField;
	private JButton btnMatch;
	private JLabel lb0;
	private JLabel lb1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientMainView01 window = new ClientMainView01();
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
	public ClientMainView01() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("知识竞赛系统");
		frame.setBounds(100, 100, 665, 417);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("知识竞赛系统");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_1.setBounds(257, 10, 135, 43);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("第一队");
		lb0 = lblNewLabel;
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 21));
		lblNewLabel.setBounds(120, 71, 105, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("第二队");
		lb1 = lblNewLabel_2;
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 21));
		lblNewLabel_2.setBounds(442, 71, 105, 43);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("匹配对手");
		btnMatch = btnNewButton;
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				startatActionPerformed(e);
//				int result = JOptionPane.showConfirmDialog(null, "是否开始比赛？");
//				if(result == 0) {
//					JOptionPane.showMessageDialog(null,"比赛开始");
//				}
				PDTO_QUEST_ENTER_ROOM req = new PDTO_QUEST_ENTER_ROOM();
				String uName = MVC.getModel(LoginCtrl.class, LoginModel.class).getUserName();
				req.name = uName;
				sendPack(PID.PID_QUESTION_ENTER_ROOM, req);
				btnMatch.setText("匹配中...");
			}
		});
		btnNewButton.setBounds(257, 172, 135, 43);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 12));
		textField.setText("规则:各参数队员按组轮流回答问题，限时60秒，单独完成，回答正确该队加10分，回答错误或弃答不加分也不扣分。");
		textField.setBounds(0, 266, 709, 78);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("比赛规则");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel_3.setBounds(0, 240, 74, 26);
		frame.getContentPane().add(lblNewLabel_3);
	}

	protected void startatActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setVisible(boolean arg0) {
		// TODO Auto-generated method stub
		frame.setVisible(arg0);
	}

	@Override
	public void updateView(PDTO pdto) {
		// TODO Auto-generated method stub
		PDTO_QUEST_ROOM_STATE info = (PDTO_QUEST_ROOM_STATE) pdto;
		JLabel[] lbs = {lb0, lb1};
		for(int i = 0; i < lbs.length; i++) {
			if(i > info.nList.size()-1) {				
				lbs[i].setText("虚位以待");
			}else {
				String n = info.nList.get(i);
				lbs[i].setText(n);
			}
		}
		if(info.isRoomFull) {
//			System.err.println("room full----------------");
			MVC.openModule(AswerCtrl2.class);
			MVC.closeModule(ClientMainCtrl01.class);
			sendPack(PID.PID_QUESTION_REQ_START, new PDTO_BASE());
		}
	}

	@Override
	protected void mClose() {
		// TODO Auto-generated method stub
		frame.dispose();
	}
}
