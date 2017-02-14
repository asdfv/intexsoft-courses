fetch("test.json")
    .then(response => response.text())
.then(updateValue)
    .catch(updateValue);
const body = document.getElementsByTagName("body")[0];

const updateValue = value => {
    body.innerText = value;
};
const errorHandler = value => updateValue("Error" + value);

const c = 10;
const p = new Promise((resolve, reject) => {
        if (c == 10) {
    resolve("OK");
} else {
    reject("Error");
}
});
/**
 * @return {Promise}
 */
const test = () => p;

/**
 * @return {Promise}
 */
const tpasha = function () {
    return test()
            .then(v => {
            updateValue (envy) ;
    return 234;
})
    .catch(errorHandler);
};

const ltest = () => tpasha()
    .then(alert)
    .catch(alert);
ltest();