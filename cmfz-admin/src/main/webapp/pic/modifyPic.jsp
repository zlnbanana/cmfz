<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

	<script type="text/javascript">
		$(function(){

        });

	</script>

	<br>
	<form id="ff" method="post">
		<table style="text-align: right">
			<tr>
				<td>标识编号：</td>
				<td>
					<input id="pid" class="easyui-textbox" style="width:230px" name="pictureId" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>文件名：</td>
				<td>
					<input id="path" class="easyui-textbox" style="width:230px" name="picturePath"/>
				</td>
			</tr>

			<tr>
				<td>轮播图创建时间：</td>
				<td>
					<input id="date" class="easyui-textbox" style="width:230px" name="pictureDate" readonly="readonly" />
				</td>
			</tr>

			<tr>
				<td>描述信息：</td>
				<td>
					<input id="desc" class="easyui-textbox" style="width:230px" name="pictureDesc"/>
				</td>
			</tr>

			<tr>
				<td>轮播图状态：</td>
				<td>
					<input id="status" class="easyui-textbox" style="width:230px" name="pictureStatus">
				</td>
			</tr>



		</table>
	</form>

