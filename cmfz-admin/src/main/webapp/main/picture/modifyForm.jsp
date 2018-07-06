<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        $("#descMessage").textbox({
            required : true,
            validateOnCreate : false,
            validateOnBlur : true,
        });

        $("descStatus").textbox({
            required : true,
            validateOnCreate : false,
            validateOnBlur : true,
        });

        $("#ModifySub").linkbutton({
            text : "提交",
            onClick : function() {
                $("#modifyForm").form("submit",{
                    url : "${pageContext.request.contextPath}/picture/modifyPicture",
                    onSubmit : function() {
                        console.log("提交前执行");
                        return $("#modifyForm").form("validate");
                    },
                    success : function(data) {
                        if(data== "1"){
                            $.messager.alert("提示","更改成功！");
                        } else {
                            $.messager.alert("提示","更改失败！");
                        }
                        $("#modifyDiv").dialog({
                            closed:true,
                        });
                        $("#slider").datagrid('reload');
                    }
                });
            },
        });

    });

</script>
<form id="modifyForm" method="post">
    <input type="hidden" name="pictureId" />
    <table>
        <tr>
            <td>描述信息：</td>
            <td><input id="descMessage" name="pictureDescription"></td>
        </tr>
        <tr>
            <td>轮播图状态：</td>
            <td><select id="ModifyStatu" class="easyui-combobox" name="pictureStatus">
                <option value="1">展示</option>
                <option value="2">不展示</option>
            </select>
            </td>
        </tr>
        <tr>
            <td><a id="ModifySub"></a></td>
        </tr>
    </table>

</form>