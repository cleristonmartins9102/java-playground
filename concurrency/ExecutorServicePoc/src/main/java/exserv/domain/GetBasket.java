package exserv.domain;

import exserv.domain.models.BasketModel;

import java.util.List;

public interface GetBasket {
    BasketModel get(List<String> userIds);
}
