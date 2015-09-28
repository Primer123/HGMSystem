package service.impl;

import java.util.ArrayList;
import java.util.List;

import model.LogFileInfo;
import dao.LogFileDao;
import dao.StaffDao;
import entity.LogFile;
import service.LogFileService;

public class LogFileServiceImpl implements LogFileService {
	private LogFileDao logFileDao;
	private StaffDao staffDao;
	
	@Override
	public List<LogFileInfo> searchLogFile(String staffid, String startdt,
			String enddt) {
		List<LogFile> entitylist=new ArrayList<LogFile>();
		List<LogFile> templist=new ArrayList<LogFile>();
		if((startdt!=null)&&(enddt!=null)){
			System.out.println(startdt);
			templist.addAll(logFileDao.findByDatetime(startdt+" 00:00:00", enddt+" 23:59:59"));
			if(staffid!=null){
				for(int i=0;i<templist.size();i++){
					if(templist.get(i).getStaffid().equals(staffid))
						entitylist.add(templist.get(i));
				}
			}
			else
				entitylist.addAll(templist);
		}
		else if((startdt==null)&&(enddt!=null)){
			templist.addAll(logFileDao.findByDatetime("2015-01-01 00:00:00", enddt+" 23:59:59"));
			if(staffid!=null){
				for(int i=0;i<templist.size();i++){
					if(templist.get(i).getStaffid().equals(staffid))
						entitylist.add(templist.get(i));
				}
			}
			else
				entitylist.addAll(templist);			
		}
        else if((startdt!=null)&&(enddt==null)){
			templist.addAll(logFileDao.findByDatetime(startdt+" 00:00:00", "2100-12-31 23:59:59"));
			if(staffid!=null){
				for(int i=0;i<templist.size();i++){
					if(templist.get(i).getStaffid().equals(staffid))
						entitylist.add(templist.get(i));
				}
			}
			else
				entitylist.addAll(templist);			
		}
		else{
			if(staffid!=null){
				entitylist.addAll(logFileDao.findByStaff(staffid));
			}
			else{
				entitylist.addAll(logFileDao.findAll());
			}
		}
		List<LogFileInfo> infolist=new ArrayList<LogFileInfo>();
		for(int j=0;j<entitylist.size();j++){
			infolist.add(convertEntity(entitylist.get(j)));
		}
		return infolist;
	}
	
	@Override
	public void deleteLogFile(LogFileInfo logfile) {
		LogFile log=convertInfo(logfile);
		logFileDao.delete(log);
	}
	
	@Override
	public void deleteLogFiles(List<LogFileInfo> logfilelist) {
		List<LogFile> loglist=new ArrayList<LogFile>();
		for(int i=0;i<logfilelist.size();i++){
			loglist.add(convertInfo(logfilelist.get(i)));
		}
		logFileDao.delete(loglist);
	}
	
	private LogFileInfo convertEntity(LogFile entity){
		LogFileInfo info=new LogFileInfo();
		info.setId(entity.getId());
		info.setStaffid(entity.getStaffid());
		String name=staffDao.findByStaffId(entity.getStaffid()).getStaffname();
		info.setStaffname(name);
		info.setOperation(entity.getOperation());
		info.setDatetime(entity.getDatetime().substring(0, 19));
		info.setRemarks(entity.getRemarks());
		return info;
	}
	
	private LogFile convertInfo(LogFileInfo info){
		LogFile entity=new LogFile();
		entity.setId(info.getId());
		entity.setStaffid(info.getStaffid());
		entity.setOperation(info.getOperation());
		entity.setDatetime(info.getDatetime());
		entity.setRemarks(info.getRemarks());
		return entity;
	}
	
	public LogFileDao getLogFileDao() {
		return logFileDao;
	}
	public void setLogFileDao(LogFileDao logFileDao) {
		this.logFileDao = logFileDao;
	}
	public StaffDao getStaffDao() {
		return staffDao;
	}
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

	
	
}
