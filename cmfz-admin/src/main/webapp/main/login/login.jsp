<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page import="java.net.URLDecoder" %>

<head>
	<title>持名法州后台管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="<%=request.getContextPath()%>/img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css" type="text/css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/login.css" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/script/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/script/common.js"></script>
	<script type="text/javascript">
		$(function(){
			//点击更换验证码：
			$("#captchaImage").click(function() {
                $("#captchaImage").attr("src","<%=request.getContextPath()%>/admin/vcode?flag="+Math.random());
			});
		});

		function run() {
			var str = "${cookie.adminName.value}";
			var newstr = decodeURI(str,"utf-8");
			document.getElementById("user").value=newstr;
        }
	</script>
</head>
<body onload="run()">

		<div class="login">
			<form id="loginForm" action="<%=request.getContextPath()%>/admin/login" method="post" >
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="<%=request.getContextPath()%>/img/header_logo.gif" />
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input id="user" type="text"  name="adminName" class="text"  maxlength="20"/>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input type="password" name="adminPwd" class="text"  maxlength="20" autocomplete="off"/>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input type="text" id="enCode" name="enCode" class="text captcha" maxlength="4" autocomplete="off"/>
								<img id="captchaImage" class="captchaImage" src="<%=request.getContextPath()%>/admin/vcode" title="点击更换验证码"/>
							</td>
						</tr>					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
						<td>
							<label>
								<input type="checkbox" id="isRememberUsername" name="rember" /> 七天免登陆
							</label>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="submit" class="homeButton" value=""><input type="submit" class="loginButton" value="登录">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>