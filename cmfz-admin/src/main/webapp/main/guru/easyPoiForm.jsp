<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        $("#GuruEasyPoiFb").filebox({
            buttonText: '选择文件',
            buttonAlign: 'right',
            accept:"application/vnd.ms-excel,application/x-xls,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
        });

        $("#GuruEasyPoiSub").linkbutton({
            text : "提交",
            onClick : function() {
                $("#GurueasyPoiForm").form("submit",{
                    url : '${pageContext.request.contextPath}/easypoi/excelImport',
                    onSubmit : function() {
                        console.log("提交前执行");
                        return $("#GurueasyPoiForm").form("validate");
                    },
                    success : function(data) {
                        if(data=="success"){
                            $.messager.alert("提示","添加成功！");

                        } else {
                            $.messager.alert("提示","添加失败！");
                        };
                        $("#gurueasyPoiDiv").dialog("close",true);
                        $("#guruSlider").datagrid('reload');
                    }
                });
            },
        });

        $("#GuruCanaleEasyPoiSub").linkbutton({
            text : "取消",
            onClick: function () {
                $("#gurueasyPoiDiv").dialog("close",true);
            }
        })
    });
</script>
<form id="GurueasyPoiForm" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>批量插入文件：</td>
            <td><input id="GuruEasyPoiFb" name="file" type="text"></td>
        </tr>
        <tr>
            <td><a id="GuruEasyPoiSub"></a></td>
            <td><a id="GuruCanaleEasyPoiSub"></a></td>
        </tr>
    </table>
</form>