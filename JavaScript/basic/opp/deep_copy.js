const oldObj = {
    name: 'xinmu',
    age: 20,
    colors: ['r', 'g', 'b'],
    friend: {
        name: 'zhangsan'
    }
}

const newObj = oldObj
newObj.name = 'xinmu123'
console.log(newObj);
console.log(oldObj);


function deepClone(obj) {
    if (typeof obj !== 'object' || obj == null) {
        return obj;
    }

    let result;

    if (obj instanceof Array) {
        result = []
    } else {
        result = {}
    }

    for (let key in obj) {
        if (obj.hasOwnProperty(key)) {
            console.log(`key => ${key}`);
            result[key] = deepClone(obj[key])
        }
    }

    return result;
}

const newObj2 = deepClone(oldObj)
newObj2.name = 'xinmu'
console.log(newObj2);
console.log(oldObj);

deepClone([1, 2, 3])