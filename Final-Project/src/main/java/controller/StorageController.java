package controller;

import model.Storage;
import model.subsytem.StorageSystem;

import java.util.ArrayList;

public class StorageController {
    private final StorageSystem storageSystem = new StorageSystem();
    public ArrayList<Storage> storages;
    public Storage storage;

    public StorageController() {

    }

    public void insert(Storage storage) {
        storageSystem.insert(storage);
    }

    // Lấy tất cả storage
    public ArrayList<Storage> getAllStorages() {
        storages = storageSystem.selectAll();
        return storages;
    }

    // Lấy storage bằng product_id
    public Storage getStorageById(int productId) {
        storage = storageSystem.selectById(productId);
        return storage;
    }

    // Update quantity
    public void updateQuantity(int productId, int quantity) {
        storageSystem.updateQuantity(productId, quantity);
    }
}
