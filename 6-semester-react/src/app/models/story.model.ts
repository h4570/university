import { random } from "lodash";
import { DateTime } from "luxon";
import { StoryOrigin } from "../enums/story-origin-enum";
import { StoryInfo } from "./story-info.model";

export class StoryModel {
    public id: number;
    public by: string;
    public score: number;
    public descendants: number;
    public time: DateTime;
    public title: string;
    public type: string;
    public url: string;
    public info: StoryInfo;
    public origin: StoryOrigin;

    constructor() {
        this.id = random(0, 100000);
        this.by = 'Sandro';
        this.score = 0;
        this.descendants = 0;
        this.time = DateTime.now();
        this.title = '';
        this.type = '';
        this.url = '';
        this.origin = StoryOrigin.app;
        this.info = {} as StoryInfo;
    }
}