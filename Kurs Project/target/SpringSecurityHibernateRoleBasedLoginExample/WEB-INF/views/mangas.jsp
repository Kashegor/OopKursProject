<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Mangas</title>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="<c:url value="/logout" />">Logout</a>
<br/>
<br/>

<h1>Equipment list</h1>

<c:if test="${!empty listMangas}">
    <table class="tg">
        <tr>
            <td width="80">ID</td>
            <td width="120">Name</td>
            <td width="120">Provider</td>
            <td width="120">Price</td>
            <td width="60">Edit</td>
            <td width="60">Delete</td>
        </tr>
        <c:forEach items="${listMangas}" var="manga">
        <tr>
            <td>${manga.id}</td>
            <td><a href="/mangadata/${manga.id}" target="_blank">${manga.name}</a></td>
            <td>${manga.provider}</td>
            <td>${manga.price/100}${manga.price%100}</td>
            <td><a href="<c:url value='/edit/${manga.id}'/>">Edit</a></td>
            <td><a href="<c:url value='/remove/${manga.id}'/>">Delete</a></td>
        </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add a new equipment</h1>

<c:url var="addAction" value="/mangas/add"/>

    <form:form action="${addAction}" commandName="manga">
        <table>
            <c:if test="${!empty manga.name}">
                <tr>
                    <td>
                        <form:label path="id">
                            <spring:message text="ID"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="id" readonly="true" size="8" disabled="true"/>
                        <form:hidden path="id"/>
                    </td>
                </tr>
            </c:if>
            <tr>
                <td>
                    <form:label path="name">
                        <spring:message text="Name"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="name"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="Provider">
                        <spring:message text="Provider"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="provider"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="price">
                        <spring:message text="Price"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="price"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="Description">
                        <spring:message text="Description"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="description"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <c:if test="${!empty manga.name}">
                        <input type="submit"
                               value="<spring:message text="Edit Equipment"/>"/>
                    </c:if>
                    <c:if test="${empty manga.name}">
                        <input type="submit"
                               value="<spring:message text="Add Equipment"/>"/>
                    </c:if>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
