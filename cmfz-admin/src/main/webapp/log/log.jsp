<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

    <script type="text/javascript">
        $(function(){
            $('#logtb').datagrid({
                url:'${pageContext.request.contextPath}/log/showAllLogs',
                columns:[[
                    {field:'logId',title:'标识编号',},
                    {field:'logUser',title:'操作人',},
                    {field:'logTime',title:'操作时间',},
                    {field:'logResource',title:'操作类',},
                    {field:'logAction',title:'操作方法',},
                    {field:'logMessage',title:'操作细节',},
                    {field:'logResult',title:'操作结果',},
                    /*{field:'operation',title:'操作',width:50,
                            formatter:function(value,row,index){ // 格式化展示数据到对应的列
                                return "<a id='picModify' class='easyui-linkbutton' data-options=\"iconCls:'icon-edit' \" onclick='picModify()'>修改</a>"
                            }
                    }*/
                ]],
                /*onLoadSuccess:function(){
                  //  $.parser.parse(); //解析器  解析所有页面
                    $("a[id='picModify']").linkbutton({});
                },*/
                pagination : true, //在DataGrid控件底部显示分页工具栏
                pageList : [ 5, 10, 15, 20, 25 ],
                pageSize : 5,
                toolbar : "#logtlb", //工具栏
                fitColumns: true, //真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。
                singleSelect:true, //只允许选择一行
                striped:true, //显示斑马线效果
                remoteSort:false, //定义从服务器对数据进行排序
                nowrap:false, //如果为true，则在同一行中显示数据。设置为true可以提高加载性能。

            });

        });


    </script>


    <table id="logtb"></table>

    <div id="logtlb" style="display: none">


        <a id="logremove" class="easyui-linkbutton"
           data-options="iconCls:'icon-edit',plain:true,text:'修改轮播图信息'"></a>

        <a id="loghelp" class="easyui-linkbutton"
           data-options="iconCls:'icon-help',plain:true,text:'帮助'"></a>

    </div>

    <div id="logdialog"></div>


