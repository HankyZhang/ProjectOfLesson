package com.dao;

import java.sql.ResultSet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.db.*;
import com.bean.userbean;
import java.util.*;
import java.sql.*;

public class userdao {
	// �ϴ���Ϣ
	public int insertdata_user(String enterpriceID, String selectyear,
			String data_crewnumlater, int crewnumearly, int crewnumlater,
			String otherreason, String ypeofdecrease, String mainreason,
			String discriptionmain, String secondreason,
			String discriptionsecond, String thirdreason,
			String discriptionthird, String area_name, int EMAIL) {
		// TODO Auto-generated method stub
		System.out.println("yes!");
		try {
			sql result = new sql();
			String temp = "insert into ��ҵ�ϱ����� values ('" + enterpriceID + "','"
					+ selectyear + "','" + data_crewnumlater + "',"
					+ crewnumearly + "," + crewnumlater + ",'" + otherreason
					+ "','" + ypeofdecrease + "','" + mainreason + "','"
					+ discriptionmain + "','" + secondreason + "','"
					+ discriptionsecond + "','" + thirdreason + "','"
					+ discriptionthird + "','" + area_name + "','" + EMAIL
					+ "');";
			System.out.println(temp);

			result.setSqlStr(temp);
			int flag1 = result.executeUpdate();

			if (flag1 == 1) {
				return 1;
			}
			result.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;

	}

	/*
	 * // ��ȡ�б� public ArrayList<userbean> user_updata(String enterpriceID) {
	 * 
	 * ArrayList<userbean> list = new ArrayList<userbean>();
	 * 
	 * ResultSet rs = null; try {
	 * 
	 * sql result = new sql(); result.getRs(); String temp =
	 * "select * from ��ҵ�ϱ����� where (��ҵ�ϱ�����.��֯��������='" + enterpriceID + "')";
	 * result.setSqlStr(temp); result.executeQuery(); rs = result.getRs();
	 * 
	 * while (rs.next()) {
	 * 
	 * String data_crewnumlater = rs.getString(2); String Crewnumearly =
	 * rs.getString(3); int crewnumearly = Integer.parseInt(Crewnumearly);
	 * String Crewnumlater = rs.getString(4); int crewnumlater =
	 * Integer.parseInt(Crewnumlater); String ypeofdecrease = rs.getString(5);
	 * String otherreason = rs.getString(6); String mainreason =
	 * rs.getString(7); String discriptionmain = rs.getString(8); String
	 * secondreason = rs.getString(9); String discriptionsecond =
	 * rs.getString(10); String thirdreason = rs.getString(11); String
	 * discriptionthird = rs.getString(12); String area_name = rs.getString(13);
	 * String s_eMAIL = rs.getString(14); int eMAIL = Integer.parseInt(s_eMAIL);
	 * userbean user = new userbean(); user.setArea_name(area_name);
	 * user.setCrewnumearly(crewnumearly); user.setCrewnumlater(crewnumlater);
	 * user.setData_crewnumlater(data_crewnumlater);
	 * user.setEnterpriceID(enterpriceID); user.setMainreason(mainreason);
	 * user.setSecondreason(secondreason); user.setThirdreason(thirdreason);
	 * user.setYpeofdecrease(ypeofdecrease);
	 * user.setDiscriptionmain(discriptionmain);
	 * user.setDiscriptionsecond(discriptionsecond);
	 * user.setDiscriptionthird(discriptionthird); user.setEMAIL(eMAIL); }
	 * 
	 * rs.last(); int rowCount = rs.getRow(); rs.beforeFirst(); if (rowCount ==
	 * 0) { rs = null; } return rs;
	 * 
	 * 
	 * } catch (Exception e) { System.out.println(e); } return list; }
	 */

	// ��������
	public ResultSet data_select(String enterpriceID, String selectyear,
			String select) {

		ResultSet rs = null;
		try {

			sql result = new sql();
			result.getRs();
			String temp;
			if (selectyear.equals("all")) {
				if (select.equals("15")) {

					temp = "select * from ��ҵ�ϱ����� where (��ҵ�ϱ�����.��֯��������='"
							+ enterpriceID
							+ "' and ��ҵ�ϱ�����.������ = ��ҵ�ϱ�����.������  and ��ҵ�ϱ�����.���=��ҵ�ϱ�����.���);";
				} else {
					temp = "select * from ��ҵ�ϱ����� where (��ҵ�ϱ�����.��֯��������='"
							+ enterpriceID
							+ "' and ��ҵ�ϱ�����.��� = ��ҵ�ϱ�����.��� and ��ҵ�ϱ�����.������='"
							+ select + "');";

				}
			} else {
				if (select.equals("15")) {

					temp = "select * from ��ҵ�ϱ����� where (��ҵ�ϱ�����.��֯��������='"
							+ enterpriceID
							+ "' and ��ҵ�ϱ�����.������ = ��ҵ�ϱ�����.������   and ��ҵ�ϱ�����.���='"
							+ selectyear + "');";

				} else {
					temp = "select * from ��ҵ�ϱ�����  where (��ҵ�ϱ�����.��֯��������='"
							+ enterpriceID + "' and ��ҵ�ϱ�����.������='" + select
							+ "' and ��ҵ�ϱ�����.���='" + selectyear + "');";

				}
			}

			System.out.println(temp);
			result.setSqlStr(temp);
			result.executeQuery();
			rs = result.getRs();
			rs.last();
			int rowCount = rs.getRow();
			rs.beforeFirst();
			if (rowCount == 0) {
				rs = null;
			}
			return rs;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	/*
	 * public ResultSet selectdata_user_info(String enterpriceID) { ResultSet rs
	 * = null; try { sql result = new sql(); result.getRs(); String temp =
	 * "select * from ��ҵ�ϱ����� where (��ҵ�ϱ�����.��֯��������='" + enterpriceID + "')";
	 * result.setSqlStr(temp); result.executeQuery(); rs = result.getRs();
	 * rs.last(); int rowCount = rs.getRow(); rs.beforeFirst(); if (rowCount ==
	 * 0) { rs = null; } return rs; } catch (Exception e) {
	 * System.out.println(e); return rs; } }
	 */
}
