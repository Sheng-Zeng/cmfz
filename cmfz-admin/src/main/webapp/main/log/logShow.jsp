<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        $("#logSlider").datagrid({
            url: "${pageContext.request.contextPath}/log/showAll",
            remoteSort: false,
            singleSelect: true,
            nowrap: false,
            fitColumns: true,
            striped: true,
            pagination: true,
            pageSize: 5,
            pageList: [5, 10, 15, 20],
            columns: [[
                {field: 'logId', title: '日志ID', align: 'right', sortable: true},
                {field: 'logUser', title: '操作用户', sortable: true},
                {field: 'logTime', title: '操作时间', sortable: true},
                {field: 'logResource', title: '操作办法', sortable: true},
                {field: 'logAction', title: '操作行为', sortable: true},
                {field: 'logMessage', title: '操作信息', sortable: true},
                {field: 'logResult', title: '操作是否成功', sortable: true}
            ]]
        });
    });
</script>
<table id="logSlider"></table>
