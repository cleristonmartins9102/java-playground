package exserv.domain.models;

import java.util.List;

public class BasketModel {
    public String id;
    public List<ItemModel> items;

    @Override
    public String toString() {
        return "BasketModel{id='" + id + "', items=" + items + "}";
    }
}
