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
	         function binguanAdd()
	         {
	            var url="<%=path %>/admin/binguan/binguanAdd.jsp";
	            window.location.href=url;
	         }
	         function binguanDel(id)
	         {
	             if(confirm('您确定删除吗？'))
	             {
	                 window.location.href="<%=path %>/binguanDel.action?id="+id;
	             }
	         }
	         function kefangAdd(binguanId)
	         {
	            var url="<%=path %>/admin/kefang/kefangAdd.jsp?binguanId="+binguanId;
	            window.location.href=url;
	         }
	         
	         
	         function kefangMana(binguanId)
	         {
	            var url="<%=path %>/kefangMana.action?binguanId="+binguanId;
	            window.location.href=url;
	         }
           
       </script>
	</head>

	<body leftmargin="2" topmargin="2">
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="24">${requestScope.mingcheng}</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="4%">序号</td>
					<td width="16%">宾馆名称</td>
					<td width="16%">宾馆地址</td>
					<td width="16%">联系电话</td>
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.binguanList}" var="binguan" varStatus="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 ${ss.index+1}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${binguan.mingcheng}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${binguan.dizhi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${binguan.dianhua}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="删除" onclick="binguanDel(${binguan.id})"/>
						<input type="button" value="添加宾馆" onclick="kefangAdd(${binguan.id})"/>
						<input type="button" value="客房管理" onclick="kefangMana(${binguan.id})"/>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 8px;">
			  <tr>
			    <td>
			      <input type="button" value="添加宾馆" style="width: 130px;" onclick="binguanAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
