<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" language="java" %>
<html>
<head>
	<title>首页</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/angular.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.tabletojson.js"></script>
</head>
<body>
	<div ng-app="myApp" ng-controller="siteCtrl"> 
		<ul>
		  <li ng-repeat="x in persons">
		    {{ x.name + ', ' + x.age }}
		  </li>
		</ul>
	</div>
	<script>
		var app = angular.module('myApp', []);
			
		app.controller('siteCtrl', function($scope, $http) {
			$http({
				method: 'post',
				url: '${pageContext.request.contextPath}/personList'
			}).then(function successCallback(response) {
					$scope.persons = response.data.persons;
				}, function errorCallback(response) {
					// 请求失败执行代码
			});
		  
		});
	</script>
	
	<table id="personId">
		<thead>
			<tr>
				<td>姓名<input type="hidden" value="name"></td>
				<td>年龄<input type="hidden" value="age"></td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><input type="text" value="tom"></td>
				<td><input type="text" value="11"></td>
			</tr>
			<tr>
				<td><input type="text" value="jack"></td>
				<td><input type="text" value="15"></td>
			</tr>
		</tbody>
	</table>
	
	<button onclick="clickTAble()">click</button>
<script type="text/javascript">
	function clickTAble(){
		 var a = TableToJson('personId');
		alert(a);
		 alert(JSON.stringify(a)); 
		/*   var table = $('#personId').tableToJSON(); // Convert the table into a javascript object
		  console.log(table);
		  alert(JSON.stringify(table)); */
	}

	function TableToJson(tableid) {
	    var txt = "[";
	    var table = document.getElementById(tableid);
	    var row = table.getElementsByTagName("tr");
	    var col = row[0].getElementsByTagName("td");
	    for (var j = 1; j < row.length; j++) {
	        var r = "{";
	        for (var i = 0; i < col.length; i++) {
	            var tds = row[j].getElementsByTagName("td");
	            r += "\"" + col[i].getElementsByTagName("input")[0].value + "\"\:\"" + tds[i].getElementsByTagName("input")[0].value + "\",";
	        }
	        r = r.substring(0, r.length - 1)
	        r += "},";
	        txt += r;
	    }
	    txt = txt.substring(0, txt.length - 1);
	    txt += "]";
	    return txt; 
	}



</script>
</body>
</html>