<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Leezhenhao
  Date: 2019/05/31
  Time: 16:24:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>空气质量维护页面</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<br/>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h1 class="text-center">
                空气质量维护信息
            </h1>
            <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/air/update" method="POST">

                <input type="hidden" name="id" value="${air.id}">
                <%--发送PUT请求--%>
                <input type="hidden" name="_method" value="PUT">

                <div class="form-group">
                    <label for="district" class="col-sm-4 control-label" style="font-size: 18px">监测区域:</label>
                    <div class="col-sm-5">
                        <select name="districtId" class="form-control" id="district" >
                            <c:forEach items="${districtList}" var="district">
                                <option <c:if test="${air.districtId == district.id}">selected</c:if> value="${district.id}" >${district.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="monitorTime" class="col-sm-4 control-label" style="font-size: 18px">监测日期:</label>
                    <div class="col-sm-5">
                        <input type="date" name="monitorTime" value="<fmt:formatDate value="${air.monitorTime}" pattern="yyyy-MM-dd" />" class="form-control" id="monitorTime" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="pm10" class="col-sm-4 control-label" style="font-size: 18px">PM10值:</label>
                    <div class="col-sm-5">
                        <input type="text" name="pm10" value="${air.pm10}" class="form-control" id="pm10" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="pm25" class="col-sm-4 control-label" style="font-size: 18px">PM2.5值:</label>
                    <div class="col-sm-5">
                        <input type="text" name="pm25" value="${air.pm25}" class="form-control" id="pm25" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="monitoringStation" class="col-sm-4 control-label" style="font-size: 18px">监测站:</label>
                    <div class="col-sm-5">
                        <input type="text" name="monitoringStation" value="${air.monitoringStation}" class="form-control" id="monitoringStation" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="lastModifyTime" class="col-sm-4 control-label" style="font-size: 18px">最后修改时间:</label>
                    <div class="col-sm-5">
                        <input type="text" readonly value="<fmt:formatDate value='${air.lastModifyTime}' pattern='yyyy-MM-dd HH:mm:ss' />"  class="form-control" id="lastModifyTime" />
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-5">
                        <button type="submit" class="btn btn-default">更新</button>
                        <button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/air/delete/${air.id}'">删除</button>
                        <button type="button" class="btn btn-default" onclick="history.go(-1)">返回</button>
<%--
                        <button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/air/list'">返回</button>
--%>
                    </div>
                </div>
            </form>

            <div style="text-align: center">
                <span>${updateMsg}${deleteMsg}</span>
            </div>

        </div>
    </div>
</div>
</body>
</html>
