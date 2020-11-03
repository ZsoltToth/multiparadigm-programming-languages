
const dummy_function = () => {
    return true;
}

const add = (a,b) => {return a+b}
const sub = (a,b) => {return a-b}
const mul = (a,b) => {return a*b}
const div = (a,b) => {return a/b}

const counter = (function(cnt_init){let cnt = cnt_init; return function(){cnt += 1; return cnt;}})(0);

module.exports = {
    dummy_function: dummy_function,
    add: add,
    sub: sub,
    mul: mul,
    div: div,
    counter : counter
}