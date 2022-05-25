import { useState, useEffect } from "react";
import { StoryModel } from "../models/story.model";
import { ApiStoryService } from "../services/api.story.service";

const service = new ApiStoryService();

export const useStory = (id: number) => {
    const [story, setStory] = useState<StoryModel | undefined>(undefined);

    useEffect(() => {
        async function fetch(): Promise<StoryModel> {
            const result = await service.get(id);
            setStory(result);
            return result;
        }

        fetch();
    }, [id]);

    return { story };
};