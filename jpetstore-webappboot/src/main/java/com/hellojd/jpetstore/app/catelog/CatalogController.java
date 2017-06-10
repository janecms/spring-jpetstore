package com.hellojd.jpetstore.app.catelog;

import com.hellojd.jpetstore.domain.model.Category;
import com.hellojd.jpetstore.domain.service.catalog.CatalogService;
import com.hellojd.jpetstore.domain.service.catalog.CatalogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 产品目录
 */
@RestController
public class CatalogController {
    @Autowired
    CatalogService catalogService;

    @RequestMapping(value = "/category/list", method = RequestMethod.GET)
    public List<Category> getCategoryList() {
        return catalogService.getCategoryList();
    }
}
