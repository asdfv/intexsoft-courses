var usersURL = 'http://localhost:8080/userapp/user/all';

var usersButton = document.getElementById("usersButton");

var printArray = function (array) {
    var table = document.createElement("table");
    table.className = "table table-striped table-condensed";
    var row = table.insertRow(-1);
    row.insertCell(-1).innerHTML = "<b>Id</b>";
    row.insertCell(-1).innerHTML = "<b>Name</b>";
    for (var index = 0; index < array.length; index++) {
        var row = table.insertRow(-1);
        var idCell = row.insertCell(-1);
        idCell.innerHTML = array[index].id;
        var nameCell = row.insertCell(-1);
        nameCell.innerHTML = array[index].name;
    }
    document.body.appendChild(table);
}

var fetchUsers = function () {
    fetch(usersURL)
        .then(function (response) {
            response.json()
                .then(function (arrayData) {
                    printArray(arrayData);
                });
        });
}

usersButton.addEventListener("click", fetchUsers);
