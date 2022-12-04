export default class ToolsCollector {
    count = 0;
    wasFetched = false;

    async get() {
        await this.fetchGuard();
        return this.count;
    }

    async decrease() {
        await this.fetchGuard();
        return --this.count;
    };

    async increase() {
        await this.fetchGuard();
        return ++this.count;
    };

    async fetchGuard() {
        if (!this.wasFetched) {
            const data = await this.getCountFromApi();
            this.count = data[0];
            this.wasFetched = true;
        }
    }

    async getCountFromApi() {
        const response = await fetch('https://www.randomnumberapi.com/api/v1.0/random?min=10&max=100');
        return await response.json();
    }
}