package dao;

import model.Pet;
import java.util.List;

public class PetDAO{
  private static fianl String FILE = "data/pets.dat";

  public List<Pet> getAll() { return FileHandler.load(FILE); }
  public public void saveAll(List<Pet> pets) { FileHandler.save(FILE, pets); }

    public void add(Pet p) {
        List<Pet> list = getAll();
        list.add(p);
        saveAll(list);
    }

    public void update(Pet p) {
        List<Pet> list = getAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPetId().equals(p.getPetId())) { list.set(i, p); break; }
        }
        saveAll(list);
    }

    public void delete(String petId) {
        List<Pet> list = getAll();
        list.removeIf(p -> p.getPetId().equals(petId));
        saveAll(list);
    }

    public String generateId() {
        List<Pet> list = getAll();
        return "P" + String.format("%03d", list.size() + 1);
    }
}
