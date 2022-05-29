import { ApiService } from "./api.service";
import { StoryModel } from "../models/story.model";
import { Mapper } from "../interfaces/mapper";
import { DatabaseService } from "./database.service";
import { AppStory } from "../models/app-story.model";
import { AppStoryModelMapper } from "../mappers/app-story.mapper";
import { firstValueFrom, Observable, of, Subject } from "rxjs";
import { IStoryService } from "../interfaces/story-service";
import { DateTime } from "luxon";
import { DbStoryInfoMapper } from "../mappers/db-story-info.mapper";

const storyChange = new Subject<StoryModel[]>();

export class AppStoryService extends ApiService implements IStoryService {
    private readonly _dbMapper: Mapper<AppStory, StoryModel>;
    private readonly _infoMapper: DbStoryInfoMapper;
    private readonly _db: DatabaseService;

    public onStoryChange$: Observable<StoryModel[]> = storyChange.asObservable();

    constructor() {
        super();
        this._infoMapper = new DbStoryInfoMapper();
        this._dbMapper = new AppStoryModelMapper();
        this._db = new DatabaseService();
    }

    public save(story: StoryModel) {
        story.info.modificationDate = DateTime.now();

        const mappedInfo = this._infoMapper.map(story.info);
        this._db.saveStoryInfo(story.id, mappedInfo);

        const dbStory = this._dbMapper.map(story);
        this._db.saveAppStory(dbStory);

        storyChange.next([story]);
    }

    public saveMany(stories: StoryModel[]) {
        stories.forEach(story => {
            this.save(story);
        })
        storyChange.next(stories);
    }

    public get(id: number): Promise<StoryModel> {
        const dbStory = this._db.getAppStory(id)!;
        const story = this._dbMapper.map(dbStory);
        return firstValueFrom(of(story));
    }

    public getMany(): Promise<StoryModel[]> {
        const appStories = this._db.getAppStories();
        const stories = appStories.map(c => this._dbMapper.map(c));
        return firstValueFrom(of(stories));
    }

    public getIds(): Promise<number[]> {
        const appStories = this._db.getAppStories().map(c => c.id);
        return firstValueFrom(of(appStories));
    }
}
