const imgAddress = 'https://img2020.cnblogs.com/blog/872412/202112/872412-20211210100318503-1259974147.png'


const imgPromise = (url) => {
    return new Promise((resolve, reject) => {
        const img = new Image();
        img.src = url;
        img.onload = () => {
            resolve(img);
        };
        img.onerror = () => {
            reject(new Error('error'));
        };
    });
};

imgPromise(imgAddress).then(img => console.log(img)).catch(err => console.log(err))