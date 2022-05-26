import { DateTime } from "luxon";
import { StoryComment } from "./story-comment.model";

export class StoryInfo {
    storyId: number;
    comments: StoryComment[];
    modificationDate: DateTime;
    isHidden: boolean;
    appScore: number;

    public get isModified(): boolean {
        return this.appScore > 0 || this.isHidden || this.comments.length > 0;
    }

    constructor() {
        this.storyId = 0;
        this.comments = [];
        this.modificationDate = DateTime.now();
        this.isHidden = false;
        this.appScore = 0;
    }
}