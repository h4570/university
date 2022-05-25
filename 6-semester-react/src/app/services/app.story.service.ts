import { ApiService } from "./api.service";
import { StoryModel } from "../models/story.model";
import { Mapper } from "../interfaces/mapper";
import { DatabaseService } from "./database.service";
import { AppStory } from "../models/app-story.model";
import { AppStoryModelMapper } from "../mappers/app-story.mapper";
import { firstValueFrom, Observable, of, Subject } from "rxjs";
import { IStoryService } from "../interfaces/story-service";

const storyChange = new Subject<StoryModel[]>();

export class AppStoryService extends ApiService implements IStoryService {
    private readonly _dbMapper: Mapper<AppStory, StoryModel>;
    private readonly _db: DatabaseService;

    public onStoryChange$: Observable<StoryModel[]> = storyChange.asObservable();

    constructor() {
        super();
        this._dbMapper = new AppStoryModelMapper();
        this._db = new DatabaseService();
    }

    public save(story: StoryModel) {
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

    public getIds(): Promise<number[]> {
        const appStories = this._db.getAppStories().map(c => c.id);
        return firstValueFrom(of(appStories));
    }
}
