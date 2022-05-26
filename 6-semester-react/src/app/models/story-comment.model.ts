import { random } from "lodash";

export class StoryComment {
    id: number;
    username: string;
    content: string;

    constructor() {
        this.id = random(0, 100000);
        this.username = '';
        this.content = '';
    }
}