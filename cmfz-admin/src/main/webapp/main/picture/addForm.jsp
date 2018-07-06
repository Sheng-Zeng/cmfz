<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function() {
        $("#addDes").textbox({
            required : true,
            validateOnCreate : false,
            validateOnBlur : true,
            prompt : "请输入图片描述信息",
        });

        $("#addFb").filebox({
            buttonText: '选择文件',
            buttonAlign: 'right',
            accept:"image/jpeg, image/png"
        });

        $("#addSub").linkbutton({
            text : "提交",
            onClick : function() {
                $("#addForm").form("submit",{
                    url : '${pageContext.request.contextPath}/picture/add',
                    onSubmit : function() {
                        console.log("提交前执行");
                        return $("#addForm").form("validate");
                    },
                    success : function(data) {
                        if(data=="success"){
                            $.messager.alert("提示","添加成功！");

                        } else {
                            $.messager.alert("提示","添加失败！");
                        }
                        $("#addDiv").dialog({
                            closed:true,
                        });
                       $("#slider").datagrid('reload');
                    }
                });
            },
        });
    });
</script>
<form id="addForm" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>轮播图描述：</td>
            <td><input id="addDes" name="desc" type="text" ></td>
        </tr>
        <tr>
            <td>轮播图状态：</td>
            <td><select id="addStatu" class="easyui-combobox" name="dept">
                <option value="1">展示</option>
                <option value="2">不展示</option>
            </select>
            </td>
        </tr>
        <tr>
            <td>上传轮播图：</td>
            <td><input id="addFb" name="picture" type="text"></td>
        </tr>
        <tr>
            <td><a id="addSub"></a></td>
        </tr>
    </table>
</form>