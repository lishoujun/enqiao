<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>恩桥网址之家</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script src="js/jquery-1.7.2.min.js"></script>
<jsp:include page="so360.jsp"></jsp:include>

<jsp:include page="/bg" />
<script language="javascript">
	function clickadd(id) {
		$.ajax({
			//	url : "/jae_deploy/nav/clickadd",
			url : "/clickadd",
			type : "POST",
			data : {
				id : id
			},
			dataType : "json",//返回json类型
			success : function(data) { // 返回data后的具体操作 
				//alert("The click's count has been increased 1");
			}
		});
	}
</script>
</head>
<body>
	<div id="main">
		<div id="so360">
			<form action="http://www.so.com/s" target="_blank" id="so360form">
				<input type="text" autocomplete="on" name="q" id="so360_keyword">
				<input type="submit" id="so360_submit" value="360 搜 索"> <input
					type="hidden" name="ie" value="utf8"> <input type="hidden"
					name="src" value="zz"> <input type="hidden" name="site"
					value="www.enqiao.cn"> <input type="hidden" name="rg"
					value="0">
			</form>
		</div>

		<jsp:include page="/showlinks" />
		<p id="w">我们的服务：</p>
		<a id="wa" href="bige.jsp">逼格</a> <a id="wa" href="jobmap.jsp">jobmap</a>
		<p id="wa">
			2013-2015 京ICP备13036464号-1<a id="wa" class="mailto"
				href="mailto:lsjun@aliyun.com">邮件联系</a> <a id="wa" href="log.jsp">变更记录</a>
		</p>
	</div>
</body>
</html>