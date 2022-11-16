package sysfkc.mvc.answer;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.frm.mvc.BaseView;
import com.frm.proto.PDTO;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
@Deprecated
public class AnswerView extends BaseView{

	private JFrame frame;
	//�ı���
	private JTextField team1Text;
	private JTextField team2Text;
	private JTextField team3Text;
	private JTextField team4Text;
	private JTextField team5Text;
	private JTextField team6Text;
	
	//ѡ�ť
	private JRadioButton rda,rdb,rdc,rdd;
	
	//��һ�ⰴť
	private JButton next;
	//��ʼ��ť
	private JButton start; 
	//�ӱ�ǩ
	private JLabel th,team1,team1y,team2,team2y,team3,team3y,team4,team4y,team5,team5y,team6,team6y;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnswerView window = new AnswerView();
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
	public AnswerView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		frame = new JFrame();
		frame.setTitle("\u77E5\u8BC6\u7ADE\u8D5B");
		frame.setBounds(100, 100, 646, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//��һ����Ϣ
		team1 = new JLabel("第一队");
		team1.setBounds(69, 68, 58, 15);
		frame.getContentPane().add(team1);
		//ͼƬ
		team1y = new JLabel("");
		team1y.setIcon(new ImageIcon("D:\\zhishi\\project\\resource\\main\\light_red.png"));
		team1y.setBounds(111, 68, 31, 15);
		frame.getContentPane().add(team1y);
		
		team1Text = new JTextField();
		team1Text.setBounds(137, 65, 66, 21);
		frame.getContentPane().add(team1Text);
		team1Text.setColumns(10);
		
		//�ڶ�����Ϣ
		team2 = new JLabel("第二队");
		team2.setBounds(377, 68, 58, 15);
		frame.getContentPane().add(team2);
		
		team2y = new JLabel("");
		team2y.setIcon(new ImageIcon("D:\\zhishi\\project\\resource\\main\\light_red.png"));
		team2y.setBounds(421, 68, 24, 15);
		frame.getContentPane().add(team2y);
		
		team2Text = new JTextField();
		team2Text.setBounds(453, 65, 66, 21);
		frame.getContentPane().add(team2Text);
		team2Text.setColumns(10);
		
		//��������Ϣ
		team3 = new JLabel("第三队");
		team3.setBounds(69, 138, 58, 15);
		frame.getContentPane().add(team3);
		
		team3y = new JLabel("");
		team3y.setIcon(new ImageIcon("D:\\zhishi\\project\\resource\\main\\light_red.png"));
		team3y.setBounds(111, 138, 31, 15);
		frame.getContentPane().add(team3y);
				
		team3Text = new JTextField();
		team3Text.setBounds(137, 135, 66, 21);
		frame.getContentPane().add(team3Text);
		team3Text.setColumns(10);
		
		//���Ķ���Ϣ
		team4 = new JLabel("第四队");
		team4.setBounds(377, 138, 58, 15);
		frame.getContentPane().add(team4);
		
		team4y = new JLabel("");
		team4y.setIcon(new ImageIcon("D:\\zhishi\\project\\resource\\main\\light_red.png"));
		team4y.setBounds(421, 138, 31, 15);
		frame.getContentPane().add(team4y);
		
		team4Text = new JTextField();
		team4Text.setBounds(453, 135, 66, 21);
		frame.getContentPane().add(team4Text);
		team4Text.setColumns(10);
		
		//�������Ϣ
		team5 = new JLabel("第五队");
		team5.setBounds(69, 199, 58, 15);
		frame.getContentPane().add(team5);
		
		team5y = new JLabel("");
		team5y.setIcon(new ImageIcon("D:\\zhishi\\project\\resource\\main\\light_red.png"));
		team5y.setBounds(111, 199, 31, 15);
		frame.getContentPane().add(team5y);
		
		team5Text = new JTextField();
		team5Text.setBounds(137, 196, 66, 21);
		frame.getContentPane().add(team5Text);
		team5Text.setColumns(10);
		
		//��������Ϣ
		team6 = new JLabel("第六队");
		team6.setBounds(377, 202, 58, 15);
		frame.getContentPane().add(team6);
		
		team6y = new JLabel("");
		team6y.setIcon(new ImageIcon("D:\\zhishi\\project\\resource\\main\\light_red.png"));
		team6y.setBounds(421, 199, 31, 15);
		frame.getContentPane().add(team6y);
		
		team6Text = new JTextField();
		team6Text.setBounds(453, 196, 66, 21);
		frame.getContentPane().add(team6Text);
		team6Text.setColumns(10);
		
		//��ʼ��ť
		start = new JButton("开始");
		//��ʼ��ť����¼�
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartActionPerformed(e);
			}
		});
		start.setBounds(242, 304, 97, 23);
		frame.getContentPane().add(start);
		
		//ABCDѡ�ť
		 rda = new JRadioButton("A");
		 rda.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		ActionPerformed(e);
		 	}
		 });
		rda.setBounds(342, 344, 47, 23);
		rda.setVisible(false);
		frame.getContentPane().add(rda);
		
		 rdb = new JRadioButton("B");
		 rdb.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		BctionPerformed(e);
		 	}
		 	
		 });
		rdb.setBounds(391, 344, 44, 23);
		rdb.setVisible(false);
		frame.getContentPane().add(rdb);
		
		 rdc = new JRadioButton("C");
		 rdc.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		CctionPerformed(e);
		 	}
		 });
		rdc.setBounds(438, 344, 43, 23);
		rdc.setVisible(false);
		frame.getContentPane().add(rdc);
		
		 rdd = new JRadioButton("D");
		 rdd.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		DctionPerformed(e);
		 	}
		 });
		rdd.setBounds(483, 344, 36, 23);
		rdd.setVisible(false);
		frame.getContentPane().add(rdd);
		
		//��һ�ⰴť
		next = new JButton("提交");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextActionPerformed(e);
				
			}
		});
		next.setBounds(525, 344, 97, 23);
		next.setVisible(false);
		frame.getContentPane().add(next);
		
		th = new JLabel("0");
		th.setBounds(185, 242, 24, 15);
		th.setVisible(false);
		frame.getContentPane().add(th);
		
		tm = new JLabel("题目");
		tm.setBounds(205, 242, 58, 15);
		tm.setVisible(false);
		frame.getContentPane().add(tm);
		
		
		
	}
	//D��ť�¼�
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

	//C��ť�¼�
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
	//B��ť�¼�
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

	//A��ť�¼�
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
	//��һ�ⰴť���
	private int arr=1;
	private final int Maxs=6;
	private JLabel tm;
	protected void nextActionPerformed(ActionEvent e) {
		
		JLabel teamys[] = {team1y,team2y,team3y,team4y,team5y,team6y};
		
		for(int i = 0;i<Maxs;i++) {
			boolean flag=arr==i;
			String img = !flag?"D:\\zhishi\\project\\resource\\main\\light_red.png":"D:\\zhishi\\project\\resource\\main\\light_green.png";
			teamys[i].setIcon(new ImageIcon(img));
		}
		arr++;
		if(arr==Maxs) {
			arr=0;
		}
		
		//点击提交按钮，判断选中哪个选项
		if(rda.isSelected()==true) {
			System.out.println(rda.getText());
			
		}
		if(rdb.isSelected()==true) {
			System.out.println(rdb.getText());
		}
		if(rdc.isSelected()==true) {
			System.out.println(rdc.getText());
		}
		if(rdd.isSelected()==true) {
			System.out.println(rdd.getText());
		}
	}

	//��ʼ��ť���
	protected void StartActionPerformed(ActionEvent e) {
		
		//��ʾѡ�����һ�ⰴť
		rda.setVisible(true);
		rdb.setVisible(true);
		rdc.setVisible(true);
		rdd.setVisible(true);
		next.setVisible(true);
		th.setVisible(true);
		tm.setVisible(true);
		//���ؿ�ʼ��ť
		start.setVisible(false);
		//��һ��ͼƬ�л�
		team1y.setIcon(new ImageIcon("D:\\zhishi\\project\\resource\\main\\light_green.png"));
		
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
