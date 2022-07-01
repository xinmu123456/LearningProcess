const http = require('http');

http.createServer((request, response) => {
    response.writeHead(200, { 'Content-Type': 'text/plain' })
    response.end('Hello World\n');
}).listen(8888)

console.log('run at 8888...');