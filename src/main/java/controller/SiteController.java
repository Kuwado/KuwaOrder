package controller;

import model.Site;
import model.subsytem.SiteSystem;

import java.util.ArrayList;

public class SiteController {
    private final SiteSystem siteSystem = new SiteSystem();
    public ArrayList<Site> sites;
    public Site site;

    public SiteController() {

    }

    public void insert(Site site) {
        siteSystem.insert(site);
    }

    // Lấy tất cả sites
    public ArrayList<Site> getAllSites() {
        sites = siteSystem.selectAll();
        return sites;
    }

    // Lấy site bằng id
    public Site getSiteById(int res_id) {
        site = siteSystem.selectById(res_id);
        return site;
    }
}
