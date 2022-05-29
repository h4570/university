import { useState, useEffect } from "react";
import { StoryOrigin } from "../enums/story-origin-enum";
import { IStoryService } from "../interfaces/story-service";
import { ApiStoryService } from "../services/api.story.service";
import { AppStoryService } from "../services/app.story.service";

const apiService = new ApiStoryService();
const appService = new AppStoryService();

export const useStories = (origin: StoryOrigin) => {
    let [stories, setStories] = useState<number[]>([]);

    const getServiceByOrigin = (origin: StoryOrigin): IStoryService => {
        if (origin === 'api') {
            return apiService;
        }
        return appService;
    }

    async function fetch(): Promise<number[]> {
        const result = await getServiceByOrigin(origin).getIds();
        setStories(result);
        return result;
    }

    useEffect(() => {
        fetch();
    }, [origin]);

    return { stories, fetch };
};