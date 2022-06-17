var promise = new Promise(function (resolve, reject) {
    reject('abc');
})

promise.then((res) => console.log(res)).catch((err) => console.log(err))

let p1 = new Promise(
    (resolve, reject) => {
        resolve('success')
    }
)

let p2 = new Promise(
    (resolve, reject) => {
        resolve('成功')
    }
)

let p3 = Promise.reject('failed')

Promise.all([p1, p2]).then((result) => {
    console.log(result);
}).catch((err) => {
    console.log(err);
})

Promise.all([p1, p2, p3]).then((result) => {
    console.log(result);
}).catch((err) => {
    console.log(err);
})




