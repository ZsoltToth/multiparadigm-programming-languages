
const _add = (a,b) => a+b;
const _sub = (a,b) => a-b;
const _mul = (a,b) => a*b;
const _div = (a,b) => a/b;
const _sum = (array = []) => {
    return array.reduce((total, current) => total + current,0);
}

const _power = (array=[], p = 2) => {
    return array.map(n => Math.pow(n,p));
}

const _positives = (array = []) =>{
    return array.filter(num => num >= 0.0);
}

module.exports = {
    add : _add,
    sub : _sub,
    mul : _mul,
    div : _div,
    sum : _sum,
    power : _power,
    positives : _positives
}
