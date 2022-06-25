const p = new Promise((resolve, reject) => {
    if (10 > 2) {
        resolve('ok1')
    } else {
        reject('no')
    }
}).then(n => console.log(n))

console.log(p);

const p2 = new Promise((resolve, reject) => {
    resolve('ok2')
}).then(n => console.log(n))


const p3 = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve('yay1!')
    }, 3000);
}).then(n => console.log(n))

const p4 = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve('yay2!')
    }, 2000);
}).then(n => console.log(n))

