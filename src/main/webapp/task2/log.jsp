<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.censoft.login.entity.Log"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*"%>
<%

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href=" <%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link href="dist/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">
<script src="assets/js/ie-emulation-modes-warning.js"></script>
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	       <style>
            /*web background*/
            .container{
                display:table;
                height:100%;
            }

            .row{
                display: table-cell;
                vertical-align: middle;
            }
            /* centered columns styles */
            .row-centered {
                text-align:center;
            }
            .col-centered {
                display:inline-block;
                float:none;
                text-align:left;
                margin-right:-4px;
            }
            .input-group-md{
            margin-top: 10px;
            }
        </style>
</head>
<body>
<table class="table table-bordered table-striped">
		<h2>日志管理 &nbsp;|&nbsp;
		<a href="task2/demo.do" class="btn-delete" "><font>回到demo页</font></a></h2>
		<hr />
		<tr>		
			<th class="text-center">用户编号</th>
			<th class="text-center">被操作u</th>
			<th class="text-center">被操作p</th>
			<th class="text-center">时间</th>
			<th class="text-center">操作类型</th>
			<th class="text-center">日志操作</th>
		</tr>
		<!--前台显示的时候的序号  -->
		<c:forEach items="${log}" var="sj"  varStatus="status">
			<tr>
				<td>${status.index + 1}</td> 
				
				<input name="id" id="id" value="${ sj.id }" type="hidden"/>
				<%-- <a type="hidden" href="view?id=${ sj.id }" data-target="#large"
									data-toggle="modal"><nobr>${ sj.id }</nobr></a> --%>
				<td>${ sj.name }</td>
				<td>${ sj.password }</td>
				
				<td>${ sj.shijian }</td>
				<c:if test="${'0' eq sj.cz }">
					<td>编辑</td>
				</c:if>
				<c:if test="${'1' eq sj.cz }">
					<td>删除</td>
				</c:if>
				<c:if test="${'2' eq sj.cz }">
					<td>login</td>
				</c:if>
				
				</td>
				<td>&nbsp;|&nbsp;
				<a href="task2/dellog.do?id=${ sj.id } " class="btn-delete" data-code="${ sj.id }"><font>删除</font></a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="task2/createExcel.do" class="btn btn-default btn-lg" role="button">导出日志</a>
<script type="text/javascript">
</script>

	<%-- <%
		String name = uu.getName();
		String pwd = uu.getPassworld();
	%>
	<ul class="list-group">
		<li class="list-group-item"><%=name%>:欢迎你</li>
		<li class="list-group-item">密码为：<%=pwd%></li>
		<button type="button" class="btn btn-default">
			<a href="task2/logintwo.jsp">注销</a>
		<button type="button" class="btn btn-default">
			<a href="task2/edit.do">编辑</a>
	</ul> --%>
<!-- 	<div>
		模态框（Modal）
		<div class="modal fade " id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" >
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h5 class="modal-title" id="myModalLabel">编辑页</h5>
					</div>
					<div class="modal-body ">
				action="${pageContext.request.contextPath}/task2/show.do" 	
						 <form id="form1" >
                        <div class="input-group input-group-md">
                            <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" id="username" name="name" placeholder="请输入用户ID"/>
                        </div>
                        <div class="input-group input-group-md">
                            <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-lock"></i></span>
                            <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码"/>
                        </div>
                        <br/>
                       <button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button type="submit" class="btn btn-default" onclick="login">提交更改</button>
                    </form:form>
					</div>
					<div class="modal-footer">
						
					</div>
				</div>
				/.modal-content
			</div>
			/.modal
		</div>
	</div> -->
</body>
</html>