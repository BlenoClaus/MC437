package com.mc437.produshow.ws;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * Created by gustavo on 21/09/17.
 */
@Controller
@RequestMapping("/suppliers")
public class SupplierController {

    @RequestMapping(value = {"", "/"}, method = GET)
    @ResponseBody
    public String listSuppliers() {
        return "";
    }

    @RequestMapping(value = "/{supplierId}", method = GET)
    @ResponseBody
    public String supplier(@PathVariable("supplierId") long supplierId) {
        return "";
    }

    @RequestMapping(value = "/add", method = POST)
    @ResponseBody
    public String addSupplier() {
        return "";
    }

    @RequestMapping(value = "/{supplierId}", method = PUT)
    @ResponseBody
    public String updateSupplier(@PathVariable("supplierId") long supplierId) {
        return "";
    }

}
