package dao;

import java.util.List;

import entity.LogFile;

public interface LogFileDao {
    public void create(LogFile logfile);
	
	public void delete(LogFile logfile);	
	
	public void delete(List<LogFile> logfilelist);
	
	public List<LogFile> findAll();
	
	public LogFile findById(int id);
	
	public List<LogFile> findByStaff(String staffid);	

	public List<LogFile> findByDatetime(String datestart, String dateend);
}
