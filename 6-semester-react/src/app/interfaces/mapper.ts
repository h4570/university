export interface Mapper<T1, T2> {
    map(from: T1): T2;
    map(from: T2): T1;
    map(from: T1, to: T2): T2;
    map(from: T2, to: T2): T1;
}