<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="path"></c:set>
<!doctype html>
<html lang="en">
<head>
    <title>持明法州后台管理系统首页</title>
    <%--js--%>
    <script src="${path}/statics/boot/js/jquery-2.2.1.min.js"></script>
    <script src="${path}/statics/boot/js/bootstrap.js"></script>
    <script src="${path}/statics/jqgrid/js/trirand/i18n/grid.locale-cn.js"></script>
    <script src="${path}/statics/jqgrid/js/ajaxfileupload.js"></script>

    <%--css--%>
    <link rel="stylesheet" href="${path}/statics/boot/css/bootstrap.css">
    <link rel="stylesheet" href="${path}/statics/jqgrid/css/trirand/ui.jqgrid-bootstrap-ui.css">
</head>
<body>
<h1>欢迎：&emsp;&emsp;${sessionScope.nickname}</h1>





</body>
</html>