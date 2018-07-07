<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

	<script type="text/javascript">
		$(function(){

			$('#path').filebox({
				buttonText: "选择文件",
				buttonIcon: "icon-note",
				buttonAlign: 'right'
			})

			$('#status').combobox({
				limitToList:true,//设置为true时，输入的值只能是列表框中的内容
				panelHeight:60, //下拉面板高度

			});

		});

	</script>

	<br>
	<form id="ff" method="post" style="text-align: center" enctype="multipart/form-data">
		<table style="text-align: right">
			<tr>
				<td>轮播图描述：</td>
				<td>
					<input id="desc" class="easyui-textbox" style="width:230px" name="pictureDesc"/>
				</td>
			</tr>

			<tr>
				<td>轮播图状态：</td>
				<td>
					<select id="status" class="easyui-combobox" name="pictureStatus" style="width:230px;">
						<option value="未展示">不展示</option>
						<option value="展示中">展示</option>
					</select>
				</td>
			</tr>

			<tr>
				<td>上传轮播图：</td>
				<td>
					<input id="path" class="easyui-filebox" style="width:230px" name="myFile" />
				</td>
			</tr>

		</table>
	</form>

