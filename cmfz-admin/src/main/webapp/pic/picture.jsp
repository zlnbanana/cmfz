<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

    <script type="text/javascript">
        $(function(){
            $('#pictb').datagrid({
                url:'${pageContext.request.contextPath}/pic/showAllPic',
                columns:[[
                    {field:'pictureId',title:'标识编号',width:150},
                    {field:'picturePath',title:'文件名',width:120,},
                    {field:'pictureDesc',title:'描述信息',width:120,},
                    {field:'pictureStatus',title:'轮播图状态',width:120,},
                    {field:'pictureDate',title:'轮播图创建时间',width:120,},
                    {field:'operation',title:'操作',width:50,
                            formatter:function(value,row,index){ // 格式化展示数据到对应的列
                                return "<a class='easyui-linkbutton' data-options=\"iconCls:'icon-edit' \" onclick='picModify()'>修改</a>"
                            }
                    }
                ]],
                onLoadSuccess:function(){
                    $.parser.parse(); //解析器  解析所有页面
                },
                pagination : true, //在DataGrid控件底部显示分页工具栏
                pageList : [ 5, 10, 15, 20, 25 ],
                pageSize : 5,
                toolbar : "#pictlb", //工具栏
                fitColumns: true, //真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。
                singleSelect:true, //只允许选择一行
                striped:true, //显示斑马线效果
                remoteSort:false, //定义从服务器对数据进行排序
                nowrap:false, //如果为true，则在同一行中显示数据。设置为true可以提高加载性能。


                view: detailview,
                // 展示内容
                detailFormatter: function(rowIndex, rowData){//detailFormatter函数返回行详细内容
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/picture/'+ rowData.picturePath +'" style="height:50px;"></td>' +
                        '</tr></table>';
                }
            });

        });


        //弹窗
        $(function() {
            //增
            $("#picadd").linkbutton({
                onClick:function(){
                    //展示一个对话框窗口
                    $("#picdialog").dialog({
                        title:"新增轮播图",
                        width:500,
                        height:300,
                        href:"${pageContext.request.contextPath}/pic/addPic.jsp",
                        modal:true,
                        shadow:true,
                        buttons:[{
                            text:"保存",
                            iconCls:"icon-disk",
                            handler:function(){
                                $("#picff").form("submit",{
                                    url:"${pageContext.request.contextPath}/pic/addPic",
                                    success:function(res){
                                        if(res=="success"){
                                            $.messager.alert('提示消息','上传成功');
                                            $("#picdialog").dialog("close");
                                            $("#pictb").datagrid({
                                                url : "${pageContext.request.contextPath}/pic/showAllPic",
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
                                $("#picdialog").dialog("close");
                            }
                        }],
                    });
                },
            });

            //修改
            $("#picmodify").linkbutton({
                onClick: function () {
                    var rowData = $("#pictb").datagrid("getSelected");
                    //展示一个对话框窗口
                    $("#picdialog").dialog({
                        title:"修改轮播图信息",
                        width:500,
                        height:300,
                        href:"${pageContext.request.contextPath}/pic/modifyPic.jsp",
                        modal:true,
                        shadow:true,
                        buttons:[{
                            text:"保存",
                            iconCls:"icon-disk",
                            handler:function(){
                                $("#picff").form("submit",{
                                    url:"${pageContext.request.contextPath}/pic/modifyPic",
                                    success:function(res){
                                        if(res=="success"){
                                            $.messager.alert('提示','修改成功');
                                            $("#picdialog").dialog("close");
                                            $("#pictb").datagrid({
                                                url : "${pageContext.request.contextPath}/pic/showAllPic",
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
                                $("#picdialog").dialog("close");
                            }
                        }],
                        onLoad:function(){
                            $("#picff").form("load",rowData);//在加载时将行数据加载到表单元素中
                        }
                    });

                }
            });

        });

        //修改
        function picModify(){
            var rowData = $("#pictb").datagrid("getSelected");
            //展示一个对话框窗口
            $("#picdialog").dialog({
                title:"修改轮播图信息",
                width:500,
                height:300,
                href:"${pageContext.request.contextPath}/pic/modifyPic.jsp",
                modal:true,
                shadow:true,
                buttons:[{
                    text:"保存",
                    iconCls:"icon-disk",
                    handler:function(){
                        $("#picff").form("submit",{
                            url:"${pageContext.request.contextPath}/pic/modifyPic",
                            success:function(res){
                                if(res=="success"){
                                    $.messager.alert('提示','修改成功');
                                    $("#picdialog").dialog("close");
                                    $("#pictb").datagrid({
                                        url : "${pageContext.request.contextPath}/pic/showAllPic",
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
                        $("#picdialog").dialog("close");
                    }
                }],
                onLoad:function(){
                    $("#picff").form("load",rowData);//在加载时将行数据加载到表单元素中
                }
            });
        }

    </script>


    <table id="pictb"></table>

    <div id="pictlb" style="display: none">

        <a id="picadd" class="easyui-linkbutton"
           data-options="iconCls:'icon-add',plain:true,text:'新增轮播图'"></a>

        <a id="picmodify" class="easyui-linkbutton"
           data-options="iconCls:'icon-edit',plain:true,text:'修改轮播图信息'"></a>

        <a id="pichelp" class="easyui-linkbutton"
           data-options="iconCls:'icon-help',plain:true,text:'帮助'"></a>

    </div>

    <div id="picdialog"></div>


