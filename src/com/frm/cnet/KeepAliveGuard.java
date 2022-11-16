package com.frm.cnet;

import java.io.IOException;

import com.frm.proto.PID;
import com.frm.thread.AbsThread;
import com.frm.thread.AutoThread;
import com.frm.utils.TimeUtils;

import sysfkc.a_proto.apdto.PDTO_TICKER;

/**
 * @author LinHuanZhi
 * @time 2021年12月13日
 * @email lhz034069@163.com
 * @description 
 */
public class KeepAliveGuard extends AbsThread{
//	long checkDelay = 10;
	long keepAliveDelay = 2000;
	private CSocketImp csImpl;
	
	public KeepAliveGuard(CSocketImp csImpl) {
		// TODO Auto-generated constructor stub
		this.csImpl = csImpl;
		this.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (csImpl.isConnected) {
			if (TimeUtils.MillisDiff(csImpl.lastSendTime) > keepAliveDelay) {
//				csImpl.sendMessage(new PDTO_TICKER()); //TODO
				PDTO_TICKER dto = new PDTO_TICKER();
				dto.setPId(PID.PID_TICKER);
				dto.info = "client's official ticker...";
				csImpl.sendMessage(dto);
				csImpl.lastSendTime = TimeUtils.curMillis();
			} else {
				try {
					Thread.sleep(CSocketImp.SLEEP_GAP);
				} catch (InterruptedException e) {
					e.printStackTrace();
//					csImpl.disConnBcException();
					csImpl.disconnectFromServer();
				}
			}
		}
	}
	
	
}
