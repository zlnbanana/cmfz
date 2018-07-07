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
				<td>上师编号：</td>
				<td>
					<input id="mid" class="easyui-textbox" style="width:230px" name="masterId" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>上师法名：</td>
				<td>
					<input id="name" class="easyui-textbox" style="width:230px" name="masterName"/>
				</td>
			</tr>

			<tr>
				<td>上师图片：</td>
				<td>
					<input id="date" class="easyui-textbox" style="width:230px" name="masterPhoto" />
					<%--<input id="photo" class="easyui-filebox" style="width:230px" name="myFile" />--%>
				</td>
			</tr>

			<tr>
				<td>上师简介：</td>
				<td>
					<input id="sum" class="easyui-textbox" style="width:230px" name="masterSummary"/>
				</td>
			</tr>

		</table>
	</form>

