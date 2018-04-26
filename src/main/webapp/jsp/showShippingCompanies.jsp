<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Shipping Companies</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Home Port</th>
			<th>Balance</th>
			<th>Ships</th>
			
		</tr>
		
		<c:forEach items = "${shippingCompanies}" var ="shippingCompany">
			<tr>
				<td>${shippingCompany.name}</td>
				<td>${shippingCompany.homePort}</td>
				<td>${shippingCompany.balance}</td>
				<td>${shippingCompany.ships}</td>
			</tr>
		</c:forEach>
	</table>
		<a href="/">Home Page</a>
	
</body>
</html>