package CallablePromisePoc.contracts;

public interface HttpClient<R> {
    R request(String method, String url);
}
