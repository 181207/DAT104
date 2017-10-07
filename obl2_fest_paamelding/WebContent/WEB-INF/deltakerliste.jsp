<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deltakerliste</title>
</head>
<body>
	<h2>Deltakerliste</h2>
	<table border="1">
		<tr bgcolor="#cccccc">
			<th>Kjønn</th>
			<th align="left">Navn</th>
		</tr>
		<c:forEach items="${deltakere}" var="u">
			<c:choose>
				<c:when test="${u.mobil eq skjema.mobil}">
					<c:choose>
					<c:when test="${u.betalt}">	<tr bgcolor="#A9D15E"></c:when>
					<c:otherwise><tr bgcolor="#ffaaaa"></c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise> <tr> </c:otherwise>
			</c:choose>
				<td align="center">
				
				<c:if test="${u.kjonn=='true'}">&#9794;</c:if>
				<c:if test="${u.kjonn=='false'}">&#9792;</c:if></td>
				<td>${u.fornavn} ${u.etternavn}</td>
			
			</tr>
		</c:forEach>
	</table>
	
	<a href="logout">Ferdig</a>

</body>
</html>