import { DateTime } from "luxon";
import { StoryComment } from "./story-comment.model";

export class DbStoryInfo {
    storyId: number;
    comments: StoryComment[];
    modificationDate: number;
    isHidden: boolean;
    isScoreAdded: boolean;
    appScore: number;

    constructor() {
        this.storyId = 0;
        this.comments = [];
        this.modificationDate = DateTime.now().toUnixInteger();
        this.isHidden = false;
        this.isScoreAdded = false;
        this.appScore = 0;
    }
}