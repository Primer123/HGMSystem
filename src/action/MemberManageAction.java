package action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import model.MemberInfo;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Component;

import service.MemberService;
import entity.Member;

@ParentPackage(value="json-default")
@Results({@Result(name="success", location="/jsp/MemberManage.jsp"), 
	 @Result(name="input", location="/jsp/MemberManage.jsp")})
@Component
public class MemberManageAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MemberInfo member;

	@Resource
	private MemberService memberService;
	

	public MemberInfo getMember() {
		return member;
	}

	public void setMember(MemberInfo member) {
		this.member = member;
	}


    //@Action(value= "/membersearch")
    
    
	@Action(value = "/add")
	public String createMember() throws Exception {
		super.execute();
	   //setMember(request.getParameter("memberInfo"));
		
		/*member.setMemberid(request.getParameter("member.name"));
		member.setGender(Integer.parseInt(request.getParameter("member.gender")));
		member.setPassword(request.getParameter("member.password"));
		member.setAddress(request.getParameter("member.address"));
		member.setEmail(request.getParameter("member.email"));
		member.setRemarks(request.getParameter("member.remarks"));
		*/
		
		
		
		
		
		String memberId = memberService.addNewMember(member);
			

		List<MemberInfo> memberInfos = memberService.searchByName("member");
			
		if (memberInfos == null) {
			memberInfos = new ArrayList<MemberInfo>();
		}
		
		for (int i = 0; i < 4; i++) {
			MemberInfo memberInfo = new MemberInfo();
			memberInfo.setId(i);
			memberInfo.setGender(1);
			memberInfo.setName("name" + i);
			memberInfo.setRemarks("remarks" + i);
			memberInfos.add(memberInfo);
		}
		
		request.setAttribute("memberInfos", memberInfos);
		
		if (memberId == null) {
			request.setAttribute("msg", 0);
			return "input";
		}

		return "success";
	}
	
	@Action(value = "/delete")
	public String deleteMember() throws Exception {
		super.execute();
		String memberId = request.getParameter("id");
		System.out.println("===id: " + memberId);
		
		memberService.deleteMember(member);

		List<MemberInfo> memberInfos = null;
		
		memberService.searchByName("member");
		if (memberInfos == null) {
			memberInfos = new ArrayList<MemberInfo>();
		}
		
		for (int i = 0; i < 3; i++) {
			MemberInfo memberInfo = new MemberInfo();
			memberInfo.setId(i);
			memberInfo.setGender(1);
			memberInfo.setName("name" + i);
			memberInfo.setRemarks("remarks" + i);
			memberInfos.add(memberInfo);
		}
		
		request.setAttribute("memberInfos", memberInfos);
		
		return "success";
	}
	
	@Action(value = "/update")
	public String getMemberInfo() throws Exception {
		super.execute();
		String memberId = request.getParameter("id");
		MemberInfo memberInfo = memberService.searchByMemberid(memberId);
				//memberService.searchByMemberid(memberId);
		memberInfo.setId(0);
		memberInfo.setGender(1);
		memberInfo.setName("name");
		memberInfo.setRemarks("remarks");
	
		request.setAttribute("singleMember", memberInfo);
		
		return "input";
	}
}
