package service;

import java.util.List;

import model.LogFileInfo;

public interface LogFileService {	
	/*
	 * ��������ѯ��־��Ϣ
	 */
	public List<LogFileInfo> searchLogFile(String staffid,String startdt,String enddt);
	
	/*
	 * ɾ����־
	 */
	public void deleteLogFile(LogFileInfo logfile);
	
	/*
	 * ����ɾ����־
	 */
	public void deleteLogFiles(List<LogFileInfo> logfilelist);
}
