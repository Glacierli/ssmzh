<%@page import="com.sun.org.apache.bcel.internal.generic.NEW"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户登录</title>
<link href="../dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link href="../assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">
<script src="../assets/js/ie-emulation-modes-warning.js"></script>
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
	<div class="container">
		<div class="row row-centered">
			<div class="well col-md-5 col-centered">
				<h2>欢迎登录</h2>
				<form action="push.do" method="get" id="form">
					<div class="input-group input-group-md">
						<span class="input-group-addon" id="sizing-addon1"><i
							class="glyphicon glyphicon-user" aria-hidden="true"></i></span> 
							<input type="text" class="form-control" id="userid" name="name"
							placeholder="请输入用户ID" />
					</div>
					<div class="input-group input-group-md">
						<span class="input-group-addon" id="sizing-addon1"><i
							class="glyphicon glyphicon-lock"></i></span> 
							<input type="password"class="form-control" id="pwd" name="password"
							placeholder="请输入密码" />
					</div>
					<br />
					<button type="submit" class="btn btn-success btn-block">登录</button>
					</form:form>
			</div>
		</div>
	</div>
	<script>
	</script>
</body>
</html>
