<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Leezhenhao
  Date: 2019/05/31
  Time: 12:22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>空气列表</title>

    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<br/>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                空气质量检测信息库
            </h3>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-6 column">
            <form id="form" action="${pageContext.request.contextPath}/air/list" method="get" class="form-horizontal" role="form">
                <input type="hidden" id="page" name="page" value="1" />
                <div class="form-group">
                    <label for="district" class="col-sm-2 control-label">按区域查询</label>
                    <div class="col-sm-10">
                        <select name="districtId" class="form-control" id="district" >
                            <option value="0">不限</option>
                            <c:forEach items="${districtList}" var="district">
                                <option <c:if test="${districtId == district.id}">selected</c:if> value="${district.id}">${district.name}</option>
                            </c:forEach>
                        </select>
                        <button type="submit" class="btn btn-default">查询</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-6 column">
            <a href="${pageContext.request.contextPath}/air/add"><h4 class="text-center">添加空气质量信息</h4></a>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <c:choose>
                <c:when test="${pageInfo.count > 0}">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>
                                序号
                            </th>
                            <th>
                                区域
                            </th>
                            <th>
                                检测时间
                            </th>
                            <th>
                                PM10数据
                            </th>
                            <th>
                                PM2.5数据
                            </th>
                            <th>
                                监测站
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageInfo.list}" var="air" varStatus="i">
                            <tr class="success">
                                <td>${i.index + 1}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/air/maintain/${air.id}">${air.DName}</a>

                                </td>
                                <td>
                                    <fmt:formatDate value="${air.monitorTime}" pattern="yyyy-MM-dd" />
                                </td>
                                <td>${air.pm10}</td>
                                <td>${air.pm25}</td>
                                <td>${air.monitoringStation}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                    <ul class="pagination pagination-lg">

                        <c:if test="${pageInfo.page>1}">
                            <li>
                                <a href="javascript:;" onclick="page(1)">首页</a>
                            </li>
                            <li>
                                <a href="javascript:;" onclick="page(${pageInfo.page - 1})">上一页</a>
                            </li>
                        </c:if>

                        <c:if test="${pageInfo.page < pageInfo.pages}">
                            <li>
                                <a href="javascript:;" onclick="page(${pageInfo.page + 1})">下一页</a>
                            </li>
                            <li>
                                <a href="javascript:;" onclick="page(${pageInfo.pages})">尾页</a>
                            </li>
                        </c:if>

                    </ul>
                    <script>
                        function page(page){
                            document.getElementById("page").value = page;
                            document.getElementById("form").submit();
                        }
                    </script>
                    <span>
                        当前第 ${pageInfo.page} 页 / 共 ${pageInfo.pages} 页 (共 ${pageInfo.count } 条)
                    </span>

                </c:when>
                <c:otherwise>
                    <h3 class="text-center">
                        抱歉!暂无数据!
                    </h3>
                </c:otherwise>
            </c:choose>

        </div>
    </div>
</div>
</body>
</html>
