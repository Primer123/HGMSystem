package service;

import java.util.List;

import entity.Wakeup;

public interface WakeupService {
	/*
	 * 获得未执行的叫早服务
	 */
	public List<Wakeup> getNonactivatedWakeup();
	
	/*
	 * 添加叫早服务
	 */
	public boolean addWakeupService(String roomnum, String datetime);
	
	/*
	 * 设置叫早时间
	 */
	public void setWakeupDatetime(Wakeup wakeup);

}
