export const URLS = {
    topStories: 'https://hacker-news.firebaseio.com/v0/topstories.json',
    newStories: 'https://hacker-news.firebaseio.com/v0/newstories.json',
    story: (id: number) => `https://hacker-news.firebaseio.com/v0/item/${id}.json`
}