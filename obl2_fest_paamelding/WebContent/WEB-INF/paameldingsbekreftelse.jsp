<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>P�meldingsbekreftelse</title>
</head>
<body>
<h2>P�meldingsbekreftelse</h2>
<p>P�meldingen er mottatt for</p>
<p>&nbsp;&nbsp;&nbsp; ${skjema.fornavn}<br/>
&nbsp;&nbsp;&nbsp; ${skjema.etternavn}<br/>
&nbsp;&nbsp;&nbsp; ${skjema.mobil}<br/>
&nbsp;&nbsp;&nbsp; 	<c:choose> <c:when test="${skjema.kjonn == 'true'}"> Kvinne </c:when> <c:when test="${skjema.kjonn == 'false'}"> Mann </c:when> </c:choose></p>
<p><b>NB! Husk � betale til kassereren f�r festen!</b></p>
<a href="deltakerliste">G� til deltagerlisten</a>
</body>
</html>