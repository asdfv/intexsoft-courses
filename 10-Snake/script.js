var size = 20;
var snake = {
    "tailLength": 9,
    "speed": 10
};
var genGridDivs;
var setClass;
var initSnakeBody;
var snakeBody;
var random;
var genFood;
var foodId;
var headId;
var traceHandler;
var move;

if (snake.tailLength >= size) {
    var massage = "The length of the snake must be smaller than size!";
    alert(massage);
    throw new Error(massage);
}
genGridDivs = function(size) {
    var container = document.body;
    for (var row = 0; row < size; row++) {
        var line = document.createElement("div");
        line.className = "row";
        line.id = "line" + row;
        for (var col = 0; col < size; col++) {
            var cell = document.createElement("div");
            cell.className = "cell";
            cell.id = col + "-" + row;
            line.appendChild(cell);
        }
        container.appendChild(line);
    }
}
initSnakeBody = tailLength => {
    var snakeBody = [];
    for (var col = 0; col < tailLength; col++) {
        snakeBody.push(col + "-0");
    }
    snakeBody.forEach(id => setClass("snake", id));
    return snakeBody;
};
random = (min, max) => {
    return Math.floor(Math.random() * (max - min)) + min;
};
genFood = snakeBody => {
    if (snake.tailLength > size * size - 2) {
        alert("Game over");
    }
    var col;
    var row;
    var id;
    do {
        col = random(0, size);
        row = random(0, size);
        id = col + "-" + row;
    } while (snakeBody.includes(id));
    setClass("food", id);
    return id;
};

setClass = (clazz, id) => {
    document.getElementById(id).className = clazz;
};

genGridDivs(size);
snakeBody = initSnakeBody(snake.tailLength);
foodId = genFood(snakeBody);
headId = snakeBody[snake.tailLength - 1];

traceHandler = id => {
    snakeBody.push(id);
    if (snakeBody.length > snake.tailLength) {
        return snakeBody.shift();
    }
    return "0-0";
};
move = speed => {
    var row = 0;
    var col = snake.tailLength;
    setInterval( () => {
        headId = col + "-" + row;
        setClass("snake", headId);
        var tailId = traceHandler(headId);
        setClass("cell", tailId);

        if (headId == foodId) {
            snake.tailLength += 3;
            foodId = genFood(snakeBody);
        }
        col++;
        if (col == size) {
            col = 0;
            row++;
        }
        if (row == size) {
            col = 0;
            row = 0;
        }
    }, 1000 / speed)
};
move(snake.speed);
