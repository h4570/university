import { StoryModel } from "../models/story.model";

export interface IStoryService {
    save(story: StoryModel): void;
    saveMany(stories: StoryModel[]): void;
    get(id: number): Promise<StoryModel>;
    getIds(): Promise<number[]>;
}