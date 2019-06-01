<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Leezhenhao
  Date: 2019/05/31
  Time: 16:11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>空气质量添加页面</title>

    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<br/>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h1 class="text-center">
                添加空气质量信息
            </h1>
            <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/air/add" method="POST">
                <div class="form-group">
                    <label for="district" class="col-sm-4 control-label" style="font-size: 18px">监测区域:</label>
                    <div class="col-sm-5">
                        <select required name="districtId" class="form-control" id="district" >
                            <option>请选择</option>
                            <c:forEach items="${districtList}" var="district">
                                <option value="${district.id}" >${district.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="monitorTime" class="col-sm-4 control-label" style="font-size: 18px">监测日期:</label>
                    <div class="col-sm-5">
                        <input required type="date" name="monitorTime" class="form-control" id="monitorTime" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="pm10" class="col-sm-4 control-label" style="font-size: 18px">PM10值:</label>
                    <div class="col-sm-5">
                        <input required type="text" name="pm10" class="form-control" id="pm10" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="pm25" class="col-sm-4 control-label" style="font-size: 18px">PM2.5值:</label>
                    <div class="col-sm-5">
                        <input required type="text" name="pm25" class="form-control" id="pm25" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="monitoringStation" class="col-sm-4 control-label" style="font-size: 18px">监测站:</label>
                    <div class="col-sm-5">
                        <input required type="text" name="monitoringStation" class="form-control" id="monitoringStation" />
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-5">
                        <button type="submit" class="btn btn-default">保存</button>
                        <button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/air/add'">重置</button>
                        <button type="button" class="btn btn-default" onclick="history.go(-1)">返回</button>
                        <%--<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/air/list'">返回</button>--%>
                    </div>
                </div>
            </form>

            <div style="text-align: center">
                <span>${addMsg}</span>
            </div>

        </div>
    </div>
</div>
</body>
</html>
