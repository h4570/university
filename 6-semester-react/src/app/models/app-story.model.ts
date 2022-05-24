import { DateTime } from "luxon";

export class AppStory {
    public id: number;
    public by: string;
    public score: number;
    public time: number;
    public title: string;
    public url: string;

    constructor() {
        this.id = 0;
        this.by = '';
        this.score = 0;
        this.time = DateTime.now().toUnixInteger();
        this.title = '';
        this.url = '';
    }
}