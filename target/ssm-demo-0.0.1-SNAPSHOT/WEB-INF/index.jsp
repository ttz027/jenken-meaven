<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="../statics/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../js/plugins/angularjs/angular.min.js"></script>
<script type="text/javascript" src="../js/base.js"></script>
<script type="text/javascript" src="../js/service/itemService.js"></script>
<script type="text/javascript" src="../js/controller/itemController.js"></script>
</head>
<body ng-app="boot" ng-controller="itemController" ng-init="findAll()">
	<%
		String list = request.getParameter("list");
	%>
	<div id="a">ddddddd</div>
	${list }
	<br/>
	{{list}}
	<table>
		<tr ng-repeat="info in list">
			<td>{{allId[info.id]}}</td>
			<td>{{info.name}}</td>
		</tr>
	</table>
</body>
<script type="text/javascript">
// 	alert($("#a").html());
</script>
</html>