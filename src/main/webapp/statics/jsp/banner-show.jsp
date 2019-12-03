<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="path"></c:set>
<!doctype html>
<html lang="en">
<head>
    <title>轮播图</title>
    <script>
        $("#banner-table").jqGrid({
            url: '${path}/banner/selectAll',
            datatype: "json",
            colNames: ['ID', '名称', '封面', '描述', '状态', '创建时间'],
            colModel: [
                {name: 'id', hidden: true},
                {name: 'name', editable: true},
                {
                    name: 'cover', editable: true, edittype: 'file',
                    formatter: function (value, option, rows) {
                        return "<img style='width:80px;height:70px' src='${path}/statics/images/" + value + "'>";
                    }
                },
                {name: 'description', editable: true},
                {
                    name: 'status',
                    width: 40,
                    align: "center",
                    edittype: 'select',
                    editoptions: {value: '1:正常;2:冻结'},
                    editable: true,
                    formatter: function (value, option, rows) {
                        if (value == 1) return "正常";
                        else return "冻结";
                    }
                },
                {name: 'createDate',}
            ],
            styleUI: 'Bootstrap',
            autowidth: true,
            height: 380,
            rowNum: 4,
            rowList: [4, 10, 20, 30],
            pager: '#banner-pager',
            viewrecords: true,
            caption: "展示所有轮播图",
            editurl: "${path}/banner/edit"
        }).navGrid("#banner-pager", {edit: true, add: true, del: true},
            {
                //控制修改操作
                closeAfterEdit: true,

            }, {
                closeAfterAdd: true,
                //控制添加操作
                afterSubmit: function (result) {
                    if (result.responseJSON.code == 200) {
                        $.ajaxFileUpload({
                            url: '${path}/banner/upload',
                            data: {id: result.responseJSON.data},
                            type: 'POST',
                            fileElementId: 'cover',
                            success: function () {
                                $("#banner-table").trigger('reloadGrid');
                            }
                        })
                    }
                    return "123123";
                }
            }, {
                //控制删除操作
            });

    </script>
</head>
<body>

<table id="banner-table"></table>
<div id="banner-pager"></div>

</body>
</html>