export class ApiStory {
    public id: number;
    public by: string;
    public score: number;
    public descendants: number;
    public time: number;
    public title: string;
    public type: string;
    public url: string;

    constructor() {
        this.id = 0;
        this.by = '';
        this.score = 0;
        this.descendants = 0;
        this.time = 0;
        this.title = '';
        this.type = '';
        this.url = '';
    }
}