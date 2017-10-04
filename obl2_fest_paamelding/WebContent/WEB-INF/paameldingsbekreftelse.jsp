<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Påmeldingsbekreftelse</title>
</head>
<body>
<h2>Påmeldingsbekreftelse</h2>
<p>Påmeldingen er mottatt for</p>
<p>&nbsp;&nbsp;&nbsp; ${skjema.fornavn}<br/>
&nbsp;&nbsp;&nbsp; ${skjema.etternavn}<br/>
&nbsp;&nbsp;&nbsp; ${skjema.mobil}<br/>
&nbsp;&nbsp;&nbsp; 	<c:choose> <c:when test="${skjema.kjonn == 'true'}"> Kvinne </c:when> <c:when test="${skjema.kjonn == 'false'}"> Mann </c:when> </c:choose></p>
<p><b>NB! Husk å betale til kassereren før festen!</b></p>
<a href="deltakerliste">Gå til deltagerlisten</a>
</body>
</html>