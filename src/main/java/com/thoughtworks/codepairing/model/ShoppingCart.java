package com.thoughtworks.codepairing.model;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
    private List<Product> products;
    private Customer customer;

    public ShoppingCart(Customer customer, List<Product> products) {
        this.customer = customer;
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Order checkout() {
        double totalPrice = 0;

        //key为商品名字 value为商品数量
        HashMap<String, Integer> productMap = new HashMap();

        int loyaltyPointsEarned = 0;
        for (Product product : products) {
            double discount = 0;
            if (product.getProductCode().startsWith("DIS")) {
                Integer persent = Integer.parseInt(product.getProductCode().split("_")[1]);
                Double rate = 0.01 * persent.doubleValue();
                discount = product.getPrice() * rate;
                loyaltyPointsEarned += product.getPrice() / persent;
            }
            //第二题
            else if (product.getProductCode().startsWith("BULK_BUY_2_GET_1")) {
                String key = product.getProductCode();
                //如果map中存在该key 则数量+1
                if (productMap.containsKey(key)) {
                    productMap.put(key, productMap.get(key) + 1);
                    //买二送一 当数量为3整数的时候 直接跳过 不进行totalPrice的修改
                    if (productMap.get(key) % 3 == 0) {
                        continue;
                    }
                } else {
                    productMap.put(key, 1);
                }

            } else {
                loyaltyPointsEarned += (product.getPrice() / 5);
            }

            totalPrice += product.getPrice() - discount;
        }

        //第三题
        if (totalPrice>500)
        {
            totalPrice = totalPrice*0.95;
        }
        return new Order(totalPrice, loyaltyPointsEarned);
    }

    @Override
    public String toString() {
        return "Customer: " + customer.getName() + "\n" + "Bought:  \n" + products.stream().map(p -> "- " + p.getName() + ", " + p.getPrice()).collect(Collectors.joining("\n"));
    }
}
