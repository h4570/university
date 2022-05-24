import { DateTime } from "luxon";

export class StoryInfo {
    storyId: number;
    comments: { username: string, content: string }[];
    modificationDate: DateTime;
    isHidden: boolean;
    isScoreAdded: boolean;
    appScore: number;

    constructor() {
        this.storyId = 0;
        this.comments = [];
        this.modificationDate = DateTime.now();
        this.isHidden = false;
        this.isScoreAdded = false;
        this.appScore = 0;
    }
}