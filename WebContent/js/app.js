(function() {

	var app = angular.module('Contacts', []);

	app
			.controller(
					'ContactsController',
					function($http) {
						var cont = this;
						$http
								.get(
										'http://localhost:8080/RestClint/handlethose/peoples/contacts/get')
								.success(function(response) {
									if (response.length == 0) {
										/* cont.contact=[{}]; */

										console.log("IFFF");
									} else {
										cont.contact = response;
										console.log("Else");
									}
									console.log(response);
								});

						/*
						 * cont.contact=[ { "name": "Santa", "number":
						 * "9177595206" }, { "name": "Baby", "number":
						 * "987795206" }, { "name": "Royale", "number":
						 * "9876543214" }, { "name": "Spin", "number":
						 * "9856314756" } ];
						 * 
						 */
					});
	app
			.controller(
					'ContactAddController',
					function($http) {

						this.con = {};
						this.addContact = function(cntact) {
							/*
							 * cntact.push(this.con);
							 * console.log(this.con.name+"ADD");
							 * console.log(this.con.number+"ADD"); this.con={};
							 */
							$http
									.post(
											'http://localhost:8080/RestClint/handlethose/peoples/contacts/post',
											{}, {
												params : {
													name : this.con.name,
													number : this.con.number
												}
											}).success(function(response) {

										console.log(response);
									});
							console.log(this.con);
							if (cntact.length == 0) {

								/*
								 * cntact=[{}]; cntact.pop();
								 */
								cntact.push(this.con);
								console.log("IF" + cntact);
								this.con = {};
							} else {
								cntact.push(this.con);
								this.con = {};
								console.log("ELSE" + cntact);
							}
						};

					});
	app
			.controller(
					'DeleteController',
					function($http) {
						this.con = {};
						this.deleteContact = function(cntact) {

							if (!cntact.length == 0) {
								var o = cntact.pop(this.con);
								var num = o.number;
								var na = o.name;

								$http(
										{
											method : 'DELETE',
											url : 'http://localhost:8080/RestClint/handlethose/peoples/contacts/delete',
											params : {
												name : na,
												number : num
											}
										}).then(function(response) {

									console.log(response);
								});
							} else {

								alert("Contacts Deleted!!");

							}
						};
					});

	app
			.controller(
					'UpdateController',
					function($scope, $http) {
						this.con = {};

						this.updateContact = function(cntact) {
							var na = document.getElementById("namee").value;
							var num = document.getElementById("numbere").value;

							$http
									.put(
											'http://localhost:8080/RestClint/handlethose/peoples/contacts/put',
											{}, {
												params : {
													name : na,
													number : num
												}
											})
									.success(
											function(response) {
												for (i = 0; i < cntact.length; i++) {
													console.log(cntact[i].name
															+ "UP");
													if (cntact[i].name == na) {
														console
																.log(cntact[i].name
																		+ "UP");
														cntact[i].name = na;
														cntact[i].number = num;

													}
												}
												console.log(response);
												//alert(response);
												//$scope.mess=response;
											});

						};

					});

})();
