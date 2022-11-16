package sysfkc.mvc.clientMain;





import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.frm.mvc.BaseView;
import com.frm.proto.PDTO;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
@Deprecated
public class ClientMainView extends BaseView implements ActionListener{

	private JFrame frame; 
	//GUI�������
	private JPanel testPanel = null;

	private JButton testButton = null;

	private JFrame testFrame = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientMainView window = new ClientMainView();
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
	public ClientMainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//ͷ������
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setFont(new Font("Dialog", Font.PLAIN, 15));
		frame.setTitle("2021\u79D1\u5B66\u77E5\u8BC6\u7ADE\u8D5B");
		frame.setBounds(100, 100, 703, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//����
		JLabel lblNewLabel = new JLabel("2021\u79D1\u5B66\u77E5\u8BC6\u7ADE\u8D5B");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 16));
		lblNewLabel.setBounds(275, 10, 142, 48);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7B2C\u4E00\u961F");
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 15));
		lblNewLabel_1.setBounds(156, 77, 62, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u7B2C\u4E8C\u961F");
		lblNewLabel_1_1.setFont(new Font("����", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(478, 77, 62, 38);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u7B2C\u4E09\u961F");
		lblNewLabel_1_2.setFont(new Font("����", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(156, 169, 62, 38);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("\u7B2C\u56DB\u961F");
		lblNewLabel_1_3.setFont(new Font("����", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(478, 169, 62, 38);
		frame.getContentPane().add(lblNewLabel_1_3);
		
			JButton btnNewButton = new JButton("\u5F00\u59CB\u7B54\u9898");
			btnNewButton.setBackground(Color.RED);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					startatActionPerformed(e);
					int result = JOptionPane.showConfirmDialog(null, "�Ƿ�ʼ����");
					if(result == 0) {
						JOptionPane.showMessageDialog(null,"������ʽ��ʼ");
					}
					
				}
			});
			btnNewButton.setFont(new Font("����", Font.BOLD, 16));
			btnNewButton.setBounds(275, 327, 148, 38);
			frame.getContentPane().add(btnNewButton);
			
			JLabel lblNewLabel_2 = new JLabel("\u7ADE\u8D5B\u89C4\u5219:\r\n\r\n");
			lblNewLabel_2.setFont(new Font("����", Font.BOLD, 14));
			lblNewLabel_2.setBounds(10, 215, 88, 38);
			frame.getContentPane().add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("(\u5FC5\u7B54\u9898)\u73AF\u8282:\u5404\u53C2\u6570\u961F\u5458\u6309\u7EC4\u8F6E\u6D41\u56DE\u7B54\u95EE\u9898\uFF0C\u9650\u65F660\u79D2\uFF0C\u5355\u72EC\u5B8C\u6210\uFF0C\u56DE\u7B54\u6B63\u786E\u8BE5\u961F\u52A010\u5206\uFF0C\u56DE\u7B54\u9519\u8BEF\u6216\u5F03\u7B54\u4E0D\u52A0\u5206\u4E5F\u4E0D\u6263\u5206\u3002");
			lblNewLabel_3.setFont(new Font("����", Font.BOLD, 12));
			lblNewLabel_3.setBounds(10, 253, 669, 64);
			frame.getContentPane().add(lblNewLabel_3);
			
			JButton btnNewButton_1 = new JButton("\u5F00\u59CB\u5339\u914D");
			btnNewButton_1.setBackground(Color.GREEN);
			btnNewButton_1.setFont(new Font("����", Font.BOLD, 14));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					TestThread testThread = new TestThread();//������һ�����������߳�
					JButton btn = (JButton) e.getSource();
					btn.setText("����ƥ��...");
				}
			});
			btnNewButton_1.setBounds(282, 125, 120, 38);
			frame.getContentPane().add(btnNewButton_1);
			
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBackground(Color.CYAN);
			frame.setJMenuBar(menuBar);
			
			JMenu mnNewMenu = new JMenu("\u5173\u4E8E\u6211\u4EEC");
			mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
			menuBar.add(mnNewMenu);
			
			JMenuItem mntmNewMenuItem = new JMenuItem("\u5C0F\u7EC4\u6210\u5458");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFrame frame=new JFrame("С���Ա");
					frame.getContentPane().setLayout(null);
					frame.setBounds(20,20,300,300);
					JLabel lblNewLabel_4 = new JLabel("��Ա���ֻ�ֵ���ܾ�꣬�²�����������");
					lblNewLabel_4.setFont(new Font("����", Font.BOLD, 14));
					lblNewLabel_4.setBounds(0, 30, 300, 150);
					frame.getContentPane().add(lblNewLabel_4);
					frame.setVisible(true);
				}
			});
			mnNewMenu.add(mntmNewMenuItem);
			
			
	}
	
	protected void startatActionPerformed(ActionEvent e) {
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
	protected void setVisible(boolean arg0) {
		// TODO Auto-generated method stub
		frame.setVisible(arg0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateView(PDTO pdto) {
		// TODO Auto-generated method stub
		
	}
}
