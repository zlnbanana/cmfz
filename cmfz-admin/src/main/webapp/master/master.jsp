<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

    <script type="text/javascript">
        $(function(){
            $('#tb').datagrid({
                url:'${pageContext.request.contextPath}/master/showAllMaster',
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
                toolbar : "#tlb", //工具栏
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

        });


        //弹窗
        $(function() {
            //增
            $("#add").linkbutton({
                onClick:function(){
                    //展示一个对话框窗口
                    $("#dialog").dialog({
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
                                $("#ff").form("submit",{
                                    url:"${pageContext.request.contextPath}/master/addMaster",
                                    success:function(res){
                                        if(res=="success"){
                                            $.messager.alert('提示消息','上传成功');
                                            $("#dialog").dialog("close");
                                            $("#tb").datagrid({
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
                                $("#dialog").dialog("close");
                            }
                        }],
                    });
                },
            });
        });

        //修改
        function masModify(){
            var rowData = $("#tb").datagrid("getSelected");
            //展示一个对话框窗口
            $("#dialog").dialog({
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
                        $("#ff").form("submit",{
                            url:"${pageContext.request.contextPath}/master/modifyMaster",
                            success:function(res){
                                if(res=="success"){
                                    $.messager.alert('提示','修改成功');
                                    $("#dialog").dialog("close");
                                    $("#tb").datagrid({
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
                        $("#dialog").dialog("close");
                    }
                }],
                onLoad:function(){
                    $("#ff").form("load",rowData);//在加载时将行数据加载到表单元素中
                }
            });
        }

    </script>


    <table id="tb"></table>

    <div id="tlb" style="display: none">

        <a id="add" class="easyui-linkbutton"
           data-options="iconCls:'icon-add',plain:true,text:'新增上师'"></a>

        <a id="modify" class="easyui-linkbutton"
           data-options="iconCls:'icon-edit',plain:true,text:'修改上师信息'"></a>

        <a id="query" class="easyui-linkbutton"
           data-options="iconCls:'icon-help',plain:true,text:'根据上师的法名模糊查询'"></a>

        <a id="help" class="easyui-linkbutton"
           data-options="iconCls:'icon-help',plain:true,text:'批量插入'"></a>

    </div>

    <div id="dialog"></div>


