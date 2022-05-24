import { fromFetch } from "rxjs/fetch";
import { map, Observable, switchMap } from "rxjs";
import { ApiServiceConfig } from "../interfaces/api-service-config";

export abstract class ApiService {
    protected fetchModel<T>(url: string, config: ApiServiceConfig): Observable<T> {
        const result = this.fetch(url)
            .pipe(
                map(c => Object.assign(config.createNewApiEntity() as any, c)),
            );
        return result;
    }

    protected fetch<T>(url: string): Observable<T> {
        const result = fromFetch(url).pipe(
            switchMap(c => c.json()),
            map(c => c as T),
        )
        return result;
    }
}
