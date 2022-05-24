import { map, firstValueFrom } from "rxjs";
import { ApiService } from "./api.service";
import { StoryModel } from "../models/story.model";
import { ApiStory } from "../models/api-story.model";
import { Mapper } from "../interfaces/mapper";
import { ApiStoryModelMapper } from "../mappers/api-story.mapper";
import { URLS } from "../consts/urls";
import { DatabaseService } from "./database.service";
import { IStoryService } from "../interfaces/story-service";
import { DbStoryInfoMapper } from "../mappers/db-story-info.mapper";

export class ApiStoryService extends ApiService implements IStoryService {
    private readonly _apiMapper: ApiStoryModelMapper;
    private readonly _infoMapper: DbStoryInfoMapper;
    private readonly _db: DatabaseService;

    constructor() {
        super();
        this._apiMapper = new ApiStoryModelMapper();
        this._infoMapper = new DbStoryInfoMapper();
        this._db = new DatabaseService();
    }

    public save(story: StoryModel) {
        const mappedInfo = this._infoMapper.map(story.info);
        this._db.saveStoryInfo(story.id, mappedInfo);
    }

    public saveMany(stories: StoryModel[]) {
        stories.forEach(story => {
            this.save(story);
        })
    }

    public get(id: number): Promise<StoryModel> {
        const story$ = this.fetchModel<ApiStory>(URLS.story(id), { createNewApiEntity: () => new ApiStory() })
            .pipe(
                map(c => this._apiMapper.map(c)),
            );
        return firstValueFrom(story$);
    }

    public getIds(): Promise<number[]> {
        const stories$ = this.fetch<number[]>(URLS.newStories);
        return firstValueFrom(stories$);
    }
}
