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

describe('Grading Tests', ()=>{

    const FAILED_EXAM_RESULT = 'FAILED';
    const PASSED_EXAM_RESULT = 'PASSED';
    const exam_results = [
        {
            name : 'Alice',
            score : 32
        },
        {
            name : 'Bob',
            score : 39
        },
        {
            name : 'Charlie',
            score : 98
        },
        {
            name : 'Denis',
            score : 78
        },
        {
            name : 'Eve',
            score : 56
        },
        {
            name : 'Frank',
            score : 14
        },
        {
            name : 'Gabe',
            score : 49
        },
        {
            name : 'Hugo',
            score : 39
        },
        {
            name : 'Ivan',
            score : 100
        },
        {
            name : 'John',
            score : 43
        },
        {
            name : 'Kevin',
            score : 65
        },
        {
            name : 'Lousie',
            score : 54
        },
        {
            name : 'Maria',
            score : 63
        },
        {
            name : 'Nate',
            score : 65
        },
        {
            name : 'Oliver',
            score : 12
        },
        {
            name : 'Pedro',
            score : 87
        },
        {
            name : 'Rebeca',
            score : 83
        },
        {
            name : 'Sarah',
            score : 29
        },
        {
            name : 'Tamara',
            score : 73
        },
        {
            name : 'Wade',
            score : 5
        },
    ]

    it('Grade A failed Student', ()=>{
        const expected = {...exam_results[0], result : FAILED_EXAM_RESULT};
        const actual = api.grade_students(exam_results)[0];
        expect(actual).toEqual(expected);
    })

    it('Grade A passed Student', ()=>{
        const INDEX_OF_CHARLIE_WHO_PASSED = 2;
        const expected = {...exam_results[INDEX_OF_CHARLIE_WHO_PASSED], result : FAILED_EXAM_RESULT};
        const actual = api.grade_students(exam_results)[INDEX_OF_CHARLIE_WHO_PASSED];
        expect(actual).toEqual(expected);
    })



});