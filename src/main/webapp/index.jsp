<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Hospital application</title>    <style type="text/css">
        <%@include file="/css/style.css"%>
    </style>

    </head>

    <body>
    <%@include file="/pageFragments/header.html"%>
    <%@include file="/pageFragments/nurse-nav.html"%>
        <h1>Hospital application by Viarzilin Mikalai</h1>

    <p>Система Больница. Врач определяет диагноз, делает назначение Пациенту
        (процедуры, лекарства, операции).</p>
    <p>Назначение может выполнить Медсестра (процедуры, лекарства) или Врач (любое назначение). </p>
    <p>Пациент может быть выписан из Больницы, при этом фиксируется окончательный диагноз.</p>
        <br/>
    <br/>
    <br/>
        <a href="<c:url value="/doctor/prescriptions"/>" target="_blank">Prescriptions list</a>
        <br/>
        <a href="<c:url value="/general/patients"/>" target="_blank">Patients list</a>
        <br/>
        <a href="<c:url value="/admin/users"/>" target="_blank">Users list</a>
        <br/>
        <a href="<c:url value="/doctor/rprescriptions"/>" target="_blank">Patient prescriptions</a>
        <br/>
        <a href="<c:url value="/doctor/all-patient-receptions"/>" target="_blank">Doctors receptions list</a>
        <br/>
        <a href="<c:url value="/nurse/hospitalized-receptions"/>" target="_blank">Nurse receptions list</a>
        <%@include file="/pageFragments/footer.html"%>
    </body>
</html>
