package com.frm.cnet;


import com.frm.proto.PDTO;
import com.frm.proto.PID;

/**
 * @author LinHuanZhi
 * @time 2021年12月11日
 * @email lhz034069@163.com
 * @description 负责启动、管理、线程
 */
public class CSocketMgr {
	public static CSocketMgr cs = new CSocketMgr();
	private CSocketImp csImpl;
	//--------------cfg-----------------
	private String serverIP = INetCfg.serverIp;
	private int serverPort = INetCfg.serverPort;
	//--------------cfg-----------------
	

	private CSocketMgr() {
		csImpl = new CSocketImp(this);
		this.shutDownRegister();
	}
	
	
	public void connectToServer() {
		boolean isConn = csImpl.connectToServer();
		if(isConn) {
			new KeepAliveGuard(csImpl);
			new ReceiveGuard(csImpl);
		}
	}
	
	
	public void send(PID pId, PDTO msgSnt) {
//		PDTO rtnPpt = null;
//		rtnPpt = csImpl.serialsOfClientDummy(msgSnt);
		msgSnt.setPId(pId);
		boolean sendSucc = csImpl.sendMessage(msgSnt);
//		System.out.println(rtnPpt);
	}
	
	
	private void shutDownRegister() {
		Thread t = new Thread(() -> {
        	closeSocket();
        });
        Runtime.getRuntime().addShutdownHook(t);
	}
	
	
	private void closeSocket() {
//		System.out.println("关闭处理中....");
		csImpl.disconnectFromServer();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("关闭处理完成....");
	}
	

	public String getServerIP() {
		return serverIP;
	}

	
	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}

	
	public int getServerPort() {
		return serverPort;
	}

	
	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}
	
	
	

}
