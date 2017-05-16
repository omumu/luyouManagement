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
		
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
		
        <script language="javascript">
           function baomingDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/baomingDel.action?id="+id;
               }
           }
           function baomingTY(id)
           {
             window.location.href="<%=path %>/baomingTY.action?id="+id; 
           }
           function sheyuanDetail(id)
           {
               var url="<%=path %>/sheyuanDetail.action?id="+id;
               var ret = window.showModalDialog(url,"","dialogWidth:800px; dialogHeight:200px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
           }
        </script>
	</head>

	<body leftmargin="2" topmargin="2">
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="41">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="4%">序号</td>
					<td width="20%">联系方式</td>
					<td width="10%">备注信息</td>
					
					<td width="10%">报名时间</td>
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.baomingList}" var="baoming" varStatus="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 ${ss.index+1}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${baoming.lianxifangshi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${baoming.beizhu}
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						 ${baoming.baomingshi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<c:choose>
							<c:when test="${baoming.zhuangtai == '未确认'}">
								<input type="button" value="同意报名" onclick="baomingTY(${baoming.id})"/>
							</c:when>
						</c:choose>
						<input type="button" value="删除" onclick="baomingDel(${baoming.id})"/>
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
