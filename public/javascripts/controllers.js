var userApp = angular.module('userApp', []);

userApp.controller('userController', function ($scope,$http) {

    $scope.msg = "Hello"

    function getUsers(){
        $http.get('users').success(function(data) {
            $scope.users = data;
        });
    }

    getUsers();

//    $scope.users = [
//        {'id': 1,
//            'name': 'John'},
//        {'id': 2,
//            'name': 'Tom'}
//    ];

    $scope.addUser = function(){
        $http({
            url: '/user',
            method: "POST",
            data: {id: parseInt($scope.newuser.id), name: $scope.newuser.name},
            headers: { 'Content-Type': 'application/json' }
        }).success(function (data, status, headers, config) {
            //$scope.persons = data; // assign  $scope.persons here as promise is resolved here
            getUsers();
        }).error(function (data, status, headers, config) {
            //$scope.status = status;
        });
//      $scope.users.push(
//      {
//            id: $scope.newuser.id,
//          name: $scope.newuser.name
//      });
    }

    $scope.deleteUser = function(id){
        $http({
            url: '/user/'+parseInt(id),
            method: "DELETE",
            headers: { 'Content-Type': 'application/json' }
        }).success(function (data, status, headers, config) {
            //$scope.persons = data; // assign  $scope.persons here as promise is resolved here
            getUsers();
        }).error(function (data, status, headers, config) {
            //$scope.status = status;
        });
//      $scope.users.push(
//      {
//            id: $scope.newuser.id,
//          name: $scope.newuser.name
//      });
    }
});
