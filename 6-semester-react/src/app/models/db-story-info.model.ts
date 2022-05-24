import { DateTime } from "luxon";

export class DbStoryInfo {
    storyId: number;
    comments: { username: string, content: string }[];
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