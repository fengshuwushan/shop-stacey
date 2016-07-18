<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/7/18
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored ="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>用户列表Title</title>
</head>
<body>

    <c:forEach items="${userList}" var="user">
        订单号：${user.username }，订单总额：${user.password }<br />
    </c:forEach>
</body>
</html>
