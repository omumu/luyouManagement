<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
        
        <link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
        
        <script language="javascript">
          function toupiaoAdd(id){
          	window.location.href="<%=path %>/toupiaoAdd.action?eid="+id+"&acId="+${requestScope.acId};
          }
        </script>
	</head>

	<body leftMargin=0 topMargin=0 bgColor=#ffffff>
		<jsp:include flush="true" page="/qiantai/inc/incTop.jsp"></jsp:include>

		<table border=0 cellSpacing=0 cellPadding=0 width=772 bgColor=#ffffff align=center>
			<tr>
				<td class=b vAlign=top width=178>
					<jsp:include flush="true" page="/qiantai/inc/incLeft.jsp"></jsp:include>
				</td>


				<td width="1" bgcolor="#A9A9A9"></td>
				<td width="3" bgcolor="white"></td>
				<!-- 右部分-->
				<td class=b vAlign=top width=591 align=left>

					<input type="button" value="投票" onclick="toupiaoAdd(${requestScope.essay.id})"/>

					<form action="<%=path %>/essayAdd.action" name="formAdd" method="post">
						<table width="98%" align="center" border=0 cellSpacing=0 cellPadding=2 bgcolor="#CBD8AC" style="margin-bottom:8px">
							<tr align='center'>
								<td>
									标题：${requestScope.essay.biaoti}
								</td>
							</tr>
							<tr align='center'>
								<td>
									作者：${requestScope.essay.userId}
								</td>
							</tr>
							<tr align='center'>
								<td>
									发布时间：${requestScope.essay.fabusj}
								</td>
							</tr>
							<tr align='center'>
								<td>
									内容：${requestScope.essay.neirong}
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
		<table>
			<tr><td rowspan="5" width="1"></td></tr>
		</table>
		<jsp:include flush="true" page="/qiantai/inc/incFoot.jsp"></jsp:include>
	</body>
</html>
