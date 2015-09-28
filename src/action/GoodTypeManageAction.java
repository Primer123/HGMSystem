package action;

import javax.annotation.Resource;

import model.GoodTypeInfo;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Component;

import service.GoodTypeService;

@ParentPackage(value="json-default")
@Results({@Result(name="success", location="/jsp/GoodTypeManage.jsp"),
	@Result(name="fail", location="/jsp/GoodTypeManage.jsp")})
@Component
public class GoodTypeManageAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GoodTypeInfo goodtype;
	
	@Resource
	private GoodTypeService goodTypeService;

	public GoodTypeInfo getGoodtype() {
		return goodtype;
	}

	public void setGoodtype(GoodTypeInfo goodtype) {
		this.goodtype = goodtype;
	}

	public GoodTypeService getGoodTypeService() {
		return goodTypeService;
	}

	public void setGoodTypeService(GoodTypeService goodTypeService) {
		this.goodTypeService = goodTypeService;
	}	
	
	@Action(value = "/goodtypesearch")//18
	public String searchGoodType() throws Exception{
		super.execute();
		String keyword=request.getParameter("keyword");
		String type="";
		int judge=goodTypeService.judgeKeyword(keyword);		
		if(judge==0){
			if(keyword.length()==1){
				type="0"+keyword;
			}
			else{
			    type=keyword;
			}
			GoodTypeInfo typeinfo=goodTypeService.searchByTypecode(type);
			request.setAttribute("goodtyperesult", typeinfo);
			if(typeinfo!=null){
				return "success";
			}
		}
		else{
			GoodTypeInfo typeinfo=goodTypeService.searchByTypename(keyword);
			request.setAttribute("goodtyperesult", typeinfo);
			if(typeinfo!=null){
				return "success";
			}
		}
		
		return "fail";
	}
	
	@Action(value = "/add")//65
    public String createGoodType() throws Exception{
		super.execute();
		GoodTypeInfo typeinfo=new GoodTypeInfo();
		typeinfo.setTypename(request.getParameter("typename"));
		typeinfo.setRemarks(request.getParameter("remarks"));
		if(goodTypeService.addNewGoodType(typeinfo)){
			return "success";
		}
		else{
			return "fail";
		}
	}
	
	@Action(value = "/update")
    public String modifyGoodType() throws Exception{
		super.execute();
		GoodTypeInfo typeinfo=new GoodTypeInfo();
		typeinfo.setId(Integer.parseInt(request.getParameter("id")));
		typeinfo.setTypecode(request.getParameter("typecode"));
		typeinfo.setTypename(request.getParameter("typename"));
		typeinfo.setRemarks(request.getParameter("remarks"));
		goodTypeService.modifyGoodTypeInfo(typeinfo);
		return "success";
	}
	
	@Action(value = "/delete")
    public String deleteGoodType() throws Exception{
		super.execute();
		GoodTypeInfo typeinfo=new GoodTypeInfo();
		typeinfo.setId(Integer.parseInt(request.getParameter("id")));
		typeinfo.setTypecode(request.getParameter("typecode"));
		typeinfo.setTypename(request.getParameter("typename"));
		typeinfo.setRemarks(request.getParameter("remarks"));
		if(!goodTypeService.hasGood(typeinfo)){
			goodTypeService.deleteGoodType(typeinfo);
			return "success";
		}
		else{
			return "fail";
		}
	}
}