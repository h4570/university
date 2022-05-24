import { DateTime } from "luxon";
import { AppStory } from "../models/app-story.model";
import { Mapper } from "../interfaces/mapper";
import { StoryModel } from "../models/story.model";
import { DatabaseService } from "../services/database.service";
import { StoryOrigin } from "../enums/story-origin-enum";
import { DbStoryInfoMapper } from "./db-story-info.mapper";

export class AppStoryModelMapper implements Mapper<AppStory, StoryModel>{
    private db = new DatabaseService();
    private infoMapper = new DbStoryInfoMapper();

    map(from: StoryModel): AppStory;
    map(from: AppStory): StoryModel;
    map(from: StoryModel, to: AppStory): AppStory;
    map(from: AppStory, to: StoryModel): StoryModel;
    map(from: unknown, to?: unknown): StoryModel | AppStory {
        if (from instanceof StoryModel) {
            return this.mapToApi(from, to as AppStory);
        }
        else if (from instanceof AppStory) {
            return this.mapFromApi(from, to as StoryModel);
        }
        throw new Error("Method not implemented.");
    }

    private mapFromApi(from: AppStory, to?: StoryModel | undefined): StoryModel {
        if (to === undefined) {
            to = new StoryModel();
        }

        to.id = from.id;
        to.by = from.by;
        to.score = from.score;
        to.descendants = 0;
        to.time = DateTime.fromSeconds(from.time);
        to.title = from.title;
        to.type = '';
        to.url = from.url;
        to.origin = StoryOrigin.app;
        to.info = this.infoMapper.map(this.db.getStoryInfo(from.id));

        return to;
    }

    private mapToApi(from: StoryModel, to?: AppStory | undefined): AppStory {
        if (to === undefined) {
            to = new AppStory();
        }

        to.id = from.id;
        to.by = from.by;
        to.score = from.score;
        to.time = from.time.toUnixInteger();
        to.title = from.title;
        to.url = from.url;

        return to;
    }
}