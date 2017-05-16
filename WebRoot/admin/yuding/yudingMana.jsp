<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<script type="text/javascript" src="<%=path %>/js/popup.js"></script>
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
        <script language="javascript">
           function yudingDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/yudingDel.action?id="+id;
               }
           }
           function yudingTY(id)
           {
             window.location.href="<%=path %>/yudingTY.action?id="+id; 
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2">
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="24">${sessionScope.binguanmingcheng}</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="4%">序号</td>
					<td width="10%">客房信息</td>
					<td width="10%">预定日期</td>
					<td width="10%">客户姓名</td>
					
					<td width="10%">联系方式</td>
					<td width="10%">备注信息</td>
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.yudingList}" var="yuding" varStatus="sta">
				<tr align='center' bgcolor="#FFFFFF">
					<td bgcolor="#FFFFFF" align="center">${sta.index+1}</td>
					<td bgcolor="#FFFFFF" align="center">${yuding.kefang.fangjianhao}</td>
					<td bgcolor="#FFFFFF" align="center">${yuding.riqi}</td>
					<td bgcolor="#FFFFFF" align="center">${yuding.kehuming}</td>
					
					<td bgcolor="#FFFFFF" align="center">${yuding.dianhua}</td>
					<td bgcolor="#FFFFFF" align="center">${yuding.beizhu}</td>
					<td bgcolor="#FFFFFF" align="center">
						<c:choose>
							<c:when test="${yuding.zhuangtai == '未确认'}">
								<input type="button" value="同意报名" onclick="yudingTY(${yuding.id})"/>
							</c:when>
						</c:choose>
					  <input type="button" value="删除" onclick="yudingDel(${yuding.id})"/>
				  </td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
