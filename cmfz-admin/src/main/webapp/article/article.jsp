<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<script type="text/javascript">
    $(function(){
        $("#arttb").datagrid({
            url:'${pageContext.request.contextPath}/article/showAllArticle',
            columns:[[
                {field:'articleId',title:'文章编号',width:60},
                {field:'articleName',title:'文章标题',width:100},
                {field:'articleTime',title:'创建时间',width:100},
                {field:'articlePic',title:'文章封面',width:100},
                {field:'masterID',title:'文章作者',width:60},
                {field:'articleStatus',title:'文章状态',width:80},
                {field:'operation',title:'操作',width:100,
                    formatter:function(value,row,index){ // 格式化展示数据到对应的列
                        return "<a id='artShow' class='easyui-linkbutton' data-options=\"iconCls:'icon-edit' \" onClick='showArticle()'>查看详情</a>"
                    }
                }
            ]],
            onLoadSuccess:function(){
                $("a[id='artShow']").linkbutton({});
            },
            pagination : true, //在DataGrid控件底部显示分页工具栏
            pageList : [ 5, 10, 15, 20, 25 ],
            pageSize : 5,
            toolbar : "#arttlb", //工具栏
            fitColumns: true, //真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。
            singleSelect:true, //只允许选择一行
            striped:true, //显示斑马线效果
            remoteSort:false, //定义从服务器对数据进行排序
            nowrap:false, //如果为true，则在同一行中显示数据。设置为true可以提高加载性能。

            view: detailview,
            // 展示内容
            detailFormatter: function(rowIndex, rowData){//detailFormatter函数返回行详细内容
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/article/'+ rowData.articlePic +'" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>文章标题: ' + rowData.articleName + '</p>' +
                    '<p>文章封面: ' + rowData.articlePic + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });
    });


    //弹窗
    function showArticle() {
        //查看详情
        //展示一个对话框窗口
        $("#artdialog").dialog({
            title:"文章内容",
            width:500,
            height:600,
            href:"${pageContext.request.contextPath}/article/showArticle.jsp",
            modal:true,
            minimizable:true,
            maximizable:true,
            onLoad:function(){
                var rowData = $("#arttb").datagrid("getSelected");
                document.getElementById("hh").innerHTML=rowData.articleName;
                document.getElementById("hh1").innerHTML=rowData.introduction;
            }
        });
    };

</script>


<table id="arttb"></table>

<div id="artdialog"></div>


