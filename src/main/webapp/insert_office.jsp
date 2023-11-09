<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 06-Nov-23
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create</title>
    <style>
      body {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        background-color: aqua;
        color: deeppink;
        padding: 3rem;
      }
      .heading {
        font-size: 5rem;
      }
      .error {
        font-size: 1rem;
        font-weight: bold;
        color: red;
      }
      .insert-form {
        display: flex;
        flex-direction: column;
        align-items: center;
        padding: 3rem;
        gap: 2rem;
        border: 1px solid blue;
        border-radius: .75rem;
        background-color: indigo;
      }
      .insert-form label {
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
      .submit input {
        font-size: 1.5rem;
        padding: 1rem;
        background-color: green;
        color: yellow;
      }
    </style>
</head>
<body>
<div>

</div>
<div class="page-container">
  <h1 class="heading">Office Form</h1>
  <div class="insert-form">
    <c:if test="${requestScope.error != null}">
      <p class="error">${requestScope.error}</p>
    </c:if>
    <form method="post" action="insert-office">
      <label>
        Office code
        <input type="text" name="officeCode" placeholder="required">
      </label>
      <br>
      <label>
        City
        <input type="text" name="city" placeholder="required">
      </label>
      <br>
      <label>
        Phone
        <input type="text" name="phone" placeholder="required">
      </label>
      <br>
      <label>
        Address line1
        <input type="text" name="addressLine1" placeholder="required">
      </label>
      <br>
      <label>
        Address line2
        <input type="text" name="addressLine2" placeholder="not required">
      </label>
      <br>
      <label>
        State
        <input type="text" name="state" placeholder="not required">
      </label>
      <br>
      <label>
        Country
        <input type="text" name="country" placeholder="required">
      </label>
      <br>
      <label>
        Postal code
        <input type="text" name="postalCode" placeholder="required">
      </label>
      <br>
      <label>
        Territory
        <input type="text" name="territory" placeholder="required">
      </label>
      <br>
      <div class="submit">
        <input type="submit" value="Confirm">
      </div>
    </form>
  </div>
</div>

</body>
</html>
