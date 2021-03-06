<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Prescription of Patient Page</title>

    <style type="text/css">
        <%@include file="/css/style.css"%>
    </style>
</head>
<body>
<%@include file="/pageFragments/header.html"%>
<%@include file="/pageFragments/nurse-nav.html"%>

<h1>Prescription of Patient List</h1>

<c:if test="${!empty listRprescriptions}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Patient lastname<br>firstname<br>surname</th>
            <th width="120">Doctor lastname<br>firstname<br>surname</th>
            <th width="120">Prescription name</th>
            <th width="120">Prescription date</th>
            <th width="120">Executed</th>
            <th width="60">Edit</th>
            <%--<th width="60">Delete</th>--%>
        </tr>
        <c:forEach items="${listRprescriptions}" var="rprescription">
            <tr>
                <td>${rprescription.id}</td>
                <td>${rprescription.receptions.patient.lastName}<br>
                        ${rprescription.receptions.patient.firstName}<br>
                        ${rprescription.receptions.patient.surName}</td>
                <td>${rprescription.receptions.user.lastName}<br>
                        ${rprescription.receptions.user.firstName}<br>
                        ${rprescription.receptions.user.surName}<br>
                <td>${rprescription.prescription.namePrescription}</td>
                <td>${rprescription.rprescriptionDate}</td>
                <td>${rprescription.executed ? "Executed" : ""}</td>
                <td><a href="<c:url value='/doctor/rprescriptions/edit/${rprescription.id}'/>">Edit</a></td>
                <%--<td><a href="<c:url value='/doctor/rprescriptions/remove/${rprescription.id}'/>">Delete</a></td>--%>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Patient prescription</h1>

<c:url var="addAction" value="/doctor/rprescriptions/add"/>
<form:form action="${addAction}" modelAttribute="rprescription">
    <table>
        <c:if test="${!empty rprescription.id}">
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
                <form:label path="receptions.id">
                    <spring:message text="Patient"/>
                </form:label>
            </td>
            <td>
                <form:select path="receptions.id">
                    <c:forEach items="${listHospitalizedReceptions}" var="reception">
                        <form:option value="${reception.id}">
                            ${reception.patient.lastName}&nbsp;${reception.patient.firstName}&nbsp;
                            ${reception.patient.surName}
                        </form:option>
                    </c:forEach>
                </form:select>
            </td>
        </tr>


        <tr>
            <td>
                <form:label path="prescription.id">
                    <spring:message text="Prescription"/>
                </form:label>
            </td>
            <td>
                <form:select path="prescription.id">
                    <c:forEach items="${listPrescriptions}" var="prescription">
                        <form:option value="${prescription.id}">
                            ${prescription.namePrescription}&nbsp;${prescription.typePrescription}
                        </form:option>
                    </c:forEach>
                </form:select>
            </td>
        </tr>


        <tr>
            <td>
                <form:label path="executed">
                    <spring:message text="Prescription execute"/>
                </form:label>
            </td>
            <td>
                <form:select path="executed">
                    <form:option value="true">Execute</form:option>
                    <form:option value="false">Not execute</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty rprescription.id}">
                    <input type="submit"
                           value="<spring:message text="Edit Patien prescription"/>"/>
                </c:if>
                <c:if test="${empty rprescription.id}">
                    <input type="submit"
                           value="<spring:message text="Add Patien prescription"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
