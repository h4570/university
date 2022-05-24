import { DateTime } from "luxon";
import { StoryOrigin } from "../enums/story-origin-enum";
import { Mapper } from "../interfaces/mapper";
import { ApiStory } from "../models/api-story.model";
import { StoryModel } from "../models/story.model";
import { DatabaseService } from "../services/database.service";
import { DbStoryInfoMapper } from "./db-story-info.mapper";

export class ApiStoryModelMapper implements Mapper<ApiStory, StoryModel>{
    private db = new DatabaseService();
    private infoMapper = new DbStoryInfoMapper();

    map(from: StoryModel): ApiStory;
    map(from: ApiStory): StoryModel;
    map(from: StoryModel, to: ApiStory): ApiStory;
    map(from: ApiStory, to: StoryModel): StoryModel;
    map(from: unknown, to?: unknown): StoryModel | ApiStory {
        if (from instanceof StoryModel) {
            return this.mapToApi(from, to as ApiStory);
        }
        else if (from instanceof ApiStory) {
            return this.mapFromApi(from, to as StoryModel);
        }
        throw new Error("Method not implemented.");
    }

    private mapFromApi(from: ApiStory, to?: StoryModel | undefined): StoryModel {
        if (to === undefined) {
            to = new StoryModel();
        }

        to.id = from.id;
        to.by = from.by;
        to.score = from.score;
        to.descendants = from.descendants;
        to.time = DateTime.fromSeconds(from.time);
        to.title = from.title;
        to.type = from.type;
        to.url = from.url;
        to.origin = StoryOrigin.api;
        to.info = this.infoMapper.map(this.db.getStoryInfo(from.id));

        return to;
    }

    private mapToApi(from: StoryModel, to?: ApiStory | undefined): ApiStory {
        if (to === undefined) {
            to = new ApiStory();
        }

        to.id = from.id;
        to.by = from.by;
        to.score = from.score;
        to.descendants = from.descendants;
        to.time = from.time.toUnixInteger();
        to.title = from.title;
        to.type = from.type;
        to.url = from.url;

        return to;
    }
}