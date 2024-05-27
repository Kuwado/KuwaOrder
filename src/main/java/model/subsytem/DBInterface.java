package model.subsytem;

import java.util.ArrayList;

public interface DBInterface<T> {
    public void insert(T t);
    public void update(T t);
    public void delete(int id);
    public T selectById(int id);
    public ArrayList<T> selectAll();
}
