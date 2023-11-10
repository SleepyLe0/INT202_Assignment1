<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09-Nov-23
  Time: 1:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Update</title>
  <style>
    body {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      background-color: #382933;
      color: #A4B494;
      padding: 3rem;
    }
    .heading {
      font-size: 5rem;
    }
    .update-form {
      display: flex;
      flex-direction: column;
      align-items: center;
      padding: 3rem;
      gap: 2rem;
      border: .5rem solid #3B5249;
      border-radius: .75rem;
      background-color: #519872;
      color: #dbe7ce;
    }
    .update-form label {
      display: flex;
      gap: 1rem;
      justify-content: space-between;
      font-size: 1.5rem;
    }
    .submit {
      margin-top: 2rem;
      display: flex;
      justify-content: center;
      align-items: center;
    }
    .submit input, .cancel a {
      font-size: 1.5rem;
      padding: 1rem;
      border: .25rem solid #3B5249;
      border-radius: .75rem;
      background-color: #155920;
      color: #aeefbd;
      text-decoration: none;
    }
    .cancel {
      width: 100%;
      display: flex;
      justify-content: end;
    }
  </style>
</head>
<body>
<div class="cancel">
  <a href="update-office?cancel=OK">Back</a>
</div>
<h1 class="heading">Office# ${requestScope.updateOffice.officeCode}</h1>
<div class="update-form">
  <form method="post" action="update-office?officeCode=${requestScope.updateOffice.officeCode}">
    <label>
      City
      <input type="text" name="city" placeholder="${requestScope.updateOffice.city}">
    </label>
    <br>
    <label>
      Phone
      <input type="text" name="phone" placeholder="${requestScope.updateOffice.phone}">
    </label>
    <br>
    <label>
      Address line1
      <input type="text" name="addressLine1" placeholder="${requestScope.updateOffice.addressLine1}">
    </label>
    <br>
    <label>
      Address line2
      <input type="text" name="addressLine2" placeholder="${requestScope.updateOffice.addressLine2}">
    </label>
    <br>
    <label>
      State
      <input type="text" name="state" placeholder="${requestScope.updateOffice.state}">
    </label>
    <br>
    <label>
      Country
      <input type="text" name="country" placeholder="${requestScope.updateOffice.country}">
    </label>
    <br>
    <label>
      Postal code
      <input type="text" name="postalCode" placeholder="${requestScope.updateOffice.postalCode}">
    </label>
    <br>
    <label>
      Territory
      <input type="text" name="territory" placeholder="${requestScope.updateOffice.territory}">
    </label>
    <br>
    <div class="submit">
      <input type="submit" value="Confirm">
    </div>
  </form>
</div>
</body>
</html>
