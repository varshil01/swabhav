angular.module('scm-app', ["ngRoute"])
    .config(function ($routeProvider) {
        $routeProvider

           
            .when("/login", {
                templateUrl: "Login.html",
                controller: "loginController"
            })
            .when("/adminlogin", {
                templateUrl: "AdminLogin.html",
                controller: "adminloginController"
            })
            .when("/signup", {
                templateUrl: "signup.html",
                controller: "registrationController"
            })

            .when("/subscription", {
                templateUrl: "subscription.html",
                controller: "subscriptionController"
            })
            .when("/viewsubscription", {
                templateUrl: "ViewSubscription.html",
                controller: "viewsubscriptionController"
            })
            .when("/admin", {
                templateUrl: "Admin.html",
                controller: "adminController"
            })
 .when("/logout", {
 templateUrl: "home.html",
 controller: "logoutController"
 })

    })
    .factory('tenantservice', ['$q', '$log', '$http', function ($q, $log, $http) {
        const object = {};
        object.checkTenantExist = (tenant => {
            return $q((resolve, reject) => {


                var jsontenant = JSON.stringify(tenant);

                $http({
                    method: "POST",
                    url: "http://localhost:8080/scm-app/register",
                    data: jsontenant,
                    dataType: "json",
                    contentType: 'application/json',
                    async: true

                }).then(response => {
                    resolve(response.data.urlExists);
                }).catch(error => {
                    $log.log(error);
                    reject("error occured")

                })



            })

        })

        return object;
    }])
    .factory('loginservice', ['$q', '$log', '$http', function ($q, $log, $http) {
        const object = {};
        object.saveCredentials = ((tenant, credential) => {
            return $q((resolve, reject) => {


                var jsontenant = JSON.stringify(tenant);


                $http({
                    method: "POST",
                    url: "http://localhost:8080/scm-app/savecredentials",
                    data: jsontenant,
                    dataType: "json",
                    contentType: 'application/json',
                    async: true

                }).then(response => {
                    resolve("details are saved");
                }).catch(error => {
                    $log.log(error);
                    reject("error occured while storing credentials")

                })



            })

        })
        object.authenticate = ((username, password) => {
            return $q((resolve, reject) => {
                var credentailobj = {
                    username: username,
                    password: password
                }

                var jsoncredentailobj = JSON.stringify(credentailobj);
                $http({
                    method: "POST",
                    url: "http://localhost:8080/scm-app/authenticate",
                    data: jsoncredentailobj,
                    dataType: "json",
                    contentType: 'application/json',
                    async: true

                }).then(response => {
                    resolve(response.data.authstatus);
                }).catch(error => {
                    $log.log(error);
                    reject("error occured")

                })



            })
        })
        object.authenticateAdmin = ((username, password) => {
            return $q((resolve, reject) => {
                var credentailobj = {
                    username: username,
                    password: password
                }

                var jsoncredentailobj = JSON.stringify(credentailobj);
                $http({
                    method: "POST",
                    url: "http://localhost:8080/scm-app/authenticateadmin",
                    data: jsoncredentailobj,
                    dataType: "json",
                    contentType: 'application/json',
                    async: true

                }).then(response => {
                    resolve(response.data.authstatus);
                }).catch(error => {
                    $log.log(error);
                    reject("error occured")

                })



            })
        })
        return object;

    }])
    .factory('localstorageservice', ['$q', function ($q) {
        const object = {};

        object.setStateInLocalStorage = ((tenant_id, username,state) => {
            return $q(resolve => {
                localStorage.setItem("id", tenant_id);
                localStorage.setItem("username", username);
                localStorage.setItem("state", state);
                resolve("state has set");
            })

        })

        object.getStateFromLocalStorage = (() => {
            return $q(resolve => {
                var state = localStorage.getItem("state");
                if (state = "true") {
                    state = true;
                }
                else {
                    state = false;
                }
                resolve(state);
            })
        })
        object.getUsernameFromLocalStorage = function () {
            return $q((resolve) => {
                var username = localStorage.getItem("username");
                resolve(username);
                console.log("get username from localstorage");
            })
        }
        object.getTenantIdFromLocalStorage = (() => {
            var tenant_id = localStorage.getItem("id");
            return (tenant_id);


        })
        return object;
    }])
    .factory('moduleandsupportservice', ['$q', '$log', '$http', function ($q, $log, $http) {
        const object = {};

        object.getAllModuleAndSupport = function () {
            return $q((resolve, reject) => {
                $http({
                    method: "GET",
                    url: "http://localhost:8080/scm-app/getmoduleandsupport",


                }).then(response => {
                    resolve(response);
                }).catch(error => {
                    $log.log(error);
                    reject("error occured")

                })


            })
        }

        return object;
    }])
    .factory('subscriptionservice', ['$q', '$log', '$http', function ($q, $log, $http) {
        const object = {};

        object.saveSubscription = function (subscription, id) {

            return $q((resolve, reject) => {
                var jsonSubscriptionObject = JSON.stringify(subscription);
                $http({
                    method: "POST",
                    url: "http://localhost:8080/scm-app/savesubscription?id=" + id,
                    data: jsonSubscriptionObject,
                    dataType: "json",
                    contentType: 'application/json',
                    async: true


                }).then(response => {
                    resolve(response);
                }).catch(error => {
                    $log.log(error);
                    reject("error occured")

                })


            })
        }

        object.viewSubscription = function (id) {

            return $q((resolve, reject) => {

                $http({
                    method: "GET",
                    url: "http://localhost:8080/scm-app/viewsubscription?id=" + id,
                    async: true


                }).then(response => {
                    resolve(response.data.subscriptions);
                }).catch(error => {
                    $log.log(error);
                    reject("error occured")

                })


            })
        }



        return object;
    }])
    .factory('adminservice', ['$q', '$log', '$http', function ($q, $log, $http) {
        const object = {};


        object.getAllSubscriptions = function () {

            return $q((resolve, reject) => {

                $http({
                    method: "GET",
                    url: "http://localhost:8080/scm-app/getallsubscriptions",
                    async: true


                }).then(response => {
                    resolve(response.data);
                }).catch(error => {
                    $log.log(error);
                    reject("error occured")

                })


            })
        }
        object.approveSubscription = function (sub_id) {

            return $q((resolve, reject) => {

                $http({
                    method: "GET",
                    url: "http://localhost:8080/scm-app/approve?sub_id="+sub_id,
                    async: true


                }).then(response => {
                    resolve(response.data);
                }).catch(error => {
                    $log.log(error);
                    reject("error occured")

                })


            })
        }
        object.rejectSubscription = function (sub_id) {

            return $q((resolve, reject) => {

                $http({
                    method: "GET",
                    url: "http://localhost:8080/scm-app/reject?sub_id="+sub_id,
                    async: true


                }).then(response => {
                    resolve(response.data);
                }).catch(error => {
                    $log.log(error);
                    reject("error occured")

                })


            })
        }

        object.cancelSubscription = function (sub_id) {

            return $q((resolve, reject) => {

                $http({
                    method: "GET",
                    url: "http://localhost:8080/scm-app/cancel?sub_id="+sub_id,
                    async: true


                }).then(response => {
                    resolve(response.data);
                }).catch(error => {
                    $log.log(error);
                    reject("error occured")

                })


            })
        }




        return object;
    }])

    .controller('homeController', ['$scope', '$log', '$rootScope','localstorageservice',function ($scope, $log, $rootScope,localstorageservice) {
    	$log.log("home controller");
    	$rootScope.authenticated=false;
    	
    	$rootScope.nextButton = true;
        $rootScope.tenant = {};
        localstorageservice.getUsernameFromLocalStorage().then(response=>{
        	$log.log(response);
            if(response==="root"){
            	$rootScope.username="root";
            	$rootScope.authenticated=true;
                window.location.href="#admin/";
            }
            else if(response === "null"){
            	$rootScope.authenticated=false;
            	window.location.href="#/";
            	$log.log("coming to else if of home controller");
            	
            }
            else{
            	$log.log("coming to else of home controller");
            	$rootScope.username=response;
            	$rootScope.authenticated=true;
                window.location.href="#viewsubscription/";
            }
            
        })
        
        
     }])
    .controller('loginController', ['$scope', '$log', '$rootScope', 'loginservice', 'localstorageservice', function ($scope, $log, $rootScope, loginservice, localstorageservice) {
        $scope.c_password = '';
        $scope.displaystatus = '';
        
        $scope.authenticate = function () {
            $log.log("coming to authenticate function");
            if ($rootScope.nextButton == true) {
                $log.log("authenticating the login details");
                loginservice.authenticate($rootScope.tenant.username, $rootScope.tenant.password).then(response => {
                    if(response) {

                        $log.log("you are authenticated user");
                        $rootScope.authenticated=true;
                        return localstorageservice.setStateInLocalStorage(response, $rootScope.tenant.username);

                        
                    }
                    else {
                    	$scope.displaystatus = 'Please enter valid credentials';
                    }
                }).then(res => {
                    $log.log(res);
                    $log.log("redirecting to view subscription page")
                    window.location.href = "#viewsubscription/";
                }).catch((error) => {
                    $log.log(error);
                })

            }
            else if ($rootScope.tenant.password === $scope.c_password) {
                $log.log("password and confirm password are same");
                $log.log("saving the login details");
                loginservice.saveCredentials($rootScope.tenant).then(response => {
                	$rootScope.authenticated=true;
                    return localstorageservice.setStateInLocalStorage(response, $rootScope.tenant.username);
                }).then((response) => {
                    
                    window.location.href = "#viewsubscription/";
                }).catch(error => {
                    $log.log(error);
                })


            }
            else {
                $scope.displaystatus = "password and confirm password are not same ";
                return false;
            }



        }
        $log.log("inside login controller");
       
    }])
    .controller('registrationController', ['$scope', '$log', 'tenantservice', '$rootScope', function ($scope, $log, tenantservice, $rootScope) {


        $scope.saveButton = false;
        $scope.saveButtonClicked = false;
        $scope.displaymessage = false;
        $log.log("inside registration controller");
        $scope.saveDetails = function () {
            $scope.saveButtonClicked = true;
            tenantservice.checkTenantExist($rootScope.tenant).then(response => {
                if (response == true) {
                    $scope.displaymessage = true;
                }
                else {
                    $rootScope.nextButton = false;
                    $scope.saveButton = true;

                }
                $log.log(response);
            }).catch(error => {
                $log.log(error);
            })
            console.log("inside getDetails method");
            $log.log($scope.tenant);

        }


    }])
    .controller('adminloginController', ['$scope', '$log', '$rootScope', 'loginservice', 'localstorageservice', function ($scope, $log, $rootScope, loginservice, localstorageservice) {
        $scope.displaystatus = '';
        $scope.admin = {};
        $scope.authenticateAdmin = function () {
            $log.log("coming to authenticate admin function");
            $log.log("authenticating the admin  login details");

            loginservice.authenticateAdmin($scope.admin.username, $scope.admin.password).then(response => {
                if (response == true) {
                    $log.log("you are authenticated admin");
                    $rootScope.authenticated=true;
                    $log.log("redirecting to admin page")
                    window.location.href = "#admin/";
                    return localstorageservice.setStateInLocalStorage(null, $scope.admin.username,true);

                }
                else {
                    $scope.displaystatus = 'Admin Please enter valid credentials';
                }
            }).then((response) => {
                $log.log(response);
                
            }).catch((error) => {
                $log.log(error);
            })

        }


        $log.log("inside login controller");
    }])
    .controller('subscriptionController', ['$scope', '$log', '$rootScope', 'moduleandsupportservice', 'localstorageservice', 'subscriptionservice', function ($scope, $log, $rootScope, moduleandsupportservice, localstorageservice, subscriptionservice) {
        $scope.subscription = {};
        $log.log("coming to subscription controller");
        $scope.types = ["saas", "on premise"];
        $scope.modules = [];
        $scope.services = [];
        $scope.selectedservices = [];
        $scope.selectedmodules = [];
        $scope.subscription.selectedservices = [];
        $scope.subscription.selectedmodules = [];
        $scope.disablesubmitbutton=false;
        var id = localstorageservice.getTenantIdFromLocalStorage();


        $scope.submitForApporval = function () {
        	$scope.disablesubmitbutton=true;
            $scope.selectedservices.map((x) => {

                if (x.selected == true) {
                    var service_id = x.id;
                    $log.log(x.id);
                    $scope.subscription.selectedservices.push(service_id);
                }
            })
            $scope.selectedmodules.map((x) => {
                if (x.selected == true) {
                    var module_id = x.id;
                    $log.log(x.id)
                    $scope.subscription.selectedmodules.push(module_id);
                }
            })

            $log.log("Selected modules are: " + $scope.subscription.selectedmodules);
            $log.log("Selected services are: " + $scope.subscription.selectedservices);


            subscriptionservice.saveSubscription($scope.subscription, id).then((response) => {
                $log.log(response);
            }).catch(error => {
                $log.log(error);
            })
        }
        moduleandsupportservice.getAllModuleAndSupport().then((response) => {
            $scope.services = response.data.listofservices;
            $scope.modules = response.data.modules;
            $scope.modules.map((x) => {
                var element = {
                    id: x.module_id,
                    name: x.name,
                    selected: false
                }
                $scope.selectedmodules.push(element);

            })
            $scope.services.map((x) => {
                var element = {
                    id: x.service_id,
                    name: x.name,
                    selected: false
                }
                $scope.selectedservices.push(element);

            })


        }).catch(error => {
            console.log(error);
        })

    }])
    .controller('viewsubscriptionController', ['subscriptionservice', '$scope', '$log', 'localstorageservice', function (subscriptionservice, $scope, $log, localstorageservice) {
        var id = localstorageservice.getTenantIdFromLocalStorage();
        $log.log("coming to view subscription controller");
        subscriptionservice.viewSubscription(id).then(response => {
            $scope.subscriptions = response;
            $log.log($scope.subscriptions);
        }).catch(error => {
            $log.log(error);
        })
    }])
    .controller('adminController', ['adminservice', '$scope', '$log', 'localstorageservice', function (adminservice, $scope, $log, localstorageservice) {
        $log.log("coming to admin page controller");
        
        $scope.approveSubscription=function(sub_id){
        	$log.log(sub_id);
        	adminservice.approveSubscription(sub_id).then(respone=>{
        		 window.location.href = "#admin/";
        	})
        }
        $scope.cancelSubscription=function(sub_id){
        	$log.log(sub_id);
        	adminservice.cancelSubscription(sub_id).then(respone=>{
        		 window.location.href = "#admin/";
        	})
        }
        $scope.rejectSubscription=function(sub_id){
        	$log.log(sub_id);
        	adminservice.rejectSubscription(sub_id).then(respone=>{
        		 window.location.href = "#admin/";
        	})
        }
            adminservice.getAllSubscriptions().then(response => {
            $scope.subscriptions = response.subscriptions;
            $scope.tenants = response.tenants;
            $scope.partners = response.partners;
            
            $log.log($scope.subscriptions);
        }).catch(error => {
            $log.log(error);
        })
    }])
 .controller('logoutController', ['$rootScope', '$scope', '$log','localstorageservice', function ($rootScope, $scope, $log, localstorageservice) {
 $log.log("coming to logout controller");
        
 	localstorageservice.setStateInLocalStorage(null, null, false).then(reponse => {
         $log.log("user is logout");
         
 })
      $rootScope.authenticated=false; 

        
 }])

.filter('checkstatus', function () {
        return function (status) {
            if (status == "pending") {
                return true;
            }
            else {
                return false;
            }
        }
    })
