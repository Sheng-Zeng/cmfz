<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function() {
        $("#GuruModifyName").textbox({
            required : true,
            validateOnCreate : false,
            validateOnBlur : true,
            prompt : "请输人上师法名",
        });

        $("#GuruModifyDes").textbox({
            required : true,
            validateOnCreate : false,
            validateOnBlur : true,
            prompt : "请输入上师描述信息",
        });

        $("#GuruModifyFb").filebox({
            buttonText: '选择文件',
            buttonAlign: 'right',
            accept:"image/jpeg, image/png"
        });

        $("#GuruModifySub").linkbutton({
            text : "提交",
            onClick : function() {
                $("#GuruModifyForm").form("submit",{
                    url : '${pageContext.request.contextPath}/guru/modify',
                    onSubmit : function() {
                        console.log("提交前执行");
                        return $("#GuruModifyForm").form("validate");
                    },
                    success : function(data) {
                        if(data=="success"){
                            $.messager.alert("提示","修改成功！");

                        } else {
                            $.messager.alert("提示","修改失败！");
                        }
                        $("#guruModifyDiv").dialog("close",true);
                        $("#guruSlider").datagrid('reload');
                    }
                });
            },
        });

        $("#GuruCancleModifySub").linkbutton({
            text : "取消",
            onClick: function () {
                $("#guruModifyDiv").dialog("close",true);
            }
        })
    });
</script>
<form id="GuruModifyForm" method="post" enctype="multipart/form-data">
    <input type="hidden" name="guruId">
    <table>
        <tr>
            <td>上师法名：</td>
            <td><input id="GuruModifyName" name="guruName"></td>
        </tr>
        <tr>
            <td>上师描述：</td>
            <td><input id="GuruModifyDes" name="guruSummary"></td>
        </tr>
        <tr>
            <td>上师头像：</td>
            <td><input id="GuruModifyFb" name="guruPicture"></td>
        </tr>
        <tr>
            <td><a id="GuruModifySub"></a></td>
            <td><a id="GuruCancleModifySub"></a></td>
        </tr>
    </table>
</form>