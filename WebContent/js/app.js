(function() {

	var app=angular.module('Contacts',[]);
	
	app.controller('ContactsController', function(){
	    var cont = this;
	    cont.contact=[
	           	  {
	           	    "name": "Santa",
	           	    "number": "9177595206"
	           	  },
	           	  {
	           		    "name": "Baby",
	           		    "number": "987795206"
	           	  },
	           	{
	           		    "name": "Royale",
	           		    "number": "9876543214"
	           	  },
	           	{
	           		    "name": "Spin",
	           		    "number": "9856314756"
	           	  }
	           	];

	    
	  });
	app.controller('ContactAddController',function() {
		
		this.con={};
		this.addContact=function(cntact){
			cntact.push(this.con);
			console.log(this.con.name+"ADD");
			console.log(this.con.number+"ADD");
			this.con={};	
		};
		
	});	
	app.controller('DeleteController',function() {
		this.con={};
		this.deleteContact=function(cntact) {

			console.log("absc");
			cntact.pop(this.con);
		};
	});
	
	
	app.controller('UpdateController',function() {
		this.con={};
		
			this.updateContact=function(cntact) {
				var na=document.getElementById("namee").value;
				
				var num=document.getElementById("numbere").value;
				for(i=0;i<cntact.length;i++) {
					console.log(cntact[i].name+"UP");
					if(cntact[i].name==na) {
						console.log(cntact[i].name+"UP");
						cntact[i].name=na;
						cntact[i].number=num;					
						
					}
				}
			};
		
	});

})();



/*
 
	app.controller('UpdateController',['$scope',function($scope) {
		$scope.updateCtrl.con=[];
		$scope.updateCtrl.con.number;
		$scope.updateCtrl.con.name;
		$scope.$watch("updateCtrl.con.name","updateCtrl.con.number",function(newVal,oldVal) {
			if($scope.updateCtrl.con.name!="" && $scope.updateCtrl.con.number!="")
				{
					console.log($scope.updateCtrl.con.name);
					console.log($scope.updateCtrl.con.number);
				}
			else
				{	
				console.log($scope.updateCtrl.con.name);
				console.log($scope.updateCtrl.con.number);
				
				}
		},true);
		this.updateContact=function(cntact) {
			
			
			
			for(i=0;i<cntact.length;i++) {
				if(cntact[i].name==$scope.updateCtrl.con.name) {
					cntact[i].number=$scope.updateCtrl.con.number;
				}
			}
			console.log($scope.updateCtrl.con.name);
			console.log($scope.updateCtrl.con.number);
		
			console.log(cntact);
			console.log(this.con);
			//this.con={};
		};
	}]);
*/
