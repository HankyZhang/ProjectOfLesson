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
public class userServlet3 extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;setchar=UTF-8");
		PrintWriter out=response.getWriter();
		
		
		ResultSet rs = null;
		userdao carry = new userdao();
		
		String enterpriceID = "1";
		
		
		
		//System.out.println("wojinlaile !");
		String select=request.getParameter("select");
		String selectyear=request.getParameter("selectyear");
		/*String ones=request.getParameter("13");
		String onex=request.getParameter("14");
		String twos=request.getParameter("20");
		String twox=request.getParameter("21");
		String threes=request.getParameter("30");
		String threex=request.getParameter("31");
		String fouri=request.getParameter("4");
		String five=request.getParameter("5");
		String six=request.getParameter("6");
		String seven=request.getParameter("7");
		String eight=request.getParameter("8");
		String nine=request.getParameter("9");
		String ten=request.getParameter("10");
		String eleven=request.getParameter("11");
		String twelve=request.getParameter("12");*/
	
		
		String value=request.getParameter("b");
		
		
	
		
		try
		{
			if(value.equals("ȷ��"))
			{
				
				rs=carry.data_select(enterpriceID,selectyear,select);
				if(rs!=null)
				{
					
					String flag=null;
					flag="1";
					request.setAttribute("flag",flag);
					ArrayList<String> list = new ArrayList<String>();
			
					Integer limit;
					while(rs.next())
					{
						
						String temp;
						
						temp = (String) rs.getString("��֯��������");
						list.add(temp);

						
						temp = (String) rs.getString("���");
						list.add(temp);
						
						temp = (String) rs.getString("������");
						list.add(temp);

						System.out.println(temp);
						
						limit = rs.getInt("�����ھ�ҵ����");
						temp = Integer.toString(limit);
						list.add(temp);

						System.out.println(temp);
						
						limit = rs.getInt("�����ھ�ҵ����");
						temp = Integer.toString(limit);
						list.add(temp);
						
						temp = (String) rs.getString("����ԭ��");
						list.add(temp);
											
						temp = (String) rs.getString("��ҵ������������");
						list.add(temp);
						
	
						temp = (String) rs.getString("��Ҫԭ��");
						list.add(temp);
						
						temp = (String) rs.getString("��Ҫԭ��˵��");
						list.add(temp);

						temp = (String) rs.getString("��Ҫԭ��");
						list.add(temp);
						
						temp = (String) rs.getString("��Ҫԭ��˵��");
						list.add(temp);
						
						temp = (String) rs.getString("����ԭ��");
						list.add(temp);
						
						temp = (String) rs.getString("����ԭ��˵��");
						list.add(temp);

						temp = (String) rs.getString("����");
						list.add(temp);
						
						limit = rs.getInt("���");
						temp = Integer.toString(limit);
						list.add(temp);
					}
					request.setAttribute("list",list);
					request.getRequestDispatcher("user_3.dataInquire.jsp").forward(request,response);
				}
				else {
					
					out.print("<script>alert('��������!');window.location.href='user_3.dataInquire.jsp'</script>");
				
				}
			}
			
		}
		catch (Exception e) 
		{
			System.out.println(e);
			System.out.println(e.getMessage());
		}
	}

}
