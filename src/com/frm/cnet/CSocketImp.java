package com.frm.cnet;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.frm.proto.PDTO;
import com.frm.proto.PID;
import com.frm.proto.PdtoDispatch;
import com.frm.utils.PrintUtils;

import sysfkc.a_proto.apdto.PDTO_TICKER;

/**
 * @author LinHuanZhi
 * @time 2021年12月11日
 * @email lhz034069@163.com
 * @description 具体的实现 
 */
public class CSocketImp {
	public static final int SLEEP_GAP = 20; 
	
	private CSocketMgr cs;
	private Socket socket = null;
	
	
	public long lastSendTime;
	public boolean isConnected = false;
	public CSocketImp(CSocketMgr cs) {
		this.cs = cs;
	}
	
	
	/**
	 * @return
	 * @description 连接服务器 
	 */
	public boolean connectToServer() {
		if(isConnected) return isConnected;
		try {
			socket = new Socket(cs.getServerIP(), cs.getServerPort());
			socket.setSoTimeout(3000); //如果服务器没有反应，则尝试3000毫秒
			//-----------------shield------------------------
//			os = socket.getOutputStream();
//			is = socket.getInputStream();
//			oos = new ObjectOutputStream(os);
//			ois = new ObjectInputStream(is);
			//-----------------shield------------------------
			isConnected = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			isConnected = false;
			PrintUtils.pr("failed to connect to server：" + cs.getServerIP() + "/" + cs.getServerPort());	
		}finally {
		}
		return isConnected;
	}
	
	public void disconnectFromServer() {
		if (isConnected) {
			isConnected = false;			
		}
		if(socket != null) {
			try {
				socket.shutdownInput();
				socket.shutdownOutput();
				socket.close();
				socket = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.err.println("与服务器连接断开...");
	}
	
	
	public synchronized boolean sendMessage(PDTO msg) {
		try {
			if(socket != null) {
				OutputStream os = socket.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject(msg);
				oos.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//			this.disConnBcException();
			this.disconnectFromServer();
			return false;
		}
		lastSendTime = System.currentTimeMillis();
		return true;
	}

	
	public synchronized PDTO receiveMessage() {
		PDTO receiveMsg = null;
		try {
			if(socket != null) {				
				InputStream is = socket.getInputStream();
				if (is.available() > 0) {
					ObjectInputStream ois = new ObjectInputStream(is);
					receiveMsg = (PDTO) ois.readObject();
					if(receiveMsg.getPId() == PID.PID_TICKER) {
						String info = ((PDTO_TICKER)receiveMsg).info; //TODO
//						System.out.println(info);
					}
				} else {
					Thread.sleep(SLEEP_GAP);
				}
			}
		} catch (ClassNotFoundException | IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		finally { //finally执行会导致发送问题！？		这里在场：流、（synchronized、sleep、tryCatch）	
//			System.out.println("------------------222");
//		}
		if(receiveMsg != null) {
			PdtoDispatch.p.dispatch(receiveMsg);
		}
		return receiveMsg;
	}

	
//	/**
//	 * 
//	 * @description 异常停止 
//	 */
//	public void disConnBcException() {
//		if (isConnected) {
//			isConnected = false;			
//		}
//	}

}
