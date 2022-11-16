package sysfkc.mvc.answer2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.frm.mvc.BaseView;
import com.frm.mvc.MVC;
import com.frm.proto.PDTO;
import com.frm.proto.PID;
import com.frm.utils.StringUtils;

import sysfkc.a_proto.apdto.PDTO_QUEST_COMMIT_ANSWER;
import sysfkc.a_proto.apdto.PDTO_QUEST_INFO_UPDATE;
import sysfkc.a_proto.apdto.PDTO_QUEST_PREPARE_START;
import sysfkc.a_proto.apdto.PDTO_QUEST_SHOW_RESULT;
import sysfkc.mvc.login.LoginCtrl;
import sysfkc.mvc.login.LoginModel;
import java.awt.Font;

public class AnswerView2 extends BaseView{

	private JFrame frame;
	private JTextField team1Text;
	private JTextField team2Text;
	private JRadioButton rda,rdb,rdc,rdd;
	private JButton btnCommit;
	private JLabel th,tm,lblNewLabel_4,lblNewLabel_5,team1;
	private JButton btnStart;
	private JLabel lbRst;
	private JLabel lblNewLabel_1;
	private JLabel lbCd;
	Timer timer;
	MyTimerTask task;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnswerView2 window = new AnswerView2();
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
	public AnswerView2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 590, 423);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 team1 = new JLabel("第一队");
		 team1.setFont(new Font("宋体", Font.BOLD, 21));
		team1.setBounds(41, 64, 66, 24);
		frame.getContentPane().add(team1);
		
		JLabel team2 = new JLabel("第二队");
		team2.setFont(new Font("宋体", Font.BOLD, 21));
		team2.setBounds(341, 64, 77, 24);
		frame.getContentPane().add(team2);
		
		team1Text = new JTextField();
		team1Text.setBounds(145, 61, 66, 21);
		frame.getContentPane().add(team1Text);
		team1Text.setColumns(10);
		
		team2Text = new JTextField();
		team2Text.setBounds(444, 61, 66, 21);
		frame.getContentPane().add(team2Text);
		team2Text.setColumns(10);
		
		JButton start = new JButton("开始");
		start.setFont(new Font("宋体", Font.BOLD, 21));
		btnStart = start;
		btnStart.setEnabled(false);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rda.setVisible(true);
				rdb.setVisible(true);
				rdc.setVisible(true);
				rdd.setVisible(true);
				btnCommit.setVisible(true);
				th.setVisible(true);
				tm.setVisible(true);
				start.setVisible(false);
				lblNewLabel_4.setIcon(new ImageIcon("D:\\zhishi\\project\\resource\\main\\light_green.png"));
			}
		});
		start.setBounds(161, 288, 165, 28);
		frame.getContentPane().add(start);
		
		 rda = new JRadioButton("A");
		 rda.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		ActionPerformed(e);
			 	}
			 });
		rda.setBounds(19, 342, 88, 23);
		frame.getContentPane().add(rda);
//		rda.setVisible(false);
		
		 rdb = new JRadioButton("B");
		 rdb.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		BctionPerformed(e);
			 	}
			 	
			 });
		rdb.setBounds(121, 342, 90, 23);
		frame.getContentPane().add(rdb);
//		rdb.setVisible(false);
		
		 rdc = new JRadioButton("C");
		 rdc.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		CctionPerformed(e);
			 	}
			 });
		rdc.setBounds(232, 342, 110, 23);
		frame.getContentPane().add(rdc);
//		rdc.setVisible(false);
		
		 rdd = new JRadioButton("D");
		 rdd.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		DctionPerformed(e);
			 	}
			 });
		rdd.setBounds(344, 342, 119, 23);
		frame.getContentPane().add(rdd);
//		rdd.setVisible(false);
		
		 btnCommit = new JButton("提交");
		 btnCommit.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		PDTO_QUEST_COMMIT_ANSWER req = new PDTO_QUEST_COMMIT_ANSWER();
		 		String answer = getSelAnswer();
		 		req.commitAnswer = answer + "";
		 		sendPack(PID.PID_QUESTION_COMMIT_ANSWER, req);
		 	}
		 });
		btnCommit.setBounds(469, 342, 97, 23);
		frame.getContentPane().add(btnCommit);
//		btnCommit.setVisible(false);
		
		 th = new JLabel("题号");
		 th.setFont(new Font("宋体", Font.BOLD, 21));
		th.setBounds(177, 204, 200, 24);
		frame.getContentPane().add(th);
		th.setVisible(false);
		
		 tm = new JLabel("题目");
		 tm.setFont(new Font("宋体", Font.BOLD, 21));
		tm.setBounds(222, 204, 196, 24);
		frame.getContentPane().add(tm);
		tm.setVisible(false);
		
		 lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\zhishi\\project\\resource\\main\\light_red.png"));
		lblNewLabel_4.setBounds(114, 64, 34, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		 lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\zhishi\\project\\resource\\main\\light_red.png"));
		lblNewLabel_5.setBounds(415, 64, 43, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 21));
		lbRst = lblNewLabel;
		lblNewLabel.setBounds(354, 290, 189, 24);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("即将开始答题.......");
		lbCd = lblNewLabel_1;
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 29));
		lblNewLabel_1.setBounds(143, 133, 310, 41);
		frame.getContentPane().add(lblNewLabel_1);
	}
	private String getSelAnswer() {
		String rst = "";
		JRadioButton jrds[] = {rda, rdb, rdc, rdd};
		for(JRadioButton rd: jrds) {
			if(rd.isSelected()) {
				rst = rd.getText();
			}
		}
		
		return rst;
	}

	protected void DctionPerformed(ActionEvent e) {
		if (rdd.isSelected() == true)
		{
		rda.setSelected(false);
		rdd.setSelected(true);
		rdc.setSelected(false);
		rdb.setSelected(false);
		
		}
		if (rdb.isSelected() == false)
		{
		rda.setSelected(false);
		rdc.setSelected(false);
		rdd.setSelected(false);
		rdd.setSelected(true);
		
		}
		
	}


	protected void CctionPerformed(ActionEvent e) {
		if (rdc.isSelected() == true)
		{
		rda.setSelected(false);
		rdc.setSelected(true);
		rdb.setSelected(false);
		rdd.setSelected(false);
		
		}
		if (rdc.isSelected() == false)
		{
		rdb.setSelected(false);
		rda.setSelected(false);
		rdd.setSelected(false);
		rdc.setSelected(true);
		
		}
		
	}

	protected void BctionPerformed(ActionEvent e) {
		if (rda.isSelected() == true)
		{
		rda.setSelected(false);
		rdb.setSelected(true);
		rdc.setSelected(false);
		rdd.setSelected(false);
		
		}
		if (rdb.isSelected() == false)
		{
		rdb.setSelected(false);
		rdc.setSelected(false);
		rdd.setSelected(false);
		rda.setSelected(true);
		
		}
		
	}


	protected void ActionPerformed(ActionEvent e) {
		//System.out.println(rda.getText());
		if (rda.isSelected() == true)
		{
		rda.setSelected(false);
		rdb.setSelected(true);
		rdc.setSelected(true);
		rdd.setSelected(true);
		}
		if (rda.isSelected() == false)
		{
		rdb.setSelected(false);
		rda.setSelected(true);
		rdc.setSelected(false);
		rdd.setSelected(false);
		}
	
		
	}

	@Override
	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(b);
	}

	@Override
	public void updateView(PDTO pdto) {
		// TODO Auto-generated method stub
		switch(pdto.getPId()) {
		case PID_QUESTION_PREPARE_START:
				updatePrepared(pdto);
			break;
		case PID_QUESTION_INFO_UPDATE:
			lbCd.setVisible(false);
				updateInfo(pdto);
			break;
		case PID_QUESTION_SHOW_RESULT:
				updateResult(pdto);
			break;
		case PID_QUESTION_END:
			lbCd.setVisible(false);
				updateEnd(pdto);
			break;
		default:
				System.err.println("AnswerView2 unknow type");
			break;
		}
	}

	private void updateEnd(PDTO pdto) {
		// TODO Auto-generated method stub
//		int result = JOptionPane.showConfirmDialog(null, "比赛结束");
//		System.out.println(result);
//		if(result == 0) {
////			JOptionPane.showMessageDialog(null,"比赛开始");
//			MVC.closeModule(AswerCtrl2.class);
//		}
		Object[] options = { "OK" }; 
		int isDelete = JOptionPane.showOptionDialog(frame, "比赛结束", "小提示", JOptionPane.PLAIN_MESSAGE,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		if (isDelete == JOptionPane.YES_OPTION) {
			MVC.closeModule(AswerCtrl2.class);
		}
	}

	private void updateResult(PDTO pdto) {
		// TODO Auto-generated method stub
		startCd();
		PDTO_QUEST_SHOW_RESULT info = (PDTO_QUEST_SHOW_RESULT) pdto;
//		String tick = info.isCorrect ? "✔" : "✖";
		String tick = info.isCorrect ? "对" : "错";
		lbRst.setText(tick + ": " + info.showRst);
	}

	private void updateInfo(PDTO pdto) {
		// TODO Auto-generated method stub
		btnStart.setVisible(false);
		lbRst.setText("");
		PDTO_QUEST_INFO_UPDATE rsp = (PDTO_QUEST_INFO_UPDATE) pdto;
		th.setText(rsp.Id + "");
		th.setVisible(true);
		tm.setText(rsp.timu);
		tm.setVisible(true);
		rda.setText(rsp.choiceA);
		rdb.setText(rsp.choiceB);
		rdc.setText(rsp.choiceC);
		rdd.setText(rsp.choiceD);
		String name = MVC.getModel(LoginCtrl.class, LoginModel.class).getUserName();
		if(rsp.answerName.equals(name)) {
			this.mSetBottom(true);
			updateLightState(true, rsp.answerName);
		}else {
			this.mSetBottom(false);			
			updateLightState(false, rsp.answerName);
		}
		
	}
	private void mSetBottom(boolean v) {
//		rda.setVisible(v);
//		rdb.setVisible(v);
//		rdc.setVisible(v);
//		rdd.setVisible(v);
//		btnCommit.setVisible(v);
		rda.setEnabled(v);
		rdb.setEnabled(v);
		rdc.setEnabled(v);
		rdd.setEnabled(v);
		btnCommit.setEnabled(v);
	}
	
	private void updateLightState(boolean v, String turnName) {
		if(v) { //我能答题
			JLabel jlb = findSelf(turnName);
			jlb.setIcon(new ImageIcon("D:\\zhishi\\project\\resource\\main\\light_green.png"));
			JLabel jlbOther = findOther(turnName);
			jlbOther.setIcon(new ImageIcon("D:\\zhishi\\project\\resource\\main\\light_red.png"));
		}else {//我不能答题
			JLabel jlb = findSelf(turnName);
			jlb.setIcon(new ImageIcon("D:\\zhishi\\project\\resource\\main\\light_red.png"));
			JLabel jlbOther = findOther(turnName);
			jlbOther.setIcon(new ImageIcon("D:\\zhishi\\project\\resource\\main\\light_green.png"));
		}
	}
	
	private JLabel findSelf(String turnName) {
		if(team1Text.getText().equals(turnName)) {
			return lblNewLabel_4;
		}else {
			return lblNewLabel_5;
		}
	}
	private JLabel findOther(String turnName) {
		if(team2Text.getText().equals(turnName)) {
			return lblNewLabel_4;
		}else {
			return lblNewLabel_5;
		}
	}

	private void updatePrepared(PDTO pdto) {
		startCd();
		// TODO Auto-generated method stub
		PDTO_QUEST_PREPARE_START info = (PDTO_QUEST_PREPARE_START) pdto;
		JTextField[] tfs = { team1Text,  team2Text };
		for(int i = 0; i < tfs.length; i++) {
			String n = info.nList.get(i);
			if(n == null) {
				tfs[i].setText("虚位以待");
			}else {
				tfs[i].setText(n);
			}
		}
		btnStart.setText("即将开始...");
		lbRst.setText("");
	}

	private void startCd() {
		lbCd.setVisible(true);
		if(timer == null)
			timer=new Timer(true);
		if(task!=null)
			task.cancel();
		task=new MyTimerTask();
		timer.schedule(task, 0, 1000);
	}
	private int cd = 0;
	class MyTimerTask extends TimerTask{
//		int n=3;
		public void run() {
//			n--;
//			lbCd.setText("即将答题进入下一轮..." + n);
			String postfix = StringUtils.generateTokenByV(++cd%6);
			
			lbCd.setText("即将开始答题" + postfix);
//			if(n<=0){
//				lbCd.setText("");
//				this.cancel();
//			}
		}
	}
	@Override
	protected void mClose() {
		// TODO Auto-generated method stub
		timer = null;
		if(task != null) {
			task.cancel();
		}
		task = null;
		frame.dispose();
	}
}
