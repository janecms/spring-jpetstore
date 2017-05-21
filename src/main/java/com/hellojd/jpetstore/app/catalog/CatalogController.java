package com.hellojd.jpetstore.app.catalog;

import java.util.List;
import java.util.Locale;

import com.hellojd.common.web.Version;
import com.hellojd.jpetstore.domain.model.Category;
import com.hellojd.jpetstore.domain.model.Item;
import com.hellojd.jpetstore.domain.model.Product;
import com.hellojd.jpetstore.domain.service.catalog.CatalogService;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
@RequestMapping("catalog")
public class CatalogController {
    @Inject
    CookieLocaleResolver localeResolver;

    @Inject
    protected CatalogService catalogService;

    @RequestMapping()
    public String main() {
        return "catalog/Main";
    }

    @RequestMapping("viewCategory")
    public String viewCategory(@RequestParam("categoryId") String categoryId,
            Model model) {
        List<Product> productList = catalogService
                .getProductListByCategory(categoryId);
        Category category = catalogService.getCategory(categoryId);
        model.addAttribute("productList", productList);
        model.addAttribute("category", category);
        return "catalog/Category";
    }

    @RequestMapping("viewProduct")
    public String viewProduct(@RequestParam("productId") String productId,
            Model model) {
        List<Item> itemList = catalogService.getItemListByProduct(productId);
        Product product = catalogService.getProduct(productId);
        model.addAttribute("itemList", itemList);
        model.addAttribute("product", product);
        return "catalog/Product";
    }

    @RequestMapping("viewItem")
    public String viewItem(@RequestParam("itemId") String itemId, Model model) {
        Item item = catalogService.getItem(itemId);
        Product product = item.getProduct();
        model.addAttribute("item", item);
        model.addAttribute("product", product);
        return "catalog/Item";
    }

    @RequestMapping(params = "keyword")
    public String searchProducts(@Validated ProductSearchForm form,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "common/Error";
        }
        String keyword = form.getKeyword().toLowerCase();
        List<Product> productList = catalogService.searchProductList(keyword);
        model.addAttribute("productList", productList);
        return "catalog/SearchProducts";
    }
}
