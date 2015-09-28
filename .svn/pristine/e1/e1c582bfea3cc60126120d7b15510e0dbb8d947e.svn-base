package service;

import java.io.OutputStream;
import java.util.List;

import model.ConsumptionInfo;

public interface ConsumptionService {
	/*
	 * 查询某客房的消费记录
	 */
	public List<ConsumptionInfo> searchConsumptionByCRNum(String checkinnum,String roomnum);
	
	/*
	 * 打印消费账单
	 */
	public void printConsumptionBill(OutputStream os, List<ConsumptionInfo> consumptionInfos);
	
	/*
	 * 计算消费总额
	 */
	public double calcuTotalConsumption(double discount,
			List<ConsumptionInfo> consumptions);
	
	/*
	 * 添加新的消费记录
	 */
	public void addNewConsumptionItem(List<ConsumptionInfo> consumptions,String staffid);
	
	/*
	 * 修改消费记录
	 */
	public void modifyConsumptionInfo(List<ConsumptionInfo> consumptions,String staffid);

	/*
	 * 删除消费记录
	 */
	public void deleteConsumption(ConsumptionInfo consumption,String staffid);
}
