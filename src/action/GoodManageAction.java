package action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import model.GoodInfo;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Component;

import service.GoodService;

@ParentPackage(value="json-default")
@Results({@Result(name="success", location="/jsp/GoodManage.jsp"),
	@Result(name="fail", location="/jsp/GoodManage.jsp")})
@Component
public class GoodManageAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GoodInfo good;
	
	@Resource
	private GoodService goodService;

	public GoodInfo getGood() {
		return good;
	}

	public void setGood(GoodInfo good) {
		this.good = good;
	}

	public GoodService getGoodService() {
		return goodService;
	}

	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}	
	
	@Action(value = "/goodsearch")//19
	public String searchGood() throws Exception{
		super.execute();
		String keyword=request.getParameter("keyword");
		String typename=request.getParameter("typename");
		if(keyword==""){
			if(typename.equals("全部")){
				List<GoodInfo> result=goodService.getAllGoods();
				request.setAttribute("goodresult", result);
				return "success";
			}
			else{
				List<GoodInfo> result=goodService.searchGoodByTypename(typename);
				request.setAttribute("goodresult", result);
				return "fail";
			}
		}
		else{
			int keywordtype=goodService.judgeKeyword(keyword);//0 is goodcode, 1 is goodname			
			if(typename.equals("全部")){
				if(keywordtype==0){
					GoodInfo goodinfo=goodService.getGoodByCode(keyword);
					request.setAttribute("goodresult", goodinfo);
					if(goodinfo!=null){
						return "success";
					}
					else {
						return "false";
					}
				}
				else{
					GoodInfo goodinfo=goodService.searchByName(keyword);
					request.setAttribute("goodresult", goodinfo);
					if(goodinfo!=null){
						return "success";
					}
					else {
						return "false";
					}
				}
			}
			else{			
				List<GoodInfo> result=new ArrayList<GoodInfo>();
				request.setAttribute("goodresult", result);
				if(result.size()!=0)
					return "success";
				else {
					return "fail";
				}
			}
		}		
	}
	
	@Action(value = "/add")//64
    public String createGood() throws Exception{
		super.execute();
		GoodInfo goodinfo=new GoodInfo();
		goodinfo.setGoodname(request.getParameter("goodname"));
		goodinfo.setTypename(request.getParameter("typename"));
		goodinfo.setUnitprice(Double.valueOf(request.getParameter("unitprice")));
		goodinfo.setUnitSymbol(request.getParameter("unitsymbol"));
		if(goodService.addNewGood(goodinfo)){
			return "success";
		}
		else{
			return "fail";
		}
	}
	
	@Action(value = "/update")
    public String modifyGood() throws Exception{
		super.execute();
		GoodInfo goodinfo=new GoodInfo();
		goodinfo.setId(Integer.parseInt(request.getParameter("id")));
		goodinfo.setGoodcode(request.getParameter("goodcode"));
		goodinfo.setGoodname(request.getParameter("goodname"));
		goodinfo.setTypename(request.getParameter("typename"));
		goodinfo.setUnitprice(Double.valueOf(request.getParameter("unitprice")));
		goodinfo.setUnitSymbol(request.getParameter("unitsymbol"));
		goodService.modifyGoodInfo(goodinfo);
		return "success";
	}
	
	@Action(value = "/delete")
    public String deleteGood() throws Exception{
		super.execute();
		GoodInfo goodinfo=new GoodInfo();
		goodinfo.setId(Integer.parseInt(request.getParameter("id")));
		goodinfo.setGoodcode(request.getParameter("goodcode"));
		goodinfo.setGoodname(request.getParameter("goodname"));
		goodinfo.setTypename(request.getParameter("typename"));
		goodinfo.setUnitprice(Double.valueOf(request.getParameter("unitprice")));
		goodinfo.setUnitSymbol(request.getParameter("unitsymbol"));
		goodService.deleteGood(goodinfo);
		return "success";
	}

}
