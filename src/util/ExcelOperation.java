package util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import model.ConsumptionInfo;
import entity.Guest;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelOperation {

	public static void createExcel(OutputStream os, String title,
			Map<String, Object> content) throws WriteException, IOException {
		// ����������
		WritableWorkbook workbook = Workbook.createWorkbook(os);
		// �����µ�һҳ

		if (title.equals("��ס�Ǽ�")) {
			createCheckinSheet(workbook, content);
		}

		if (title.equals("�˷��Ǽ�")) {
			createCheckoutSheet(workbook, content);
		}

		if (title.equals("�����˵�")) {
			createConsumptionSheet(workbook, content);
		}
	}

	private static void createCheckinSheet(WritableWorkbook workbook,
			Map<String, Object> content) throws WriteException, IOException {
		String checkinnum = (String) content.get("checkinnum");
		String roomnum = (String) content.get("roomnum");
		WritableSheet sheet = workbook.createSheet("��ס�Ǽ�" + checkinnum + "_"
				+ roomnum, 0);

		// ����Ҫ��ʾ������,����һ����Ԫ�񣬵�һ������Ϊ�����꣬�ڶ�������Ϊ�����꣬����������Ϊ����
		Label title = new Label(0, 0, "��ס�Ǽ�");
		sheet.addCell(title);

		Label lb_checkinnum = new Label(0, 1, "��ס����");
		sheet.addCell(lb_checkinnum);
		Label ct_checinnum = new Label(1, 1, checkinnum);
		sheet.addCell(ct_checinnum);

		Label lb_roomnum = new Label(0, 2, "�ͷ����");
		sheet.addCell(lb_roomnum);
		Label ct_roomnum = new Label(1, 2, roomnum);
		sheet.addCell(ct_roomnum);

		Label lb_typename = new Label(0, 3, "�ͷ�����");
		sheet.addCell(lb_typename);
		String typename = (String) content.get("typename");
		Label ct_typename = new Label(1, 3, typename);
		sheet.addCell(ct_typename);

		Label lb_stdprice = new Label(0, 4, "��  ׼  ��");
		sheet.addCell(lb_stdprice);
		String stdprice = (String) content.get("stdprice");
		Label ct_stdprice = new Label(1, 4, stdprice);
		sheet.addCell(ct_stdprice);

		Label lb_discprice = new Label(0, 5, "��  ��  ��");
		sheet.addCell(lb_discprice);
		String discprice = (String) content.get("discprice");
		Label ct_discprice = new Label(1, 5, discprice);
		sheet.addCell(ct_discprice);

		Label lb_deposit = new Label(0, 6, "Ѻ        ��");
		sheet.addCell(lb_deposit);
		String deposit = (String) content.get("deposit");
		Label ct_deposit = new Label(1, 6, deposit);
		sheet.addCell(ct_deposit);

		int i = 0;
		int numOfGuest = 0;
		while (content.containsKey("" + i)) {
			Guest guest = (Guest) content.get("" + i);

			Label lb_name = new Label(0, 7 + numOfGuest * 4, "��      ��"
					+ (i + 1));
			sheet.addCell(lb_name);
			String name = guest.getName();
			Label ct_name = new Label(1, 7 + numOfGuest * 4, name);
			sheet.addCell(ct_name);

			Label lb_idtype = new Label(0, 8 + numOfGuest * 4, "֤������");
			sheet.addCell(lb_idtype);
			int idtype = guest.getIdtype();
			if (idtype == 0) {
				Label ct_idtype = new Label(1, 8 + numOfGuest * 4, "���֤");
				sheet.addCell(ct_idtype);
			}
			if (idtype == 1) {
				Label ct_idtype = new Label(1, 8 + numOfGuest * 4, "����");
				sheet.addCell(ct_idtype);
			}
			if (idtype == 2) {
				Label ct_idtype = new Label(1, 8 + numOfGuest * 4, "����֤");
				sheet.addCell(ct_idtype);
			}

			Label lb_idnum = new Label(0, 9 + numOfGuest * 4, "֤������");
			sheet.addCell(lb_idnum);
			String idnum = guest.getIdnum();
			Label ct_idnum = new Label(1, 9 + numOfGuest * 4, idnum);
			sheet.addCell(ct_idnum);

			Label lb_telnum = new Label(0, 10 + numOfGuest * 4, "��ϵ�绰");
			sheet.addCell(lb_telnum);
			String telnum = guest.getTelnum();
			Label ct_telnum = new Label(1, 10 + numOfGuest * 4, telnum);
			sheet.addCell(ct_telnum);

			numOfGuest = numOfGuest + 1;
			i++;
		}

		Label lb_checkindt = new Label(0, 11 + numOfGuest * 4, "�ֵ�ʱ��");
		sheet.addCell(lb_checkindt);
		String checkindt = (String) content.get("checkindt");
		Label ct_checkindt = new Label(1, 11 + numOfGuest * 4, checkindt);
		sheet.addCell(ct_checkindt);

		Label lb_checkoutdt = new Label(0, 12 + numOfGuest * 4, "���ʱ��");
		sheet.addCell(lb_checkoutdt);
		String checkoutdt = (String) content.get("checkoutdt");
		Label ct_checkoutdt = new Label(1, 12 + numOfGuest * 4, checkoutdt);
		sheet.addCell(ct_checkoutdt);

		Label lb_numofguests = new Label(0, 13 + numOfGuest * 4, "��ס����");
		sheet.addCell(lb_numofguests);
		String numofguests = (String) content.get("numofguests");
		Label ct_numofguests = new Label(1, 13 + numOfGuest * 4, numofguests);
		sheet.addCell(ct_numofguests);

		Label lb_staffname = new Label(0, 14 + numOfGuest * 4, "��  ��  Ա");
		sheet.addCell(lb_staffname);
		String staffname = (String) content.get("staffname");
		Label ct_staffname = new Label(1, 14 + numOfGuest * 4, staffname);
		sheet.addCell(ct_staffname);

		Label lb_memberid = new Label(0, 15 + numOfGuest * 4, "��Ա���");
		sheet.addCell(lb_memberid);
		String memberid = (String) content.get("memberid");
		Label ct_memberid = new Label(1, 15 + numOfGuest * 4, memberid);
		sheet.addCell(ct_memberid);

		Label lb_mprice = new Label(0, 16 + numOfGuest * 4, "��Ա�۸�");
		sheet.addCell(lb_mprice);
		String mprice = (String) content.get("mprice");
		Label ct_mprice = new Label(1, 16 + numOfGuest * 4, mprice);
		sheet.addCell(ct_mprice);

		Label lb_breakfast = new Label(0, 17 + numOfGuest * 4, "�ṩ���");
		sheet.addCell(lb_breakfast);
		String breakfast = (String) content.get("breakfast");
		Label ct_breakfast = new Label(1, 17 + numOfGuest * 4, breakfast);
		sheet.addCell(ct_breakfast);

		Label lb_remarks = new Label(0, 18 + numOfGuest * 4, "��        ע");
		sheet.addCell(lb_remarks);
		String remarks = (String) content.get("remarks");
		Label ct_remarks = new Label(1, 18 + numOfGuest * 4, remarks);
		sheet.addCell(ct_remarks);

		workbook.write();
		workbook.close();
	}

	private static void createCheckoutSheet(WritableWorkbook workbook,
			Map<String, Object> content) throws WriteException, IOException {
		String checkinnum = (String) content.get("checkinnum");
		String roomnum = (String) content.get("roomnum");
		WritableSheet sheet = workbook.createSheet("�˷��Ǽ�" + checkinnum + "_"
				+ roomnum, 0);

		// ����Ҫ��ʾ������,����һ����Ԫ�񣬵�һ������Ϊ�����꣬�ڶ�������Ϊ�����꣬����������Ϊ����
		Label title = new Label(0, 0, "�˷��Ǽ�");
		sheet.addCell(title);

		Label lb_checkinnum = new Label(0, 1, "��ס����");
		sheet.addCell(lb_checkinnum);
		Label ct_checinnum = new Label(1, 1, checkinnum);
		sheet.addCell(ct_checinnum);

		Label lb_roomnum = new Label(0, 2, "�ͷ����");
		sheet.addCell(lb_roomnum);
		Label ct_roomnum = new Label(1, 2, roomnum);
		sheet.addCell(ct_roomnum);

		Label lb_roomprice = new Label(0, 3, "��        ��");
		sheet.addCell(lb_roomprice);
		String roomprice = (String) content.get("roomprice");
		Label ct_roomprice = new Label(1, 3, roomprice);
		sheet.addCell(ct_roomprice);

		Label lb_deposit = new Label(0, 4, "Ѻ        ��");
		sheet.addCell(lb_deposit);
		String deposit = (String) content.get("deposit");
		Label ct_deposit = new Label(1, 4, deposit);
		sheet.addCell(ct_deposit);

		Label lb_checkindt = new Label(0, 5, "�ֵ�ʱ��");
		sheet.addCell(lb_checkindt);
		String checkindt = (String) content.get("checkindt");
		Label ct_checkindt = new Label(1, 5, checkindt);
		sheet.addCell(ct_checkindt);

		Label lb_checkoutdt = new Label(0, 6, "���ʱ��");
		sheet.addCell(lb_checkoutdt);
		String checkoutdt = (String) content.get("checkoutdt");
		Label ct_checkoutdt = new Label(1, 6, checkoutdt);
		sheet.addCell(ct_checkoutdt);

		Label lb_roomrate = new Label(0, 7, "ס  ��  ��");
		sheet.addCell(lb_roomrate);
		String roomrate = (String) content.get("roomrate");
		Label ct_roomrate = new Label(1, 7, roomrate);
		sheet.addCell(ct_roomrate);

		Label lb_consumption = new Label(0, 8, "��������");
		sheet.addCell(lb_consumption);
		String consumption = (String) content.get("consumption");
		Label ct_consumption = new Label(1, 8, consumption);
		sheet.addCell(ct_consumption);

		Label lb_mealrate = new Label(0, 9, "��        ��");
		sheet.addCell(lb_mealrate);
		String mealrate = (String) content.get("mealrate");
		Label ct_mealrate = new Label(1, 9, mealrate);
		sheet.addCell(ct_mealrate);

		Label lb_telrate = new Label(0, 10, "��  ��  ��");
		sheet.addCell(lb_telrate);
		String telrate = (String) content.get("telrate");
		Label ct_telrate = new Label(1, 10, telrate);
		sheet.addCell(ct_telrate);

		Label lb_ar = new Label(0, 11, "ʵ��Ӧ��");
		sheet.addCell(lb_ar);
		String ar = (String) content.get("ar");
		Label ct_ar = new Label(1, 11, ar);
		sheet.addCell(ct_ar);

		Label lb_paymeth = new Label(0, 12, "���ʽ");
		sheet.addCell(lb_paymeth);
		String paymeth = (String) content.get("paymeth");
		Label ct_paymeth = new Label(1, 12, paymeth);
		sheet.addCell(ct_paymeth);

		Label lb_actualpay = new Label(0, 13, "ʵ        ��");
		sheet.addCell(lb_actualpay);
		String actualpay = (String) content.get("actualpay");
		Label ct_actualpay = new Label(1, 13, actualpay);
		sheet.addCell(ct_actualpay);

		Label lb_change = new Label(0, 14, "��        ��");
		sheet.addCell(lb_change);
		String change = (String) content.get("change");
		Label ct_change = new Label(1, 14, change);
		sheet.addCell(ct_change);

		Label lb_staffname = new Label(0, 15, "��  ��  Ա");
		sheet.addCell(lb_staffname);
		String staffname = (String) content.get("staffname");
		Label ct_staffname = new Label(1, 15, staffname);
		sheet.addCell(ct_staffname);

		Label lb_remarks = new Label(0, 16, "��        ע");
		sheet.addCell(lb_remarks);
		String remarks = (String) content.get("remarks");
		Label ct_remarks = new Label(1, 16, remarks);
		sheet.addCell(ct_remarks);

		// �Ѵ���������д�뵽������У����ر������
		workbook.write();
		workbook.close();
	}

	private static void createConsumptionSheet(WritableWorkbook workbook,
			Map<String, Object> content) throws WriteException, IOException {
		String checkinnum = (String) content.get("checkinnum");
		String roomnum = (String) content.get("roomnum");
		WritableSheet sheet = workbook.createSheet("�����˵�" + checkinnum + "_"
				+ roomnum, 0);

		// ����Ҫ��ʾ������,����һ����Ԫ�񣬵�һ������Ϊ�����꣬�ڶ�������Ϊ�����꣬����������Ϊ����
		Label title = new Label(0, 0, "�����˵�");
		sheet.addCell(title);

		Label lb_checkinnum = new Label(0, 1, "��ס����");
		sheet.addCell(lb_checkinnum);
		Label ct_checinnum = new Label(1, 1, checkinnum);
		sheet.addCell(ct_checinnum);

		Label lb_roomnum = new Label(2, 1, "�ͷ����");
		sheet.addCell(lb_roomnum);
		Label ct_roomnum = new Label(3, 1, roomnum);
		sheet.addCell(ct_roomnum);

		Label title_goodname = new Label(0, 2, "��Ʒ��");
		sheet.addCell(title_goodname);

		Label title_amount = new Label(1, 2, "����");
		sheet.addCell(title_amount);

		Label title_unitprice = new Label(2, 2, "����");
		sheet.addCell(title_unitprice);

		Label title_unitSymbol = new Label(3, 2, "��λ");
		sheet.addCell(title_unitSymbol);

		Label title_subtotal = new Label(4, 2, "С��");
		sheet.addCell(title_subtotal);

		Label title_staffname = new Label(5, 2, "����Ա");
		sheet.addCell(title_staffname);

		Label title_datetime = new Label(6, 2, "����ʱ��");
		sheet.addCell(title_datetime);

		int i = 0;
		while (content.containsKey("" + i)) {
			ConsumptionInfo consumptionInfo = (ConsumptionInfo) content.get(""
					+ i);

			String goodname = consumptionInfo.getGoodname();
			Label ct_goodname = new Label(0, 3 + i, goodname);
			sheet.addCell(ct_goodname);

			String amount = "" + consumptionInfo.getAmount();
			Label ct_amount = new Label(1, 3 + i, amount);
			sheet.addCell(ct_amount);

			String unitprice = "��" + consumptionInfo.getUnitprice();
			Label ct_unitprice = new Label(2, 3 + i, unitprice);
			sheet.addCell(ct_unitprice);

			String unitSymbol = consumptionInfo.getUnitSymbol();
			Label ct_unitSymbol = new Label(3, 3 + i, unitSymbol);
			sheet.addCell(ct_unitSymbol);

			String subtotal = "��" + consumptionInfo.getSubtotal();
			Label ct_subtotal = new Label(4, 3 + i, subtotal);
			sheet.addCell(ct_subtotal);

			String staffname = consumptionInfo.getStaffname();
			Label ct_staffname = new Label(5, 3 + i, staffname);
			sheet.addCell(ct_staffname);

			String datetime = consumptionInfo.getDatetime();
			Label ct_datetime = new Label(6, 3 + i, datetime);
			sheet.addCell(ct_datetime);

			i++;
		}

		Label lb_discount = new Label(0, 3+i, "�ۿ���");
		sheet.addCell(lb_discount);
		String discount = (String) content.get("discount");
		Label ct_discount = new Label(6, 3+i, discount);
		sheet.addCell(ct_discount);
		
		Label lb_totalConsumption = new Label(0, 4+i, "�ϼ�");
		sheet.addCell(lb_totalConsumption);
		String totalConsumption = (String) content.get("totalConsumption");
		Label ct_totalConsumption = new Label(6, 4+i, totalConsumption);
		sheet.addCell(ct_totalConsumption);
		
		Label lb_expenseAfterDiscount = new Label(0, 5+i, "�ۺ���");
		sheet.addCell(lb_expenseAfterDiscount);
		String expenseAfterDiscount = (String) content.get("expenseAfterDiscount");
		Label ct_expenseAfterDiscount = new Label(6, 5+i, expenseAfterDiscount);
		sheet.addCell(ct_expenseAfterDiscount);
		
		// �Ѵ���������д�뵽������У����ر������
		workbook.write();
		workbook.close();
	}
}
