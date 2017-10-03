<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <p>Fornavn: <input type="text" name="fornavn" value="${skjema.fornavn}"/>${skjema.fornavnFeilmelding}</p>
    <p>Etternavn: <input type="text" name="etternavn"  value="${skjema.etternavn}"/>${skjema.etternavnFeilmelding}</p>
    <p>Mobil (8 siffer): <input type="text" name="mobil" value="${skjema.mobil}" />${skjema.mobilFeilmelding}</p>
    <p>Kjønn: <input type="radio" name="kjonn" value="false" checked="checked" />mann
        <input type="radio" name="kjonn" value="true" />kvinne ${skjema.kjonnFeilmelding}</p>
    <p><input type="submit" value="Meld meg på" /></p>
  </fieldset>
</form>
</body>
</html>