import calculator from '../calculator';

describe('Calculator Tests',()=>{

    it('adds two positive integers',()=>{
        const a = 5;
        const b = 3;
        const expected = 8;
        const actual = calculator.add(a,b);

        expect(actual).toBeCloseTo(expected, 1)
    })
    it('adds a positive and a negative integers with zero sum',()=>{
        const a = 5;
        const b = -5;
        const expected = 0;
        const actual = calculator.add(a,b);

        expect(actual).toBeCloseTo(expected, 1)
    })

    it('Sum of positive integers', ()=>{
        const array = [1,2,3];
        const expected  = 6;
        const actual = calculator.sum(array);
        expect(actual).toBeCloseTo(expected, 1)
    })

    it('Sum of empty array', ()=>{
        const array = [];
        const expected  = 0;
        const actual = calculator.sum(array);
        expect(actual).toBeCloseTo(expected, 1)
    })

    it('Sum without arguments', ()=>{
        const expected  = 0;
        const actual = calculator.sum();
        expect(actual).toBeCloseTo(expected, 1)
    })
    it('Sum of negative integers', ()=>{
        const array = [-1,-2,-3];
        const expected  = -6;
        const actual = calculator.sum(array);
        expect(actual).toBeCloseTo(expected, 1)
    })

    it('Sum of integers with zero result', ()=>{
        const array = [1,2,-3];
        const expected  = 0;
        const actual = calculator.sum(array);
        expect(actual).toBeCloseTo(expected, 1)
    })

    it('Power a random array', ()=>{
        const array = [1,2,-3];
        const expected  = [1,4,9];
        const actual = calculator.power(array);
        expect(actual).toEqual(expected)
    })
    it('Power a random array to the 3rd.', ()=>{
        const array = [1,2,-3];
        const expected  = [1,8, -27];
        const actual = calculator.power(array,3);
        expect(actual).toEqual(expected)
    })

    it('Filter the positives only', ()=>{
        const array = [1,2,-3];
        const expected  = [1,2];
        const actual = calculator.positives(array)
        expect(actual).toEqual(expected)
    })
})