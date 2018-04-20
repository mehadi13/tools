
app.controller('studentController', function ($scope,$http, myService, urlService) {
        $scope.serviceMsg = myService.setMessage("Hello, I'm From Service");

        var url = "http://localhost:8080";
        $http.get(url).success(function (response) {
                console.log('Response');
                console.log(response);
                $scope.students = response;
        });

        $scope.checkvalue = true;

        $scope.edit = function(student1){
                console.log(student1);
                $scope.user = student1;
                $scope.checkvalue = $scope.checkvalue ? false : true;
                $scope.selectedOption = student1.option;
        }

        $scope.user = {
                id: 1,
                name: 'awesome user',
                status: 2,
                group: 4,
                groupName: 'admin'
        };

        $http.get('http://localhost:8080/options').success(function (response) {
                console.log('Response');
                console.log(response);
                $scope.options = response;
        });

       
});