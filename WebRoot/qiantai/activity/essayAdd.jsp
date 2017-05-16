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
        <script src="<%=path %>/ckeditor/ckeditor.js"></script>
        
        <script language="javascript">
            function c()
            {
                if(document.formAdd.biaoti.value=="")
                {
                    alert("请输入标题");
                    return false;
                }
                if(document.formAdd.neirong.value=="")
                {
                    alert("请输入内容");
                    return false;
                }
                document.formAdd.submit();
            }
        </script>
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/img/allbg.gif'>
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

					<form action="<%=path %>/essayAdd.action" name="formAdd" method="post">
						<table width="580" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
							<tr bgcolor="#EEF4EA">
								<td colspan="3" background="<%=path %>/img/wbg.gif" class='title'><span>&nbsp;</span></td>
							</tr>
							<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
								<td width="80px" bgcolor="#FFFFFF" align="right">
									标题：
								</td>
								<td width="500px" bgcolor="#FFFFFF" align="left">
									<input type="text" name="biaoti" size="110"/>
								</td>
							</tr>
							<tr display="none">
								<td width="80px" bgcolor="#FFFFFF" align="right">
									活动Id：
								</td>
								<td width="500px" bgcolor="#FFFFFF" align="left">
									<input type="text" name="acId" size="110" value="${requestScope.activity.id}"/>
								</td>
							</tr>
							<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
								<td width="80px" bgcolor="#FFFFFF" align="right">
									内容：
								</td>
								<td width="500px" bgcolor="#FFFFFF" align="left">
									<textarea width="100%" name="neirong" id="neirong" rows="15" cols="80">
									</textarea>
									<script>
										CKEDITOR.replace( 'neirong' );
									</script>
								</td>
							</tr>
							<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
								<td width="80px" bgcolor="#FFFFFF" align="right">
									&nbsp;
								</td>
								<td width="500px" bgcolor="#FFFFFF" align="left">
									<input type="button" value="提交" onclick="c()"/>&nbsp; 
									<input type="reset" value="重置"/>&nbsp;
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
