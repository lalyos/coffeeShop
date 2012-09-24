package com.acme;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;

public abstract class BaseServlet<V> extends HttpServlet {

    public BaseServlet() {
        super();
    }

    protected Map<String, ShoppingCart> getChoppingCart() {
        return (Map<String, ShoppingCart>) getServletContext().getAttribute("shoppingCarts");
    }
    
    protected List<String> getCoffies() {
        return (List<String>) getServletContext().getAttribute("coffees");
    }

}