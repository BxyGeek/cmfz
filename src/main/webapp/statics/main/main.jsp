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
    <script src="${path}/statics/jqgrid/js/trirand/jquery.jqGrid.min.js"></script>
    <script src="${path}/statics/jqgrid/js/ajaxfileupload.js"></script>

    <%--css--%>
    <link rel="stylesheet" href="${path}/statics/boot/css/bootstrap.css">
    <link rel="stylesheet" href="${path}/statics/jqgrid/css/trirand/ui.jqgrid-bootstrap.css">
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="#">欢迎来到持明法州后台管理系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a>欢迎:&emsp;<strong>${sessionScope.nickname}</strong></a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-expanded="false">安全退出</a>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="row">
    <div class="col-lg-2">
        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="headingOne">
                    <h4 class="panel-title text-center">
                        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                           aria-expanded="true" aria-controls="collapseOne">
                            <h2>轮播图管理</h2>
                        </a>
                    </h4>
                </div>
                <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                    <div class="panel-body  text-center">
                        <a class="btn btn-default" href="javascript:$('#contentLayout').load('../jsp/banner-show.jsp')">查询轮播图</a>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="headingTwo">
                    <h4 class="panel-title  text-center">
                        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                           href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                            <h2>专辑管理</h2>
                        </a>
                    </h4>
                </div>
                <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                    <div class="panel-body text-center">
                        <a class="btn btn-default" href="javascript:$('#contentLayout').load('../jsp/album-show.jsp')">查询专辑</a>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="headingThree">
                    <h4 class="panel-title text-center">
                        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                           href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                            <h2>文章管理</h2>
                        </a>
                    </h4>
                </div>
                <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                    <div class="panel-body text-center">
                        <a class="btn btn-default"
                           href="javascript:$('#contentLayout').load('../jsp/article-show.jsp')">查询文章</a>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="headingFour">
                    <h4 class="panel-title text-center">
                        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                           href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                            <h2>用户管理</h2>
                        </a>
                    </h4>
                </div>
                <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
                    <div class="panel-body text-center">
                        <a class="btn btn-default" href="javascript:$('#contentLayout').load('../jsp/user-show.jsp')">查询用户</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-lg-10" id="contentLayout">
        <div class="jumbotron" style="padding-left: 80px">
            <h2>欢迎来到持明法州后台管理系统</h2>
        </div>
        <img src="../images/shouye.jpg" alt="" style="width: 100%">
    </div>

</div>
<div style="text-align: center">
    <h3>持明法州@百知教育2019-1-2</h3>
</div>

</body>
</html>
