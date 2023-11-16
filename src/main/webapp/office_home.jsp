<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 08-Nov-23
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <style>
        body {
            background-color: #382933;
            color: #A4B494;
            padding: 3rem;
        }
        form {
            margin: 0;
        }
        .heading-container {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .heading-container h1 {
            font-size: 5rem;
        }
        .search-container {
            display: flex;
            align-items: center;
            gap: 1rem;
        }
        .search, .clear {
            display: flex;
        }
        .search form {
            display: flex;
            gap: 1rem;
        }
        .search label {
            display: flex;
            font-size: 2rem;
            gap: 1rem;
        }
        .search label > input {
            font-size: 1.5rem;
            border-radius: .25rem;
        }
        .submit-button {
            font-size: 1.5rem;
            padding: .25rem;
            border: .25rem solid #3B5249;
            border-radius: .75rem;
            background-color: #155920;
            color: #aeefbd;
            text-decoration: none;
        }
        .office-container {
            margin-top: 2rem;
            display: grid;
            grid-template-columns: 1fr 1fr 1fr 1fr;
            grid-gap: 1rem;
        }
        .office, .insert-office {
            padding: 1rem;
            height: 18rem;
            text-decoration: none;
            border: .5rem solid #3B5249;
            border-radius: .75rem;
            background-color: #519872;
            color: #dbe7ce;
        }
        .office-head {
            display: flex;
            justify-content: space-between;
        }
        .office-details-container {
            display: grid;
            margin-top: .75rem;
            grid-template-columns: 4fr 1fr;
            height: 12rem;
        }
        .office-button-container {
            display: grid;
            grid-template-rows: 1fr 1fr;
            grid-gap: 1rem;
        }
        .office-button {
            display: flex;
            justify-content: center;
            align-items: center;
            border-radius: .75rem;
            text-decoration: none;
            color: white;
        }
        .update {
            background-color: #8f9ae5;
        }
        .delete {
            background-color: #e39191;
        }
        .confirm {
            background-color: lightgreen;
        }
        .insert-office {
            display: flex;
            font-size: 2rem;
            justify-content: center;
            align-items: center;
        }
    </style>
</head>
<body>
<div class="heading-container">
    <h1>Office List</h1>
    <div class="search-container">
        <div class="search">
            <form action="office-home" method="post">
                <label>
                    Search :
                    <c:if test="${requestScope.search != null}">
                        <input type="text" name="search" placeholder="city, country and etc." value="${requestScope.search}">
                    </c:if>
                    <c:if test="${requestScope.search == null}">
                        <input type="text" name="search" placeholder="city, country and etc.">
                    </c:if>
                </label>
                <input type="submit" value="search" class="submit-button">
            </form>
        </div>
        <div class="clear">
            <form action="office-home?clear=OK" method="post">
                <input type="submit" value="clear" class="submit-button">
            </form>
        </div>
    </div>
</div>
<hr>
<div class="office-container">
    <c:forEach items="${requestScope.officeList}" var="office">
        <div class="office">
            <div class="office-head">
                <h1>${office.officeCode} ${office.city}</h1>
                <c:if test="${office.state != null && !office.state.equals('')}">
                    <h1>${office.state}, ${office.country}</h1>
                </c:if>
                <c:if test="${office.state == null || office.state.equals('')}">
                    <h1>${office.country}</h1>
                </c:if>
            </div>
            <hr>
            <div class="office-details-container">
                <div class="office-details">
                    <h2>${office.phone}</h2>
                    <h3>${office.addressLine1}</h3>
                    <c:if test="${office.addressLine2 != null}">
                        <h3>${office.addressLine2}</h3>
                    </c:if>
                    <h3>${office.postalCode}</h3>
                </div>
                <div class="office-button-container">
                    <a href="update-office?officeCode=${office.officeCode}" class="office-button update">Update</a>
                    <c:if test="${requestScope.deleteOffice == null || requestScope.deleteOffice != office.officeCode}">
                        <a href="delete-office?officeCode=${office.officeCode}" class="office-button delete">Delete</a>
                    </c:if>
                    <c:if test="${requestScope.deleteOffice != null && requestScope.deleteOffice == office.officeCode}">
                        <a href="delete-office?officeCode=${office.officeCode}&confirm=OK" class="office-button confirm">Confirm</a>
                    </c:if>
                </div>
            </div>
        </div>
    </c:forEach>
    <a class="insert-office" href="insert-office">
       <h1>+</h1>
    </a>
</div>
</body>
</html>
