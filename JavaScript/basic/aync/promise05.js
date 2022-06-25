new Promise((resolve, reject) => {
    setTimeout(() => {
        console.log('我执行了');
        resolve('ok')
    }, 3000);
}).then(data => {
    return new Promise((resolve, reject) => {
        console.log(data);
        resolve('d1')
    });
}).then(data => console.log(data, 1))