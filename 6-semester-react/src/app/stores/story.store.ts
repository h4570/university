import { useState, useEffect } from "react";
import { StoryOrigin } from "../enums/story-origin-enum";
import { IStoryService } from "../interfaces/story-service";
import { StoryModel } from "../models/story.model";
import { ApiStoryService } from "../services/api.story.service";
import { AppStoryService } from "../services/app.story.service";

const apiService = new ApiStoryService();
const appService = new AppStoryService();

export const useStory = (id: number, origin: StoryOrigin) => {
    const [story, setStory] = useState<StoryModel | undefined>(undefined);

    const getServiceByOrigin = (origin: StoryOrigin): IStoryService => {
        if (origin === 'api') {
            return apiService;
        }
        return appService;
    }

    useEffect(() => {
        async function fetch(): Promise<StoryModel> {
            const result = await getServiceByOrigin(origin).get(id);
            setStory(result);
            return result;
        }

        fetch();
    }, [id]);

    return { story };
};