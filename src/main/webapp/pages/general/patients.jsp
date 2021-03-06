<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title>Patients Page</title>

    <style type="text/css">
        <%@include file="/css/style.css"%>
    </style>
</head>
<body>
<%@include file="/pageFragments/header.html"%>
<%@include file="/pageFragments/nurse-nav.html"%>
<h1>Patient List</h1>
<c:if test="${!empty listPatients}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Lastname</th>
            <th width="120">Firstname</th>
            <th width="120">Surname</th>
            <%--<th width="120">Birth Date</th>--%>
            <th width="120">Adress</th>
            <th width="120">Create date</th>
            <th width="120">Update date</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listPatients}" var="patient">
            <tr>
                <td>${patient.id}</td>
                <td>${patient.lastName}</td>
                <td>${patient.firstName}</td>
                <td>${patient.surName}</td>
                <%--<td>${patient.birthDate}</td>--%>
                <td>${patient.adress}</td>
                <td>${patient.createDate}</td>
                <td>${patient.updateDate}</td>
                <td><a href="<c:url value='/general/patients/edit/${patient.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/general/patients/remove/${patient.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Patient</h1>

<c:url var="addAction" value="/general/patients/add"/>
<form:form action="${addAction}" modelAttribute="patient">
    <table>
        <c:if test="${!empty patient.lastName}">
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
                <form:label path="lastName">
                    <spring:message text="Lastname"/>
                </form:label>
            </td>
            <td>
                <form:input path="lastName" required="required"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="firstName">
                    <spring:message text="Firstname"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstName" required="required"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="surName">
                    <spring:message text="SurName"/>
                </form:label>
            </td>
            <td>
                <form:input path="surName"  required="required"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="adress">
                    <spring:message text="Adress"/>
                </form:label>
            </td>
            <td>
                <form:input path="adress"  required="required"/>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <c:if test="${!empty patient.lastName}">
                    <input type="submit"
                           value="<spring:message text="Edit Patient"/>"/>
                </c:if>
                <c:if test="${empty patient.lastName}">
                    <input type="submit"
                           value="<spring:message text="Add Patient"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>


<%--<h1>Add a Reception</h1>--%>

<%--<c:url var="addAction2" value="/general/patients/receptions/add"/>--%>
<%--<form:form action="${addAction2}" modelAttribute="reception">--%>
    <%--<table>--%>

        <%--<c:if test="${!empty reception.preliminaryDiagnosis}">--%>
            <%--<tr>--%>
                <%--<td>--%>
                    <%--<form:label path="id">--%>
                        <%--<spring:message text="ID"/>--%>
                    <%--</form:label>--%>
                <%--</td>--%>
                <%--<td>--%>
                    <%--<form:input path="id" readonly="true" size="8" disabled="true"/>--%>
                    <%--<form:hidden path="id"/>--%>
                <%--</td>--%>
            <%--</tr>--%>
        <%--</c:if>--%>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<form:label path="preliminaryDiagnosis">--%>
                    <%--<spring:message text="PreliminaryDiagnosis"/>--%>
                <%--</form:label>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<form:input path="preliminaryDiagnosis"/>--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<form:label path="discharge">--%>
                    <%--<spring:message text="Patient discharge"/>--%>
                <%--</form:label>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<form:select path="discharge">--%>
                    <%--<form:option value="true">Discharge</form:option>--%>
                    <%--<form:option value="false">Not discharge</form:option>--%>
                <%--</form:select>--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<form:label path="finalDiagnosis">--%>
                    <%--<spring:message text="FinalDiagnosis"/>--%>
                <%--</form:label>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<form:input path="finalDiagnosis"/>--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td colspan="2">--%>
                <%--<c:if test="${!empty reception.preliminaryDiagnosis}">--%>
                    <%--<input type="submit"--%>
                           <%--value="<spring:message text="Edit Reception"/>"/>--%>
                <%--</c:if>--%>
                <%--<c:if test="${empty reception.preliminaryDiagnosis}">--%>
                    <%--<input type="submit"--%>
                           <%--value="<spring:message text="Add Reception"/>"/>--%>
                <%--</c:if>--%>
            <%--</td>--%>
        <%--</tr>--%>
    <%--</table>--%>
<%--</form:form>--%>

<%@include file="/pageFragments/footer.html"%>
</body>
</html>
