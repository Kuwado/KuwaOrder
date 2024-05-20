package controller;

import model.ChosingSite;
import model.Product;
import model.Site;
import model.SiteProduct;
import model.subsytem.SiteProductSystem;
import model.tabledata.ChosenQuantity;

import java.util.ArrayList;

public class SiteProductController {
    private final SiteController siteController = new SiteController();
    private final ProductController productController = new ProductController();
    private final SiteProductSystem siteproductSystem = new SiteProductSystem();
    public ArrayList<Site> sites;
    public ArrayList<Product> products;
    public ArrayList<SiteProduct> siteproducts;
    public ArrayList<ChosenQuantity> chosingSites;
    public SiteProduct siteproduct;

    public SiteProductController() {

    }

    public void insert(SiteProduct siteproduct) {
        siteproductSystem.insert(siteproduct);
    }

    // Lấy tất cả siteproducts
    public ArrayList<SiteProduct> getAllSiteProducts() {
        siteproducts = siteproductSystem.selectAll();
        return siteproducts;
    }

    // Lấy siteproduct bằng id
    public SiteProduct getSiteProductById(int id) {
        siteproduct = siteproductSystem.selectById(id);
        return siteproduct;
    }

    // Lấy siteproduct bằng site id
    public ArrayList<SiteProduct> getSiteproductsBySite(int site_id) {
        siteproducts = siteproductSystem.selectBySiteId(site_id);
        return siteproducts;
    }

    // Lấy siteproduct bằng product_id
    public ArrayList<SiteProduct> getSiteproductsByProduct(int product_id) {
        siteproducts = siteproductSystem.selectByProductId(product_id);
        return siteproducts;
    }

    // Lấy site từ siteproduct
    public ArrayList<Site> getSitesFromSiteProduct(int product_id) {
        sites = siteproductSystem.selectSiteByProductId(product_id);
        return sites;
    }

    // Lấy product từ siteproduct
    public ArrayList<Product> getProductsFromSiteProduct(int site_id) {
        products = siteproductSystem.selectProductBySiteId(site_id);
        return products;
    }

    public SiteProduct getSiteproductFromProductAndSite(int product_id, int site_id) {
        siteproduct = siteproductSystem.selectByProductAndSite(product_id, site_id);
        return siteproduct;
    }

    public ArrayList<ChosenQuantity> getSiteToMakeOrder(int product_id, int date) {
        chosingSites = siteproductSystem.selectChosingSite(product_id, date);
        return  chosingSites;
    }

}
