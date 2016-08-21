package net.lyugaev.shop.service;

import java.util.List;

import net.lyugaev.shop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.lyugaev.shop.dao.ProductDao;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao dao;

    public Product findById(int id) {
        return dao.findById(id);
    }

    public void saveProduct(Product product) {
        dao.saveProduct(product);
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public void updateProduct(Product product) {
        Product entity = dao.findById(product.getId());
        if(entity!=null){
            entity.setName(product.getName());
            entity.setAddedDate(product.getAddedDate());
            entity.setPrice(product.getPrice());
            entity.setSku(product.getSku());
            entity.setDescription(product.getDescription());
        }
    }

    public void deleteProductBySku(String sku) {
        dao.deleteProductBySku(sku);
    }

    public List<Product> findAllProducts() {
        return dao.findAllProducts();
    }

    public Product findProductBySku(String sku) {
        return dao.findProductBySku(sku);
    }

    public boolean isProductSkuUnique(Integer id, String sku) {
        Product product = findProductBySku(sku);
        return ( product == null || ((id != null) && (product.getId() == id)));
    }

}