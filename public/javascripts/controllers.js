var userApp = angular.module('userApp', []);

userApp.controller('userCtrl', function ($scope,$http) {
  $scope.phones = [
    {'name': 'Nexus S',
     'snippet': 'Fast just got faster with Nexus S.'},
    {'name': 'Motorola XOOM™ with Wi-Fi',
     'snippet': 'The Next, Next Generation tablet.'},
    {'name': 'MOTOROLA XOOM™',
     'snippet': 'The Next, Next Generation tablet.'}
  ];
  $scope.hello = 'Hello message'

  $http.get('user').success(function(data) {
    $scope.user = data;
  });
});
