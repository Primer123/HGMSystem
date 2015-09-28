package service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.MemberInfo;
import dao.CheckinRecordDao;
import dao.MemberDao;
import dao.ReservationRecordDao;
import entity.CheckinRecord;
import entity.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao;
	private CheckinRecordDao checkinRecordDao;
	private ReservationRecordDao reservationRecordDao;

	@Override
	public MemberInfo searchByMemberid(String memberid) {
		Member member = memberDao.findBymemberid(memberid);

		if (member != null) {
			MemberInfo memberInfo = transferEntityToModel(member);
			return memberInfo;
		}

		return null;
	}

	@Override
	public List<MemberInfo> searchByName(String name) {
		List<Member> memberlist = memberDao.findByName(name);
		if (memberlist != null) {
			List<MemberInfo> memberInfos = new ArrayList<MemberInfo>();

			int size = memberlist.size();
			for (int i = 0; i < size; i++) {
				memberInfos.add(transferEntityToModel(memberlist.get(i)));
			}

			return memberInfos;
		}

		return null;
	}
	
	@Override
	public List<MemberInfo> getAllMember() {
		// TODO Auto-generated method stub
		List<Member> members = memberDao.findAll();
		if(members == null) {
			return new ArrayList<MemberInfo>();
		}
		
		List<MemberInfo> memberInfos = new ArrayList<MemberInfo>();
		int size = members.size();
		for(int i = 0; i < size; i++) {
			Member member = members.get(i);
			MemberInfo memberInfo = transferEntityToModel(member);
			memberInfos.add(memberInfo);
		}
		
		return memberInfos;
	}

	@Override
	public void addCredits(String memberid, double totalConsumption) {
		Member member = memberDao.findBymemberid(memberid);

		int totalCredits = member.getCredits();
		int credits = (int) (Math.floor(totalConsumption));
		totalCredits = totalCredits + credits;
		
		member.setCredits(totalCredits);
		if(totalCredits >= 5000) {
			member.setRank(1);
		} else {
			member.setRank(0);
		}
		
		memberDao.modify(member);
	}

	@Override
	public String addNewMember(MemberInfo memberinfo) {
		String memberid = newMemberid();
		memberinfo.setMemberid(memberid);
		memberinfo.setRank(0);
		memberinfo.setCredits(0);
		
		Member member = transferModelToEntity(memberinfo);
		memberDao.create(member);
		
		return memberid;
	}

	@Override
	public void modifyMemberInfo(MemberInfo memberinfo) {
		Member member = transferModelToEntity(memberinfo);
			
		memberDao.modify(member);
	}

	@Override
	public void deleteMember(MemberInfo memberinfo) {
		Member member = transferModelToEntity(memberinfo);
		
		memberDao.delete(member);
	}

	private MemberInfo transferEntityToModel(Member entity) {
		MemberInfo info = new MemberInfo();
		info.setAddress(entity.getAddress());
		info.setCredits(entity.getCredits());
		info.setEmail(entity.getEmail());
		info.setGender(entity.getGender());
		info.setId(entity.getId());

		List<CheckinRecord> checkinRecords = checkinRecordDao
				.findByMemberId(entity.getMemberid());
		if (checkinRecords != null) {
			info.setLatestCheckin(checkinRecords.get(0).getArrivingdt());
		} else {
			info.setLatestCheckin("0000-00-00 00:00:00");
		}

		info.setMemberid(entity.getMemberid());
		info.setName(entity.getName());
		info.setRank(entity.getRank());
		info.setRemarks(entity.getRemarks());
		info.setTelnum(entity.getTelnum());

		return info;
	}

	private Member transferModelToEntity(MemberInfo info) {
		Member entity = new Member();
		int id = entity.getId();
		if(id != 0) {
			entity.setId(id);
		}
		entity.setMemberid(info.getMemberid());
		entity.setName(info.getName());
		entity.setGender(info.getGender());
		entity.setPassword(info.getPassword());
		entity.setTelnum(info.getTelnum());
		entity.setAddress(info.getAddress());
		entity.setEmail(info.getEmail());
		entity.setCredits(info.getCredits());
		entity.setRank(info.getRank());
		entity.setRemarks(info.getRemarks());
		return entity;
	}

	private String newMemberid() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
		String date = dateFormat.format(now);
		int num = 0;
		List<Member> allmember = memberDao.findAll();
		for (int i = 0; i < allmember.size(); i++) {
			Member member = allmember.get(i);
			if (member.getMemberid().substring(0, 6).equals(date)) {
				num++;
			}
		}
		num++;
		String memberid;
		if (num < 10) {
			memberid = date + "000" + num;
		} else if (100 > num && num >= 10) {
			memberid = date + "00" + num;
		} else if (1000 > num && num >= 100) {
			memberid = date + "0" + num;
		} else {
			memberid = date + num;
		}
		return memberid;
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public CheckinRecordDao getCheckinRecordDao() {
		return checkinRecordDao;
	}

	public void setCheckinRecordDao(CheckinRecordDao checkinRecordDao) {
		this.checkinRecordDao = checkinRecordDao;
	}

	public ReservationRecordDao getReservationRecordDao() {
		return reservationRecordDao;
	}

	public void setReservationRecordDao(
			ReservationRecordDao reservationRecordDao) {
		this.reservationRecordDao = reservationRecordDao;
	}
}
