package CallablePromisePoc.infra;

import CallablePromisePoc.contracts.HttpClient;
import CallablePromisePoc.models.ProductModel;

import java.util.List;

public class HttpClientAdapter implements HttpClient<List<ProductModel>> {
    @Override
    public List<ProductModel> request(String method, String url) {
        return List.of();
    }
}
