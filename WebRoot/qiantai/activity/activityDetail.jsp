<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="s" uri="/struts-tags"%>
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
        	function getUrlVars(){  
				    var vars = [], hash;  
				    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');  
				    for(var i = 0; i < hashes.length; i++)  
				    {  
				      hash = hashes[i].split('=');  
				      vars.push(hash[0]);  
				      vars[hash[0]] = hash[1];  
				    }  
				    return vars;  
				  } 
				  function getUrlVar(name){  
				    return getUrlVars()[name];  
				  }
				  function nextPage()
          {
           	var page = getUrlVar(page);
				  	if (page < ${requestScope.pageCount} || ${requestScope.pageCount} > 1) {
				  		var url="<%=path %>activityDetail.action?page="+(page+1);
            	window.location.href=url;
				  	}else{
							alert("没有更多的数据！")
				  		return false;
				  	}
          }

          function lastPage()
          {
           	var page = getUrlVar(page);
				  	if ( page > 1 && ${requestScope.pageCount} > 1) {
				  		var url="<%=path %>activityDetail.action?page="+(page-1);
            	window.location.href=url;
				  	}else{
							alert("没有更多的数据！")
				  		return false;
				  	}
          }
          function essayAdd(id)
          { 
           	window.location.href="<%=path %>/qiantai/activity/essayAdd.jsp";
           } 
          function essayDetail(id)
          { 
           	window.location.href="<%=path %>/essayDetail.action?id="+id+"&acId="+${requestScope.activity.id};
          }
          function toupiaoAdd(eid){
          	window.location.href="<%=path %>/toupiaoAdd.action?eId="+eid+"&acId="+${requestScope.activity.id};
          }
       </script>
	</head>

	<body leftmargin="2" topmargin="2">
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

					<table width='98%'  border='0'style="margin-top:8px;margin-left: 8px;">
						<tr>
							<td>
								<input type="button" value="参与活动" style="width: 120px;" onclick="essayAdd()" />
							</td>
						</tr>
					</table>
					<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
						<tr bgcolor="#E7E7E7">
							<td height="14" colspan="4" background="<%=path %>/img/tbg.gif">&nbsp;&nbsp;</td>
						</tr>
						<tr align="center" bgcolor="#FAFAF1" height="22">
							<td width="5%">序号</td>
							<td width="30%">标题</td>
							<td width="10%">作者</td>
							<td width="10%">发布时间</td>
							<td width="10%">票数</td>
							<td width="10%">操作</td>
						</tr>	

						<s:iterator value="#request.essayList" id="obj" status="s">
							<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
								<td bgcolor="#FFFFFF" align="center">
									${s.index+1}
								</td>
								<td bgcolor="#FFFFFF" align="center">
									${obj[1]}
								</td>
								<td bgcolor="#FFFFFF" align="center">
									${obj[5]}
								</td>
								<td bgcolor="#FFFFFF" align="center">
									${obj[3]}
								</td>
								<td bgcolor="#FFFFFF" align="center">
									${obj[4]}
								</td>
								<td bgcolor="#FFFFFF" align="center">
									<input type="button" value="详情" onclick="essayDetail(${obj[0]})"/>
									<input type="button" value="投票" onclick="toupiaoAdd(${obj[0]})"/>
								</td>
							</tr>
						</s:iterator>
					</table>
					<table>
						<tr>
							<td><input type="button" value="上一页" onclick="lastPage()"/></td>
							<td><input type="button" value="下一页" onclick="nextPage()"/></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	<table>
		<tr><td rowspan="5" width="1"></td></tr>
	</table>
	<jsp:include flush="true" page="/qiantai/inc/incFoot.jsp"></jsp:include>
			
	</body>
</html>
