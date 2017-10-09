<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Betalingsoversikt</title>
</head>
<body>
<h2>Betalingsoversikt</h2>
<form action="adminpanel" method="post">
<table border="1">
	<tr bgcolor="#cccccc"><th align="left">Navn</th><th>Mobil</th><th>Betalingsstatus</th></tr>
	<c:forEach items="${deltakere}" var="u">
		<tr><td>${u.fornavn}</td>
		<td><c:set value="${u.mobil}" var="mobil" />${fn:substring(mobil, 0, 3)} ${fn:substring(mobil, 3, 5)} ${fn:substring(mobil, 5, 8)}</td>
		<td align="center"><c:choose><c:when test="${u.betalt}">Betaling mottatt</c:when>
		<c:otherwise><input type="submit" name="${u.mobil}" value="Registrer betaling" /></c:otherwise></c:choose></td></tr>
	</c:forEach>
</table>
</form>
<p><a href="adminlogout">Ferdig</a></p>
</body>
</html>