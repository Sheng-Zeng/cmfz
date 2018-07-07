<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        $("#guruSlider").datagrid({
            url: "${pageContext.request.contextPath}/guru/showAll",
            remoteSort: false,
            singleSelect: true,
            nowrap: false,
            fitColumns: true,
            striped: true,
            pagination: true,
            pageSize: 5,
            pageList: [5, 10, 15, 20],
            columns: [[
                {field: 'guruId', title: '上师编号', align: 'right', sortable: true},
                {field: 'guruName', title: '上师法名', sortable: true},
                {field: 'guruPhoto', title: '上师头像路径', sortable: true},
                {field: 'guruSummary', title: '上师描述', sortable: true},
                {
                    field: '     ',
                    title: '修 改 按 钮',
                    formatter: function (value, row, index) {
                        return "<a class='loan_ct_modify_button' onclick=\"guruEditRow('" + row.guruId + "','" + row.guruName + "','" + row.guruPhoto + "','" + row.guruSummary + "') \"></a> ";
                    }
                },
                {
                    field: '      ',
                    title: '删 除 按 钮',
                    formatter: function (value, row, index) {
                        return "<a class='loan_ct_delete_button' onclick=\"guruDeleteRow('" + row.guruId + "') \"></a> ";
                    }
                }
            ]],
            onLoadSuccess: function (data) {
                $(".loan_ct_modify_button").linkbutton({
                    text: '修改', plain: false, iconCls: 'icon-user_green'
                });
                $(".loan_ct_delete_button").linkbutton({
                    text: '删除', plain: false, iconCls: 'icon-user_green'
                });

            },
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/guru/' + rowData.guruId + '/' + rowData.guruPhoto + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '</td>' +
                    '</tr></table>';
            },
            toolbar: "#guruTb",
        });
    });

    function guruDeleteRow(guruId) {
        var result = "";
        $.ajax({
            type: 'post',
            async: false,
            url: '${pageContext.request.contextPath}/guru/delete',
            data: {
                'guruId': guruId
            },
            success: function (data) {
                result = data;
            }
        });
        if (result == "1") {
            $.messager.alert('提示', '删除成功！');
        } else {
            $.messager.alert('提示', '删除失败！');
        }
        $("#guruSlider").datagrid('reload');
    };

    function guruEditRow(guruId, guruName, guruPhoto, guruSummary) {
        $("#guruModifyDiv").dialog({
            title: '修改',
            width: 600,
            height: 300,
            href: '${pageContext.request.contextPath}/main/guru/modifyForm.jsp',
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

    function GuruSearch(value, name) {
        $("#guruSlider").datagrid("load", {
            name: name,
            value: value
        });
    };
</script>
<table id="guruSlider"></table>
<div id="guruAddDiv"></div>
<div id="gurueasyPoiDiv"></div>
<div id="guruModifyDiv"></div>
<div id="guruDeleteDiv"></div>
<table id="guruModify"></table>
<div id="guruTb" style="display: none">
    <a class="easyui-linkbutton"
       data-options="iconCls:'icon-add',plain:true,text:'新增上师',onClick: function(){
					$('#guruAddDiv').dialog({
					    title:'新增上师',
					    width:600,
					    height:300,
					    href: '${pageContext.request.contextPath}/main/guru/addForm.jsp',
					    modal: true
					});
				}"></a>
    <a class="easyui-linkbutton"
       data-options="iconCls:'icon-add',plain:true,text:'批量插入上师',onClick: function(){
					$('#gurueasyPoiDiv').dialog({
					    title:'批量插入上师',
					    width:600,
					    height:300,
					    href: '${pageContext.request.contextPath}/main/guru/easyPoiForm.jsp',
					    modal: true
					});
				}"></a>
    <a class="easyui-linkbutton"
       data-options="iconCls:'icon-add',plain:true,text:'导出所有上师',onClick: function(){
		    window.location.href = 'http://localhost:8088/cmfz-admin/easypoi/export';
				}"></a>
    <input id="guruSS" class="easyui-searchbox" style="width:300px"
           data-options="searcher:GuruSearch,prompt:'Please Input Value', menu:'#guruMM'"></input>
    <div id="guruMM">
        <div data-options="name:'guru_name',iconCls:'icon-ok'">法名</div>
    </div>
</div>