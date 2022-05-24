import { DateTime } from "luxon";
import { Mapper } from "../interfaces/mapper";
import { DbStoryInfo } from "../models/db-story-info.model";
import { StoryInfo } from "../models/story-info.model";

export class DbStoryInfoMapper implements Mapper<DbStoryInfo, StoryInfo>{
    map(from: StoryInfo): DbStoryInfo;
    map(from: DbStoryInfo): StoryInfo;
    map(from: StoryInfo, to: DbStoryInfo): DbStoryInfo;
    map(from: DbStoryInfo, to: StoryInfo): StoryInfo;
    map(from: unknown, to?: unknown): StoryInfo | DbStoryInfo {
        if (from instanceof StoryInfo) {
            return this.mapToDb(from, to as DbStoryInfo);
        }
        else if (from instanceof DbStoryInfo) {
            return this.mapFromDb(from, to as StoryInfo);
        }
        throw new Error("Method not implemented.");
    }

    private mapFromDb(from: DbStoryInfo, to?: StoryInfo | undefined): StoryInfo {
        if (to === undefined) {
            to = new StoryInfo();
        }

        to.storyId = from.storyId;
        to.comments = from.comments;
        to.modificationDate = DateTime.fromSeconds(from.modificationDate);
        to.isHidden = from.isHidden;
        to.isScoreAdded = from.isScoreAdded;
        to.appScore = from.appScore;

        return to;
    }

    private mapToDb(from: StoryInfo, to?: DbStoryInfo | undefined): DbStoryInfo {
        if (to === undefined) {
            to = new DbStoryInfo();
        }

        to.storyId = from.storyId;
        to.comments = from.comments;
        to.modificationDate = from.modificationDate.toUnixInteger();
        to.isHidden = from.isHidden;
        to.isScoreAdded = from.isScoreAdded;
        to.appScore = from.appScore;

        return to;
    }
}