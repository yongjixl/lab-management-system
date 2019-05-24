<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
%>
<script type="text/javascript">
	// Web根路径
	var webRoot = '<%=(basePath + request.getContextPath())%>';
</script>

<script type="text/javascript" src="../../plugins/jquery/jquery-2.1.1.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="../../plugins/bootstrap/js/bootstrap.min.js" charset="UTF-8"></script>
