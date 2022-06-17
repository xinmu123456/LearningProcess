const fetch = require("node-fetch");
const fetchPromise = fetch('https://mdn.github.io/learning-area/javascript/apis/fetching-data/can-store/products.json');

console.log(fetchPromise);

fetchPromise.then(response => {
    console.log(`已收到响应：${response.status}`);
});

console.log("已发送请求……");
