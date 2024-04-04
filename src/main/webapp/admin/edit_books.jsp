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
<title>Admin:Add Books</title>
<%@include file="/admin/allCss.jsp"%>

</head>
<body style="background-color: #f0f2f2;">
	<%@include file="/admin/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row mt-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<div class="text-center">
							<h5 class="text-primary">Edit Books-</h5>


							<%
							int id = Integer.parseInt(request.getParameter("id"));
							BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
							BookDtls b = dao.getBookById(id);
							%>

						</div>
						<form action="../EditBooksServlet" method="post">
							<input type="hidden" name="id" value="<%=b.getBookId()%>">
							<div class="form-group">
								<label for="exampleInputFullName">Book Name*</label> <input
									type="text" class="form-control" id="exampleInputFullName"
									required="required" name="bname" value="<%=b.getBookName()%>">
							</div>

							<div class="form-group">
								<label for="exampleInputAuthorName">Author Name*</label> <input
									type="text" class="form-control" id="exampleInputAuthorName"
									required="required" name="author" value="<%=b.getAuthor()%>">
							</div>

							<div class="form-group">
								<label for="exampleInputPrice">Price*</label> <input
									type="number" class="form-control" id="exampleInputPrice"
									required="required" name="price" value="<%=b.getPrice()%>">
							</div>



							<div class="form-group">
								<label for="inputBookStatus">Book Status</label> <select
									class="form-control" id="inputBookStatus" required="required"
									name="status">
									<option value="Active"
										${"!Active".equals(b.getStatus()) ? "selected" : ""}>Active</option>
									<option value="Inactive"
										${"Active".equals(b.getStatus()) ? "selected" : ""}>Inactive</option>
								</select>
							</div>



							<button type="submit" class="btn btn-primary">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-top: 13px">
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>