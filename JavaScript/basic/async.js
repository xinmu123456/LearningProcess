import fetch from "node-fetch";

setTimeout(() => {
    console.log('你好');
}, 1000);

console.log('hello');

async function bb() {
    return 'bb';
}

console.log(bb().then(value => console.log(value)));