const validateEmail = require('../src/main');

beforeAll(() => {
    console.log('Starting...');
});

afterAll(() => {
    console.log('Finishing...');
});

describe('Positive tests', () => {
    test('Standard email check', () => {
        expect(() => validateEmail('example@email.com').toEqual(true));
    });

    test('Email with left dots check', () => {
        expect(() => validateEmail('example.first.middle.lastname@email.com').toEqual(true));
    });

    test('Email with right dots check', () => {
        expect(() => validateEmail('example@subdomain.email.com').toEqual(true));
    });

    test('Email with plus check', () => {
        expect(() => validateEmail('example+firstname+lastname@email.com').toEqual(true));
    });

    test('Mixed email check', () => {
        expect(() => validateEmail('example.firs+tname-lastname@email.com').toEqual(true));
    });
});

describe('Negative tests', () => {
    test('Email without @ check', () => {
        expect(() => validateEmail('plaintextaddress').toEqual(false));
    });

    test('Email without name check', () => {
        expect(() => validateEmail('@email.com').toEqual(false));
    });

    test('Website check', () => {
        expect(() => validateEmail('example.email.com').toEqual(false));
    });

    test('Japanesse email check', () => {
        expect(() => validateEmail('おえあいう@example.com').toEqual(false));
    });

    test('No domain check', () => {
        expect(() => validateEmail('example@111.222.333.44444').toEqual(false));
    });
});

describe('Exceptions', () => {
    test('Throws error if value is not provided', () => {
        expect(() => validateEmail()).toThrowError('Please provide an email address');
    });

    test('Throws error if value is null', () => {
        expect(() => validateEmail(null)).toThrowError('Please provide an email address');
    });

    test('Throws error if value is empty string', () => {
        expect(() => validateEmail('')).toThrowError('Please provide an email address');
    });
});