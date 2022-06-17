const isPregnant = true;

const promise = new Promise((resolve, reject) => {
    if (isPregnant) {
        resolve('ta die')
    } else {
        reject('lao gong')
    }
});

promise.then(n => console.log(`become ${n}`))
    .catch(n => console.log(`become ${n}`))
    .finally(() => console.log('marry'))