import api from '../api';

describe('Dummy Test Suite', ()=>{
    it('is a dummy test', ()=>{
        let expected = true;
        let actual = api.dummy_function();
        expect(actual).toBe(expected);
    });

    it('adds two positive integers', ()=> {
        let a = 5;
        let b = 3;
        const expected = 8;
        const actual = api.add(a,b);
        expect(actual).toBe(expected);
    });

    it('calls the counter 3 times', ()=>{
        const expected = [1,2,3];
        const actual = [];
        let counter = api.counter;
        for(let i = 0; i  <3; i++){
            actual.push(counter())
        }
        expect(actual).toEqual(expected);
    })
})