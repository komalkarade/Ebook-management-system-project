<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DAO.BookDAOImpl"%>
<%@page import="com.DAO.BookDAO"%>
<%@page import="com.entity.BookDtls"%>
<%@page import="java.util.List"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin:All Books</title>
<%@include file="/admin/allCss.jsp"%>

</head>
<body>
	<%@include file="/admin/navbar.jsp"%>
	<h3 class="text-center">Hello,Admin</h3>
	
	<c:if test="${empty userobj}">
		<c:redirect url="../login.jsp" />
	</c:if>
	
		<c:if test="${not empty succMsg}">
								<h5 class="text-center text-success">${succMsg}</h5>
								<c:remove var="succMsg" />
							</c:if>

							<c:if test="${not empty failedMsg}">
								<h5 class="text-center text-danger">${failedMsg}</h5>
								<c:remove var="failedMsg" />
							</c:if>
	

	<table class="table table-striped">
		<thead class="bg-primary text-white">
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Image</th>

				<th scope="col">Book Name</th>
				<th scope="col">Authore</th>
				<th scope="col">Price</th>
				<th scope="col">Categories</th>
				<th scope="col">Status</th>
				<th scope="col">Action</th>

			</tr>
		</thead>
		<tbody>
			<%
  BookDAOImpl dao=new BookDAOImpl(DBConnect.getConn());
  List<BookDtls> list=dao.getAllBooks();
  for(BookDtls b:list){
	  
	  %>
			<tr>
    <td><%= b.getBookId() %></td>
    <td><img src="../book/<%= b.getPhotoName() %>" style="width:50px;height:50px;"></td>
    <td><%= b.getBookName() %></td>
    <td><%= b.getAuthor() %></td>
    <td><%= b.getPrice() %></td>
    <td><%= b.getBookCategory() %></td>
    <td><%= b.getStatus() %></td>
    <td>
        <a href="edit_books.jsp?id=<%=b.getBookId()%>" class="btn btn-sm btn-primary"><i class="fas fa-edit"></i>Edit</a>
<a href="../BooksDeleteServlet?id=<%=b.getBookId()%>" class="btn btn-sm btn-danger"><i class="fas fa-trash-alt"></i>Delete</a>
    </td>
</tr>
<% 
  }
  
  
  %>

		</tbody>
	</table>
	<div style="margin-top: 225px">
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>