package com.frm.cnet;

import com.frm.thread.AbsThread;

/**
 * @author LinHuanZhi
 * @time 2021年12月13日
 * @email lhz034069@163.com
 * @description 
 */
public class ReceiveGuard extends AbsThread {
	private CSocketImp csImpl;

	public ReceiveGuard(CSocketImp csImpl) {
		// TODO Auto-generated constructor stub
		this.csImpl = csImpl;
		this.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (csImpl.isConnected) {
			try {
				csImpl.receiveMessage();
			} catch (Exception e) {
				e.printStackTrace();
//				Client.this.stop();
//				csImpl.disConnBcException();
				csImpl.disconnectFromServer();
			}
		}
	}

}
