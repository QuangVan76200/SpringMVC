<%@page import="java.io.Writer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@page import="Model.NhanVienModel" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
ArrayList<NhanVienModel> List=null;
int countEmployee=0;
if(request.getAttribute("List")!=null){
	List =(ArrayList<NhanVienModel>) request.getAttribute("List");
}
if(request.getAttribute("countEmployee")!=null){
	out.print(request.getAttribute("countEmployee"));
	countEmployee =(Integer.valueOf(request.getAttribute("countEmployee").toString()));

}

Writer writer= response.getWriter();
%>
</head>
<body>
	<h1>${message}</h1>
	
  	<%
  	if(List!=null)
  	{
  		for(int i=0;i<List.size();i++){
  	  		writer.append( "<p>Mã Nhân Viên: "+List.get(i).getManNV()+"</p>");
  	  		writer.append( "<p>Mã Nhân Viên: "+List.get(i).getHoTen()+"</p>");
  	  		writer.append( "<p>Mã Nhân Viên: "+List.get(i).getNgaySinh()+"</p>");
  	  		writer.append( "<p>Mã Nhân Viên: "+List.get(i).getMaPhong()+"</p>");
  	  		writer.append("<br>");
  	  	}
  	}
  	%>
  	
  	
  	<h1>Phân Trang</h1>
  	<div style="width:100%">
  	 <%
    	try{
    		if(countEmployee%4!=0)
    			countEmployee=countEmployee/4+1;
    		else
    			countEmployee=countEmployee/4;
    		out.print("<div style=\"display:inline-block;height:100%;width:"+(countEmployee*30+countEmployee*14)+"px;\">");
    		out.print("<p>"+countEmployee+"</p>");
    		for(int i=1;i<=countEmployee;i++)
    		{
    			if(Integer.valueOf(request.getParameter("page").toString())==i)
    				out.print("<div style=\"height:30px; background-color:#e4e4e4 ; border-color:black;float:left; width:30px;\"><a href=\"/SpringMVC/Hello?page="+i+"\">"+i+"</a></div>");
    			else
    				out.print("<div style=\"height:30px; float:left; width:30px;\"><a href=\"/SpringMVC/Hello?page="+i+"\">"+i+"</a></div>");
    		}
    		out.print("</div>");
    	}catch(Exception e){
    		
    	}
    	%> 
  	</div>
    <p></p>
</body>
</html>