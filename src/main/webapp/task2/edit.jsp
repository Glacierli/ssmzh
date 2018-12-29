<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.censoft.login.entity.Userlogin"%>
<%
	Userlogin uu = (Userlogin) request.getAttribute("use");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href=" <%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改页面</title>
<link href="dist/css/bootstrap.min.css" rel="stylesheet">
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">
<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="assets/js/ie-emulation-modes-warning.js"></script>
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<style>
/*web background*/
.container {
	display: table;
	height: 100%;
}
.row {
	display: table-cell;
	vertical-align: middle;
}
/* centered columns styles */
.row-centered {
	text-align: center;
}
.col-centered {
	display: inline-block;
	float: none;
	text-align: left;
	margin-right: -4px;
}
.input-group-md {
	margin-top: 10px;
}
</style>
</head>
<body>
	<%
		String name = uu.getName();
		String pwd = uu.getPassworld();
		int id=uu.getId();
	%>
	<div class="container">
		<div class="row row-centered">
			<div class="well col-md-5 col-centered">
				<h2>修改</h2>
				<form id="form1" action="task2/editt.do" >
				<input name="id" id="id" value="<%=id%>" type="hidden"/>
					<div class="input-group input-group-md">
						<span class="input-group-addon" id="sizing-addon1"><i
							class="glyphicon glyphicon-user" aria-hidden="true"></i></span> <input
							type="text" class="form-control" id="userid" name="name"
							value="<%=name%>" placeholder="请输入用户ID" />
					</div>
					<div class="input-group input-group-md">
						<span class="input-group-addon" id="sizing-addon1"><i
							class="glyphicon glyphicon-lock"></i></span> <input type="password"
							class="form-control" id="pwd" name="passworld" value="<%=pwd%>"
							placeholder="请输入密码" />
					</div>
					<br />
						<button type="submit" class="btn btn-success btn-block">提交</button>
					</form>
			</div>
		</div>
	</div>
	
</body>
</html>