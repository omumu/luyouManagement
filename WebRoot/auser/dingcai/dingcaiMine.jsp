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
           function dingcaiDel(id)
           {
               if(confirm('您确定取消报名吗？'))
               {
                   window.location.href="<%=path %>/dingcaiDel.action?id="+id;
               }
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
					<td width="10%">酒店</td>
					<td width="10%">菜品</td>
					<td width="10%">数量</td>
					<td width="10%">联系人</td>
					
					<td width="10%">联系方式</td>
					<td width="10%">送菜地址</td>
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.dingcaiList}" var="dingcai" varStatus="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 ${ss.index+1}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${dingcai.jiudian.mingcheng}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${dingcai.goods.goodsName}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${dingcai.shuliang}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${dingcai.xingming}
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						 ${dingcai.lianxi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${dingcai.dizhi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="取消" onclick="dingcaiDel(${dingcai.id})"/>
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
