<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
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
							<h5 class="text-primary">Book Add</h5>

							<c:if test="${empty userobj}">
								<c:redirect url="../login.jsp" />
							</c:if>

							<c:if test="${not empty succMsg}">
								<p class="text-center text-success">${succMsg}</p>
								<c:remove var="succMsg" />
							</c:if>

							<c:if test="${not empty failedMsg}">
								<p class="text-center text-danger">${failedMsg}</p>
								<c:remove var="failedMsg" />
							</c:if>



						</div>
						<form action="../BooksAdd" method="post"
							enctype="multipart/form-data">
							<div class="form-group">
								<label for="exampleInputFullName">Book Name*</label> <input
									type="text" class="form-control" id="exampleInputFullName"
									required="required" name="bname">
							</div>

							<div class="form-group">
								<label for="exampleInputAuthorName">Author Name*</label> <input
									type="text" class="form-control" id="exampleInputAuthorName"
									required="required" name="author">
							</div>

							<div class="form-group">
								<label for="exampleInputPrice">Price*</label> <input
									type="number" class="form-control" id="exampleInputPrice"
									required="required" name="price">
							</div>

							<div class="form-group">
								<label for="inputBookCategories">Book Categories</label> <select
									class="form-control" id="inputBookCategories"
									required="required" name="bookCategory">
									<option value="" selected>--select--</option>
									<option value="New">New Book</option>
									<!-- Add more options if needed -->
								</select>
							</div>

							<div class="form-group">
								<label for="inputBookStatus">Book Status</label> <select
									class="form-control" id="inputBookStatus" required="required"
									name="status">
									<option value="" selected>--select--</option>
									<option value="Active">Active</option>
									<option value="Inactive">Inactive</option>
									<!-- Add more options if needed -->
								</select>
							</div>

							<div class="form-group">
								<label for="exampleformcontrolfile1">Upload Photo</label> <input
									type="file" class="form-control-file"
									id="exampleformcontrolfile1" name="bimg">
							</div>


							<button type="submit" class="btn btn-primary">Add</button>
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