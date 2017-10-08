<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kasserer login</title>
</head>
<body>
<h2>Kasserer login</h2>
<form action="adminlogin" method="post">
  <fieldset>
    <legend>Kasserer login</legend>
    <p>Passord: <input type="password" name="password" /><font color="red">
     <c:if test="${param.invalidPassword ne null}"> Feil passord </c:if>
     <c:if test="${param.requiresLogin ne null}"> Kun for kasserer </c:if>
     
     </font></p>
    <p><input type="submit" value="Logg inn" /></p>
  </fieldset>
</form>

</body>
</html>