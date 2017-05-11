carRentApp.controller('mainController', function ($scope) {
    $scope.notLoggedIn = true;
    $scope.regData = undefined;
    $scope.loginData = undefined;

    $scope.register = function () {

    };

    $scope.login = function () {
        $scope.notLoggedIn = false;
    };
});