import api from '../api';

describe('Dummy Test Suite', ()=>{
    it('is a dummy test', ()=>{
        let expected = true;
        let actual = api.dummy_function();
        expect(actual).toBe(expected);
    });

    it('Test sum of empty array', ()=>{
        let expected = 0;
        const input_array = [];
        let actual = api.sum_of_array(input_array);
        expect(actual).toBe(expected);
    })

    it('Test sum of an array', ()=>{
        let expected = 10;
        const input_array = [1,2,3,4];
        let actual = api.sum_of_array(input_array);
        expect(actual).toBe(expected);
    })
})


describe('Array Comprehension Tests', ()=>{
   it('counts the positives in an all positive array', ()=>{
       const input_array = [1,2,3,4];
       let expected = input_array.length;
       let actual = api.count_positives(input_array);
       expect(actual).toBe(expected);
   })

    it('counts the positives in an all negative array', ()=>{
        const input_array = [-1,-2,-3,-4];
        let expected = 0;
        let actual = api.count_positives(input_array);
        expect(actual).toBe(expected);
    })

    it('counts the positives in a mixed array', ()=>{
        const input_array = [-1,2,3,-4];
        let expected = 2;
        let actual = api.count_positives(input_array);
        expect(actual).toBe(expected);
    })


    it('filters the positives from an all positive array', ()=>{
        const input_array = [1,2,3,4];
        let expected = input_array;
        let actual = api.filter_positives(input_array);
        expect(actual).toEqual(expected);
    })

    it('filters the positives in an all negative array', ()=>{
        const input_array = [-1,-2,-3,-4];
        let expected = [];
        let actual = api.filter_positives(input_array);
        expect(actual).toEqual(expected);
    })

    it('filters the positives in a mixed array', ()=>{
        const input_array = [-1,2,3,-4];
        let expected = [2,3];
        let actual = api.filter_positives(input_array);
        expect(actual).toEqual(expected);
    })

    it('powers an all positive array', ()=>{
        const input_array = [1,2,3,4];
        let expected = [1,4,9,16];
        let actual = api.power(input_array);
        expect(actual).toEqual(expected);
    })

    it('powers an all negative array', ()=>{
        const input_array = [-1,-2,-3,-4];
        let expected = [1,4,9,16];
        let actual = api.power(input_array);
        expect(actual).toEqual(expected);
    })

    it('powers  a mixed array', ()=>{
        const input_array = [-1,2,3,-4];
        let expected = [1,4,9,16];
        let actual = api.power(input_array);
        expect(actual).toEqual(expected);
    })

});