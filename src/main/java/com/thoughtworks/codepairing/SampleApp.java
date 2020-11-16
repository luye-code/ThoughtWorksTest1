package com.thoughtworks.codepairing;

import com.thoughtworks.codepairing.model.Customer;
import com.thoughtworks.codepairing.model.Product;
import com.thoughtworks.codepairing.model.ShoppingCart;
import com.thoughtworks.codepairing.model.Order;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

//实现如下功能，满足20%折扣的商品将以“ DIS_20”开头的产品代码作为标识。购买此类产品后，客户每消费$20可赚取1点会员积分。
//        实现一组产品的报价的功能，比如“买二送一”的特殊商品将以“BULK_BUY_2_GET_1”开头的产品代码作为标识
//        实现如下功能，当购买总价超过$500，将给予5%的折扣。

public class SampleApp {
    public static final int PRICE = 100;
    public static final String PRODUCT = "Product";
    private static Customer customer = new Customer("test");

    public static void main(String[] args) {
//        List<Product> products = asList(new Product(PRICE, "BULK_BUY_2_GET_1_ABCD", PRODUCT),
//                new Product(PRICE, "BULK_BUY_2_GET_1_ABCD", PRODUCT),
//                new Product(PRICE, "BULK_BUY_2_GET_1_ABCD", PRODUCT),
//                new Product(PRICE, "BULK_BUY_2_GET_1_ABCD", PRODUCT),
//                new Product(50, "BULK_BUY_2_GET_1_ABCDE", PRODUCT),
//                new Product(50, "BULK_BUY_2_GET_1_ABCDE", PRODUCT),
//                new Product(50, "BULK_BUY_2_GET_1_ABCDE", PRODUCT),
//                new Product(PRICE, "DIS_20_ABCD", PRODUCT),
//                new Product(PRICE, "DIS_20_ABCD", PRODUCT)
//        );
//        ShoppingCart cart = new ShoppingCart(customer, products);
//        Order order = cart.checkout();
//        System.out.println(order.getTotalPrice());
        Product product1 = new Product(10.0, "DIS_10_PRODUCT1", "product 1");
        Product product2 = new Product(20.0, "DIS_10_PRODUCT2", "product 2");
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        Customer customer = new Customer("A Customer");

        ShoppingCart shoppingCart = new ShoppingCart(customer, products);
        Product product3 = new Product(30.0, "DIS_10_PRODUCT3", "product 3");
        shoppingCart.addProduct(product3);
        System.out.println(shoppingCart.toString());

        Order order = shoppingCart.checkout();
        System.out.println(order.toString());
    }
}
