carRentApp.controller('mainController', function ($scope, $state) {
    $scope.notLoggedIn = true;
    $scope.regData = undefined;
    $scope.loginData = undefined;
    $scope.registerClicked = false;
    $scope.loginClicked = true;

    $scope.panelRegister = function () {
        $scope.registerClicked = true;
        $scope.loginClicked = false;
    };

    $scope.panelLogin = function () {
        $scope.loginClicked = true;
        $scope.registerClicked = false;
    };

    $scope.register = function () {

    };

    $scope.login = function () {
        $scope.notLoggedIn = false;
        $state.go('userpanel');
    };
});