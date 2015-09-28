package service;

import java.util.List;
import model.GoodTypeInfo;

public interface GoodTypeService {
	/*
	 * �鿴������Ʒ���
	 */
	public List<GoodTypeInfo> getAllInfo(); 
	
	public GoodTypeInfo searchByTypecode(String typecode);
	
	public GoodTypeInfo searchByTypename(String typename);
	
	public int judgeKeyword(String keyword);
	
	/*
	 * �����µ���Ʒ���
	 */
	public boolean addNewGoodType(GoodTypeInfo goodtypeinfo);	
	
	/*
	 * �޸���Ʒ�����Ϣ
	 */
	public void modifyGoodTypeInfo(GoodTypeInfo goodtypeinfo);
	
	/*
	 * �ж���Ʒ����Ƿ�����Ʒ
	 */
	public boolean hasGood(GoodTypeInfo goodtypeinfo);
	
	
	/*
	 * ɾ����Ʒ���
	 */
	public void deleteGoodType(GoodTypeInfo goodtypeinfo);
}