import { LoadingBoxProperties } from "../LoadingBox/LoadingBox";

export const STORY_LOADING_BOX_PROPS: LoadingBoxProperties = {
    shapes: [
        { width: "100px", height: "100px" },
        { width: "calc(100% - 110px)", height: "5px", margin: '0 0 0 110px' },
        { width: "calc(100% - 300px)", height: "20px", margin: '15px 0 0 110px' },
        { width: "calc(100% - 200px)", height: "10px", margin: '50px 0 0 110px' },
        { width: "calc(100% - 250px)", height: "15px", margin: '70px 0 0 110px' },
    ],
    width: "100%",
    height: "100px",
}