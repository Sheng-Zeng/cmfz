<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        $("#articleTitle").textbox({
            required : true,
            validateOnCreate : false,
            validateOnBlur : true,
            prompt : "请输入文章标题",
        });

        $("#articleAuthor").combobox({
            url:'${pageContext.request.contextPath}/article/guru',
            valueField:'id',
            textField:'text'
        });

        $("#articleSubmit").linkbutton({
            text:"创建文章",
            onClick:function() {
                $("#articleForm").form("submit",{
                    url : '${pageContext.request.contextPath}/article/create',
                    onSubmit : function(param) {
                        console.log("提交前执行");
                        param.articleIntroduction = editor.txt.html();
                        return $("#articleForm").form("validate");
                    },
                    success : function(data) {
                        if(data=="success"){
                            $.messager.show({
                                title:'提示消息',
                                msg:'创建成功，消息将在4秒后关闭。',
                                showType:'show',
                                style:{
                                    right:'',
                                    top:document.body.scrollTop+document.documentElement.scrollTop,
                                    bottom:''
                                }
                            });

                        } else {
                            $.messager.show({
                                title:'提示消息',
                                msg:'创建失败，消息将在4秒后关闭。',
                                showType:'show',
                                style:{
                                    right:'',
                                    top:document.body.scrollTop+document.documentElement.scrollTop,
                                    bottom:''
                                }
                            });
                        }
                    }
                });
            },
        });

        $("#articleReboot").linkbutton({
            text:"重置内容",
            onClick:function() {
                editor.txt.clear();
                document.getElementById("articleForm").reset();
            },
        });
    });
    var E = window.wangEditor;
    var editor = new E('#articleEditor');
    editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/article/upload';
    editor.customConfig.uploadFileName = 'files';
    editor.create();
</script>
<form id="articleForm" method="post">
    <table>
        <tr>
            <td>文章标题：</td>
            <td><input id="articleTitle" name="articleName" type="text" ></td>
        </tr>
        <tr>
            <td>文章作者：</td>
            <td><input id="articleAuthor" name="guruId"></td>
        </tr>
    </table>
    <div id="articleEditor"></div>
    <table>
        <tr>
            <td><a id="articleSubmit"></a></td>
            <td><a id="articleReboot"></a></td>
        </tr>
    </table>
</form>