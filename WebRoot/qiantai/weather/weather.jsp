<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<%=path %>/css/weather.css"/>
    
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
            <header>
                <h1>WEATHER</h1>
                <div id="weather_search">
                    <span><input id="text" type="text" placeholder="请输入您要查询的城市" /></span>
                    <span><input id="btn" type="button" value=" 查询天气" /></span>
                </div>
            </header>
            <section>
                <div id="today_container">
                    <div>
                        <img src="./images/weather_icon/1.png" alt="今日天气"/>
                    </div>
                    <div>
                        <div class="main_info"><span class="info">城市</span>|<span class="info">201X-XX-XX</span>|<span class="info">星期X</span>|<span class="info">---</span> </div>
                        <div class="more_info">今日温度：<span class="info">-----</span>风力：<span class="info">-----</span>风向：<span class="info">-----</span>PM2.5：<span class="info">--</span></div>
                        <div class="more_info">紫外线强度：<span class="info">---</span>洗车指数：<span class="info">---</span>感冒指数：<span class="info">---</span>穿衣指数：<span class="info">---</span></div>
                    </div>
                </div>
                <div id="future_container">
                    <div class="future_box">
                        <img src="./images/weather_icon/1.png" alt="天气"/>
                        <span class="future_info">201X-XX-XX</span>
                        <span class="future_info">星期X</span>
                        <span class="future_info">--</span><span class="future_info">12-16℃</span>
                    </div>
                    <div class="future_box">
                        <img src="./images/weather_icon/3.png" alt="天气"/>
                        <span class="future_info">201X-XX-XX</span>
                        <span class="future_info">星期X</span>
                        <span class="future_info">--</span><span class="future_info">12-16℃</span>
                    </div>
                    <div class="future_box">
                        <img src="./images/weather_icon/2.png" alt="天气"/>
                        <span class="future_info">201X-XX-XX</span>
                        <span class="future_info">星期X</span>
                        <span class="future_info">--</span><span class="future_info">12-16℃</span>
                    </div>
                    <div class="future_box">
                        <img src="./images/weather_icon/4.png" alt="天气"/>
                        <span class="future_info">201X-XX-XX</span>
                        <span class="future_info">星期X</span>
                        <span class="future_info">--</span><span class="future_info">12-16℃</span>
                    </div>
                    <div class="future_box">
                        <img src="./images/weather_icon/5.png" alt="天气"/>
                        <span class="future_info">201X-XX-XX</span>
                        <span class="future_info">星期X</span>
                        <span class="future_info">-</span><span class="future_info">12-16℃</span>
                    </div>
                </div>
            </section>

    
        </td>
    </tr>
</table>
<table>
  <tr><td rowspan="5" width="1"></td></tr>
</table>
<jsp:include flush="true" page="/qiantai/inc/incFoot.jsp"></jsp:include>
<script src="<%=path %>/js/weather.js"></script>
</body>
</html>