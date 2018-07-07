<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

<script type="text/javascript">
	$(function() {
		// 数据表格 加载远程数据 数据来源数据库
		$("#tb").datagrid({
			url : "${pageContext.request.contextPath}/master/showAllMaster",
			columns : [ [ {
				title : "编号",field : "masterId",
			}, {
				title : "姓名",field : "masterName",
			}, {
				title : "图片",field : "masterPhoto",
			} , {
				title : "简介",field : "masterSummary",
			} , {
                title : "操作",field:"operation",width:100,
				formatter:function(value,row,index){ // 格式化展示数据到对应的列
                    return "<a class='easyui-linkbutton' onclick='dePer()'>删除</a>  <a class='easyui-linkbutton' onclick='modify()'>查看详情</a>";
                }
            }] ],
			onLoadSuccess:function(){
                $.parser.parse();
            },
			pagination : true, //在DataGrid控件底部显示分页工具栏
			pageList : [ 5, 10, 15, 20, 25 ],
			pageSize : 5,
			toolbar : "#tlb", //工具栏
			fitColumns: true,
			singleSelect:true, //只允许选择一行
			striped:true //显示斑马线效果
		});
		
		
	});
	//弹窗
	$(function() {
		//增
		$("#add").linkbutton({
			onClick:function(){
				//展示一个对话框窗口
				$("#dialog").dialog({
					title:"窗口",
					width:600,
					height:400, 
					href:"${pageContext.request.contextPath}/add.jsp",
					modal:true,
					shadow:true,
					buttons:[{
						text:"保存",
						iconCls:"icon-save",
						handler:function(){
							$("#ff").form("submit",{
									url:"${pageContext.request.contextPath}/person/addPerson.do",
									success:function(res){
									    if(res=="success"){
									        $.messager.alert('提示','添加成功');
									        $("#dialog").dialog("close");
                                            $("#tb").datagrid({
                                                url : "${pageContext.request.contextPath}/person/queryPerson.do",
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
		
		//删
		$("#remove").linkbutton({
			onClick:function(){
				var rowData = $("#tb").datagrid("getSelected");
				$.messager.confirm("确认","确认删除用户" + rowData.name + "的所有信息吗",function(r){
				    if(r){
                        var result ="";
                        $.ajax({
                            type:"post",
                            async:false,
                            url:"${pageContext.request.contextPath}/person/removePerson.do",
                            data:{
                                "id" : rowData.id,
                            },
                            success:function(data){
                                result = data;
                                if (result == 1 ) {
                                    $.messager.alert('提示','删除成功，请刷新页面！');
                                } else {
                                    $.messager.alert('提示','删除失败！');
                                }
                            }
                        });
					}
				});
			
			}
		});

		
		//改
		$("#modify").linkbutton({
			onClick:function(){
				var rowData = $("#tb").datagrid("getSelected");
				//展示一个对话框窗口
				$("#dialog").dialog({
					title:"窗口",
					width:600,
					height:400, 
					href:"${pageContext.request.contextPath}/modify.jsp",
					modal:true,
					shadow:true,
					buttons:[{
						text:"保存",
						iconCls:"icon-save",
						handler:function(){
							$("#ff").form("submit",{
								url:"${pageContext.request.contextPath}/person/modifyPerson.do",
                                success:function(res){
                                    if(res=="success"){
                                        $.messager.alert('提示','修改成功');
                                        $("#dialog").dialog("close");
                                        $("#tb").datagrid({
                                            url : "${pageContext.request.contextPath}/person/queryPerson.do",
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
			},
		});

		
	});

    function dePer(){

		var rowData = $("#tb").datagrid("getSelected");
		$.messager.confirm("确认","确认删除用户" + rowData.name + "的所有信息吗",function(r){
			if(r){
				var result ="";
				$.ajax({
					type:"post",
					async:false,
					url:"${pageContext.request.contextPath}/person/removePerson.do",
					data:{
						"id" : rowData.id,
					},
					success:function(data){
						result = data;
						if (result == 1 ) {
							$.messager.alert('提示','删除成功，请刷新页面！');
						} else {
							$.messager.alert('提示','删除失败！');
						}
					}
				});
			}
		});
    };



	function modify(){
            var rowData = $("#tb").datagrid("getSelected");
            //展示一个对话框窗口
            $("#dialog").dialog({
                title:"窗口",
                width:600,
                height:400,
                href:"${pageContext.request.contextPath}/modify.jsp",
                modal:true,
                shadow:true,
                buttons:[{
                    text:"保存",
                    iconCls:"icon-save",
                    handler:function(){
                        $("#ff").form("submit",{
                            url:"${pageContext.request.contextPath}/person/modifyPerson.do",
                            success:function(res){
                                if(res=="success"){
                                    $.messager.alert('提示','修改成功');
                                    $("#dialog").dialog("close");
                                    $("#tb").datagrid({
                                        url : "${pageContext.request.contextPath}/person/queryPerson.do",
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
    };

</script>


	<table id="tb" ></table>
	 
	<div id="tlb" style="display: none">
			
		<a id="add" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true,text:'新增'"></a> 
			
		<a id="modify" class="easyui-linkbutton"
			data-options="iconCls:'icon-edit',plain:true,text:'修改'"></a> 
		
		<a id="remove" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel',plain:true,text:'删除'"></a>

	</div>  
	
	<div id="dialog"></div>
	

