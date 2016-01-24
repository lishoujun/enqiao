<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style type="text/css">
#so360 {
	white-space: nowrap
}

#so360 form {
	margin: 0;
	padding: 0
}

#so360_keyword {
	width: 387px;
	height: 32px;
	line-height: 32px;
	font: 14px arial;
	padding: 2px 5px;
	margin-right: 5px;
	border: 2px solid #ffffff;
	outline: 0;
	vertical-align: middle
}

#so360_submit {
	width: 90px;
	height: 40px;
	border: 0;
	color: #3ab9fe;
	background: #ffffff;
	
	font:  14px arial;
	padding: 0;
	padding-top: 3px\9;
	cursor: pointer;
	vertical-align: middle
}
</style>

<script type="text/javascript">
	(function() {
		function $(id) {
			return document.getElementById(id);
		}
		function addEvent(node, type, fn) {
			if (node.addEventListener) {
				node.addEventListener(type, fn, false);
			} else if (node.attachEvent) {
				node.attachEvent("on" + type, fn);
			} else {
				node["on" + type] = fn;
			}
		}
		;
		var form = $("so360form");
		if (!form) {
			return;
		}
		addEvent(form, "submit", function() {
			form.src.value = "zz_" + window.location.host.replace(/\./g, "_");
			return true;
		});
	})();
</script>