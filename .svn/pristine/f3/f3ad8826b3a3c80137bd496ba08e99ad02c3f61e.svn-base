package service;

import java.util.List;

import model.MemberInfo;

public interface MemberService {
	/*
	 * 通过会员编号查找会员
	 */
	public MemberInfo searchByMemberid(String memberid);

	/*
	 * 通过会员姓名查找会员
	 */
	public List<MemberInfo> searchByName(String name);
	
	/*
	 * 获得所有会员
	 */
	public List<MemberInfo> getAllMember();

	/*
	 * 增加积分（通常在办理退房登记时调用）
	 */
	public void addCredits(String memberid, double totalConsumption);

	/*
	 * 新增会员
	 */
	public String addNewMember(MemberInfo memberinfo);

	/*
	 * 修改会员信息
	 */
	public void modifyMemberInfo(MemberInfo memberinfo);

	/*
	 * 删除会员
	 */
	public void deleteMember(MemberInfo memberinfo);

}
