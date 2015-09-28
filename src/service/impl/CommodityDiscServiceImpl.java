package service.impl;

import java.text.DecimalFormat;
import java.util.List;

import service.CommodityDiscService;
import dao.CommodityDiscDao;
import dao.MemberDao;
import entity.CommodityDisc;
import entity.Member;

public class CommodityDiscServiceImpl implements CommodityDiscService {
	private CommodityDiscDao commodityDiscDao;
	private MemberDao memberDao;

	@Override
	public List<CommodityDisc> getAllCommodityDisc() {
		List<CommodityDisc> commodityDiscs = commodityDiscDao.findAll();
		return commodityDiscs;
	}

	@Override
	public double getCommodityDisc(String memberid) {
		// TODO Auto-generated method stub
		Member member = memberDao.findBymemberid(memberid);
		
		String status = "";
		if(member == null) {
			status = "非会员";
		} else {
			int rank = member.getRank();
			if (rank == 0) {
				status = "普通会员";
			} else {
				status = "VIP会员";
			}
		}
		
		CommodityDisc commodityDisc = commodityDiscDao.findByStatus(status);
		double discount = commodityDisc.getDiscount();
		DecimalFormat df = new DecimalFormat("#.##");
		discount = Double.parseDouble(df.format(discount));
		
		return discount;
	}

	@Override
	public void modifyCommodityDisc(List<CommodityDisc> commodityDiscs) {
		int size = commodityDiscs.size();
		for (int i = 0; i < size; i++) {
			CommodityDisc commodityDisc = commodityDiscs.get(i);
			commodityDiscDao.modify(commodityDisc);
		}
	}

	@Override
	public void deleteCommodityDisc(CommodityDisc commodityDisc) {
		commodityDiscDao.delete(commodityDisc);
	}

	@Override
	public void addCommodityDisc(List<CommodityDisc> commodityDiscs) {
		int size = commodityDiscs.size();
		for (int i = 0; i < size; i++) {
			CommodityDisc commodityDisc = commodityDiscs.get(i);
			commodityDiscDao.create(commodityDisc);
		}
	}

	public CommodityDiscDao getCommodityDiscDao() {
		return commodityDiscDao;
	}

	public void setCommodityDiscDao(CommodityDiscDao commodityDiscDao) {
		this.commodityDiscDao = commodityDiscDao;
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
