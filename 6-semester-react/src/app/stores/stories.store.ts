import { useState, useEffect } from "react";
import { StoryOrigin } from "../enums/story-origin-enum";
import { IStoryService } from "../interfaces/story-service";
import { ApiStoryService } from "../services/api.story.service";
import { AppStoryService } from "../services/app.story.service";

const apiService = new ApiStoryService();
const appService = new AppStoryService();

export const useStories = (origin: StoryOrigin) => {
    const [stories, setStories] = useState<number[]>([]);


    const getServiceByOrigin = (origin: StoryOrigin): IStoryService => {
        if (origin === 'api') {
            return apiService;
        }
        return appService;
    }

    useEffect(() => {
        async function fetch(): Promise<number[]> {
            const result = await getServiceByOrigin(origin).getIds();
            setStories(result);
            return result;
        }

        fetch();
    }, [origin]);

    return { stories };
};