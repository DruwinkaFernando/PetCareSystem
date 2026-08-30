package dao;

import model.Owner;
import java.util.List;

public class OwnerDAO {
    private static final String FILE = "data/owners.dat";

    public List<Owner> getAll() { return FileHandler.load(FILE); }
    public void saveAll(List<Owner> owners) { FileHandler.save(FILE, owners); }

    public void add(Owner o) {
        List<Owner> list = getAll();
        list.add(o);
        saveAll(list);
    }
