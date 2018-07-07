<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function() {
        $("#GuruAddName").textbox({
            required : true,
            validateOnCreate : false,
            validateOnBlur : true,
            prompt : "请输人上师法名",
        });

        $("#GuruAddDes").textbox({
            required : true,
            validateOnCreate : false,
            validateOnBlur : true,
            prompt : "请输入上师描述信息",
        });

        $("#GuruAddFb").filebox({
            buttonText: '选择文件',
            buttonAlign: 'right',
            accept:"image/jpeg, image/png"
        });

        $("#GuruAddSub").linkbutton({
            text : "提交",
            onClick : function() {
                $("#GuruAddForm").form("submit",{
                    url : '${pageContext.request.contextPath}/guru/add',
                    onSubmit : function() {
                        console.log("提交前执行");
                        return $("#GuruAddForm").form("validate");
                    },
                    success : function(data) {
                        if(data=="success"){
                            $.messager.alert("提示","添加成功！");

                        } else {
                            $.messager.alert("提示","添加失败！");
                        }
                        $("#guruAddDiv").dialog("close",true);
                       $("#guruSlider").datagrid('reload');
                    }
                });
            },
        });
    });
</script>
<form id="GuruAddForm" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>上师法名：</td>
            <td><input id="GuruAddName" name="guruName" type="text" ></td>
        </tr>
        <tr>
            <td>上师描述：</td>
            <td><input id="GuruAddDes" name="guruSummary" type="text" ></td>
        </tr>
        <tr>
            <td>上师头像：</td>
            <td><input id="GuruAddFb" name="guruPicture" type="text"></td>
        </tr>
        <tr>
            <td><a id="GuruAddSub"></a></td>
        </tr>
    </table>
</form>