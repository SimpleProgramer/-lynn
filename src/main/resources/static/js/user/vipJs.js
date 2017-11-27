$(function() {
	function loadTableJson() {
		$.ajax({
			url: ctx + "/admin/loadVipDatas",
			data:getPageJson(10,1),
			type:"post",
			dataType:"json",
			success:function(data) {
				if(200 == data.code) {
					$(".tableBody").html("");
					//解析到页面table
					var datas = "";
					$.each(data.list,function(index,item) {
						datas += "<tr>"
							+"<td>"+ item.id +"</td>"
							+"<td>"+ item.userName +"</td>"
							+"<td>"+ item.surplusAmount +"</td>"
							+"<td>"+ item.dateString +"</td>"
							+"<td>"+ item.userPhone +"</td>"
							+"<td><a href='#' onclick='loadVipUserInfo("+ item.id +")'><span>编辑</span></a>&nbsp;&nbsp;<a href='#'><span>删除</span></a></td>"
								+"</tr>";
					})
					$(".tableBody").append(datas);
				}
			},
			error:function() {
				alert(1);
			}
		})
	}
	$(".active").bind("click",loadTableJson);
	/*$(".active").click();*/
	$(".btn-edit").bind("click",editVipInfo);
	function editVipInfo() {
		var data = {
				"id":$("input[name=id]").val(),
				"vipName":$("input[name=vipName]").val(),
				"vipPhone":$("input[name=vipPhone]").val(),
				"vipAddress":$("input[name=vipAddress]").val(),
				"vipAmount":$("input[name=vipAmount]").val(),
				"pageIndex":1,
				"pageSize":10
		}
		$.ajax({
			url: ctx + "/admin/updateVipDatas",
			data:data,
			type:"post",
			dataType:"json",
			success:function(data) {
				if(200 == data.code) {
					$("."+data.obj.id+"id").text(data.obj.id);
					$("."+data.obj.id+"name").text(data.obj.vipName);
					$("."+data.obj.id+"amount").text(data.obj.vipAmount);
					$("."+data.obj.id+"phone").text(data.obj.vipPhone);
					$("#myModal").hide();
					$("input").val("");
					$(".active").click();
				}
			}
		})
	}
})