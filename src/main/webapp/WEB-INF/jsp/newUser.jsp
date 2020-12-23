<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style>
        #wrap{
            width:530px;
            margin-left:auto;
            margin-right:auto;
            text-align:center;
        }

        table{
            border:3px solid;
            width: 600px;
            height: 200px;
        }

        td{
            border:1px solid lightgrey;
            font-size: 20px;
        }
        #inputDec{
            text-align:center;
            width:200px; height:50px;
        }

        #title{
            background-color:lightgrey;
        }
    </style>
</head>
<body>
<div id="wrap">
    <br><br>
    <b><font size="8" color="gray">Registration</font></b>
    <br><br><br>
    <form:form action="/addNewUser" method="post" modelAttribute="user">
        <table border="1" width="500" cellpadding="5" cellspacing="0">
            <tr>
                <td id="title">Frist Name</td>
                <td id="inputDec">
                    <form:input path="firstName" size="20" />
                    <form:errors path="firstName" cssClass="error" cssStyle="color: red" />
                </td>
                <td id="title">Last Name</td>
                <td id="inputDec">
                    <form:input path="lastName" size="20" />
                    <form:errors path="lastName" cssClass="error" cssStyle="color: red" />
                </td>
            </tr>
            <tr>
                <td id="title">Address</td>
                <td id="inputDec">
                    <form:input path="address" size="10"/>
                    <form:errors path="address" cssClass="error" cssStyle="color: red" />
                </td>
            </tr>
            <tr>
                <td id="title">Email</td>
                <td id="inputDec">
                    <form:input path="email" size="20" />
                    <form:errors path="email" cssClass="error" cssStyle="color: red" />
                </td>
            </tr>
            <tr>
                <td id="title">Password</td>
                <td id="inputDec">
                    <form:password path="password" size="40" />
                    <form:errors path="password" cssClass="error" cssStyle="color: red"  />
                </td>
            </tr>
            <tr>
                <td id="title">Confirm Password</td>
                <td id="inputDec">
                    <form:password path="confirmPassword" size="40" />
                    <form:errors path="confirmPassword" cssClass="error" cssStyle="color: red"  />
                </td>
            </tr>
        </table>
        <br>
        <label><input type="checkbox" name="agree" maxlength="30" >I agree to the terms of service</label>
        <br>
        <form:errors path="agree" cssClass="error" cssStyle="color: red" />
        <br>
        <br>
        <input id="inputDec" type="submit" value="register"/>  <input id="inputDec" type="button" value="cancel">
    </form:form>
</div>
</body>
</html>
