package sysfkc.mvc.zClient;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.frm.cnet.CSocketMgr;
import com.frm.mvc.BaseView;
import com.frm.proto.PDTO;
import com.frm.utils.BrAdapterUtils;
@Deprecated
public class ClientView extends BaseView{

	private JFrame frmClient;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientView window = new ClientView();
					window.frmClient.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClient = new JFrame();
		frmClient.setTitle("client");
		frmClient.setBounds(100, 100, 450, 300);
		frmClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClient.getContentPane().setLayout(null);
		
//		String strTest = "1111111111111111111啊啊啊啊啊啊啊啊啊啊啊啊啊111111111啊啊啊啊啊啊啊啊啊啊啊啊啊啊11111111111111111111啊啊啊啊啊啊啊啊啊啊啊1111111111111111111111111111111111111222222222"; 
		String strTest = "啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊"; 
		JLabel lblNewLabel = new JLabel("123");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(30, 23, 377, 156);
		frmClient.getContentPane().add(lblNewLabel);
		BrAdapterUtils.formatBr(lblNewLabel, strTest);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(30, 202, 270, 21);
		frmClient.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("发送");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CSocketMgr.cs.connectToServer();
			}
		});
		btnNewButton.setBounds(310, 201, 97, 23);
		frmClient.getContentPane().add(btnNewButton);
	}

	@Override
	protected void mClear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void mClose() {
		// TODO Auto-generated method stub
		frmClient.dispose();
	}

	@Override
	protected void setVisible(boolean arg0) {
		// TODO Auto-generated method stub
		frmClient.setVisible(arg0);
	}

	@Override
	public void updateView(PDTO pdto) {
		// TODO Auto-generated method stub
		
	}
}
