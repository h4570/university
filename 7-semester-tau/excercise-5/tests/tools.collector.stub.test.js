import ToolsCollector from '../src/tools.collector';

jest.mock('../src/tools.collector', () => {
    return jest.fn().mockImplementation(() => {
        const increaseStub = jest.fn().mockResolvedValueOnce(2).mockResolvedValueOnce(3);
        const decreaseStub = jest.fn().mockResolvedValueOnce(1).mockResolvedValueOnce(0);

        return {
            increase: increaseStub,
            decrease: decreaseStub,
        };
    });
});

describe('ToolsCollector stub tests', () => {
    let collector = new ToolsCollector();

    beforeEach(() => {
        collector = new ToolsCollector();
    });

    it('Should be defined', () => {
        expect(collector).toBeDefined();
    });

    it('Single increase', () => {
        collector.increase().then((data) => {
            expect(data).toBe(2);
        });
    });

    it('Multi increase', () => {
        collector.increase().then((data) => {
            expect(data).toBe(2);
            collector.increase().then((data2) => {
                expect(data2).toBe(3);
            });
        });
    });

    it('Single decrease', () => {
        collector.decrease().then((data) => {
            expect(data).toBe(1);
        });
    });

    it('Multi decrease', () => {
        collector.decrease().then((data) => {
            expect(data).toBe(1);
            collector.decrease().then((data2) => {
                expect(data2).toBe(0);
            });
        });
    });

    it('Increase/decrease', () => { // Idealnie pokazuje problem ze stubem
        collector.increase().then((data) => {
            expect(data).toBe(2);
            collector.decrease().then((data2) => {
                expect(data2).toBe(1);
            });
        });
    });

    it('Decrease/increase', () => { // Idealnie pokazuje problem ze stubem
        collector.decrease().then((data) => {
            expect(data).toBe(1);
            collector.increase().then((data2) => {
                expect(data2).toBe(2);
            });
        });
    });
});