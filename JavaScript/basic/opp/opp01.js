class Student {
    constructor(name, score) {
        this.name = name;
        this.score = score;
    }
}

const student = new Student('zhangsan', 99)
console.log(student);
student.name = 100
console.log(student)
