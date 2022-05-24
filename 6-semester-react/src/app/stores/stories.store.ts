import { useState, useEffect } from "react";
import { ApiStoryService } from "../services/api.story.service";

const service = new ApiStoryService();

export const useStories = () => {
    const [stories, setStories] = useState<number[]>([]);

    useEffect(() => {
        async function fetch(): Promise<number[]> {
            const result = await service.getIds();
            setStories(result);
            return result;
        }

        fetch();
    }, []);

    return { stories };
};