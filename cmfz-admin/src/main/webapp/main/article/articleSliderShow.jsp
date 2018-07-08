<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        $("#articleSlider").datagrid({
            url: "${pageContext.request.contextPath}/article/showAll",
            remoteSort: false,
            singleSelect: true,
            nowrap: false,
            fitColumns: true,
            striped: true,
            pagination: true,
            pageSize: 5,
            pageList: [5, 10, 15, 20],
            columns: [[
                {field: 'articleId', title: '文章ID', align: 'right', sortable: true},
                {field: 'articleName', title: '文章名', sortable: true},
                {field: 'guruId', title: '作者ID', sortable: true},
                {field: 'articleDate', title: '文章创建日期', sortable: true},
                {
                    field: '     ',
                    title: '文 章 操 作',
                    formatter: function (value, row, index) {
                        return "<a class='loan_ct_article_details_button' onclick=\"articleDetails('" + row.articleId + "') \"></a> ";
                    }
                },
                {
                    field: '      ',
                    title: '修 改 按 钮',
                    formatter: function (value, row, index) {
                        return "<a class='loan_ct_article_modify_button' onclick=\"articleModify('" + row.articleId + "','" + row.articleName + "','" + row.guruId + "') \"></a> ";
                    }
                }
            ]],
            onLoadSuccess: function (data) {
                $(".loan_ct_article_details_button").linkbutton({
                    text: '详情', plain: false, iconCls: 'icon-user_green'
                });
                $(".loan_ct_article_modify_button").linkbutton({
                    text: '修改', plain: false, iconCls: 'icon-user_green'
                });
            },
        });
    });

    function articleDetails(articleId) {
        $("#articleDetails").dialog({
            title: '文章详情',
            maximizable:true,
            width: 300,
            height: 600,
            resizable:true,
            onLoad:function(){
                $.get("${pageContext.request.contextPath}/article/getIntroduction", { articleId: articleId },
                    function(data){
                        $("#articleDetailsDiv").html(data);
                    });
            },
            href:'${pageContext.request.contextPath}/main/article/articleDetail.jsp',
        })
    };

    function articleModify(articleId, articleName, guruId) {
        $("#guruModifyDiv").dialog({
            title: '修改',
            width: 300,
            height: 150,
            href: '${pageContext.request.contextPath}/main/article/articleModifyForm.jsp',
            modal: true,
            onLoad: function () {
                $("#GuruModifyForm").form('load', {
                    guruId: guruId,
                    guruName: guruName,
                    guruPhoto: guruPhoto,
                    guruSummary: guruSummary
                });
            }
        });
    };
</script>
<table id="articleSlider"></table>
<div id="articleModifyDiv"></div>
<div id="articleDetails"></div>