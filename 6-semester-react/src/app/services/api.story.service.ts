import { map, firstValueFrom, delay, Subject, Observable } from "rxjs";
import { ApiService } from "./api.service";
import { StoryModel } from "../models/story.model";
import { ApiStory } from "../models/api-story.model";
import { ApiStoryModelMapper } from "../mappers/api-story.mapper";
import { URLS } from "../consts/urls";
import { DatabaseService } from "./database.service";
import { IStoryService } from "../interfaces/story-service";
import { DbStoryInfoMapper } from "../mappers/db-story-info.mapper";
import { random } from "lodash";
import { DateTime } from "luxon";

const storyChange = new Subject<StoryModel[]>();

export class ApiStoryService extends ApiService implements IStoryService {
    private readonly _apiMapper: ApiStoryModelMapper;
    private readonly _infoMapper: DbStoryInfoMapper;
    private readonly _db: DatabaseService;

    public onStoryChange$: Observable<StoryModel[]> = storyChange.asObservable();

    constructor() {
        super();
        this._apiMapper = new ApiStoryModelMapper();
        this._infoMapper = new DbStoryInfoMapper();
        this._db = new DatabaseService();
    }

    public save(story: StoryModel) {
        story.info.modificationDate = DateTime.now();
        const mappedInfo = this._infoMapper.map(story.info);
        this._db.saveStoryInfo(story.id, mappedInfo);
        storyChange.next([story]);
    }

    public saveMany(stories: StoryModel[]) {
        stories.forEach(story => {
            this.save(story);
        })
        storyChange.next(stories);
    }

    public get(id: number): Promise<StoryModel> {
        const story$ = this.fetchModel<ApiStory>(URLS.story(id), { createNewApiEntity: () => new ApiStory() })
            .pipe(
                delay(random(50, 300)),
                map(c => this._apiMapper.map(c)),
            );
        return firstValueFrom(story$);
    }

    public getIds(): Promise<number[]> {
        const stories$ = this.fetch<number[]>(URLS.newStories);
        return firstValueFrom(stories$);
    }
}
