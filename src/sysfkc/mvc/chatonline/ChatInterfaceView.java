package sysfkc.mvc.chatonline;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.StyledDocument;

import com.frm.mvc.BaseView;
import com.frm.mvc.MVC;
import com.frm.proto.PDTO;
import com.frm.proto.PID;
import com.frm.utils.StringUtils;

import sysfkc.a_proto.apdto.PDTO_CHAT_INFO;
import sysfkc.mvc.login.LoginCtrl;
import sysfkc.mvc.login.LoginModel;

public class ChatInterfaceView extends BaseView implements MouseListener, Runnable{
	   private StyledDocument docMsg = null;
	public JFrame frame;
	private JTextField tf;
	private JTextArea jta;
    private JScrollPane sp = null;
    /*表情框*/
    private EmojiPopWin picWindow;
    private List<PicInfo> myPicInfo = new LinkedList<>();
    private List<PicInfo> receivePicInfo = new LinkedList<>();
    private JButton b_pic;
//    private JTextPane jp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatInterfaceView window = new ChatInterfaceView();
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
	public ChatInterfaceView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		String uName = MVC.getModel(LoginCtrl.class, LoginModel.class).getUserName();
		frame.setTitle("欢迎您，" + uName);
		frame.setBounds(100, 100, 457, 323);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		frame.add(sp);
		tf = new JTextField();
		tf.setBounds(24, 224, 299, 21);
		tf.setColumns(10);
		
		JButton btnNewButton = new JButton("发送");
		btnNewButton.setBackground(Color.CYAN);
		
		btnNewButton.setBounds(329, 223, 97, 23);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(tf);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		jta = textArea;
		jta.setEditable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = MVC.getModel(LoginCtrl.class, LoginModel.class).getUserName();
				String strTf=tf.getText();
//				System.out.println("ss"+strTf);
//				jta.append(strTf+"\n");
//				tf.setText("");
				if(strTf.equals("")) {
//					System.out.println("666");
//					JOptionPane.showInternalInputDialog(frame.getContentPane(),"666","6", 1);
					JOptionPane.showMessageDialog(null, "请输入，不要为空", "请输入", JOptionPane.ERROR_MESSAGE);
					
				}
				if(strTf.length()>0) {
					System.out.println("333");
					btnNewButton.setEnabled(true);
					PDTO_CHAT_INFO pdto = new PDTO_CHAT_INFO();
					pdto.msg = strTf;
					pdto.name = name;
					tf.setText("");
					sendPack(PID.CHAT_INFO, pdto);
//					textArea.append(strTf+"\n");
				}
				
			}
		});
		textArea.setBounds(0, 0, 436, 187);
//		frame.getContentPane().add(textArea);
//		sp.add(textArea);
		sp = new JScrollPane(textArea);
		sp.setBounds(0, 27, 436, 187);
//		sp.add(textArea);
		frame.getContentPane().add(sp);
		
		JLabel lblNewLabel = new JLabel("\u5728\u7EBF\u591A\u4EBA\u804A\u5929\u5BA4");
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setFont(new Font("����", Font.BOLD, 12));
		lblNewLabel.setBounds(178, 10, 87, 15);
		frame.getContentPane().add(lblNewLabel);
		//表情按钮
		b_pic = new JButton("表情");
		b_pic.setBounds(23, 392, 97, 23);
		b_pic.setFocusable(false);
        b_pic.addMouseListener(this);
		frame.getContentPane().add(b_pic);
		
		JButton btnNewButton_1 = new JButton("清空");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setBounds(329, 253, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
//		jp = new JTextPane();
//		jp.setBounds(197, 274, 96, 21);
//		frame.getContentPane().add(jp);
//		docMsg = jp.getStyledDocument();
        picWindow = new EmojiPopWin(this);
        frame.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
            	ChatInterfaceView.this.picWindow.dispose();
            }

            @Override
            public void componentMoved(ComponentEvent e) {
            	ChatInterfaceView.this.picWindow.dispose();
            }

            @Override
            public void componentHidden(ComponentEvent e) {
            	ChatInterfaceView.this.picWindow.dispose();
            }

        });
        tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String strsend=tf.getText();
				if(strsend.trim().length()==0) {
					return;
				}
				tf.setText("");
				textArea.append(strsend+"\n");
				
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
	
	public void updateView(PDTO pdto) {
		PDTO_CHAT_INFO info = (PDTO_CHAT_INFO) pdto;
		jta.append(StringUtils.replaceToken("@：@", info.name, info.msg) + "\n");
	}

	@Override
	protected void setVisible(boolean arg0) {
		// TODO Auto-generated method stub
		frame.setVisible(arg0);
	}	
	//6666666
	public void mousePressed(MouseEvent e) {
	        picWindow.setVisible(false);
	    }
	 

	    public void mouseReleased(MouseEvent e) {


	        JComponent source = (JComponent) e.getSource();
	        /*鼠标释放时在事件源内,才响应单击事件*/
	        if (e.getX() >= 0 && e.getX() <= source.getWidth() && e.getY() >= 0
	                && e.getY() <= source.getHeight()) {
	        	if (source == this.b_pic) {
	                picWindow.setVisible(true);
	            } 

	        }
	    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void insertSendPic(ChatPic cupic) {
		// TODO Auto-generated method stub
		
	}
//	 public void insertSendPic(ImageIcon imgIc) {
//	        //jpMsg.setCaretPosition(docChat.getLength()); // 设置插入位置
//	        jp.insertIcon(imgIc); // 插入图片
//	        System.out.println(jp.getText());
//	        System.out.print(imgIc.toString());
//	        //insert(new FontAttrib()); // 这样做可以换行
//	    }
	public JButton getPicBtn() {
		// TODO Auto-generated method stub
		return b_pic;
	}
	public void receivedPicInfo(String picInfos) {
        String[] infos = picInfos.split("[+]");
        for (int i = 0; i < infos.length; i++) {
            String[] tem = infos[i].split("[&]");
            if (tem.length == 2) {
                PicInfo pic = new PicInfo(Integer.parseInt(tem[0]), tem[1]);
                receivePicInfo.add(pic);
            }
        }
    }
}

