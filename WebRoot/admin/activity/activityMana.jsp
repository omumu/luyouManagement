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
           function activityAdd()
           {
              var url="<%=path %>/admin/activity/activityAdd.jsp";
              window.location.href=url;
           }
           
           function activityDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/activityDel.action?id="+id;
               }
           }

           function activityDetail(id)
           {
              var url="<%=path %>/activityDetail.action?page=1&id="+id;
              window.location.href=url;
           }
           
       </script>
	</head>

	<body leftmargin="2" topmargin="2">
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 8px;">
			  <tr>
			    <td>
			      <input type="button" value="添加活动" style="width: 120px;" onclick="activityAdd()" />
			    </td>
			  </tr>
		  </table>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="4">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
				  <td width="5%">序号</td>
					<td width="30%">标题</td>
					<td width="10%">开始时间</td>
					<td width="10%">结束时间</td>
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.activityList}" var="activity" varStatus="s">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 ${s.index+1}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${activity.zhuti}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${activity.kaishisj}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${activity.jieshusj}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="详情" onclick="activityDetail(${activity.id})"/>
						<input type="button" value="删除" onclick="activityDel(${activity.id})"/>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			
	</body>
</html>
