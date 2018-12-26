<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Your Bucket</title>
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

<h1>Bucket</h1>

<c:if test="${!empty listMangas}">
    <table class="tg">
        <tr>
            <td width="80">ID</td>
            <td width="120">Name</td>
            <td width="120">Provider</td>
            <td width="120">Price</td>
            <td width="60">Remove</td>
        </tr>
        <c:forEach items="${listMangas}" var="manga">
            <tr>
                <td>${manga.id}</td>
                <td><a href="/mangadata/${manga.id}" target="_blank">${manga.name}</a></td>
                <td>${manga.provider}</td>
                <td>${manga.price/100}${manga.price%100}</td>
                <td><a href="<c:url value='/removeB/${manga.id}'/>">Remove</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add to Bucket</h1>
<c:if test="${!empty listMangas}">
    <table class="tg">
        <tr>
            <td width="80">ID</td>
            <td width="120">Name</td>
            <td width="120">Provider</td>
            <td width="120">Price</td>
            <td width="60">Add</td>
        </tr>
        <c:forEach items="${allListMangas}" var="manga">
            <tr>
                <td>${manga.id}</td>
                <td><a href="/mangadata/${manga.id}" target="_blank">${manga.name}</a></td>
                <td>${manga.provider}</td>
                <td>${manga.price/100}${manga.price%100}</td>
                <td><a href="<c:url value='/addB/${manga.id}'/>">Add</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
