package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.db.*;
import com.bean.*;
import com.dao.*;


public class userServlet1 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final ResultSet NULL = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			ResultSet rs = null;
			userdao carry = new userdao();
			String temp = request.getParameter("subdataFill");

			String enterpriceID = request.getParameter("number");
			String data_crewnumlater = request.getParameter("select");
			String selectyear = request.getParameter("selectyear");
	//		int data_crewnumlater = Integer.parseInt(s_data_crewnumlater);
			String Crewnumearly = request.getParameter("jianDangNumber");
			int crewnumearly = Integer.parseInt(Crewnumearly);
			String Crewnumlater = request.getParameter("diaoChaNumber");
			int crewnumlater = Integer.parseInt(Crewnumlater);
			String ypeofdecrease = request.getParameter("type");
			String otherreason = request.getParameter("otherReason");
			
			String mainreason = request.getParameter("mainReason");
			String discriptionmain = request.getParameter("mainReasonInfo");
			String secondreason = request.getParameter("secondReason");
			String discriptionsecond = request.getParameter("secondReasonInfo");
			String thirdreason = request.getParameter("thirdReason");
			String discriptionthird = request.getParameter("thirdReasonInfo");
			
			String area_name = request.getParameter("fax");
		
			String s_EMAIL = request.getParameter("EMAIL");
			int EMAIL = Integer.parseInt(s_EMAIL);
		/*	PrintWriter out = response.getWriter();
			out.print(Crewnumearly);
			out.print(Crewnumlater);
			out.print(ypeofdecrease);
			out.print(mainreason);
			out.print(secondreason);
			out.print(thirdreason);
			out.print(area_name);
			out.print(enterpriceID);
			out.print(data_crewnumlater);
	*/
			
			
			// if(student_id==null)
			// {
			// HttpSession session = request.getSession(false);
			// student_id=(String)session.getAttribute("user_id");
			// student_id="1120150000";
			// }
			if(temp.equals("数据上报"))
			{
				int scs = carry.insertdata_user(enterpriceID, selectyear, data_crewnumlater,
						 crewnumearly,  crewnumlater,  otherreason,
						 ypeofdecrease,  mainreason,  discriptionmain,
						 secondreason,  discriptionsecond,  thirdreason,
						 discriptionthird,  area_name,  EMAIL);
				if(scs==0)
				{
					PrintWriter out = response.getWriter();
					out.print("<script>alert('您已经提交过！');window.location.href='user_2.dataFill.jsp'</script>");
				}
				else
				{
					PrintWriter out = response.getWriter();
					out.print("<script>alert('提交成功！!');window.location.href='user_2.dataFill.jsp'</script>");
				}
			}
			
				

		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getMessage());
		}
	}

}
