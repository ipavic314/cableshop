package hr.algebra.cableshop.domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CableCartItem> cableCartItemList;

    public Cart() {
        cableCartItemList = new ArrayList<>();
    }
}
