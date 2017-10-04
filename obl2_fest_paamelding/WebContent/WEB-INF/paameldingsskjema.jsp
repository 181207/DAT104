<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Påmelding</title>
</head>
<body>
<h2>Påmelding</h2>
<form action="signup" method="post">
  <fieldset>
    <legend>Personlige data</legend>
    <p>Fornavn: <input type="text" name="fornavn" value="${skjema.fornavn}"/> ${skjema.fornavnFeilmelding}</p>
    <p>Etternavn: <input type="text" name="etternavn"  value="${skjema.etternavn}"/> ${skjema.etternavnFeilmelding}</p>
    <p>Mobil (8 siffer): <input type="text" name="mobil" value="${skjema.mobil}" /> ${skjema.mobilFeilmelding}</p>
    <p>Kjønn: 
    	<input type="radio" name="kjonn" value="false" <c:if test="${skjema.kjonn=='false'}"> checked="checked" </c:if>/>mann
        <input type="radio" name="kjonn" value="true" <c:if test="${skjema.kjonn=='true'}"> checked="checked" </c:if>/>kvinne 
        ${skjema.kjonnFeilmelding}
	</p> 
    <p><input type="submit" value="Meld meg på" /></p>
  </fieldset>
</form>
</body>
</html>