package net.lyugaev.shop.utils;

/**
 * Created by dmitry on 25.08.16.
 */

import javax.servlet.http.HttpServletRequest;
import net.lyugaev.shop.model.Cart;

public class Utils {

    // Products in Cart, stored in Session.
    public static Cart getCartInSession(HttpServletRequest request) {

        // Get Cart from Session.
        Cart Cart = (Cart) request.getSession().getAttribute("myCart");

        // If null, create it.
        if (Cart == null) {
            Cart = new Cart();

            // And store to Session.
            request.getSession().setAttribute("myCart", Cart);
        }

        return Cart;
    }

//    public static void removeCartInSession(HttpServletRequest request) {
//        request.getSession().removeAttribute("myCart");
//    }

}