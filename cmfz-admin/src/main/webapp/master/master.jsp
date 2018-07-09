<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

    <script type="text/javascript">
        $(function(){
            $("#mastb").datagrid({
                url:'${pageContext.request.contextPath}/master/showAllMaster',
                columns:[[
                    {field:'masterId',title:'上师编号',width:150},
                    {field:'masterName',title:'上师法名',width:120,},
                    {field:'masterPhoto',title:'上师图片',width:120,},
                    {field:'masterSummary',title:'上师简介',width:120,},
                    {field:'operation',title:'操作',width:50,
                            formatter:function(value,row,index){ // 格式化展示数据到对应的列
                                return "<a id='masModify' class='easyui-linkbutton' data-options=\"iconCls:'icon-edit' \" onclick='masModify()'>修改</a>"
                            }
                    }
                ]],
                onLoadSuccess:function(){
                    $("a[id='masModify']").linkbutton({});
                },
                pagination : true, //在DataGrid控件底部显示分页工具栏
                pageList : [ 5, 10, 15, 20, 25 ],
                pageSize : 5,
                toolbar : "#mastlb", //工具栏
                fitColumns: true, //真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。
                singleSelect:true, //只允许选择一行
                striped:true, //显示斑马线效果
                remoteSort:false, //定义从服务器对数据进行排序
                nowrap:false, //如果为true，则在同一行中显示数据。设置为true可以提高加载性能。

                view: detailview,
                // 展示内容
                detailFormatter: function(rowIndex, rowData){//detailFormatter函数返回行详细内容
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/master/'+ rowData.masterPhoto +'" style="height:50px;"></td>' +
                        '</tr></table>';
                },

            });
        });


        //弹窗
        $(function() {
            //增
            $("#masadd").linkbutton({
                onClick:function(){
                    //展示一个对话框窗口
                    $("#masdialog").dialog({
                        title:"新增上师",
                        width:500,
                        height:300,
                        href:"${pageContext.request.contextPath}/master/addMaster.jsp",
                        modal:true,
                        shadow:true,
                        buttons:[{
                            text:"保存",
                            iconCls:"icon-disk",
                            handler:function(){
                                $("#masff").form("submit",{
                                    url:"${pageContext.request.contextPath}/master/addMaster",
                                    success:function(res){
                                        if(res=="success"){
                                            $.messager.alert('提示消息','上传成功');
                                            $("#masdialog").dialog("close");
                                            $("#mastb").datagrid({
                                                url : "${pageContext.request.contextPath}/master/showAllMaster",
                                            })
                                        } else{
                                            $.messager.alert('提示消息','上传失败');
                                        }
                                    }
                                });
                            },
                        },{
                            text:"取消",
                            iconCls:"icon-cancel",
                            handler:function(){
                                //关闭对话框窗口
                                $("#masdialog").dialog("close");
                            }
                        }],
                    });
                },
            });

            //修改
            $("#masmodify").linkbutton({
                onClick: function () {
                    var rowData = $("#mastb").datagrid("getSelected");
                    //展示一个对话框窗口
                    $("#masdialog").dialog({
                        title:"修改上师信息",
                        width:500,
                        height:300,
                        href:"${pageContext.request.contextPath}/master/modifyMaster.jsp",
                        modal:true,
                        shadow:true,
                        buttons:[{
                            text:"保存",
                            iconCls:"icon-disk",
                            handler:function(){
                                $("#masff").form("submit",{
                                    url:"${pageContext.request.contextPath}/master/modifyMaster",
                                    success:function(res){
                                        if(res=="success"){
                                            $.messager.alert('提示','修改成功');
                                            $("#masdialog").dialog("close");
                                            $("#mastb").datagrid({
                                                url : "${pageContext.request.contextPath}/master/showAllMaster",
                                            })
                                        }
                                    }
                                });
                            }
                        },{
                            text:"取消",
                            iconCls:"icon-cancel",
                            handler:function(){
                                //关闭对话框窗口
                                $("#masdialog").dialog("close");
                            }
                        }],
                        onLoad:function(){
                            $("#masff").form("load",rowData);//在加载时将行数据加载到表单元素中
                        }
                    });

                }
            });

            //批量增加
            $("#masbatch").linkbutton({
                onClick:function(){
                    //打开对话框窗口
                    $("#masdialog").dialog({
                        title:"批量增加上师",
                        width:500,
                        height:300,
                        href:"${pageContext.request.contextPath}/master/batchMaster.jsp",
                        modal:true,
                        shadow:true,
                        buttons:[{
                            text:"保存",
                            iconCls:"icon-disk",
                            handler:function(){
                                $("#masff").form("submit",{
                                    url:"${pageContext.request.contextPath}/master/batchMaster",
                                    success:function(res){
                                        if(res=="success"){
                                            $.messager.alert('提示消息','上传成功');
                                            $("#masdialog").dialog("close");
                                            $("#mastb").datagrid({
                                                url : "${pageContext.request.contextPath}/master/showAllMaster",
                                            })
                                        }
                                    }
                                });
                            },
                        },{
                            text:"取消",
                            iconCls:"icon-cancel",
                            handler:function(){
                                //关闭对话框窗口
                                $("#masdialog").dialog("close");
                            }
                        }],
                    });
                }
            });

        });

        //修改
        function masModify(){
            var rowData = $("#mastb").datagrid("getSelected");
            //展示一个对话框窗口
            $("#masdialog").dialog({
                title:"修改上师信息",
                width:500,
                height:300,
                href:"${pageContext.request.contextPath}/master/modifyMaster.jsp",
                modal:true,
                shadow:true,
                buttons:[{
                    text:"保存",
                    iconCls:"icon-disk",
                    handler:function(){
                        $("#masff").form("submit",{
                            url:"${pageContext.request.contextPath}/master/modifyMaster",
                            success:function(res){
                                if(res=="success"){
                                    $.messager.alert('提示','修改成功');
                                    $("#masdialog").dialog("close");
                                    $("#mastb").datagrid({
                                        url : "${pageContext.request.contextPath}/master/showAllMaster",
                                    })
                                }
                            }
                        });
                    }
                },{
                    text:"取消",
                    iconCls:"icon-cancel",
                    handler:function(){
                        //关闭对话框窗口
                        $("#masdialog").dialog("close");
                    }
                }],
                onLoad:function(){
                    $("#masff").form("load",rowData);//在加载时将行数据加载到表单元素中
                }
            });
        }

        //模糊查询
        function qq(value, name) {
            $("#mastb").datagrid({
                url:"${pageContext.request.contextPath}/master/queryPersonByOther",
                queryParams:{
                    value:value,
                    name:name,
                },
                columns:[[
                    {field:'masterId',title:'上师编号',width:150},
                    {field:'masterName',title:'上师法名',width:120,},
                    {field:'masterPhoto',title:'上师图片',width:120,},
                    {field:'masterSummary',title:'上师简介',width:120,},
                    {field:'operation',title:'操作',width:50,
                        formatter:function(value,row,index){ // 格式化展示数据到对应的列
                            return "<a class='easyui-linkbutton' data-options=\"iconCls:'icon-edit' \" onclick='masModify()'>修改</a>"
                        }
                    }
                ]],
                onLoadSuccess:function(){
                    $.parser.parse(); //解析器  解析所有页面
                },

                pagination : true, //在DataGrid控件底部显示分页工具栏
                pageList : [ 5, 10, 15, 20, 25 ],
                pageSize : 5,
                toolbar : "#mastlb", //工具栏
                fitColumns: true, //真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。
                singleSelect:true, //只允许选择一行
                striped:true, //显示斑马线效果
                remoteSort:false, //定义从服务器对数据进行排序
                nowrap:false, //如果为true，则在同一行中显示数据。设置为true可以提高加载性能。

                view: detailview,
                // 展示内容
                detailFormatter: function(rowIndex, rowData){//detailFormatter函数返回行详细内容
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/master/'+ rowData.masterPhoto +'" style="height:50px;"></td>' +
                        '</tr></table>';
                }
            });

        }


    </script>


    <table id="mastb"></table>

    <div id="mastlb" style="display: none">

        <a id="masadd" class="easyui-linkbutton"
           data-options="iconCls:'icon-add',plain:true,text:'新增上师'"></a>

        <a id="masmodify" class="easyui-linkbutton"
           data-options="iconCls:'icon-edit',plain:true,text:'修改上师信息'"></a>


        <input id="ss" class="easyui-searchbox" style="width:300px"
               data-options="searcher:qq,prompt:'请输入您查询的上师法名',menu:'#mm'" />
        <div id="mm" style="width:30px">
            <div data-options="name:'name',iconCls:'icon-user'">法名</div>
        </div>

        <a id="masbatch" class="easyui-linkbutton"
           data-options="iconCls:'icon-help',plain:true,text:'批量插入'"></a>

    </div>

    <div id="masdialog"></div>


