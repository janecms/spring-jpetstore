package com.hellojd.jpetstore;
import com.hellojd.jpetstore.domain.model.Category;
import com.hellojd.jpetstore.domain.repository.account.AccountRepository;
import com.hellojd.jpetstore.domain.service.catalog.CatalogService;
import hello.JpetStoreApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpetStoreApplication.class)
public class DemoApplicationTests {
	@Autowired
	AccountRepository accountRepository;
	@Test
	public void contextLoads() {
//		List<Category> categoryList = catalogService.getCategoryList();
//		for(Category cat:categoryList){
//			System.out.println(cat);
//		}
		System.out.println(accountRepository);
	}

}
