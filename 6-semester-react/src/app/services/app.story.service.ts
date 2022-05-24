import { ApiService } from "./api.service";
import { StoryModel } from "../models/story.model";
import { Mapper } from "../interfaces/mapper";
import { DatabaseService } from "./database.service";
import { AppStory } from "../models/app-story.model";
import { AppStoryModelMapper } from "../mappers/app-story.mapper";
import { firstValueFrom, of } from "rxjs";
import { IStoryService } from "../interfaces/story-service";

export class AppStoryService extends ApiService implements IStoryService {
    private readonly _dbMapper: Mapper<AppStory, StoryModel>;
    private readonly _db: DatabaseService;

    constructor() {
        super();
        this._dbMapper = new AppStoryModelMapper();
        this._db = new DatabaseService();
    }

    public save(story: StoryModel) {
        const dbStory = this._dbMapper.map(story);
        this._db.saveAppStory(dbStory);
    }

    public saveMany(stories: StoryModel[]) {
        stories.forEach(story => {
            this.save(story);
        })
    }

    public get(id: number): Promise<StoryModel> {
        const dbStory = this._db.getAppStory(id)!;
        const story = this._dbMapper.map(dbStory);
        return firstValueFrom(of(story));
    }

    public getIds(): Promise<number[]> {
        const appStories = this._db.getAppStories().map(c => c.id);
        return firstValueFrom(of(appStories));
    }
}
