<%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 17/11/2022
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.response.contextPath/resources/css/style.css}"/>

</head>
<body>
        <!-- the head of the table starts here -->
    <div id="wrapper">
        <div id="header">
            <h2>CRM- Customer Relationship Manager</h2>
        </div>
    </div>
        <!-- put a new button: Add customer -->
        <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;"
        class="add-button"/>
        <!-- the header ends here -->

        <div id="container">
            <div id="content">
                <!-- add out html table -->
                <table>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Action</th>
                    </tr>
                    <!-- loop over and print our customer -->
                <c:forEach var="customer" items="${customers}">
                    <!-- Construct an update link with customer id -->
                    <c:url var="updateLink" value="/customer/showFormUpdate">
                        <c:param name="customerId" value="${customer.id}"/>
                    </c:url>

                    <!--Construct a delete link base  -->
                    <c:url var="deleteLink" value="/customer/delete">
                        <c:param name="customerId" value="${customer.id}"/>
                    </c:url>


                    <tr>
                        <td>${customer.firstName}</td>
                        <td>${customer.lastName}</td>
                        <td>${customer.email}</td>
                        <td>
                            <!-- display the update link -->
                            <a href="${updateLink}">Update </a>
                            |
                            <a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this customer?')))return false">Delete</a>
                        </td>
                        <td></td>
                    </tr>

                </c:forEach>
                </table>


            </div>
        </div>
  </body>
</html>
