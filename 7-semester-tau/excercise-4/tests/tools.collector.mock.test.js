import ToolsCollector from '../src/tools.collector';

describe('ToolsCollector mock tests', () => {
    let collector = new ToolsCollector();

    beforeEach(() => {
        collector = new ToolsCollector();

        jest.spyOn(collector, 'getCountFromApi');

        // Mock only API function and keep all logic in the class
        collector.getCountFromApi.mockImplementation(() => new Promise((resolve) => resolve([1])));
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
        collector.get().then(initialValue => {
            collector.decrease().then((data) => {
                expect(data).toBe(initialValue - 1);
            });
        });
    });

    it('Multi decrease', () => {
        collector.get().then(initialValue => {
            collector.decrease().then((data) => {
                expect(data).toBe(initialValue - 1);
                collector.decrease().then((data2) => {
                    expect(data2).toBe(initialValue - 2);
                });
            });
        });
    });

    it('Increase/decrease', () => {
        collector.get().then(initialValue => {
            collector.increase().then((data) => {
                expect(data).toBe(initialValue + 1);
                collector.decrease().then((data2) => {
                    expect(data2).toBe(initialValue);
                });
            });
        });
    });

    it('Decrease/increase', () => {
        collector.get().then(initialValue => {
            collector.decrease().then((data) => {
                expect(data).toBe(initialValue - 1);
                collector.increase().then((data2) => {
                    expect(data2).toBe(initialValue);
                });
            });
        });
    });
});