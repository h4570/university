import { StoryModel } from "../models/story.model";
import { IStoryService } from "../interfaces/story-service";
import { ApiStoryService } from "./api.story.service";
import { AppStoryService } from "./app.story.service";
import { merge, Observable } from "rxjs";

export class AutoStoryService {
    private readonly _apiService = new ApiStoryService();
    private readonly _appService = new AppStoryService();

    public onStoryChange$: Observable<StoryModel[]> = merge(
        this._apiService.onStoryChange$,
        this._appService.onStoryChange$
    );

    public save(story: StoryModel): void {
        this.getServiceByStory(story).save(story);
    }

    public saveMany(stories: StoryModel[]): void {
        this.getServiceByStory(stories[0]).saveMany(stories);
    }

    private getServiceByStory(story: StoryModel): IStoryService {
        if (story.origin === 'api') {
            return this._apiService;
        }
        return this._appService;
    }
}
