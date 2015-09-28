package service;

import java.util.List;

import model.LogFileInfo;

public interface LogFileService {	
	/*
	 * 多条件查询日志信息
	 */
	public List<LogFileInfo> searchLogFile(String staffid,String startdt,String enddt);
	
	/*
	 * 删除日志
	 */
	public void deleteLogFile(LogFileInfo logfile);
	
	/*
	 * 批量删除日志
	 */
	public void deleteLogFiles(List<LogFileInfo> logfilelist);
}
