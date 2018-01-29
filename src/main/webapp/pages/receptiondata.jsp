<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>ReceptionData</title>

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
<h1>Reception Details</h1>

<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Preliminary diagnosis</th>
        <th width="120">Reception date</th>
        <th width="120">IsDischarge</th>
        <th width="120">Final diagnosis</th>
        <th width="120">Discharge date</th>
    </tr>
    <tr>
        <td>${reception.id}</td>
        <td>${reception.preliminaryDiagnosis}</td>
        <td>${reception.receptionDate}</td>
        <td>${reception.discharge}</td>
        <td>${reception.finalDiagnosis}</td>
        <td>${reception.dischargeDate}</td>
    </tr>
</table>
</body>
</html>