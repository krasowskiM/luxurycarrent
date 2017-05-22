carRentApp.controller('userPanelController', function ($http, $rootScope, $scope, $state) {
    $scope.userTO = undefined;

    $http.get('api/userfunds').then(function (response) {
        $scope.userTO = response.data;
    });

    $scope.logout = function () {
        $rootScope.notLoggedIn = true;
        $state.go('logout');
    };
});