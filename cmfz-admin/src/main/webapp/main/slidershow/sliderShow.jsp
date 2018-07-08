<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
       $("#slider").datagrid({
           url:"${pageContext.request.contextPath}/picture/showAll",
           remoteSort:false,
           singleSelect:true,
           nowrap:false,
           fitColumns:true,
           striped:true,
           pagination : true,
           pageSize : 5,
           pageList : [ 5, 10, 15, 20 ],
           columns:[[
               {field:'pictureId',title:'标识编号',align:'right',sortable:true},
               {field:'picturePath',title:'图片路径',sortable:true},
               {
                   field:'pictureStatus',
                   title:'图片展示状态',
                   align:'right',
                   sortable:true,
                   formatter: function(value,row,index){
                       if (value == "1"){
                           return "<p>展示</p>";
                       } else {
                           return "<p style='color: red'>未展示</p>";
                       }
                   }

               },
               {field:'pictureDescription',title:'图片描述',sortable:true},
               {field:'pictureDate',title:'图片创建日期'},
               {
                   field:'     ',
                   title:'操 作 按 钮',
                   formatter: function(value,row,index){
                       return "<a class='loan_ct_view_button' onclick=\"editRow('"+row.pictureId+"','"+row.pictureStatus+"','"+row.pictureDescription+"') \"></a>";
                   }
               }
           ]],
           onLoadSuccess:function(data){
               $(".loan_ct_view_button").linkbutton({
                   text:'修改', plain:false, iconCls:'icon-user_green'
               });
           },
           view: detailview,
           detailFormatter: function(rowIndex, rowData){
               return '<table><tr>' +
                   '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/'+rowData.picturePath+ '" style="height:50px;"></td>' +
                   '<td style="border:0">' +
                   '</td>' +
                   '</tr></table>';
           },
           toolbar : [{
               iconCls: 'icon-add',
               text:"新增轮播图",
               plain:true,
               handler: function(){
                   $("#addDiv").dialog({
                       title: "新增轮播图",
                       width: 300,
                       height: 150,
                       iconCls:"icon-add",
                       collapsible:true,
                       minimizable:true,
                       maximizable:true,
                       resizable:true,
                       href: "${pageContext.request.contextPath}/main/slidershow/addForm.jsp",
                       modal: true,
                   });
               },
           },'-',{
               iconCls: 'icon-help',
               text:"帮助",
               plain:true,
               handler: function(){
                   alert('帮助按钮')
               },
           }],
        });
    });

    function editRow(pictureId,pictureStatus,pictureDescription) {
        $("#modifyDiv").dialog({
            title:'修改',
            width:300,
            height:150,
            modal: true,
            href: '${pageContext.request.contextPath}/main/slidershow/modifyForm.jsp',
            onLoad:function(){
                $("#modifyForm").form('load',{
                    pictureId:pictureId,
                    pictureDescription:pictureDescription,
                    picturePath:pictureStatus
                });
            }
        });
    }
</script>
<table id="slider"></table>
<div id="addDiv"></div>
<div id="modifyDiv"></div>