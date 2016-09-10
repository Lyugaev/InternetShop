package net.lyugaev.shop.service;

import net.lyugaev.shop.dao.ProductDao;
import net.lyugaev.shop.entity.Account;
import net.lyugaev.shop.entity.Product;
import org.hamcrest.core.IsEqual;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.CoreMatchers.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by dmitry on 10.09.16.
 */
public class ProductServiceTest {

    private ProductServiceImpl productService;
    private ProductDao dao;

    @Before
    public void setup() {
        productService = new ProductServiceImpl();
        dao = mock(ProductDao.class);
        productService.dao = dao;
    }

    @Test
    public void findById_ReturnId_Test() {
        Product product = new Product();
        product.setId(3);
        when(dao.findById(3)).thenReturn(product);

        productService.findById(3);

        verify(dao).findById(3);
        assertThat(product.getId(), equalTo(3));
    }

    @Test(expected = RuntimeException.class)
    public void findById_ThrowException_Test() {
        Product product = new Product();
        when(dao.findById(3)).thenReturn(product);
        when(dao.findById(0)).thenThrow(new RuntimeException());

        productService.findById(0);
    }

    @Test
    public void saveProduct_Ok_Test() {
        Product product = new Product();

        productService.saveProduct(product);

        verify(dao, times(1)).saveProduct(product);
    }

    @Test(expected = Error.class)
    public void saveProduct_Fail_Test() {
        Product product = new Product();
        doThrow(new Error()).when(dao).saveProduct(product);

        productService.saveProduct(product);
    }

    @Test
    public void updateProduct_Test() {
        Product product = new Product();
        product.setId(7);
        product.setName("pork");
        product.setDescription("is that we");
        product.setAddedDate(new LocalDate(2016, 8, 25));
        product.setPrice(511.4);

        Product entityProduct = new Product();
        when(dao.findById(anyInt())).thenReturn(entityProduct);

        productService.updateProduct(product);
        productService.updateProduct(product);

        verify(dao, times(2)).findById(7);
        assertThat(entityProduct, equalTo(product));
        assertThat(entityProduct.getName(), equalTo(product.getName()));
        assertThat(entityProduct.getPrice(), equalTo(product.getPrice()));
    }

    @Test
    public void findAllProducts_Ok_Test() {
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product());
        productList.add(new Product());
        when(dao.findAllProducts()).thenReturn(productList);

        List<Product> testList = new ArrayList<Product>();
        testList = productService.findAllProducts();

        verify(dao).findAllProducts();
        assertThat(testList.size(), equalTo(2));
    }

    @Test(expected = RuntimeException.class)
    public void findAllProducts_Fail_Test() {
        when(dao.findAllProducts()).thenThrow(new RuntimeException());

        productService.findAllProducts();
    }
}
