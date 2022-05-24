import { AppStory } from "../models/app-story.model";
import { DbStoryInfo } from "../models/db-story-info.model";

export class DatabaseService {
    private readonly APP_STORIES_LOCAL_STORAGE_KEY = 'appStories';
    private readonly STORIES_INFO_LOCAL_STORAGE_KEY = 'storiesInfo';

    saveStoryInfo(storyId: number, info: DbStoryInfo) {
        const storyInfos = this.getStoryInfos();
        const dbInfo = storyInfos.find(c => c.storyId === storyId);

        if (dbInfo) {
            storyInfos.splice(storyInfos.indexOf(dbInfo), 1);
        }

        storyInfos.push(info);

        localStorage.setItem(this.STORIES_INFO_LOCAL_STORAGE_KEY, JSON.stringify(storyInfos));
    }

    getStoryInfos(): DbStoryInfo[] {
        const storage = localStorage.getItem(this.STORIES_INFO_LOCAL_STORAGE_KEY);
        if (storage) {
            const raw = JSON.parse(storage) as DbStoryInfo[];
            const result: DbStoryInfo[] = [];
            raw.forEach(item => result.push(Object.assign(new DbStoryInfo(), item)));
            return result;
        } else {
            const result = [] as DbStoryInfo[];
            localStorage.setItem(this.STORIES_INFO_LOCAL_STORAGE_KEY, JSON.stringify(result));
            return result;
        }
    }

    getStoryInfo(storyId: number): DbStoryInfo {
        const storyInfos = this.getStoryInfos();
        let result = storyInfos.find(c => c.storyId === storyId);

        if (!result) {
            result = this.createNewInfo(storyId);
            storyInfos.push(result);
            localStorage.setItem(this.STORIES_INFO_LOCAL_STORAGE_KEY, JSON.stringify(storyInfos));
            return result;
        }

        return result;
    }

    getAppStories(): AppStory[] {
        const storage = localStorage.getItem(this.APP_STORIES_LOCAL_STORAGE_KEY);
        if (storage) {
            const raw = JSON.parse(storage) as AppStory[];
            const result: AppStory[] = [];
            raw.forEach(item => result.push(Object.assign(new AppStory(), item)));
            return result;
        } else {
            const result = [] as AppStory[];
            localStorage.setItem(this.APP_STORIES_LOCAL_STORAGE_KEY, JSON.stringify(result));
            return result;
        }
    }

    getAppStory(id: number): AppStory | undefined {
        const stories = this.getAppStories();
        const result = stories.find(c => c.id === id);
        return result;
    }

    saveAppStory(story: AppStory) {
        const stories = this.getAppStories();
        const dbInfo = stories.find(c => c.id === story.id);

        if (dbInfo) {
            stories.splice(stories.indexOf(dbInfo), 1);
        }

        stories.push(story);

        localStorage.setItem(this.APP_STORIES_LOCAL_STORAGE_KEY, JSON.stringify(stories));
    }

    private createNewInfo(storyId: number) {
        const result = new DbStoryInfo();
        result.storyId = storyId;
        return result;
    }
}
