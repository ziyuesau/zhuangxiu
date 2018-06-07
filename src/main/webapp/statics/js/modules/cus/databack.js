$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'cus/databack/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '操作者', name: 'username', index: 'username', width: 80 }, 			
			{ label: '备份路径', name: 'path', index: 'path', width: 80 }, 			
			{ label: '操作时间', name: 'createTime', index: 'create_time', width: 80 },
			{
                    label: '操作', name: '', index: 'operate', width: 50, align: 'center',
                    formatter: function (cellvalue, options, rowObject) {
                        
                       return "<a onclick='lookup(\""+ rowObject.id + "\");' style='text-decoration:underline;color:blue'>查看</a>";
                    },
                },				
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

function lookup(id){
vm.showList = false;
			vm.showCode=true;
            vm.title = "详细信息";
            
            vm.getInfo(id)
}
var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		databack: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.databack = {};
		},
		rollback: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要还原选中的记录？', function(){
				alert("还原成功");
			});
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.databack.id == null ? "cus/databack/save" : "cus/databack/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.databack),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "cus/databack/delete",
				    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "cus/databack/info/"+id, function(r){
                vm.databack = r.databack;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});