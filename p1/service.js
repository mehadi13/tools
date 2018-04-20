app.service('myService', function () {
    this.message = '';
    this.setMessage = function (newMessage) {
        this.message = newMessage;
        return this.message;
    };
});

app.service('urlService', function ($http) {
    var url = "data.txt";
    return {
        getAll: function () {
            console.log('$http.get(url)');
            return $http.get(url);
        }
    }
});